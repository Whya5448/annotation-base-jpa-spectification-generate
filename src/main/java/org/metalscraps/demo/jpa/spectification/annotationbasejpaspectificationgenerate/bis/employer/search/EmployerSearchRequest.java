package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.search;

import lombok.Getter;
import lombok.Setter;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.All;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.And;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.Or;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.XPredicate;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.Employer;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.enums.GeneralState;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchRequest;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
public class EmployerSearchRequest extends SearchRequest<Employer> {

    @All
    @Or
    @XPredicate(fieldName = "id")
    private String empNo;

    @All
    @Or
    @XPredicate
    private String name;

    @All
    @Or
    @XPredicate
    private String dept;

    @And
    @XPredicate("equal")
    private GeneralState state;

    @Override
    public Specification<Employer> getSpecification() {
        return super.getSpecification().and((root, query, criteriaBuilder) -> criteriaBuilder.isNotNull(root.get("deptId")));
    }
}
