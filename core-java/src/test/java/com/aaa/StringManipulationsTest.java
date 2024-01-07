package com.aaa;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class StringManipulationsTest {

    @Test
    public void breakStringMeaningfully() {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("tesco");
        dictionary.add("to");
        dictionary.add("srinath");
        dictionary.add("has");
        dictionary.add("come");
        String srinathhascometotesco = StringManipulations.breakStringMeaningfully("srinathhascometotesco", dictionary);
        System.out.println(srinathhascometotesco);
        Assert.assertEquals("srinath has come to tesco", srinathhascometotesco);

    }
}