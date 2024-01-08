package com.puzzles;

/**
 * Write an application that reads several lines of text from the keyboard and prints
 * a table indicating the number of occurrences of each letter of the alphabet in the text.
 * <p>
 * NOTE: This program works well for an alphabet count up to 20. if needed beyond that the program
 * can be enhanced for the purpose
 *
 * @author Srinath.Rayabarapu
 */
class Alphabets {
    // initializing the text for the string variable line_of_text

    String line_of_text = "welcome to the world of computers aaaaaaaaaaaa bbbbbbbbbb";

    // alphas[] is a array varaiable which consists of alphabetics from A to Z

    char alphas[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'};

    // nos[] is an string variable which is used to initialise the numbers that
    // has to be occured during output.

    String nos[] = {"zero", "one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine"};
    String nos1[] = {"eleven", "twelve", "thirteen", "fourteen", "fifteen",
            "sixteen", "seventeen", "eighteen", "nineteen"};
    String nos2[] = {"ten", "twenty", "thirty", "forty", "fifty", "sixty",
            "seventy", "eighty", "ninety"};

    // counts[] is an integer variable which is used to count the number of
    // characters while looping
    int counts[] = new int[26];

    // this method keeps track of the count of each character in the given
    // sentence

    void countLetters() {

        for (int i = 0; i < line_of_text.length(); i++) {
            for (int j = 0; j < alphas.length; j++) {
                if (line_of_text.charAt(i) == alphas[j])
                    counts[j]++; // counts the no.of characters
            }
        }
    }

    void display() // displays the table of count of characters
    {
        int quot;
        for (int i = 0; i < alphas.length; i++) {  // main loop starts

            // checks for values between 0 and 9 both inclusive
            if (counts[i] < 10) {
                for (int j = 0; j < 10; j++) {
                    if (counts[i] == j) {
                        System.out.println(nos[j] + "\t" + alphas[i] + "'s");
                        break;
                    }
                }
            }

            // checks for values between 11 and 19 both inclusive
            if (counts[i] > 10 && counts[i] < 20) {
                for (int j = 11, k = 0; j < 20; j++, k++) {
                    if (counts[i] == j) {
                        System.out.println(nos1[k] + "\t" + alphas[i] + "'s");
                        break;
                    }
                }
            }

            // checks for values multiples of 10
            for (int m = 10; m < 90; m = m + 10) {
                if (counts[i] > 0 && counts[i] % 10 == 0) {
                    quot = counts[i] / 10;
                    System.out.println(nos2[quot - 1] + "\t" + alphas[i] + "'s");
                    break;
                }
            }
        }
    }
}

public class AlphabetTableMain {
    public static void main(String[] args) {
        // a1 is the object of Alphabets class which is used to call the Alphabets class methods
        Alphabets al = new Alphabets();

        // calling the countLetters and display method using Alphabets class object
        al.countLetters();
        al.display();
    }
}