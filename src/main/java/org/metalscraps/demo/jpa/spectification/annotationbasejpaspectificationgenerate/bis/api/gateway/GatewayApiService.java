package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.api.gateway;

import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.TestUtils;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.PageRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.SearchResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class GatewayApiService {

    private final GatewayApiRepository repository;

    public GatewayApiService(GatewayApiRepository repository) {
        this.repository = repository;
    }

    public <T extends SearchResponse<GatewayApi, ?>> Page<SearchResponse<GatewayApi, ?>> search(SearchRequest<GatewayApi> searchRequest, PageRequest pageRequest, Class<T> clazz) {
        Page<GatewayApi> all = repository.findAll(searchRequest.getSpecification(), pageRequest.of());
        return (Page<SearchResponse<GatewayApi, ?>>) all.map(x -> TestUtils.newInstance(clazz).build(x));
    }
}