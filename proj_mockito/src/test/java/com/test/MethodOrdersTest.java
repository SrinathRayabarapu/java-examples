package com.test;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodOrdersTest {

    StringBuilder builder = new StringBuilder("");

    @AfterEach
    void afterEach(){
        System.out.println(builder.toString());
    }

    @Order(1)
    @Test
    void method3(){
        System.out.println("Executing method 3");
        builder.append("3");
    }

    @Order(3)
    @Test
    void method1(){
        System.out.println("Executing method 1");
        builder.append("1");
    }

    @Order(2)
    @Test
    void method4(){
        System.out.println("Executing method 4");
        builder.append("4");
    }

    @Order(4)
    @Test
    void method2(){
        System.out.println("Executing method 2");
        builder.append("2");
    }

}
