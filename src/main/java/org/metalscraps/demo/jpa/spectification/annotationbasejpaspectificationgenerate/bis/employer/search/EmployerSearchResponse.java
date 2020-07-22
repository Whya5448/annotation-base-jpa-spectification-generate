package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.search;

import lombok.Getter;
import lombok.Setter;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.Employer;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.TestUtils;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchResponse;

@Getter
@Setter
public class EmployerSearchResponse implements SearchResponse<Employer, EmployerSearchResponse> {

    private String name,
        dept,
        state;

    public static EmployerSearchResponse fromEntity(Employer entity) {
        EmployerSearchResponse vo = TestUtils.convertValue(entity, EmployerSearchResponse.class);
        vo.setState(entity.getState().getState());
        return vo;
    }

    public EmployerSearchResponse build(Employer entity) {
        return EmployerSearchResponse.fromEntity(entity);
    }

}
