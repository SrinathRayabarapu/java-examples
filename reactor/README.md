# Project Reactor Module

This module demonstrates reactive programming using Project Reactor, the foundation of Spring WebFlux.

## Module Overview

The `reactor` module provides comprehensive examples of:
- Reactive Streams specification implementation
- Flux (0..N elements) operations
- Mono (0..1 elements) operations
- Error handling strategies
- Testing reactive streams

## What is Project Reactor?

Project Reactor is a fourth-generation reactive library based on the Reactive Streams specification. It provides two main types:

| Type | Description | Use Case |
|------|-------------|----------|
| **Mono<T>** | Async sequence of 0..1 elements | Single value operations |
| **Flux<T>** | Async sequence of 0..N elements | Multiple value operations |

## Package Structure

| Package | Description |
|---------|-------------|
| `com.reactor` | Main application and examples |
| `com.reactor.domain` | Domain entities (Book, Review) |
| `com.reactor.services` | Reactive service implementations |
| `com.reactor.services.exceptions` | Custom business exceptions |

## Key Classes

### Services

| Class | Description |
|-------|-------------|
| `FluxServices` | Flux operations (map, flatMap, concat, merge, zip) |
| `MonoServices` | Mono operations |
| `BookService` | Reactive book information service |
| `BookInfoService` | Book metadata service |
| `ReviewService` | Book review service |

### Domain

| Class | Description |
|-------|-------------|
| `Book` | Book aggregate with info and reviews |
| `BookInfo` | Book metadata (title, author, ISBN) |
| `Review` | Book review with rating |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| reactor-core | 3.5.0 | Core reactive library |
| reactor-tools | 3.5.0 | Debugging tools |
| reactor-test | 3.5.0 | Testing utilities |

## Building the Module

```bash
# From the root project directory
mvn clean install -pl reactor

# Or from the reactor directory
cd reactor
mvn clean install
```

## Running Examples

```bash
cd reactor
mvn compile exec:java -Dexec.mainClass="com.reactor.ReactorMain"
```

## Core Concepts Demonstrated

### 1. Creating Reactive Streams

```java
// Flux - multiple elements
Flux<String> fruitsFlux = Flux.fromIterable(List.of("Apple", "Banana"));
Flux<Integer> numbers = Flux.range(1, 10);

// Mono - single element
Mono<String> fruit = Mono.just("Mango");
Mono<Object> empty = Mono.empty();
```

### 2. Transforming Data

```java
// map - synchronous 1:1 transformation
fruitsFlux.map(String::toUpperCase);

// flatMap - async 1:N transformation (unordered)
fruitsFlux.flatMap(s -> Flux.just(s.split("")));

// concatMap - async 1:N transformation (ordered)
fruitsFlux.concatMap(s -> Flux.just(s.split("")));
```

### 3. Combining Streams

```java
// concat - sequential, preserves order
Flux.concat(flux1, flux2);

// merge - interleaved, async
Flux.merge(flux1, flux2);

// mergeSequential - parallel execution, ordered result
Flux.mergeSequential(flux1, flux2);

// zip - combines elements pairwise
Flux.zip(flux1, flux2, (a, b) -> a + b);
```

### 4. Error Handling

```java
// Return fallback value
flux.onErrorReturn("default");

// Switch to alternate stream
flux.onErrorResume(e -> Flux.just("backup"));

// Continue processing on error
flux.onErrorContinue((e, item) -> log.error("Skipped: " + item));

// Transform exception
flux.onErrorMap(MyBusinessException::new);
```

### 5. Side Effects

```java
flux.doOnNext(item -> log.info("Processing: " + item))
    .doOnError(e -> log.error("Error: " + e))
    .doOnComplete(() -> log.info("Done!"))
    .doOnSubscribe(sub -> log.info("Subscribed"));
```

### 6. Handling Empty Streams

```java
// Default value if empty
flux.defaultIfEmpty("default");

// Switch to alternate stream if empty
flux.switchIfEmpty(Flux.just("alternate"));
```

## Operators Reference

### Transformation Operators

| Operator | Description |
|----------|-------------|
| `map` | Transform each element synchronously |
| `flatMap` | Transform to Publisher, merge results (unordered) |
| `concatMap` | Transform to Publisher, concat results (ordered) |
| `transform` | Apply a function to the whole Flux |

### Filtering Operators

| Operator | Description |
|----------|-------------|
| `filter` | Keep elements matching predicate |
| `take` | Take first N elements |
| `skip` | Skip first N elements |
| `distinct` | Remove duplicates |

### Combining Operators

| Operator | Description |
|----------|-------------|
| `concat` | Append streams sequentially |
| `merge` | Merge streams, interleave elements |
| `zip` | Combine elements pairwise |
| `combineLatest` | Combine latest from each |

### Error Handling

| Operator | Description |
|----------|-------------|
| `onErrorReturn` | Return fallback value |
| `onErrorResume` | Switch to fallback stream |
| `onErrorContinue` | Skip failed element, continue |
| `onErrorMap` | Transform the error |
| `retry` | Retry on error |

## Testing with StepVerifier

```java
@Test
void testFruitsFlux() {
    Flux<String> fruits = fluxServices.fruitsFlux();
    
    StepVerifier.create(fruits)
        .expectNext("Banana")
        .expectNext("Orange")
        .expectNextCount(3)
        .verifyComplete();
}
```

## Best Practices

1. **Never block in reactive code** - Use `subscribe()` or return the Publisher
2. **Handle errors properly** - Always have an error handling strategy
3. **Use checkpoints for debugging** - Helps identify where errors occur
4. **Choose the right operator** - `flatMap` vs `concatMap` based on ordering needs
5. **Use reactor-tools for debugging** - Better stack traces in development

## Common Pitfalls

- ❌ Calling `.block()` in reactive code
- ❌ Not subscribing to the stream
- ❌ Ignoring backpressure
- ❌ Using blocking I/O in reactive chains
- ❌ Not handling errors in the stream

## Related Modules

- `rx-java` - RxJava reactive examples
- `resilience4j` - Fault tolerance with reactive
- `core-java` - CompletableFuture comparison

