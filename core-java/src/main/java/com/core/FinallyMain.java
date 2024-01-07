package com.core;

public class FinallyMain {

    public static void main(String[] args) {
        try{
            int i = 10/0;
            System.out.println(i);
            System.exit(0); // finally will not be executed
        } catch (Exception e){

        } finally{
            System.out.println("Finally block called!");
        }
    }

}
