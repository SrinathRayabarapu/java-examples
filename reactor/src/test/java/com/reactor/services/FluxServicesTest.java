package com.reactor.services;

import com.reactor.services.exceptions.MyCustomBusinessException;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.tools.agent.ReactorDebugAgent;

class FluxServicesTest {

    FluxServices fluxServices = new FluxServices();

    @Test
    void fruitsFlux() {
        Flux<String> stringFlux = fluxServices.fruitsFlux();
        StepVerifier.create(stringFlux).expectNext("Banana", "Orange", "Apple", "Chikoo", "Mango").verifyComplete();
    }

    @Test
    void fruitsFluxMap() {
        Flux<String> stringFlux = fluxServices.fruitsFluxMap();
        StepVerifier.create(stringFlux).expectNext("BANANA", "ORANGE", "APPLE", "CHIKOO", "MANGO").verifyComplete();
    }

    @Test
    void fruitsFluxFlatMap() {
        Flux<String> stringFlux = fluxServices.fruitsFluxFlatMap();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void fruitsFluxFlatMapAsync() {
        Flux<String> stringFlux = fluxServices.fruitsFluxFlatMapAsync();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void fruitsFluxConcatMapAsync() {
        Flux<String> stringFlux = fluxServices.fruitsFluxConcatMapAsync();
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(12)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransform() {
        Flux<String> stringFlux = fluxServices.fruitsFluxTransform(5);
        StepVerifier.create(stringFlux)
//                .expectNext("B", "a", "n", "a", "n", "a", "O", "r", "a", "n", "g", "e")
                .expectNextCount(3)
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformDefaultIfEmpty() {
        Flux<String> stringFlux = fluxServices.fruitsFluxTransformDefaultIfEmpty(15);
        StepVerifier.create(stringFlux)
                .expectNext("Default Fruit!")
                .verifyComplete();
    }

    @Test
    void fruitsFluxTransformSwitchIfEmpty() {
        Flux<String> stringFlux = fluxServices.fruitsFluxTransformSwitchIfEmpty(15);
        StepVerifier.create(stringFlux)
                .expectNext("random fruit1", "random fruit2")
                .verifyComplete();
    }

    @Test
    void fruitsVeggiesFluxConcat() {
        Flux<String> fruitsVeggiesFlux = fluxServices.fruitsVeggiesFluxConcat();
        StepVerifier.create(fruitsVeggiesFlux)
                .expectNext("Mango", "Banana", "Tomato", "Cucumber")
                .verifyComplete();
    }

/*    @Test
    void fruitsVeggiesFluxMerge() {
        Flux<String> fruitsVeggiesFlux = fluxServices.fruitsVeggiesFluxMerge();
        StepVerifier.create(fruitsVeggiesFlux)
                .expectNext("Mango", "Tomato", "Banana", "Cucumber")
//                .expectNextCount(4)
                .verifyComplete();
    }*/

    @Test
    void fruitsVeggiesFluxMergeSequential() {
        Flux<String> fruitsVeggiesFlux = fluxServices.fruitsVeggiesFluxMergeSequential();
        StepVerifier.create(fruitsVeggiesFlux)
                .expectNext("Mango", "Banana", "Tomato", "Cucumber")
                .verifyComplete();
    }

    @Test
    void fruitsVeggiesZip() {
        Flux<String> fruitsVeggiesFlux = fluxServices.fruitsVeggiesZip();
        StepVerifier.create(fruitsVeggiesFlux)
                .expectNext("MangoTomato", "BananaCucumber")
                .verifyComplete();
    }

    @Test
    void fruitsVeggiesZipTuple() {
        Flux<String> fruitsVeggiesFlux = fluxServices.fruitsVeggiesZipTuple();
        StepVerifier.create(fruitsVeggiesFlux)
                .expectNext("MangoTomatoPotato", "BananaCucumberBeans")
                .verifyComplete();
    }

    @Test
    void fruitsFluxDoOn() {
        Flux<String> fruitsFluxDoOn = fluxServices.fruitsFluxDoOn();
        StepVerifier.create(fruitsFluxDoOn)
                .expectNext("Banana", "Orange", "Apple", "Chikoo", "Mango")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorReturn() {
        Flux<String> fruitsFluxOnErrorReturn = fluxServices.fruitsFluxOnErrorReturn().log();
        StepVerifier.create(fruitsFluxOnErrorReturn)
                .expectNext("Banana", "Orange", "Apple", "Chikoo", "Mango", "New Fruit!")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorContinue() {
        Flux<String> fruitsFluxOnErrorReturn = fluxServices.fruitsFluxOnErrorContinue().log();
        StepVerifier.create(fruitsFluxOnErrorReturn)
                .expectNext("BANANA", "ORANGE", "CHIKOO", "MANGO")
                .verifyComplete();
    }

    @Test
    void fruitsFluxOnErrorMap() {
        ReactorDebugAgent.init();
        ReactorDebugAgent.processExistingClasses();

        Flux<String> fruitsFluxOnErrorReturn = fluxServices.fruitsFluxOnErrorMap().log();
        StepVerifier.create(fruitsFluxOnErrorReturn)
                .expectNext("BANANA", "ORANGE")
                .expectError(MyCustomBusinessException.class)
                .verify();
    }

}