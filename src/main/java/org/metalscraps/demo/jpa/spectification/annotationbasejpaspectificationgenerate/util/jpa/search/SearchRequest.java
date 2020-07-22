package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search;

import java.util.Optional;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

public class SearchRequest<T> {

    @Getter
    @Setter
    private String all;

    public Specification<T> getSpecification() {
        if (!StringUtils.isEmpty(all)) {
            Searches.setAll(this, all);
        }

        return Optional.ofNullable(Specification.where(Searches.getOrSpecifications(this)))
            .map(x -> x.and(Searches.getAndSpecifications(this)))
            .orElse(null);
    }
}
