package com.core.codewars;

public class Maskify {

    public static String maskify(String str) {
        if(str.length() <= 4){
            return str;
        }
        String last = str.substring(str.length()-4, str.length());
        String appender = "";
        for(int i =0; i < str.substring(0,str.length()-4).length(); i++){
            appender = appender + "#";
        }
        return appender+last;
    }

}
