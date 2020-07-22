package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search;

import java.time.ZonedDateTime;
import java.util.Set;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.All;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.And;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.Or;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.XPredicate;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.GatewayApi;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.enums.GeneralState;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.TestUtils;
import org.springframework.data.jpa.domain.Specification;

@Getter
@Setter
public class GatewayApiSearchRequest extends SearchRequest<GatewayApi> {

    @All
    @Or
    @XPredicate
    private String name;

    @All
    @Or
    @XPredicate
    private String uri;

    @All
    @Or
    @XPredicate(fieldName = "service.name")
    private String service;

    @All
    @Or
    @XPredicate(fieldName = "creator.id")
    private String createId;

    @And
    @XPredicate("equal")
    private GeneralState state;

    @Or
    @XPredicate(value="zonedDateTimeGreaterThanOrEqualTo", fieldName = "createDate")
    private Long startDate;

    @Or
    @XPredicate(value="zonedDateTimeLessThanOrEqualTo", fieldName = "createDate")
    private Long endDate;

    public void setStartDate(Long startDate) { this.startDate = startDate; }
    public void setStartDate(ZonedDateTime startDate) { this.startDate = startDate.toEpochSecond(); }
    public void setEndDate(Long endDate) { this.endDate = endDate; }
    public void setEndDate(ZonedDateTime endDate) { this.endDate = endDate.toEpochSecond(); }

    @And
    @XPredicate(authOverride = true)
    @Setter(AccessLevel.NONE)
    private Boolean auth;

    @And
    @XPredicate(value="equal", fieldName = "organization.id")
    @Setter(AccessLevel.NONE)
    private Long authOrganizationId;

    @And
    @XPredicate(value="equal", fieldName = "creator.id")
    @Setter(AccessLevel.NONE)
    private String authCreateId;

    @Override
    public Specification<GatewayApi> getSpecification() {
        Set<String> authorites = TestUtils.getAuthorities();

        if(authorites.contains("IAPI_GATEWAY-S-OWN")) authCreateId = TestUtils.getUsername();
        else if(authorites.contains("IAPI_GATEWAY-S-ORG")) authOrganizationId = TestUtils.getOrganizationId();
        else if(!authorites.contains("IAPI_GATEWAY-S-ALL")) auth = false;

        return super.getSpecification();

    }

}