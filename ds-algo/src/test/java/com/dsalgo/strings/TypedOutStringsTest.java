package com.dsalgo.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TypedOutStringsTest {

    @Test
    void test(){
        TypedOutStrings typedOutStrings = new TypedOutStrings();

        assertTrue(typedOutStrings.backspaceCompare("ab#c","ad#c"));

        assertTrue(typedOutStrings.backspaceCompare("ab##","c#d#"));

        assertFalse(typedOutStrings.backspaceCompare("a#c","b"));

        assertTrue(typedOutStrings.backspaceCompare("a##c","#a#c"));

    }

}