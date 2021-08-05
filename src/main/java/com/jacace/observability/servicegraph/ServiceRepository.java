package com.jacace.observability.servicegraph;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ServiceRepository extends ReactiveMongoRepository<Service, String> 
{

    //Reactor is built on the Reactive Streams specification. 
    //Reactive Streams is composed of 4 simple Java interfaces 
    //(Publisher, Subscriber, Subscription and Processor), 
    //The core concern of Reactive Streams is handling backpressure. 
    //In a nutshell, backpressure is a mechanism that permits a 
    //receiver to ask how much data it wants to receive from the emitter.

    //Mono is used for handling zero or one result
    //Flux is used to handle zero to many results
    //Mono is the Reactive equivalent of CompletableFuture type, 
    //and allow to provide a consistent API for handling single 
    //and multiple elements in a Reactive way.

    //No doubt that web flux and project reactor are 
    //together good in building non-blocking with the minimum number of 
    //resources without compromising on performance

    //Reactive types: Their strength lies in their capacity
    //to serve more request concurrently, and to handle operations
    //with latency, such as requesting data from a remote server, 
    //more efficiently

    //Unlike traditional processing that blocks the current 
    //thread while waiting a result, a Reactive API that waits 
    //costs nothing,

	@Query("{ id: { $exists: true }}")
	Flux<Service> retrieveAllAuthors(final PageRequest pageRequest);

}