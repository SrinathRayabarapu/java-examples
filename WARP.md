# WARP.md

This file provides guidance to WARP (warp.dev) when working with code in this repository.

## Project Overview

This is a **multi-module Maven project** containing Java learning examples, data structures, algorithms, design patterns, and practical implementations. It serves as a comprehensive reference and practice repository for Java development concepts.

**Java Version**: Java 21 (compiler target), with some modules using Java 17
**Build Tool**: Apache Maven 3.x

## Build Commands

### Full Build
```bash
mvn clean install
```

### Build Without Tests
```bash
mvn clean install -DskipTests
```

### Build Specific Module
```bash
mvn clean install -pl <module-name> -am
```
Example: `mvn clean install -pl ds-algo -am`

The `-am` flag builds required dependencies (like `util` module).

### Package (JAR Creation)
```bash
mvn clean package
```

## Testing

### Run All Tests
```bash
mvn test
```

### Run Tests for Specific Module
```bash
mvn test -pl <module-name>
```

### Run a Single Test Class
```bash
mvn test -Dtest=ClassName
```
Example: `mvn test -pl proj_mockito -Dtest=CalculatorTest`

### Run a Single Test Method
```bash
mvn test -Dtest=ClassName#methodName
```

**Note**: This project uses both JUnit 4 (in `ds-algo`) and JUnit 5 (in `proj_mockito` and root parent).

## Code Architecture

### Multi-Module Structure

The project follows a **flat multi-module Maven structure** where all modules are siblings under the root `java-examples` parent POM. Modules are categorized by their learning focus:

#### Core Learning Modules

- **`ds-algo`**: Data structures and algorithms (300+ implementations)
  - Arrays, linked lists, trees, graphs, stacks, queues
  - Sorting, searching, hashing, dynamic programming
  - Divide and conquer algorithms (see `divideandconquer` package)
  - Located in: `com.dsalgo.*`
  
- **`core-java`**: Core Java language concepts
  - Various packages exploring Java fundamentals
  - Contains dependencies on `util`, `ds-algo`, and `data-layer`
  - Located in: `com.*` (multiple top-level packages)

- **`design-patterns`**: Gang of Four and other design patterns
  - Located in: `com.design.*`, `com.dpattern.*`

- **`lld`**: Low-Level Design examples (system design implementations)
  - `com.parkinglot.*` - Parking lot system
  - `com.splitwise.*` - Expense sharing system

#### Technology-Specific Modules

- **`proj_mockito`**: Mockito and JUnit 5 examples
  - Test ordering examples (`NeedToRunFirstTest`, etc.)
  - Uses JUnit Jupiter (5.8.2) and Mockito (4.8.0)

- **`reactor`**: Project Reactor (reactive programming)
  - Uses reactor-core 3.5.0

- **`rx-java`**: RxJava examples

- **`resilience4j`**: Circuit breaker and resilience patterns

- **`data-layer`**: Database access examples
  - Hibernate 4.3.6 implementations
  - Located in: `com.hibernate.*`, `com.jdbc.*`

- **`proj_pdf`**: PDF generation examples

- **`proj_qrcode`**: QR code generation

#### Utility Module

- **`util`**: Shared utilities (string utilities, etc.)
  - Located in: `com.sri.strings.*`
  - Used as a dependency by `ds-algo` and `core-java`

### Module Dependencies

```
core-java
  ├── depends on: util
  ├── depends on: ds-algo
  └── depends on: data-layer

ds-algo
  └── depends on: util
```

All other modules are independent.

### Key Architectural Patterns

1. **Test-Driven Examples**: Most modules contain extensive test suites demonstrating usage
2. **Self-Contained Implementations**: Each module is focused on a specific topic and can be studied independently
3. **Practical Examples**: Modules like `lld` contain complete system implementations, not just snippets
4. **Documentation Embedded**: Many algorithms include in-code documentation (e.g., `ds-algo/divideandconquer/README.md`)

## Important Project Conventions

### Package Structure
- Most modules use `com.*` as the base package with topic-specific subpackages
- The `ds-algo` module is particularly large with ~304 Java files organized by algorithm category

### Testing Conventions
- Test classes follow the `*Test.java` naming convention
- Tests are located in `src/test/java` following standard Maven structure
- The `proj_mockito` module demonstrates JUnit 5 test ordering features

### Lombok Usage
- The project uses Lombok (1.18.42) for reducing boilerplate
- Lombok annotation processing is configured in the parent POM

## Continuous Integration

The project uses GitHub Actions (`.github/workflows/maven.yml`):
- Runs on: `ubuntu-latest` with JDK 21 (Temurin distribution)
- Triggered on: pushes and PRs to `master` branch
- Command: `mvn -B package --file pom.xml`

## Working with this Repository

### When Adding New Modules
1. Add the module directory under the root
2. Update the `<modules>` section in the root `pom.xml`
3. Set the parent reference in the module's `pom.xml`

### When Working with Data Structures/Algorithms
- Check `ds-algo/src/main/java/com/dsalgo/` for existing implementations
- Many implementations include both iterative and recursive versions
- Look for companion README files in specific packages (e.g., `divideandconquer/README.md`)

### When Writing Tests
- Use JUnit 5 for new test code (as in `proj_mockito`)
- Leverage Mockito (available project-wide) for mocking dependencies
- Follow existing test naming conventions in the relevant module
