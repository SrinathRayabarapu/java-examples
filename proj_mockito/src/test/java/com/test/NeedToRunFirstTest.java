package com.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(1)
public class NeedToRunFirstTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Running NeedToRunFirstTest class");
    }

    @Test
    void someTest(){
        System.out.println("Some test in NeedToRunFirstTest");
    }

}
