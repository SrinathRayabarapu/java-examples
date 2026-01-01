# Resilience4j Module

This module demonstrates fault tolerance patterns using Resilience4j library for building resilient microservices.

## Module Overview

Resilience4j is a lightweight fault tolerance library inspired by Netflix Hystrix, designed for Java 8+ and functional programming. This module provides examples of implementing resilience patterns in Java applications.

## What is Resilience4j?

Resilience4j provides several core modules for fault tolerance:

| Module | Description | Use Case |
|--------|-------------|----------|
| **Circuit Breaker** | Prevents cascading failures | When downstream service is failing |
| **Rate Limiter** | Limits call frequency | API throttling, resource protection |
| **Retry** | Retries failed operations | Transient failures |
| **Bulkhead** | Limits concurrent calls | Resource isolation |
| **Time Limiter** | Sets call timeouts | Preventing hanging calls |
| **Cache** | Caches results | Performance optimization |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Building the Module

```bash
# From the root project directory
mvn clean install -pl resilience4j

# Or from the resilience4j directory
cd resilience4j
mvn clean install
```

## Core Patterns

### 1. Circuit Breaker

Prevents repeated calls to a failing service:

```java
CircuitBreakerConfig config = CircuitBreakerConfig.custom()
    .failureRateThreshold(50)                     // 50% failure rate opens circuit
    .waitDurationInOpenState(Duration.ofSeconds(30))
    .slidingWindowSize(10)
    .build();

CircuitBreaker circuitBreaker = CircuitBreaker.of("myService", config);

Supplier<String> decoratedSupplier = CircuitBreaker
    .decorateSupplier(circuitBreaker, () -> callExternalService());
```

**States:**
- **CLOSED** - Normal operation, calls pass through
- **OPEN** - Circuit is open, calls fail fast
- **HALF_OPEN** - Testing if service recovered

### 2. Retry

Retries failed operations with configurable backoff:

```java
RetryConfig config = RetryConfig.custom()
    .maxAttempts(3)
    .waitDuration(Duration.ofMillis(500))
    .retryOnException(e -> e instanceof IOException)
    .build();

Retry retry = Retry.of("myService", config);

Supplier<String> decoratedSupplier = Retry
    .decorateSupplier(retry, () -> callExternalService());
```

### 3. Rate Limiter

Controls the rate of calls:

```java
RateLimiterConfig config = RateLimiterConfig.custom()
    .limitForPeriod(10)                           // 10 calls per period
    .limitRefreshPeriod(Duration.ofSeconds(1))    // 1 second refresh
    .timeoutDuration(Duration.ofMillis(100))      // Wait time if limit reached
    .build();

RateLimiter rateLimiter = RateLimiter.of("myService", config);
```

### 4. Bulkhead

Limits concurrent calls:

```java
// Semaphore Bulkhead
BulkheadConfig config = BulkheadConfig.custom()
    .maxConcurrentCalls(10)
    .maxWaitDuration(Duration.ofMillis(100))
    .build();

Bulkhead bulkhead = Bulkhead.of("myService", config);

// Thread Pool Bulkhead
ThreadPoolBulkheadConfig tpConfig = ThreadPoolBulkheadConfig.custom()
    .maxThreadPoolSize(10)
    .coreThreadPoolSize(5)
    .queueCapacity(100)
    .build();
```

### 5. Time Limiter

Sets timeout for operations:

```java
TimeLimiterConfig config = TimeLimiterConfig.custom()
    .timeoutDuration(Duration.ofSeconds(2))
    .build();

TimeLimiter timeLimiter = TimeLimiter.of("myService", config);

CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> 
    callExternalService());
    
Callable<String> decoratedCallable = TimeLimiter
    .decorateFutureSupplier(timeLimiter, () -> future);
```

## Combining Patterns

Patterns can be combined for comprehensive fault tolerance:

```java
// Combine Retry + CircuitBreaker + Bulkhead
Supplier<String> decoratedSupplier = Decorators.ofSupplier(() -> callService())
    .withRetry(retry)
    .withCircuitBreaker(circuitBreaker)
    .withBulkhead(bulkhead)
    .decorate();
```

**Order matters!** Recommended order:
1. Bulkhead (outermost)
2. Time Limiter
3. Rate Limiter
4. Circuit Breaker
5. Retry (innermost)

## Metrics and Monitoring

Resilience4j provides built-in metrics:

```java
CircuitBreaker.Metrics metrics = circuitBreaker.getMetrics();
float failureRate = metrics.getFailureRate();
int numberOfFailedCalls = metrics.getNumberOfFailedCalls();
```

## Best Practices

1. **Tune thresholds carefully** - Based on your SLA requirements
2. **Use fallbacks** - Provide graceful degradation
3. **Monitor metrics** - Track circuit breaker state changes
4. **Test failure scenarios** - Ensure patterns work as expected
5. **Log state transitions** - For debugging and alerting

## Spring Boot Integration

For Spring Boot applications, use the Resilience4j Spring Boot starter:

```xml
<dependency>
    <groupId>io.github.resilience4j</groupId>
    <artifactId>resilience4j-spring-boot2</artifactId>
    <version>1.7.1</version>
</dependency>
```

Then use annotations:

```java
@CircuitBreaker(name = "myService", fallbackMethod = "fallback")
@Retry(name = "myService")
public String callExternalService() {
    // ...
}
```

## Comparison with Hystrix

| Feature | Resilience4j | Hystrix |
|---------|--------------|---------|
| Dependencies | Lightweight | Heavy (Netflix stack) |
| Java Version | 8+ (functional) | 6+ |
| Maintenance | Active | Maintenance mode |
| Reactive | Native support | Limited |
| Configuration | Code or YAML | Archaius |

## Resources

- [Official Documentation](https://resilience4j.readme.io/)
- [GitHub Repository](https://github.com/resilience4j/resilience4j)
- [Tutorial Reference](https://javatechonline.com/how-to-implement-fault-tolerance-in-microservices-using-resilience4j/)

## Related Modules

- `reactor` - Reactive programming (Resilience4j integrates with Reactor)
- `core-java` - Exception handling patterns

