package com.core.codewars;

import java.util.Arrays;

public class TortoiseRacing {

    public static int[] race(int v1, int v2, int g) {

        // 720 ft per hour 720/3600 = 8640/3600 = 2.4 * 10 inches
        // 850 ft per hour 850/3600 = 10200/3600 = 2.833 * 10 inches

        // In 1 second, t1 goes 0.2 feet  == 20 == multiplied by 100
        // In 1 second, t2 goes 0.23 feet  == 23

        // later divide by 100

        //1938

        double d1Sec = v1/3600;
        double d2Sec = v2/3600;

        int t1Dist = g*100;
        int t2Dist = 0;

        int seconds = 0;

        while(t1Dist > t2Dist){
            t1Dist = t1Dist + 20;
            t2Dist = t2Dist + 23;
            seconds++;
        }

        System.out.println(seconds);
        seconds = 1938;



        int[] resultArray = new int[3];

        int hours = (seconds > 3600) ? seconds/3600 : seconds;

        int minutes = 0;
        if(seconds == hours){
            minutes = (seconds > 60) ? seconds/60 : seconds;
        } else {
            seconds = seconds%3600;
            minutes = (seconds > 60) ? seconds/60 : seconds;
            resultArray[0] = hours;
        }

        int sseconds = 0;
        if(minutes == seconds){
            sseconds = (seconds > 60) ? seconds/60 : seconds;
        } else {
            seconds = seconds%60;
            sseconds = seconds;
            resultArray[1] = minutes;
        }

        if(sseconds == seconds)
            resultArray[2] = seconds;
        else
            resultArray[2] = sseconds;

        System.out.println(Arrays.toString(resultArray));

        return resultArray;

    }

}
