package com.puzzles;

/**
 *
 */
public class VowelCountMain {

    /**
     * @param str
     * @return
     */
    public static int getCountLinear(String str) {
        int count = 0;
        for (char c : str.toCharArray()) {
            count += ('a' == c || 'e' == c || 'i' == c || 'o' == c || 'u' == c) ? 1 : 0;
        }
        return count;
    }

    /**
     *
     * @param string
     * @return
     */
    public static int getCountClever(String string){
        return (int)string.chars().filter(c -> "aeiou".indexOf(c) >= 0).count();
    }

}