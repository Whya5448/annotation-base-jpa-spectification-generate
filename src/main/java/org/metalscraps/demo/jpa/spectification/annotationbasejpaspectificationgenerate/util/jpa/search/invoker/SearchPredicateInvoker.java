package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.invoker;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;

public interface SearchPredicateInvoker<T, Y> {

    Predicate invoke(Expression<T> x, Y y, CriteriaBuilder cb);
}