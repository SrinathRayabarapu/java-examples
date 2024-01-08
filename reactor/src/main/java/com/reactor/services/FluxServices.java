package com.reactor.services;

import com.reactor.services.exceptions.MyCustomBusinessException;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.function.Function;

@Slf4j
public class FluxServices {

    public Flux<String> fruitsFlux() {
        return Flux.fromIterable(List.of("Banana", "Orange", "Apple", "Chikoo", "Mango")).log();
    }

    public Flux<String> fruitsFluxMap() {
        return fruitsFlux().map(String::toUpperCase).log();
    }

    public Flux<String> fruitsFluxFlatMap() {
        return Flux.fromIterable(List.of("Banana", "Orange"))
                .flatMap(s -> Flux.just(s.split("")))
                .log();
    }

    public Flux<String> fruitsFluxFlatMapAsync() {
        return Flux.fromIterable(List.of("Banana", "Orange"))
                .flatMap(s -> Flux.just(s.split(""))) // emit order is not guaranteed
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                .log();
    }

    public Flux<String> fruitsFluxConcatMapAsync() {
        return Flux.fromIterable(List.of("Banana", "Orange"))
                .concatMap(s -> Flux.just(s.split(""))) //emits in order
                .delayElements(Duration.ofMillis(new Random().nextInt(1000)))
                .log();
    }

    public Flux<String> fruitsFluxTransform(int length) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > length);
        return Flux.fromIterable(List.of("Banana", "Orange", "Apple", "Chikoo", "Mango"))
                .transform(filterData)
                .log();
    }

    public Flux<String> fruitsFluxTransformDefaultIfEmpty(int length) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > length);
        return Flux.fromIterable(List.of("Banana", "Orange", "Apple", "Chikoo", "Mango"))
                .transform(filterData)
                .defaultIfEmpty("Default Fruit!")
                .log();
    }

    public Flux<String> fruitsFluxTransformSwitchIfEmpty(int length) {
        Function<Flux<String>, Flux<String>> filterData = data -> data.filter(s -> s.length() > length);
        return Flux.fromIterable(List.of("Banana", "Orange", "Apple", "Chikoo", "Mango"))
                .transform(filterData)
                .switchIfEmpty(Flux.just("random fruit1", "random fruit2")) // further transform can also be used
                .log();
    }

    public Flux<String> fruitsVeggiesFluxConcat() {
        Flux<String> fruits = Flux.just("Mango", "Banana");
        Flux<String> veggies = Flux.just("Tomato", "Cucumber");
        return Flux.concat(fruits, veggies).log(); //order is guaranteed
    }

    public Flux<String> fruitsVeggiesFluxMerge() {
        Flux<String> fruits = Flux.just("Mango", "Banana")
                .delayElements(Duration.ofMillis(100));
        Flux<String> veggies = Flux.just("Tomato", "Cucumber")
                .delayElements(Duration.ofMillis(200));
        return Flux.merge(fruits, veggies).log(); //data is interleaved(async in nature)
    }

    public Flux<String> fruitsVeggiesFluxMergeSequential() {
        Flux<String> fruits = Flux.just("Mango", "Banana")
                .delayElements(Duration.ofMillis(100));
        Flux<String> veggies = Flux.just("Tomato", "Cucumber")
                .delayElements(Duration.ofMillis(200));
        return Flux.mergeSequential(fruits, veggies).log(); //data is interleaved(async in nature)
    }

    public Flux<String> fruitsVeggiesZip() {
        Flux<String> fruits = Flux.just("Mango", "Banana");
        Flux<String> veggies = Flux.just("Tomato", "Cucumber");
        return Flux.zip(fruits, veggies, (first, second) -> first + second).log();
    }

    public Flux<String> fruitsVeggiesZipTuple() {
        Flux<String> fruits = Flux.just("Mango", "Banana");
        Flux<String> veggies = Flux.just("Tomato", "Cucumber");
        Flux<String> moreVeggies = Flux.just("Potato", "Beans");
        return Flux.zip(fruits, veggies, moreVeggies)
                .map(objects -> objects.getT1() + objects.getT2() + objects.getT3()
                ).log();
    }

    public Flux<String> fruitsFluxDoOn() {
        return Flux.fromIterable(List.of("Banana", "Orange", "Apple", "Chikoo", "Mango"))
                .doOnNext(s -> log.info(s))
                .doOnSubscribe(subscription -> log.info("subscription : " + subscription))
                .doOnComplete(() -> log.info("Completed!"));
    }

    public Flux<String> fruitsFluxOnErrorReturn() {
        return Flux.just("Banana", "Orange", "Apple", "Chikoo", "Mango")
                .concatWith(Flux.error(new RuntimeException("Runtime exception!!")))
                .doOnError(e -> log.info(e.getMessage()))
                .onErrorReturn("New Fruit!");
    }

    public Flux<String> fruitsFluxOnErrorContinue() {
        return Flux.just("Banana", "Orange", "Apple", "Chikoo", "Mango")
                .map(s -> {
                    if (s.equalsIgnoreCase("Apple")) {
                        throw new RuntimeException("Runtime exception occurred!");
                    } else {
                        return s.toUpperCase();
                    }
                })
                .onErrorContinue((e1, e2) -> {
                    log.info(e1.getMessage() + " happened on " + e2.toString());
                });
    }

    public Flux<String> fruitsFluxOnErrorMap() {
        return Flux.just("Banana", "Orange", "Apple", "Chikoo", "Mango")
                .checkpoint("Error Checkpoint-1")
                .map(s -> {
                    if (s.equalsIgnoreCase("Apple")) {
                        throw new RuntimeException("Runtime exception occurred!");
                    } else {
                        return s.toUpperCase();
                    }
                })
                .checkpoint("Error Checkpoint-2")
                .onErrorMap(MyCustomBusinessException::new); //converting original exception to business friendly one
    }

}