package com.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@Order(2)
public class NeedToRunSecondTest {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Running NeedToRunSecondTest class");
    }

    @Test
    void someTest(){
        System.out.println("Some test in NeedToRunSecondTest");
    }

}
