package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.invoker.SearchPredicateInvoker;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.invoker.StringLike;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XPredicate {

    Class<? extends SearchPredicateInvoker> value() default StringLike.class;

    String fieldName() default "";

    boolean authOverride() default false;
}
