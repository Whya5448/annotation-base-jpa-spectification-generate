package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.service;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "gateway_api_service")
public class GatewayApiServiceEntity {
    @Id
    private Long id;

    private String name;
}