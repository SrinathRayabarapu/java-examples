package com.core.generics;

import java.util.List;

/**
 * class to demo class with generic methods and no generic specifiers at class level.
 *
 * @author Srinath.Rayabarapu
 */
public class GenericMethodUtil {

    private GenericMethodUtil() {
        //private constructor to make it util class
    }

    public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
    }

    /**
     * example for extending a bound. good for generic algorithms.
     *
     * @param anArray
     * @param elem
     * @param <T>
     * @return
     */
    public static <T extends Comparable<T>> int countGreaterThan(T[] anArray, T elem) {
        int count = 0;
        for (T e : anArray) {
            if (e.compareTo(elem) > 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * method to test java type inferring
     *
     * @param list
     */
    public static void processList(List<String> list) {
        System.out.println(list.size());
    }

    /**
     * method to sum list of Numbers a wildcard which is upper bounded to Number
     *
     * @param list
     * @return
     */
    public static double sumOfUpperBoundList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list) {
            s += n.doubleValue();
        }
        return s;
    }

    /**
     * method to print list of elements which are lower bounded to Integer
     *
     * @param list
     */
    public static void printLowerBoundList(List<? super Integer> list) {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println(list);
    }

}