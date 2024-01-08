package com.reactor.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class MonoServices {

    public Mono<String> mangoMono() {
        return Mono.just("Mango").log();
    }

    public Mono<List<String>> mangoMonoFlatMap() {
        return Mono.just("Mango")
                .flatMap(s -> Mono.just(List.of(s.split(""))))
                .log();
    }

    public Flux<String> mangoMonoFlatMapToMany() {
        return Mono.just("Mango")
                .flatMapMany(s -> Flux.just(s.split("")))
                .log();
    }

    public Mono<String> fruitsVeggiesZipTuple() {
        Mono<String> fruits = Mono.just("Mango");
        Mono<String> veggies = Mono.just("Tomato");
        Mono<String> moreVeggies = Mono.just("Potato");
        return Mono.zip(fruits, veggies, moreVeggies)
                .map(objects -> objects.getT1() + objects.getT2() + objects.getT3()).log();
    }

}
