package com.rxjava;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

/**
 * Basic RxJava example demonstrating Flowable usage.
 * 
 * <p>This is the "Hello World" of RxJava, showing the simplest possible
 * reactive stream: creating a Flowable and subscribing to it.</p>
 * 
 * <h3>What is RxJava?</h3>
 * <p>RxJava is a Java implementation of Reactive Extensions (ReactiveX).
 * It allows you to compose asynchronous and event-based programs
 * using observable sequences.</p>
 * 
 * <h3>Key Concepts:</h3>
 * <ul>
 *   <li><b>Observable/Flowable</b> - Emits items over time</li>
 *   <li><b>Observer/Subscriber</b> - Receives emitted items</li>
 *   <li><b>Operators</b> - Transform, filter, combine streams</li>
 *   <li><b>Schedulers</b> - Control threading</li>
 * </ul>
 * 
 * <h3>Flowable vs Observable:</h3>
 * <p>Flowable supports backpressure (handling fast producer/slow consumer),
 * while Observable does not. Use Flowable when dealing with large or
 * unbounded streams.</p>
 * 
 * @author Srinath.Rayabarapu
 * @see io.reactivex.Flowable
 * @see io.reactivex.Observable
 */
@Slf4j
public class HelloWorld {
    
    /**
     * Main method demonstrating basic Flowable subscription.
     * 
     * <p>Creates a simple Flowable that emits "Hello world" and
     * subscribes with a logging consumer.</p>
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {

        Flowable.just("Hello world")
                .subscribe(log::info);

    }
}
