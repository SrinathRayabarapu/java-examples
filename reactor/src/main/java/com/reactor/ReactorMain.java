package com.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Slf4j
public class ReactorMain {
    public static void main(String[] args) {

/*        FluxServices fluxServices = new FluxServices();
        MonoServices monoServices = new MonoServices();

        log.info("From Flux");
        Flux<String> stringFlux = fluxServices.fruitsFlux();
        stringFlux.subscribe(fruit -> log.info(fruit));

        log.info("From Mono");
        monoServices.mangoMono().subscribe(fruit -> log.info(fruit));*/

        try{
            getMessage2()
                    .doOnError(throwable -> {
                        log.error("doOnError :::::$$$ {}", throwable.getMessage());
                    })
                    .onErrorResume(throwable -> {
                        log.error("onErrorResume : ", throwable);
                        return Mono.empty();
                    })
                    .subscribe();
        } catch (Exception e){
            log.error("Exception is : ", e);
        }

    }

    static Mono<Object> getMessage2() {

        boolean b = false;

        if(!b){
            Mono.defer(() -> {
                        throw new RuntimeException();
                    });
        }

        return Mono.just("").flatMap(str -> {
            if(str.equalsIgnoreCase("")){
                throw new RuntimeException("Invalid");
            }
            return Mono.empty();
        }).switchIfEmpty(Mono.defer(() -> {
            throw new RuntimeException("Supply Keys entity OR invoice_supply_keys Table Not Found for shipment No: ");
        }));
    }


    static Mono<Object> getMessage() {

        boolean b = false;

        if(!b){
            throw new RuntimeException();
        }

        return Mono.just("").flatMap(str -> {
            if(str.equalsIgnoreCase("")){
                throw new RuntimeException("Invalid");
            }
            return Mono.empty();
        }).switchIfEmpty(Mono.defer(() -> {
            throw new RuntimeException("Supply Keys entity OR invoice_supply_keys Table Not Found for shipment No: ");
        }));
    }

    static Mono<Object> getMessage1() {
        return Mono.just("").flatMap(str -> {
            return Mono.empty();
        }).switchIfEmpty(Mono.defer(() -> {
            return Mono.error(new RuntimeException());
        }));
    }

}