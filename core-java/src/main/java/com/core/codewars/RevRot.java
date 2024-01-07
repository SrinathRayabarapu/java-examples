package com.core.codewars;

public class RevRot {
    public static String revRot(String input, int sz) {

        if(sz == 0 || sz > input.length())
            return "";

        int times = input.length()/sz;

        String returnString = "";

        int startIndex = 0;
        int endIndex = sz;
        for(int i=0; i<times; i++){
            String val = input.substring(startIndex, endIndex);
            System.out.println("val : " + val);
            val = rotateOrReverse(val);
            returnString = returnString + val;
            startIndex=startIndex+sz;
            endIndex=endIndex+sz;
        }

        return returnString;
    }

    private static String rotateOrReverse(String val) {

        int addVal = 0;
        for(char c : val.toCharArray()){
            addVal = addVal + (Integer.valueOf(c+"") * Integer.valueOf(c+"") * Integer.valueOf(c+""));
        }
        System.out.println(addVal);
        if(addVal%2 == 0){
            // reverse
            StringBuilder sb = new StringBuilder(val);
            return sb.reverse().toString();
        } else {
            // rotate by 1
            val = val.substring(1, val.length()) + val.charAt(0);
            return val;
        }
    }

    // best solution from Katas
    public static String bestRevRot(String nums, int sz) {
        StringBuffer groups = new StringBuffer();
        for (int i = 0, len = nums.length(); i + sz <= len && sz > 0; i += sz) {
            String group = nums.substring(i, i + sz);
            groups.append(isDivisible(group) ? new StringBuffer(group).reverse() : group.substring(1) + group.charAt(0));
        }
        return groups.toString();
    }

    public static boolean isDivisible(String group) {
        int sum = 0;
        for (char num : group.toCharArray()) {
            sum += Character.getNumericValue(num);
        }
        return sum % 2 == 0;
    }
}
