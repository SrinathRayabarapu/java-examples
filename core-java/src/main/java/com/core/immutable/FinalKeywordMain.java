package com.core.immutable;

/**
 * final for a class is not inheritable.
 * <p>
 * final for a method is not overridden.
 * <p>
 * final for a variable is not changeable but can be declated at class level and initialize in constructor.
 * <p>
 * <p>
 * Note: You cannot override a final method but you can overload(bcause you are creating another method)
 *
 * @author Srinath.Rayabarapu
 */
public class FinalKeywordMain {

    public static void main(String[] args) {
        new ChildFinal();
        new ChildFinal("Valtech");
    }
}

class ParentFinal {

    final String abc;

    public ParentFinal(String s) {
        this.abc = "srinath";
        System.out.println("Parent constructor called..." + s);
    }

    final void A() {
    }

}

class ChildFinal extends ParentFinal {

    public ChildFinal() {
        super("srinath");
        System.out.println("Child constructor called...");
    }

    public ChildFinal(String s) {
        super(s);
        System.out.println("Child constructor called...");
    }
}