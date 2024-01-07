package com.core.codewars;

public class MaxDiffLength {
    public static int mxdiflg(String[] a1, String[] a2) {

        int a1Max = 0, a1Min = Integer.MAX_VALUE;
        int a2Max = 0, a2Min = Integer.MAX_VALUE;

        if(a1.length == 0 || a2.length == 0){
            return -1;
        }

        for(String a : a1){
            if(a1Max < a.length()){
                a1Max = a.length();
            }
            if(a1Min > a.length()){
                a1Min = a.length();
            }
        }

        for(String a : a2){
            if(a2Max < a.length()){
                a2Max = a.length();
            }
            if(a2Min > a.length()){
                a2Min = a.length();
            }
        }

        System.out.println("a1Max : " + a1Max + ", a1Min : " + a1Min);
        System.out.println("a2Max : " + a2Max + ", a2Min : " + a2Min);

        int diff1 = a1Max - a2Min;
        int diff2 = a2Max - a1Min;

        return (diff1 > diff2) ? diff1 : diff2;
    }

    // best solution from Kata
    public static int bestMxdiflg(String[] a1, String[] a2) {
        if(a1.length==0||a2.length==0)
            return -1;

        int b1=0, b2=0;
        int l1=Integer.MAX_VALUE, l2=Integer.MAX_VALUE;

        for (String s : a1) {
            b1 = Math.max(b1, s.length());
            l1 = Math.min(l1, s.length());
        }
        for (String s : a2) {
            b2 = Math.max(b2, s.length());
            l2 = Math.min(l2, s.length());
        }

        return Math.max(Math.abs(b2-l1), Math.abs(b1-l2));
    }

}