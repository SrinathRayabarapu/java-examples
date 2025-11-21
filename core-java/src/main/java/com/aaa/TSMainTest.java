package com.aaa;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author Srinath Rayabarapu
 */
public class TSMainTest {

    @Test
    public void testTescoString() {
        List<String> input = new ArrayList<>();
        input.add("abctesco");
        input.add("abctescoxyz");
        input.add("tesco");
        input.add("TESCOxyz");
        input.add("abctes");
        input.add("aTeSCo");
        input.add("abcsco");
        List<String> stringTesco = new TSMain().findStringTesco(input, "Tesco");
        System.out.println(stringTesco);
        assertEquals(5, stringTesco.size());
    }

}