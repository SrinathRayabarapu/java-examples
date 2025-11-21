package com.puzzles;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * @author srinath rayabarapu
 */
public class VowelCountMainTest {

    @Test
    public void testCase1() {
        assertEquals(5, VowelCountMain.getCountLinear("abracadabra"), "Nope!");
    }

    @Test
    public void testCase2() {
        assertEquals(5, VowelCountMain.getCountClever("abracadabra"), "Nope!");
    }

}