package com.dsalgo.strings;

import com.sri.strings.random.RandomSentences;

/**
 * program to make random sentences from different string arrays.
 *
 * @author Srinath.Rayabarapu
 */
public class RandomSentencesMain {
    public static void main(String[] ar) {
        RandomSentences arrays = new RandomSentences();
        arrays.formSentences();
        arrays.showSentences();
    }
}