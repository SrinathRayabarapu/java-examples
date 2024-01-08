package com.reactor.services;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

class MonoServicesTest {

    MonoServices monoServices = new MonoServices();

    @Test
    void mangoMono() {
        Mono<String> stringMono = monoServices.mangoMono();
        StepVerifier.create(stringMono).expectNext("Mango").verifyComplete();
    }

    @Test
    void mangoMonoFlatMap() {
        Mono<List<String>> listMono = monoServices.mangoMonoFlatMap();
        StepVerifier.create(listMono)
                .expectNext(List.of("M", "a", "n", "g", "o"))
//                .expectNextCount(1)
                .verifyComplete();
    }

    @Test
    void mangoMonoFlatMapToMany() {
        Flux<String> stringFlux = monoServices.mangoMonoFlatMapToMany();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(5)
                .verifyComplete();
    }

    @Test
    void fruitsVeggiesZipTuple() {
        Mono<String> fruitsVeggiesFlux = monoServices.fruitsVeggiesZipTuple();
        StepVerifier.create(fruitsVeggiesFlux)
                .expectNext("MangoTomatoPotato")
                .verifyComplete();
    }

}