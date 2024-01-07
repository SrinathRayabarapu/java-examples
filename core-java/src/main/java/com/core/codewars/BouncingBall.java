package com.core.codewars;

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {

        System.out.printf("h %s bounce %s and window %s \n", h, bounce, window);

        if(h <= 0 && window < h){
            return -1;
        }

        if(!(0 < bounce && bounce < 1)){
            return -1;
        }

        int counter = 1;
        while(h*bounce > window){
            h = h-(h*bounce);
            System.out.println(h);
            counter = counter+1;
        }

        return counter + 1;
    }
}
