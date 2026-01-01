package com.resilience4j;

/**
 * Main entry point for Resilience4j fault tolerance examples.
 * 
 * <p>Resilience4j is a lightweight fault tolerance library designed for
 * functional programming. It provides higher-order functions (decorators)
 * to enhance any functional interface, lambda expression, or method reference
 * with a Circuit Breaker, Rate Limiter, Retry, or Bulkhead.</p>
 * 
 * <h3>Core Patterns:</h3>
 * <ul>
 *   <li><b>Circuit Breaker</b> - Prevents cascading failures by failing fast</li>
 *   <li><b>Retry</b> - Retries failed operations with configurable backoff</li>
 *   <li><b>Rate Limiter</b> - Limits the number of calls per period</li>
 *   <li><b>Bulkhead</b> - Limits concurrent executions</li>
 *   <li><b>Time Limiter</b> - Sets timeout for async operations</li>
 * </ul>
 * 
 * <h3>Key Benefits over Hystrix:</h3>
 * <ul>
 *   <li>Lightweight with minimal dependencies</li>
 *   <li>Designed for Java 8+ functional programming</li>
 *   <li>Native support for reactive libraries</li>
 *   <li>Actively maintained</li>
 * </ul>
 * 
 * <h3>Usage Pattern:</h3>
 * <pre>{@code
 * CircuitBreaker circuitBreaker = CircuitBreaker.ofDefaults("myService");
 * Supplier<String> decoratedSupplier = CircuitBreaker
 *     .decorateSupplier(circuitBreaker, () -> callExternalService());
 * String result = decoratedSupplier.get();
 * }</pre>
 * 
 * @author Srinath.Rayabarapu
 * @see <a href="https://resilience4j.readme.io/">Resilience4j Documentation</a>
 * @see <a href="https://javatechonline.com/how-to-implement-fault-tolerance-in-microservices-using-resilience4j/">Tutorial</a>
 */
public class Resilience4jMain {
    
    /**
     * Main method - placeholder for Resilience4j examples.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        // TODO: Add Resilience4j examples
        System.out.println("Resilience4j Examples - See README.md for details");
    }
}
