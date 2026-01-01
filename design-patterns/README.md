# Design Patterns Module

This module provides comprehensive implementations of Gang of Four (GoF) design patterns and other common software design patterns in Java.

## Module Overview

Design patterns are reusable solutions to common problems in software design. They represent best practices evolved over time by experienced software developers. This module organizes patterns into three main categories:

## Pattern Categories

### 1. Creational Patterns
Patterns that deal with object creation mechanisms.

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Singleton** | Ensures only one instance exists | Logging, Configuration, Thread Pools |
| **Factory** | Creates objects without exposing creation logic | Shape creation, Document handling |
| **Abstract Factory** | Creates families of related objects | Cross-platform UI components |
| **Builder** | Constructs complex objects step by step | Building complex configurations |
| **Prototype** | Creates objects by cloning existing ones | Object caching, expensive object creation |

### 2. Structural Patterns
Patterns that deal with object composition and class relationships.

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Adapter** | Makes incompatible interfaces work together | Legacy system integration |
| **Composite** | Treats individual and composite objects uniformly | File systems, UI hierarchies |
| **Decorator** | Adds behavior to objects dynamically | Stream wrappers, UI components |
| **Facade** | Provides a simplified interface to complex subsystems | API simplification |
| **Flyweight** | Shares common state to support large numbers of objects | Game objects, Character rendering |
| **Proxy** | Controls access to another object | Lazy loading, access control |

### 3. Behavioral Patterns
Patterns that deal with object communication and responsibility.

| Pattern | Description | Use Case |
|---------|-------------|----------|
| **Chain of Responsibility** | Passes requests along a chain of handlers | Event handling, Logging |
| **Command** | Encapsulates requests as objects | Undo/Redo, Transaction management |
| **Observer** | Notifies dependents of state changes | Event systems, MVC pattern |
| **State** | Alters behavior when internal state changes | State machines, Workflow |
| **Strategy** | Defines interchangeable algorithms | Sorting, Payment processing |

## Package Structure

```
com.dpattern/
├── behavioural/
│   ├── chainofresponsibility/
│   ├── command/
│   ├── observer/
│   ├── state/
│   └── strategy/
├── creational/
│   ├── abstractfactory/
│   ├── breaksingleton/
│   ├── builder/
│   ├── factory/
│   ├── prototype/
│   └── singleton/
├── structural/
│   ├── adapter/
│   ├── composite/
│   ├── decorator/
│   ├── facade/
│   ├── flyweight/
│   └── proxy/
└── businessdelegate/

com.design/
└── oopsprinciples/  (SOLID principles examples)
```

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Building the Module

```bash
# From the root project directory
mvn clean install -pl design-patterns

# Or from the design-patterns directory
cd design-patterns
mvn clean install
```

## Running Examples

Each pattern has a `Main` class that demonstrates its usage:

```bash
# Run Singleton Pattern example
mvn compile exec:java -Dexec.mainClass="com.dpattern.creational.singleton.SingletonPatternMain"

# Run Factory Pattern example
mvn compile exec:java -Dexec.mainClass="com.dpattern.creational.factory.FactoryPatternMain"

# Run Observer Pattern example
mvn compile exec:java -Dexec.mainClass="com.dpattern.behavioural.observer.ex1.ObserverPatternMain"

# Run Adapter Pattern example
mvn compile exec:java -Dexec.mainClass="com.dpattern.structural.adapter.AdapterPatternMain"
```

## Pattern Implementations

### Singleton Pattern Variants

| Implementation | Thread-Safe | Lazy Loading | Description |
|---------------|-------------|--------------|-------------|
| `SingletonCommon` | No | Yes | Basic implementation |
| `SingletonEager` | Yes | No | Eager initialization |
| `LazySingleton` | Yes (with double-check) | Yes | Double-checked locking |
| `BillPughSinglePattern` | Yes | Yes | Inner class holder pattern (recommended) |
| `SingletonPatternEnumMain` | Yes | Yes | Enum-based (most robust) |

### Breaking & Protecting Singleton

- `BreakSingletonCommonMain` - Shows how to break singleton using reflection
- `ReflectionSingleMain` - Reflection-based singleton breaking
- `SingletonReflectionPreventionMain` - How to prevent reflection attacks

### Builder Pattern Examples

- **Good Example** (`good/`)  - Traditional builder with director
- **Best Example** (`best/`) - Fluent builder API (recommended)
- **Student Builder** - Real-world entity building

### Observer Pattern Examples

- **Example 1** (`ex1/`) - Classic push-based observer
- **Example 2** (`ex2/`) - Interface-based implementation

### Decorator Pattern Examples

- **Shape Decorator** - Adding behavior to shapes
- **Pizza Decorator** (`ex2/`) - Toppings as decorators

## SOLID Principles

The `com.design.oopsprinciples` package demonstrates:

| Principle | Class | Description |
|-----------|-------|-------------|
| **S** - Single Responsibility | `Account` | One reason to change |
| **O** - Open/Closed | `FileHandler` | Open for extension, closed for modification |
| **L** - Liskov Substitution | `SavingsAccount` | Subtypes substitutable for base types |
| **I** - Interface Segregation | `IWithdraw`, `IProcessInterest` | Specific interfaces |
| **D** - Dependency Inversion | Various | Depend on abstractions |

## Key Concepts

### When to Use Which Pattern

**Creational:**
- Use **Singleton** when exactly one instance is needed globally
- Use **Factory** when the exact class to create is determined at runtime
- Use **Builder** when object construction is complex with many optional parameters

**Structural:**
- Use **Adapter** when integrating incompatible interfaces
- Use **Decorator** when you need to add responsibilities dynamically
- Use **Facade** when you want to simplify a complex subsystem

**Behavioral:**
- Use **Observer** for publish-subscribe scenarios
- Use **Strategy** when you have multiple interchangeable algorithms
- Use **Command** when you need to parameterize objects with operations

## Best Practices Demonstrated

1. **Program to interfaces** - All patterns use interfaces/abstract classes
2. **Favor composition over inheritance** - Decorator, Strategy patterns
3. **Encapsulate what varies** - Factory, Strategy patterns
4. **Loose coupling** - Observer, Mediator patterns

## Additional Resources

- [Refactoring Guru - Design Patterns](https://refactoring.guru/design-patterns)
- [Gang of Four Book](https://www.amazon.com/Design-Patterns-Elements-Reusable-Object-Oriented/dp/0201633612)
- [Head First Design Patterns](https://www.amazon.com/Head-First-Design-Patterns-Brain-Friendly/dp/0596007124)

## Related Modules

- `core-java` - Uses patterns in practical examples
- `lld` - Low-level design applying these patterns

