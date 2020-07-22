package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer;

import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.search.EmployerSearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.search.EmployerSearchResponse;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployerService {

    private final EmployerRepository repository;

    public EmployerService(EmployerRepository repository) {
        this.repository = repository;
    }

    public Page<EmployerSearchResponse> search(EmployerSearchRequest searchRequest, PageRequest pageRequest, Class<EmployerSearchResponse> employerSearchResponseClass) {
        pageRequest.setSort("dept");
        Page<Employer> all = repository.findAll(searchRequest.getSpecification(), pageRequest.of());
        return all.map(x -> new EmployerSearchResponse().build(x));
    }
}
