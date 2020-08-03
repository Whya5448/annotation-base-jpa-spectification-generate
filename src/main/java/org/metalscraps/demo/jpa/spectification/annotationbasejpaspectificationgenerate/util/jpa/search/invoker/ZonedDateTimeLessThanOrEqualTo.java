package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.invoker;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

public class ZonedDateTimeLessThanOrEqualTo implements SearchPredicateInvoker<ZonedDateTime, Long> {

    public Predicate invoke(Expression<ZonedDateTime> x, Long v, CriteriaBuilder cb) {
        return cb.lessThanOrEqualTo(x, ZonedDateTime.ofInstant(Instant.ofEpochMilli(v), ZoneOffset.ofHours(9)));

    }
}
