package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.invoker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

public class Equal implements SearchPredicateInvoker<Object, Object> {

    public Predicate invoke(Expression<Object> x, Object v, CriteriaBuilder cb) {
        return cb.equal(x, v);
    }
}
