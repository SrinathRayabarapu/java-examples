# Core Java Module

This module contains comprehensive examples and demonstrations of core Java programming concepts, from basic fundamentals to advanced features introduced in Java 8 and beyond.

## Module Overview

The `core-java` module is organized into several sub-packages, each focusing on specific areas of Java programming:

### Package Structure

| Package | Description |
|---------|-------------|
| `com.core.annotations` | Examples of Java annotations - built-in and custom annotations |
| `com.core.binding` | Static and dynamic binding demonstrations |
| `com.core.bitwise` | Bitwise operators and operations |
| `com.core.bytes` | Byte manipulation (e.g., image to byte array conversion) |
| `com.core.classes` | Class fundamentals, inner classes, interfaces, abstract classes |
| `com.core.classloader` | Java ClassLoader mechanism examples |
| `com.core.cloning` | Object cloning (shallow vs deep copy) |
| `com.core.codewars` | Solutions to Codewars programming challenges |
| `com.core.collections` | Java Collections Framework - HashMap, HashSet, List, Map, etc. |
| `com.core.comparable` | Comparable interface implementation |
| `com.core.comparator` | Comparator interface and custom comparators |
| `com.core.cowin` | HTTP client and API interaction example |
| `com.core.datentime` | Date and time handling (legacy and modern APIs) |
| `com.core.enums` | Java enumerations |
| `com.core.exceptions` | Exception handling - checked, unchecked, and custom exceptions |
| `com.core.garbagecollector` | Garbage collection concepts and demonstrations |
| `com.core.generics` | Java Generics - type safety, wildcards, bounds |
| `com.core.hash` | Hashing algorithms and implementations |
| `com.core.immutable` | Immutable objects and design patterns |
| `com.core.io` | File I/O operations - streams, readers, writers |
| `com.core.java8` | Java 8+ features - lambdas, streams, Optional, functional interfaces |
| `com.core.locale` | Internationalization and localization |
| `com.core.memory` | Memory management demonstrations |
| `com.core.net` | Networking - sockets, HTTP clients |
| `com.core.oops` | Object-oriented programming principles |
| `com.core.polymorphism` | Polymorphism - method overloading and overriding |
| `com.core.references` | Strong, Weak, Soft, and Phantom references |
| `com.core.regex` | Regular expressions |
| `com.core.security` | Encryption, hashing, and security utilities |
| `com.core.solid` | SOLID principles demonstrations |
| `com.core.strings` | String manipulation and common operations |
| `com.core.threads` | Multi-threading, concurrency, synchronization, locks |
| `com.core.utils` | Utility classes |
| `com.core.wrapperclasses` | Wrapper classes (Integer, Double, etc.) |

### Additional Packages

| Package | Description |
|---------|-------------|
| `com.aaa` | Miscellaneous utility programs and demos |
| `com.advanced.applets` | Java Applet examples (legacy) |
| `com.apps` | Small applications (address book, logbook) |
| `com.assignments` | Interview/assignment solutions |
| `com.bmc` | Puzzle solutions |
| `com.json.examples` | JSON parsing examples |
| `com.mockito` | Mockito testing examples |
| `com.swings` | Java Swing GUI examples |
| `com.util` | General utility classes |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Building the Module

```bash
# From the root project directory
mvn clean install -pl core-java

# Or from the core-java directory
cd core-java
mvn clean install
```

## Running Examples

Most classes contain a `main` method and can be run directly. For example:

```bash
# Compile and run a specific class
cd core-java
mvn compile exec:java -Dexec.mainClass="com.core.java8.streams.StreamsMain"
```

Or run directly from your IDE by right-clicking on the main class and selecting "Run".

## Key Topics Covered

### Java 8+ Features
- **Lambda Expressions** - Functional programming in Java
- **Stream API** - Declarative data processing
- **Optional** - Null-safe programming
- **Functional Interfaces** - Predicate, Function, Consumer, Supplier
- **Method References** - Shorthand for lambdas
- **Default Methods** - Interface evolution
- **CompletableFuture** - Asynchronous programming

### Concurrency & Multi-threading
- Thread creation (Runnable, Thread, Callable)
- Synchronization (synchronized blocks, methods)
- Locks (ReentrantLock, ReadWriteLock)
- Thread pools (ExecutorService, ThreadPoolExecutor)
- Concurrent collections (ConcurrentHashMap, BlockingQueue)
- Thread communication (wait/notify, Condition)
- CountDownLatch, CyclicBarrier, Semaphore

### Collections Framework
- List, Set, Map implementations
- Iterators and concurrent modification
- Comparable vs Comparator
- Custom cache implementations

### Exception Handling
- Checked vs Unchecked exceptions
- Custom exceptions
- Try-with-resources
- Exception chaining

## Dependencies

This module depends on:
- `util` module
- `ds-algo` module  
- `data-layer` module
- External libraries: Lombok, Jackson, Commons-IO, Mockito

## Resources

- Configuration files in `src/main/resources/`
- Sample data files for I/O examples

## Testing

```bash
# Run all tests
mvn test

# Run a specific test class
mvn test -Dtest=ClassName
```

