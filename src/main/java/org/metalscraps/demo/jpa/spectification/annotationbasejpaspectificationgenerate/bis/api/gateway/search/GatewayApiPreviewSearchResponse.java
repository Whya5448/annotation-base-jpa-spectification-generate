package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search;

import java.util.UUID;
import lombok.Data;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.GatewayApi;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.TestUtils;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchResponse;

@Data
public class GatewayApiPreviewSearchResponse implements SearchResponse<GatewayApi, GatewayApiPreviewSearchResponse> {

    private UUID id;
    private String name,
        serviceName,
        desc,
        creatorName;

    public static GatewayApiPreviewSearchResponse fromEntity(GatewayApi entity) {
        GatewayApiPreviewSearchResponse vo = TestUtils.convertValue(entity, GatewayApiPreviewSearchResponse.class);
        vo.setCreatorName(entity.getCreator().getName());
        vo.setServiceName(entity.getCreator().getName());
        return vo;
    }

    public GatewayApiPreviewSearchResponse build(GatewayApi entity) {
        return GatewayApiPreviewSearchResponse.fromEntity(entity);
    }

}