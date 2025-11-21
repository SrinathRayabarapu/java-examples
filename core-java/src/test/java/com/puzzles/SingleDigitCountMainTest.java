package com.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingleDigitCountMainTest {

    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, SingleDigitCountMain.persistence(39));
        assertEquals(0, SingleDigitCountMain.persistence(4));
        assertEquals(2, SingleDigitCountMain.persistence(25));
        assertEquals(4, SingleDigitCountMain.persistence(999));
    }

}