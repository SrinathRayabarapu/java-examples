package com.core.classes.inner;

/**
 * class to demo inner classes and their characteristics
 * 
 * @author Srinath.Rayabarapu
 */
public class InnerClassesMain {

    class Contents {
        private int i = 11;
        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;
        public Destination(String whereTo) {
            this.label = whereTo;
        }
        String readLabel() {
            return label;
        }
    }

    public Destination to(String whereTo) {
        return new Destination(whereTo);
    }

    public Contents contents() {
        return new Contents();
    }

    public void ship(String destination) {
        Destination destiny = new Destination(destination);
        System.out.println(destiny.readLabel());
    }

    public static void main(String[] args) {
        InnerClassesMain innerClassesMain = new InnerClassesMain();
        innerClassesMain.ship("Pasara");

        InnerClassesMain parcel12 = new InnerClassesMain();
        // defining references to inner classes
        InnerClassesMain.Contents c = parcel12.contents();
        InnerClassesMain.Destination d = parcel12.to("warangal");

    }
}
