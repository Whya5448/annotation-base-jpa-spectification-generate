package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search;

import java.time.ZonedDateTime;
import lombok.Getter;
import lombok.Setter;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.GatewayApi;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.enums.GeneralState;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.All;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.And;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.Or;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.annotations.XPredicate;

@Getter
@Setter
public class GatewayApiPreviewSearchRequest extends SearchRequest<GatewayApi> {

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
    @XPredicate(value = "zonedDateTimeGreaterThanOrEqualTo", fieldName = "createDate")
    private Long startDate;

    @Or
    @XPredicate(value = "zonedDateTimeLessThanOrEqualTo", fieldName = "createDate")
    private Long endDate;

    public void setStartDate(Long startDate) {
        this.startDate = startDate;
    }

    public void setStartDate(ZonedDateTime startDate) {
        this.startDate = startDate.toEpochSecond();
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    public void setEndDate(ZonedDateTime endDate) {
        this.endDate = endDate.toEpochSecond();
    }
}