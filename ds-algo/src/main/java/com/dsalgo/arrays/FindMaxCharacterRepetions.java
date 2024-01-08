package com.dsalgo.arrays;

public class FindMaxCharacterRepetions {

    public static void main(String[] args) {

        String input = "My name is Mohan";

        int[] output = findMaxCharacterRepetions(input.toLowerCase());
        System.out.println(output[0] + "-" + output[1]);

    }

    private static int[] findMaxCharacterRepetions(String input) {

        int[] intCharArray = new int[26];

        char[] chars = input.toCharArray();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)) {
                intCharArray[c - 97] = intCharArray[c - 97] + 1;
            }
        }

        int maxChar = 0;
        int maxRep = 0;

        for (int i = 0; i < intCharArray.length; i++) {
            if (maxRep < intCharArray[i]) {
                maxRep = intCharArray[i];
                maxChar = i;
            }
        }

        int[] out = {maxChar + 97, maxRep};

        return out;
    }

}