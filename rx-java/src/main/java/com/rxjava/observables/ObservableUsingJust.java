package com.rxjava.observables;

import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObservableUsingJust {

    public static void main(String[] args) {

        Observable
                .just("a", "b", "c", "d", "e", "f", "g", "h", "j", "k")
                .subscribe(new SimpleObserver());

    }

}
