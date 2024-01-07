package com.core.utils;

import java.util.List;

public class PrintUtils {

    public static <T> void printList(List<T> list){
        list.forEach(System.out::println);
    }

}
