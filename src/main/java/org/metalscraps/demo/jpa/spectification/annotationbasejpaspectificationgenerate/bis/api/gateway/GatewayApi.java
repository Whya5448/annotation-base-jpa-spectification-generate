package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway;

import java.time.ZonedDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.service.GatewayApiServiceEntity;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.organization.Organization;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.user.User;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.enums.GeneralState;

@Data
@Entity
@Table(name = "gateway_api")
public class GatewayApi {

    @Id
    private UUID id;

    private String name;

    private String desc;

    private String uri;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private GatewayApiServiceEntity service;

    @ManyToOne
    @JoinColumn(name = "org_id")
    private Organization organization;

    @ManyToOne
    @JoinColumn(name = "create_id")
    private User creator;

    @Enumerated(EnumType.STRING)
    private GeneralState state;

    @Column(name = "create_date")
    private ZonedDateTime createDate;

    @Column(name = "update_date")
    private ZonedDateTime updateDate;

}