package com.rxjava.observables;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import lombok.extern.slf4j.Slf4j;

/**
 * A simple Observer implementation demonstrating the RxJava Observer contract.
 * 
 * <p>An Observer subscribes to an Observable and receives items emitted by it.
 * This implementation logs each lifecycle event for educational purposes.</p>
 * 
 * <h3>Observer Lifecycle:</h3>
 * <ol>
 *   <li><b>onSubscribe</b> - Called when subscription begins, provides Disposable</li>
 *   <li><b>onNext</b> - Called for each emitted item (0 to N times)</li>
 *   <li><b>onError</b> - Called if an error occurs (terminal event)</li>
 *   <li><b>onComplete</b> - Called when stream completes (terminal event)</li>
 * </ol>
 * 
 * <h3>Important Notes:</h3>
 * <ul>
 *   <li>onError and onComplete are mutually exclusive - only one will be called</li>
 *   <li>After onError or onComplete, no more onNext calls will occur</li>
 *   <li>The Disposable from onSubscribe can be used to cancel subscription</li>
 * </ul>
 * 
 * <h3>Usage:</h3>
 * <pre>{@code
 * Observable.just("Hello", "World")
 *     .subscribe(new SimpleObserver());
 * }</pre>
 * 
 * @author Srinath.Rayabarapu
 * @see Observer
 * @see Disposable
 */
@Slf4j
public class SimpleObserver implements Observer<Object> {

    /**
     * Called when the Observer subscribes to the Observable.
     * 
     * <p>The Disposable can be used to cancel the subscription
     * if the Observer no longer wants to receive items.</p>
     *
     * @param d the Disposable representing this subscription
     */
    @Override
    public void onSubscribe(Disposable d) {
        log.info("onSubscribe");
    }

    /**
     * Called for each item emitted by the Observable.
     * 
     * <p>This method will be called 0 to N times before either
     * onError or onComplete is called.</p>
     *
     * @param s the emitted item
     */
    @Override
    public void onNext(Object s) {
        log.info("onNext --> : {}", s);
    }

    /**
     * Called if the Observable encounters an error.
     * 
     * <p>This is a terminal event - no more items will be emitted
     * and onComplete will not be called.</p>
     *
     * @param e the exception that occurred
     */
    @Override
    public void onError(Throwable e) {
        log.error("onError --> : ", e);
    }

    /**
     * Called when the Observable has finished emitting items.
     * 
     * <p>This is a terminal event - indicates successful completion
     * of the stream. onError will not be called after this.</p>
     */
    @Override
    public void onComplete() {
        log.info("onComplete");
    }

}
