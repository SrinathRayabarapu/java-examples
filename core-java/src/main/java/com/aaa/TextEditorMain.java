package com.aaa;

/**
 * given a text and wrap length, wrap the text like in a editor
 *
 * TODO:
 *
 * #tesco
 *
 * @author Srinath.Rayabarapu
 */
public class TextEditorMain {

    public static void main(String[] args) {
        String inputText = "abcaa xyzzz 123 456 78901 001 00233";
        int wrapLength = 20;
        wrapText(inputText, wrapLength);

        wrapText1(inputText, wrapLength);
    }

    public static void wrapText1(String inputText, int wrapLength) {
        String temp = "";
        for (int i = 0; i < inputText.length(); i++) {
            if(i == wrapLength){

            }
        }
    }

    public static void wrapText(String inputText, int wrapLength) {
        // only wrap in case it's larger
        String returnString = "";
        String[] stringArray = inputText.split(" ");
        for(String str : stringArray){
            if(inputText.indexOf(str) > wrapLength){
                returnString = returnString + " \n" + str;
                wrapLength = wrapLength * 2;
            } else {
                returnString = returnString + " " + str;
            }
        }
        System.out.println(returnString);
    }

}