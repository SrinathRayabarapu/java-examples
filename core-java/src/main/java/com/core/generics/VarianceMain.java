package com.core.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * Objective is to control what data flows-in and flows-out.
 * <p>
 * variance examples:
 * Covariant - if it accepts subtypes but not supertypes
 * Contravariant - if it accepts supertypes but not subtypes
 * Bivariant - if it accepts both supertypes and subtypes
 * Invariant - does not accept either supertypes and subtypes
 *
 * @author Srinath.Rayabarapu
 */
public class VarianceMain {

    public static void main(String[] args) {

        covariant();

        contravariant();

        biVariant();

        invariant();

    }

    /**
     * If B is subtype of A, then GenericType<B> is subtype of GenericType<? extends A>
     * <p>
     * Hint: Arrays[Object] is a way of achieving covariance in Java 1.5 or before.
     */
    private static void covariant() {

        // CREATION

        // OK
        List<? extends Joe> joes1 = new ArrayList<Joe>();
        List<? extends Joe> joes2 = new ArrayList<JoeJr>();
        // NOT OK
//        List<? extends Joe> joes3 = new ArrayList<Person>();

        // ADDING
        List<? extends Joe> joes = new ArrayList<>();
        // NOT OK
//        joes.add(new Joe());
//        joes.add(new JoeJr());
//        joes.add(new Person());

        // READING
        List<? extends Joe> joesList = new ArrayList<>();
        Joe j = joesList.get(0);
        Person p = joesList.get(0);
//        JoeJr joe = joesList.get(0);

    }

    /**
     * if A is a supertype of B, then GenericType<A> is a supertype of GenericType<? super B>
     */
    private static void contravariant() {
        // CREATION
        List<? super Joe> joesList1 = new ArrayList<Joe>();
        List<? super Joe> joesList2 = new ArrayList<Person>();
//        List<? super Joe> joesList3 = new ArrayList<JoeJr>();

        // ADDING
        List<? super Joe> joesList = new ArrayList<>();
//        joesList.add(new Person());
        joesList.add(new Joe());
        joesList.add(new JoeJr());

        // READING
        List<? super Joe> joes1 = new ArrayList<>();
//        Person p = joes1.get(0);
//        Joe j = joes1.get(0);
        Object o = joes1.get(0); // everything is an object
    }

    /**
     * unbounded wildcard.
     *
     * Think of GenericType<?> as GenericType<Object>
     */
    private static void biVariant() {

    }

    /**
     * if A is a supertype of B, then GenericType<A> is not a supertype of GenericType<B> and vice versa.
     */
    private static void invariant() {

        // CREATION

        // NOT POSSIBLE
//        List<Person> personList = new ArrayList<Joe>();
//        List<Joe> joesList = new ArrayList<Person>();

        // ADDING

        // POSSIBLE
        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person());
        personsList.add(new Joe());
        personsList.add(new JoeJr());

        // READING

        // POSSIBLE
        List<Joe> joesList = new ArrayList<>();
        Person person = joesList.get(0);
        Joe joe = joesList.get(0);
        // NOT OK
//        JoeJr joeJr = joesList.get(0);

    }

}

// hierarchy: Person > Joe > JoeJr
class Person {

}

class Joe extends Person {

}

class JoeJr extends Joe {

}
