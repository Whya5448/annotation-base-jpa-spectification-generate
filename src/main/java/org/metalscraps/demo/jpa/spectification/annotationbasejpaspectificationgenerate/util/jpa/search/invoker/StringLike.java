package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.invoker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

public class StringLike implements SearchPredicateInvoker<String, String> {

    public Predicate invoke(Expression<String> x, String v, CriteriaBuilder cb) {
        return cb.like(cb.upper(x), String.format("%%%s%%", v.toUpperCase()));
    }
}
