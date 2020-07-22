package org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer;

import javax.validation.Valid;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.search.EmployerSearchRequest;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.bis.employer.search.EmployerSearchResponse;
import org.metalscraps.demo.jpa.spectification.annotationbasejpaspectificationgenerate.util.jpa.search.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployerController {

    private final EmployerService service;

    public EmployerController(EmployerService service) {
        this.service = service;
    }

    @GetMapping("/api/employer")
    public Page<EmployerSearchResponse> search(@ModelAttribute EmployerSearchRequest searchRequest,
        @ModelAttribute @Valid final PageRequest PageRequest) {
        return service.search(searchRequest, PageRequest, EmployerSearchResponse.class);
    }
}

