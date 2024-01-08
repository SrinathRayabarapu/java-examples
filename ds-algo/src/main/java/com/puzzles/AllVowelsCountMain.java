package com.puzzles;

/**
 * a program that reads in a sentence and displays the count of individual vowels in the sentence
 *
 * @author Srinath Rayabarapu
 */
public class AllVowelsCountMain {

    public static void main(String[] args) {
        CheckVowels chk = new CheckVowels();
        chk.readString("abracadabra");
        chk.showCount();
    }
}

class CheckVowels {

    int a_count, e_count, i_count, o_count, u_count;

    CheckVowels() {
        a_count = 0;
        e_count = 0;
        i_count = 0;
        o_count = 0;
        u_count = 0;
    }

    void readString(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'A')
                a_count++;
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E')
                e_count++;
            if (str.charAt(i) == 'i' || str.charAt(i) == 'I')
                i_count++;
            if (str.charAt(i) == 'o' || str.charAt(i) == 'O')
                o_count++;
            if (str.charAt(i) == 'u' || str.charAt(i) == 'U')
                u_count++;
        }
    }

    void showCount() {
        System.out.println("No.of a's	:	" + a_count);
        System.out.println("No.of e's	:	" + e_count);
        System.out.println("No.of i's	:	" + i_count);
        System.out.println("No.of o's	:	" + o_count);
        System.out.println("No.of u's	:	" + u_count);
    }

}