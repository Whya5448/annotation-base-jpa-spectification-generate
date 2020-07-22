package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search;

import java.time.ZonedDateTime;
import java.util.UUID;
import lombok.Data;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.GatewayApi;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.TestUtils;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchResponse;

@Data
public class GatewayApiSearchResponse implements SearchResponse<GatewayApi, GatewayApiSearchResponse> {

    private UUID id;
    private String name,
        uri,
        method,
        apiPolicyName,
        createId,
        state,
        serviceName;

    private ZonedDateTime createDate, updateDate;

    public static GatewayApiSearchResponse fromEntity(GatewayApi entity) {
        GatewayApiSearchResponse vo = TestUtils.convertValue(entity, GatewayApiSearchResponse.class);
        vo.setState(entity.getState().getState());
        vo.setCreateId(entity.getCreator().getName());
        vo.setCreateDate(entity.getCreateDate());
        vo.setServiceName(entity.getService().getName());
        return vo;
    }

    public GatewayApiSearchResponse build(GatewayApi entity) {
        return GatewayApiSearchResponse.fromEntity(entity);
    }
}