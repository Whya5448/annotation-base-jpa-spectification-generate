package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway;

import javax.validation.Valid;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search.GatewayApiPreviewSearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search.GatewayApiPreviewSearchResponse;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search.GatewayApiSearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway.search.GatewayApiSearchResponse;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.PageRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayApiController {

    private final GatewayApiService service;

    public GatewayApiController(GatewayApiService service) {
        this.service = service;
    }

    @GetMapping("/api/gateway")
    public Page<SearchResponse<GatewayApi,?>> search(@ModelAttribute GatewayApiSearchRequest searchRequest,
        @ModelAttribute @Valid PageRequest pageRequest) {
        return service.search(searchRequest, pageRequest, GatewayApiSearchResponse.class);
    }

    @GetMapping("/api/gateway/preview")
    public Page<SearchResponse<GatewayApi,?>> searchPreview(@ModelAttribute GatewayApiPreviewSearchRequest searchRequest,
        @ModelAttribute @Valid PageRequest pageRequest) {
        return service.search(searchRequest, pageRequest, GatewayApiPreviewSearchResponse.class);
    }

}
