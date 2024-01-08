package com.test;

import com.test.main.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Test Math operations in Calculator class")
class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll method called");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll method called");
    }

    static Stream<Arguments> parameterisedMethod() {
        return Stream.of(Arguments.of(5, 3, 2),
                Arguments.of(5, 0, 5),
                Arguments.of(-5, 3, -8));
    }

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
        System.out.println("@BeforeEach method called");
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach method called");
    }

    // test<System under Test>_<Condition or State change>_<Expected Result>
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        // Arrange (Given)
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

        // Act (When)
        int actualResult = calculator.integerDivision(dividend, divisor);

        // Assess (Then)
        Assertions.assertEquals(expectedResult, actualResult, "The value didn't match!");
    }

//    @Disabled("Way to disable a test!")
    @DisplayName("Divisible by Zero")
    @Test
    void testIntegerDivision_WhenFourIsDividedByZero_ShouldThrowArithmeticException() {
        ArithmeticException exception = Assertions.assertThrows(ArithmeticException.class, () -> calculator.integerDivision(4, 0));
        assertEquals("Divisor is Zero", exception.getMessage());
    }

    @Test
    void testIntegerSubtraction_WhenThreeIsSubtractedByOne_ShouldReturnTwo() {
        int result = calculator.integerSubtraction(3, 1);
        assertEquals(2, result);
    }

    @ParameterizedTest
//    @MethodSource("parameterisedMethod")
//    @CsvSource({"-5, 3, -8"})
    @CsvFileSource(resources = "/csvFileSource.csv")
    void testParameterisedMethod_WhenAListOfArgumentsProvided_ShouldExecuteAllOfTheParams(int minuend, int subtrahend,
                                                                                          int expectedResult) {
        int actualValue = calculator.integerSubtraction(minuend, subtrahend);
        assertEquals(expectedResult, actualValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"srinath", "hitharsh", "viyansh"})
    void valueSourceExample(String someText) {
        System.out.println(someText);
        assertNotNull(someText);
    }

    @RepeatedTest(3)
    void repeatedTest(RepetitionInfo repetitionInfo, TestInfo testInfo) {
        System.out.println("This " + testInfo.getTestMethod().get().getName() + " is repeating for : " + repetitionInfo.getCurrentRepetition());
    }

}