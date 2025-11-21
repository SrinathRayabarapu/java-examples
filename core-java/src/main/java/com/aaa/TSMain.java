package com.aaa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 *
 * @author Srinath Rayabarapu
 */
public class TSMain {

    public static void main(String[] args) {

        String abc = "aaaabcccaaa";

        int[] charsNum = new int[128];

        String tem = "";
        char tempC = abc.charAt(0);

        for (int i = 0; i < abc.length(); i++) {
            charsNum[abc.charAt(i) - 'a']++;
        }

        for (int i = 0; i < abc.length(); i++) {
            System.out.println("tempC = " + tempC);
            System.out.println("abc.charAt(i) = " + abc.charAt(i));
            if(tempC != abc.charAt(i)){
                tem += tempC;
                tempC = abc.charAt(i);
            }
        }

        System.out.println("tem = " + tem);

        String value = "";
        for (int i = 0; i < tem.length(); i++) {
            value += charsNum[tem.charAt(i)] + tem.charAt(i);
        }

        System.out.println(value);

//        test1();
    }

    private static void test1() {
        String[] stockNamesArray = {"a", "b", "c"};
        float[][] stocks = {{0.0f, 1.0f}, {1.0f, 1.0f}, {2.0f}};

        float[] averageArray= new float[stocks.length];

        for (int i = 0; i < stocks.length; i++) {
            float sum = 0.0f;
            for (int j = 0; j < stocks[i].length; j++) {
                sum += stocks[i][j];
            }
            averageArray[i] = sum / stocks[i].length;
        }

        Map<String, Float> num = new HashMap<>();
        for (int i = 0; i < stockNamesArray.length; i++) {
            num.put(stockNamesArray[i], averageArray[i]);
        }

        Stream<Float> sorted = num.values().stream().sorted(Comparator.reverseOrder());
        List<String> collect = sorted.map(floatNum -> getKeyByValue(num, floatNum)).collect(Collectors.toList()).stream().limit(3).collect(Collectors.toList());

        String[] array = new String[collect.size()];
        for (int i = 0; i < collect.size(); i++) {
            array[i] = collect.get(i);
        }

        System.out.println(Arrays.toString(array));
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public List<String> findStringTesco(List<String> inputStringsList, String searchKey) {
        List<String> tesco = inputStringsList.stream().
                filter(str -> str.toLowerCase().contains(searchKey.toLowerCase())).collect(Collectors.toList());
        return tesco;
    }

}
