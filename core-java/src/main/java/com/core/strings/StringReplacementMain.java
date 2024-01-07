package com.core.strings;

/**
 * In DNA strings, symbols "A" and "T" are complements of each other, as "C" and "G". You have
 * function with one side of the DNA (string, except for Haskell); you need to get the other
 * complementary side. DNA strand is never empty or there is no DNA at all.
 * <p>
 * Example:
 * makeComplement("ATTGC") // return "TAACG"
 * makeComplement("GTAT") // return "CATA"
 *
 * @author Srinath Rayabarapu
 */
public class StringReplacementMain {

    public static void main(String[] args) {
        // A~T C~G
        System.out.println(makeComplement("ATTGC")); // return "TAACG"
        System.out.println(makeComplement("GTAT")); // return "CATA"
    }

    public static String makeComplement(String dna) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dna.toCharArray().length; i++) {
            builder.append(getReplacement(dna.toCharArray()[i]));
        }
        return builder.toString();
    }

    public static char getReplacement(char c){
        switch (c){
            case 'A':return 'T';
            case 'T':return 'A';
            case 'C':return 'G';
            case 'G':return 'C';
            default:
                throw new IllegalStateException("Unexpected value: " + c);
        }
    }
    

}