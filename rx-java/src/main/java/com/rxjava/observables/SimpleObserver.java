package com.rxjava.observables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SimpleObserver implements Observer<Object> {

    @Override
    public void onSubscribe(Disposable d) {
        log.info("onSubscribe");
    }

    @Override
    public void onNext(Object s) {
        log.info("onNext --> : {}", s);
    }

    @Override
    public void onError(Throwable e) {
        log.error("onError --> : ", e);
    }

    @Override
    public void onComplete() {
        log.info("onComplete");
    }

}
