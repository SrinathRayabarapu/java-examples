package com.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(3)
public class NeedToRunThirdTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Running NeedToRunThirdTest class");
    }

    @Test
    void someTest(){
        System.out.println("Some test in NeedToRunThirdTest");
    }

}
