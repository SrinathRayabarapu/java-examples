package com.core.collections;

import com.core.io.Employee;

import java.util.*;

/**
 * all List related operations
 *
 * @author Srinath.Rayabarapu
 */
public class ListMain {

    public static void main(String[] args) {

        List<String> abcList = new ArrayList<>();
        abcList.add("a");
//        abcList.add(null);
        abcList.add("b");
        abcList.forEach(a -> System.out.println(a.toLowerCase()));

        LinkedList<Object> list = new LinkedList<>();
        Vector<String> vector = new Vector<>();

        list.add("string");
        list.add(new Integer(454545));


        Iterator iterator;
        ListIterator listIterator;
        Enumeration enumeration;

        iterator = list.iterator();
        listIterator = list.listIterator();
        enumeration = vector.elements();

        // forward direction only
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        vector.add("added later");

        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }

        // making a collection unmodifiable
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("a", "SDE", 33));
        employees.add(new Employee("b", "SDE1", 34));

        employees = Collections.unmodifiableList(employees);
        // UnsupportedOperationException here
        // employees.add(new Employee("c", "SDE2", 35));

    }

}