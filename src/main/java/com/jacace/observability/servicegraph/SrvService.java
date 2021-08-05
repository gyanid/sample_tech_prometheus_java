package com.jacace.observability.servicegraph;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import reactor.core.publisher.Flux;

public class SrvService {

    @Autowired
    ServiceRepository serviceRepository;

    public Flux<Service> getAllServices(Integer offset, Integer limit) {
        return serviceRepository.retrieveAllAuthors(PageRequest.of(offset, limit));
    }

}
