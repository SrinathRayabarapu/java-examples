# Utility Module

This module provides shared utility classes used across other modules in the java-examples project.

## Module Overview

The `util` module contains common utility classes that can be reused by other modules. It serves as a central location for shared functionality.

## Available Utilities

| Class | Package | Description |
|-------|---------|-------------|
| `RandomSentences` | `com.sri.strings.random` | Generates random sentences for testing |

## Package Structure

```
com.sri/
└── strings/
    └── random/
        └── RandomSentences.java
```

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| JUnit | 4.12 | Testing |

## Building the Module

```bash
# From the root project directory
mvn clean install -pl util

# Or from the util directory
cd util
mvn clean install
```

## Usage

### RandomSentences

Generates random English sentences for testing purposes:

```java
RandomSentences generator = new RandomSentences();

// Get 10 random sentences
List<String> sentences = generator.getOf(10);

// Or use default size
generator.formSentences();
generator.showSentences();
```

**Sample Output:**
```
The boy drove to a girl.
One dog jumped from some town.
A car ran over the boy.
```

### Adding as Dependency

Other modules can use this utility by adding the dependency:

```xml
<dependency>
    <groupId>com.sri.java.examples</groupId>
    <artifactId>util</artifactId>
    <version>${project.parent.version}</version>
</dependency>
```

## Running Examples

```bash
cd util
mvn compile exec:java -Dexec.mainClass="com.sri.strings.random.RandomSentences"
```

## Design Notes

### Why a Separate Util Module?

1. **Code Reuse** - Avoid duplicating utility code across modules
2. **Dependency Management** - Central location for shared dependencies
3. **Testing** - Utilities can be tested independently
4. **Versioning** - Updates propagate to all dependent modules

### Module Dependencies

The following modules depend on `util`:
- `core-java`
- `ds-algo`

## Extending the Module

To add new utilities:

1. Create appropriate package structure under `src/main/java`
2. Add unit tests under `src/test/java`
3. Update this README with documentation
4. Run `mvn install` to make available to other modules

## Best Practices

1. **Keep utilities stateless** - Prefer static methods or immutable instances
2. **Document thoroughly** - Other developers will use these classes
3. **Test extensively** - Utilities are used widely, bugs propagate
4. **Minimize dependencies** - Keep the module lightweight

## Related Modules

All other modules in the project may use utilities from this module.

