package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search;

import javax.validation.constraints.Max;
import javax.validation.constraints.Positive;
import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PageRequest {
    @Positive
    private int page = 1;

    @Max(50)
    @Positive
    private int size = 15;

    private String sort = "createDate";
    private Sort.Direction direction = Sort.Direction.DESC;

    public org.springframework.data.domain.PageRequest of() {
        return org.springframework.data.domain.PageRequest.of(page - 1, size, direction, sort);
    }
}