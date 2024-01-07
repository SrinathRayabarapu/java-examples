package com.core.polymorphism;

/**
 * checks how dynamic polymorphism works with overriding
 *
 * #whatfix
 *
 * @author Srinath.Rayabarapu
 */
public class OverridingPuzzleMain {

    public static void main(String[] args) {
        Base1 o1 = new Base1();
        o1.show();
        o1 = new Base2();
        o1.show();
        Base3 o2 = new Base3();
        o2.show(o1);
    }

}

class Base1{
    void show(){
        System.out.println("A");
    }
}

class Base2 extends Base1{
    void show(){
        System.out.println("B");
    }
}

class Base3 {
    void show(Base1 b){
        b.show();
    }
}