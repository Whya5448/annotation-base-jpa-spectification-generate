package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.All;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.And;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.Or;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.XPredicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

@Slf4j
public class Searches {

    private static <T> boolean isFieldNull(SearchRequest<T> o, Field f) {
        f.setAccessible(true);
        try {
            return f.get(o) == null;
        } catch (IllegalAccessException e) {
            return true;
        }
    }

    private static <T> boolean isFieldNotNull(SearchRequest<T> o, Field f) {
        return !isFieldNull(o, f);
    }

    private static Optional<Method> getMethod(String name) {
        return Stream.of(Invoke.class.getDeclaredMethods())
            .filter(it -> it.getName().equalsIgnoreCase(name))
            .peek(it -> it.setAccessible(true))
            .findFirst();
    }

    private static <T> List<Field> getMethodsByAnnotations(SearchRequest<T> o, Class<? extends Annotation> annotationClass) {
        return Stream.of(o.getClass().getDeclaredFields())
            .filter(it -> it.getAnnotation(annotationClass) != null)
            .collect(Collectors.toList());
    }

    private static <T> Predicate getPredicate(SearchRequest<T> o, Field it, Root<T> root, CriteriaBuilder cb) {
        try {

            it.setAccessible(true);
            XPredicate XPredicate = it.getAnnotation(XPredicate.class);
            String columnName = XPredicate.fieldName();
            if (StringUtils.isEmpty(columnName)) {
                columnName = it.getName();
            }
            String value = XPredicate.value();
            Object fieldValue = it.get(o);

            if (XPredicate.authOverride()) {
                return (Boolean) fieldValue ? cb.and() : cb.or();
            }

            Path path;
            if (columnName.contains(".")) {
                // 2-3차 조인은 추가작업 필요
                String[] p = columnName.split("\\.");
                path = root.join(p[0]).get(p[1]);
            } else {
                path = root.get(columnName);
            }

            Method method = Searches.getMethod(value).get();
            return (Predicate) method.invoke(null, path, fieldValue, cb);


        } catch (IllegalAccessException | InvocationTargetException e) {
            log.error(e.getMessage(), e);
            return (Predicate) (Specification<T>) (a, b, c) -> c.conjunction();
        }
    }

    public static <T> void setAll(SearchRequest<T> o, Object all) {
        getMethodsByAnnotations(o, All.class)
            .forEach(it -> {
                try {
                    it.setAccessible(true);
                    it.set(o, all);
                } catch (IllegalAccessException e) {
                    log.error(e.getMessage(), e);
                }
            });
    }

    public static <T> Specification<T> getOrSpecifications(SearchRequest<T> o) {
        return getMethodsByAnnotations(o, Or.class)
            .stream()
            .filter(it -> isFieldNotNull(o, it))
            .map(it -> (Specification<T>) (root, query, cb) -> getPredicate(o, it, root, cb))
            .reduce(Specification.where(null), (x, y) -> x == null ? y : y == null ? x : x.or(y));
    }

    public static <T> Specification<T> getAndSpecifications(SearchRequest<T> o) {
        return getMethodsByAnnotations(o, And.class)
            .stream()
            .filter(it -> isFieldNotNull(o, it))
            .map(it -> (Specification<T>) (root, query, cb) -> getPredicate(o, it, root, cb))
            .reduce(Specification.where(null), (x, y) -> x == null ? y : y == null ? x : x.and(y));
    }

    @SuppressWarnings("unused")
    static class Invoke {

        private static <Y> Predicate equal(Expression<Y> x, Y v, CriteriaBuilder cb) {
            return cb.equal(x, v);
        }

        private static Predicate stringLike(Expression<String> x, String v, CriteriaBuilder cb) {
            return cb.like(cb.upper(x), String.format("%%%s%%", v.toUpperCase()));
        }

        private static Predicate zonedDateTimeGreaterThanOrEqualTo(Expression<ZonedDateTime> x, Long v, CriteriaBuilder cb) {
            return cb.greaterThanOrEqualTo(x, ZonedDateTime.ofInstant(Instant.ofEpochMilli(v), ZoneOffset.ofHours(9)));
        }

        private static Predicate zonedDateTimeLessThanOrEqualTo(Expression<ZonedDateTime> x, Long v, CriteriaBuilder cb) {
            return cb.lessThanOrEqualTo(x, ZonedDateTime.ofInstant(Instant.ofEpochMilli(v), ZoneOffset.ofHours(9)));
        }
    }

}