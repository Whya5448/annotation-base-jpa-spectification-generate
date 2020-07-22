package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search;

public interface SearchResponse<I, O> {
    O build(I entity);
}