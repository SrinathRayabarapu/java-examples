package com.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerFunctionMainTest {

    @Test
    void power() {
        assertEquals(25, PowerFunctionMain.power(5, 2));

//        assertEquals(25, PowerFunctionMain.power1(5, 2));

//        assertEquals(8, PowerFunctionMain.power1(2, 3));

        assertEquals(19683, PowerFunctionMain.power1(3, 9));
    }
}