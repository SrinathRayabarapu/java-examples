package com.dsalgo.recursion;

public class StarDividerMain {

    public static void main(String[] args) {
//        printRecursively("xxyy", 0);

//        printIteratively("xxyy");
        String a = "test";
        String b = "test";
        b = a;
        a = "abc";
        System.out.println(b);

        String input = "hello";
        for (int i = 0; i <input.length(); i++) {

        }


    }

    private static void printIteratively(String input) {
        String output = null;
        for(int i = 0; i < input.length()-1; i++){
            if(input.charAt(i) == input.charAt(i+1)){
                output = input.substring(0,i+1) + "-" + input.substring(i+1, input.length());
            }
        }
        System.out.println(output);
    }

    private static void printRecursively(String input, int index) {

    }

}
