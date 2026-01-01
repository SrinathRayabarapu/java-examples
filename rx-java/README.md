# RxJava Module

This module demonstrates reactive programming using RxJava 2, a library for composing asynchronous and event-based programs using observable sequences.

## Module Overview

The `rx-java` module provides examples of:
- Observable and Flowable patterns
- Observer implementations
- Reactive operators
- Backpressure handling

## What is RxJava?

RxJava is a Java implementation of Reactive Extensions (ReactiveX). It extends the observer pattern to support sequences of data/events and adds operators that allow you to compose sequences together declaratively.

## Core Types

| Type | Description | Backpressure |
|------|-------------|--------------|
| **Observable** | Emits 0..N items, then completes or errors | No |
| **Flowable** | Like Observable but with backpressure | Yes |
| **Single** | Emits exactly 1 item or an error | No |
| **Maybe** | Emits 0 or 1 item, or an error | No |
| **Completable** | Emits no items, just completes or errors | No |

## Package Structure

| Package | Description |
|---------|-------------|
| `com.rxjava` | Main examples (HelloWorld) |
| `com.rxjava.models` | Data models (Shape) |
| `com.rxjava.observables` | Observable/Observer implementations |
| `com.rxjava.utils` | Utility classes |

## Key Classes

| Class | Description |
|-------|-------------|
| `HelloWorld` | Basic Flowable example |
| `SimpleObserver` | Observer implementation with lifecycle methods |
| `ObservableUsingJust` | Creating Observables with `just()` |
| `Shape` | Domain model for examples |
| `RxUtils` | Utility methods |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| RxJava 2 | 2.2.19 | Core reactive library |
| Logback | 1.4.14 | Logging |
| Logstash Encoder | 7.4 | JSON logging |

## Building the Module

```bash
# From the root project directory
mvn clean install -pl rx-java

# Or from the rx-java directory
cd rx-java
mvn clean install
```

## Running Examples

```bash
cd rx-java
mvn compile exec:java -Dexec.mainClass="com.rxjava.HelloWorld"
```

## Core Concepts

### 1. Creating Observables

```java
// From single or multiple items
Observable.just("Hello", "World")

// From an iterable
Observable.fromIterable(list)

// From a callable
Observable.fromCallable(() -> expensiveOperation())

// With Flowable (backpressure support)
Flowable.just("Hello world")
```

### 2. Observer Lifecycle

```java
public class SimpleObserver implements Observer<Object> {
    @Override
    public void onSubscribe(Disposable d) {
        // Called when subscription starts
    }
    
    @Override
    public void onNext(Object item) {
        // Called for each emitted item
    }
    
    @Override
    public void onError(Throwable e) {
        // Called if an error occurs
    }
    
    @Override
    public void onComplete() {
        // Called when stream completes
    }
}
```

### 3. Subscribing

```java
// Lambda-based subscription
observable.subscribe(
    item -> System.out.println(item),    // onNext
    error -> error.printStackTrace(),     // onError
    () -> System.out.println("Done")      // onComplete
);

// Observer-based subscription
observable.subscribe(new SimpleObserver());
```

### 4. Common Operators

#### Transformation
```java
observable
    .map(s -> s.toUpperCase())           // Transform each item
    .flatMap(s -> Observable.just(s))    // Transform to Observable
    .concatMap(s -> Observable.just(s))  // Like flatMap, preserves order
```

#### Filtering
```java
observable
    .filter(s -> s.length() > 3)         // Filter items
    .take(5)                              // Take first N
    .skip(2)                              // Skip first N
    .distinct()                           // Remove duplicates
```

#### Combining
```java
Observable.merge(obs1, obs2)              // Merge (interleaved)
Observable.concat(obs1, obs2)             // Concatenate (sequential)
Observable.zip(obs1, obs2, (a,b) -> a+b) // Combine pairwise
```

#### Error Handling
```java
observable
    .onErrorReturn(e -> "default")       // Return fallback value
    .onErrorResumeNext(fallbackObs)      // Switch to fallback
    .retry(3)                            // Retry on error
```

## Backpressure

Flowable handles backpressure - when producer is faster than consumer:

```java
Flowable.range(1, 1000000)
    .onBackpressureBuffer()     // Buffer items
    .onBackpressureDrop()       // Drop excess items
    .onBackpressureLatest()     // Keep only latest
    .observeOn(Schedulers.io())
    .subscribe(item -> process(item));
```

## Schedulers

Control which threads execute operations:

| Scheduler | Use Case |
|-----------|----------|
| `Schedulers.io()` | I/O-bound work |
| `Schedulers.computation()` | CPU-intensive work |
| `Schedulers.newThread()` | New thread per subscriber |
| `Schedulers.single()` | Single reusable thread |
| `AndroidSchedulers.mainThread()` | Android UI thread |

```java
observable
    .subscribeOn(Schedulers.io())        // Subscribe on I/O thread
    .observeOn(Schedulers.computation()) // Observe on compute thread
    .subscribe(...)
```

## RxJava 2 vs RxJava 3

| Feature | RxJava 2 | RxJava 3 |
|---------|----------|----------|
| Package | `io.reactivex` | `io.reactivex.rxjava3` |
| Java Version | 6+ | 8+ |
| Nulls | Not allowed | Not allowed |
| Reactive Streams | 1.0.0 | 1.0.3 |

## Best Practices

1. **Dispose subscriptions** - Prevent memory leaks
2. **Handle errors** - Always provide error handling
3. **Use appropriate type** - Single, Maybe, Completable when applicable
4. **Mind the schedulers** - Don't block on main/UI thread
5. **Consider backpressure** - Use Flowable for potentially large streams

## Common Pitfalls

- ❌ Forgetting to subscribe
- ❌ Not disposing subscriptions
- ❌ Blocking on observable threads
- ❌ Ignoring backpressure with large streams
- ❌ Not handling errors

## Related Modules

- `reactor` - Project Reactor (alternative reactive library)
- `core-java` - CompletableFuture examples

