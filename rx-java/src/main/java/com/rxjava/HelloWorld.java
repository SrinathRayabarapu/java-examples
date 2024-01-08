package com.rxjava;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HelloWorld {
    public static void main(String[] args) {

        Flowable.just("Hello world")
                .subscribe(log::info);

    }
}
