# Mockito Testing Module

This module demonstrates unit testing with JUnit 5 and Mockito framework, showcasing best practices for mocking dependencies and writing effective tests.

## Module Overview

The `proj_mockito` module provides examples of:
- JUnit 5 testing features
- Mockito mocking framework
- Test-driven development (TDD) practices
- Service layer testing patterns

## Package Structure

### Main Classes (`src/main/java`)

| Package | Class | Description |
|---------|-------|-------------|
| `com.user` | `User` | User domain entity |
| `com.user` | `UserService` | Business logic for user operations |
| `com.user` | `UserRepository` | Interface for data access |
| `com.user` | `UserRepositoryImpl` | Repository implementation |
| `com.user` | `UserException` | Custom exception for user operations |
| `com.test.main` | `Calculator` | Simple calculator for demo |

### Test Classes (`src/test/java`)

| Package | Class | Description |
|---------|-------|-------------|
| `com.test.user` | `UserServiceTest` | Tests for UserService with mocking |
| `com.test` | `CalculatorTest` | Calculator unit tests |
| `com.test` | `DemoTest` | Various JUnit 5 features demo |
| `com.test` | `MethodOrdersTest` | Test method ordering examples |
| `com.test` | `NeedToRunFirstTest` | Test execution order demo |

## Prerequisites

- **Java 17** or higher
- **Maven 3.6+**

## Dependencies

| Dependency | Version | Purpose |
|------------|---------|---------|
| JUnit Jupiter API | 5.8.2 | Test annotations and assertions |
| JUnit Jupiter Params | 5.8.2 | Parameterized tests |
| JUnit Jupiter Engine | 5.8.2 | Test execution engine |
| Mockito JUnit Jupiter | 4.8.0 | Mocking framework integration |

## Building the Module

```bash
# From the root project directory
mvn clean install -pl proj_mockito

# Or from the proj_mockito directory
cd proj_mockito
mvn clean install
```

## Running Tests

```bash
# Run all tests
mvn test

# Run specific test class
mvn test -Dtest=UserServiceTest

# Run with verbose output
mvn test -Dtest=UserServiceTest -DtrimStackTrace=false
```

## Key Testing Concepts Demonstrated

### 1. Mockito Annotations

```java
@ExtendWith(MockitoExtension.class)  // Enable Mockito
public class UserServiceTest {

    @InjectMocks
    UserService userService;  // Class under test with mocks injected

    @Mock
    UserRepositoryImpl userRepository;  // Mock dependency
}
```

### 2. Arrange-Act-Assert Pattern

```java
@Test
void testCreateUser_whenUserDetailsProvided_returnUserObject() {
    // Arrange - Set up test data and mock behavior
    Mockito.when(userRepository.save(Mockito.any(User.class))).thenReturn(true);

    // Act - Execute the method under test
    User user = userService.save(new User(...));

    // Assert - Verify the results
    assertNotNull(user, "User object should not be null!");
}
```

### 3. Mock Verification

```java
// Verify method was called exactly once
Mockito.verify(userRepository, Mockito.times(1)).save(Mockito.any(User.class));

// Verify method was never called
Mockito.verify(userRepository, Mockito.never()).delete(Mockito.any());
```

### 4. Exception Testing

```java
@Test
void testCreateUser_whenFirstNameEmpty_throwsException() {
    UserException exception = assertThrows(UserException.class, () -> {
        userService.save(new User(id, "", lastName, email, mobileNumber));
    });
    
    assertEquals("User First name is either null or blank/empty!", exception.getMessage());
}
```

### 5. Test Lifecycle

```java
@BeforeEach
void init() {
    // Setup before each test
}

@AfterEach
void cleanup() {
    // Cleanup after each test
}

@BeforeAll
static void setupAll() {
    // Setup before all tests (static)
}
```

## JUnit 5 Features Covered

### Assertions

| Method | Description |
|--------|-------------|
| `assertEquals()` | Check equality |
| `assertNotNull()` | Check not null |
| `assertTrue()` / `assertFalse()` | Check boolean |
| `assertThrows()` | Verify exception thrown |
| `assertAll()` | Group multiple assertions |
| `assertTimeout()` | Check execution time |

### Parameterized Tests

```java
@ParameterizedTest
@ValueSource(strings = {"racecar", "radar", "able was I ere I saw elba"})
void palindromes(String candidate) {
    assertTrue(isPalindrome(candidate));
}

@ParameterizedTest
@CsvFileSource(resources = "/csvFileSource.csv")
void testWithCsvFile(String input, int expected) {
    // Test with data from CSV
}
```

### Test Ordering

```java
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class OrderedTest {
    @Test @Order(1)
    void firstTest() { }
    
    @Test @Order(2)
    void secondTest() { }
}
```

## Mockito Features Covered

### Stubbing Methods

```java
// Return a value
when(mock.method()).thenReturn(value);

// Throw an exception
when(mock.method()).thenThrow(new RuntimeException());

// Answer dynamically
when(mock.method(any())).thenAnswer(invocation -> {
    String arg = invocation.getArgument(0);
    return arg.toUpperCase();
});
```

### Argument Matchers

```java
when(mock.method(any())).thenReturn(value);        // Any argument
when(mock.method(anyString())).thenReturn(value);  // Any string
when(mock.method(eq("specific"))).thenReturn(value); // Specific value
when(mock.method(argThat(s -> s.length() > 5))).thenReturn(value); // Custom matcher
```

### Verification

```java
verify(mock).method();                    // Called at least once
verify(mock, times(2)).method();          // Called exactly 2 times
verify(mock, never()).method();           // Never called
verify(mock, atLeastOnce()).method();     // At least once
verify(mock, atMost(3)).method();         // At most 3 times
```

## Test Resources

| File | Description |
|------|-------------|
| `csvFileSource.csv` | Test data for parameterized tests |
| `junit-platform.properties` | JUnit 5 configuration |

## Best Practices Demonstrated

1. **Single Responsibility** - Each test tests one thing
2. **Descriptive Names** - Test names describe what is being tested
3. **Isolation** - Tests don't depend on each other
4. **Fast Execution** - Mocking avoids slow external calls
5. **Readable Assertions** - Clear error messages

## Common Pitfalls Avoided

- ❌ Testing multiple things in one test
- ❌ Sharing state between tests
- ❌ Mocking the class under test
- ❌ Over-mocking (mocking everything)
- ❌ Testing implementation details instead of behavior

## Related Modules

- `core-java` - Java concepts being tested
- `design-patterns` - Patterns that benefit from testing

