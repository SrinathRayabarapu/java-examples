package com.reactor;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Main entry point demonstrating Project Reactor reactive programming concepts.
 * 
 * <p>Project Reactor is a reactive programming library that implements the
 * Reactive Streams specification. It provides two main types:</p>
 * 
 * <ul>
 *   <li><b>Mono&lt;T&gt;</b> - Async sequence of 0 or 1 element</li>
 *   <li><b>Flux&lt;T&gt;</b> - Async sequence of 0 to N elements</li>
 * </ul>
 * 
 * <h3>Key Concepts Demonstrated:</h3>
 * <ul>
 *   <li>Error handling with doOnError, onErrorResume</li>
 *   <li>Lazy evaluation with Mono.defer()</li>
 *   <li>switchIfEmpty for handling empty streams</li>
 *   <li>Subscription and reactive stream lifecycle</li>
 * </ul>
 * 
 * <h3>Error Handling Patterns:</h3>
 * <ul>
 *   <li>{@code doOnError} - Side effect on error (logging)</li>
 *   <li>{@code onErrorResume} - Switch to fallback stream</li>
 *   <li>{@code onErrorReturn} - Return default value</li>
 *   <li>{@code onErrorMap} - Transform exception type</li>
 * </ul>
 * 
 * @author Srinath.Rayabarapu
 * @see reactor.core.publisher.Mono
 * @see reactor.core.publisher.Flux
 */
@Slf4j
public class ReactorMain {
    
    /**
     * Main method demonstrating reactive error handling patterns.
     *
     * @param args command-line arguments (not used)
     */
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