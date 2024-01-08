package com.dsalgo.strings;

/**
 * given a number string, insert '-' between two odd numbers and '*' between two even numbers
 * Ex: 12*2*23-3-34*4*47-78*8*8*21
 *
 * @author Srinath.Rayabarapu
 */
public class InsertCharacterOddEvenNumbersMain {

    public static void main(String[] args) {
        String input = "12467930";

        // shashank's solution
        printFormattedString1(input);

        // parthiban's solution
        printFormattedString(input);

    }

    private static void printFormattedString1(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(input.charAt(0));
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) % 2 == 0 && input.charAt(i - 1) % 2 == 0) {
                stringBuilder.append("*" + input.charAt(i));
            } else if (input.charAt(i) % 2 != 0 && input.charAt(i - 1) % 2 != 0) {
                stringBuilder.append("-" + input.charAt(i));
            } else {
                stringBuilder.append(input.charAt(i));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static void printFormattedString(String input) {
        char[] numbers = input.toCharArray();
        String result = "";

        for (int i = 1; i < numbers.length; i++) {
            int value1 = Character.getNumericValue(numbers[i - 1]);
            int value2 = Character.getNumericValue(numbers[i]);
            result += value1;
            if (value1 % 2 != 0 && value2 % 2 != 0) {
                result += "-";
            } else if (value1 % 2 == 0 && value2 % 2 == 0) {
                result += "*";
            }
        }
        result += numbers[numbers.length - 1];
        System.out.println(result);
    }



}
