package com.design.oopsprinciples;

public class FileHandler {
    public static void writeToFile(String filePath, Exception ex) {
        System.out.println("Writing an exception : " + ex + " a log file : " + filePath);
    }
}