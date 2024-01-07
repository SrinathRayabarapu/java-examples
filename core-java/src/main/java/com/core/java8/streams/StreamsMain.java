package com.core.java8.streams;

import com.core.comparable.Employee;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * It's not about How - It's just What!
 *
 * @author Srinath.Rayabarapu
 */
public class StreamsMain {

    public static void main(String[] args) {

        Arrays.asList("abc", "def", "ghi", "ayx").
                stream().
                filter(s -> s.startsWith("a")).
                map(a -> a.toUpperCase()).
                sorted().
                forEach(System.out::println);
        System.out.println("-----");

        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        myList
                .stream()
                .filter(s -> s.startsWith("c"))//accepts a predicate
                .map(String::toUpperCase) // produces a different stream from input stream
                .sorted()//can accept a comparator - creates sorted view stream without changing backed collection
                .forEach(System.out::println);//accepts a consumer

        System.out.println("-----");

        myList
                .stream()
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("-----");

        Stream.of("b1", "b2", "a3") //creating a Stream
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("-----");

        Arrays.stream(new int[]{1, 2, 3})//another way of creating stream - IntStream can support more terminal operations
                .map(n -> 2 * n + 1)
                .average()
                .ifPresent(System.out::println);

        System.out.println("-----");

        Stream.of("a1", "a2", "a9")//mapping String to Int
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        System.out.println("-----");

        Stream.of(1.0, 2.0, 3.0) //mapping double to int and to object
                .mapToInt(Double::intValue)
                .mapToObj(i -> "b" + i)
                .forEach(System.out::println);

        System.out.println("-----");

        Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> s.startsWith("a"));
        stream.anyMatch(s -> true);
        //stream.noneMatch(s -> true); //will give IllegalStateException

        System.out.println("-----");

        Supplier<Stream<String>> supStream = () -> Stream.of("d2", "a2", "b1", "b3", "c")//creating a Stream chain to support
                //multiple chain terminal operations
                .filter(s -> s.startsWith("a"));

        supStream.get().anyMatch(s -> true);
        supStream.get().noneMatch(s -> true);


        System.out.println("----------- Max or Min etc operations -----------");

        // get max or min number -----------------
        Integer maxNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).max(Comparator.comparing(Integer::valueOf)).get();
        Integer minNumber = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).min(Comparator.comparing(Integer::valueOf)).get();

        System.out.println("maxNumber = " + maxNumber);
        System.out.println("minNumber = " + minNumber);

        //get max and min characters
        String maxChar = Stream.of("H", "T", "D", "I", "J").max(Comparator.comparing(String::valueOf)).get();
        String minChar = Stream.of("H", "T", "D", "I", "J").min(Comparator.comparing(String::valueOf)).get();

        System.out.println("maxChar = " + maxChar);
        System.out.println("minChar = " + minChar);

        // get max and min of Employees based on age
        List<Employee> emps = new ArrayList<>();

        emps.add(new Employee(1, "Lokesh", 36));
        emps.add(new Employee(2, "Alex", 46));
        emps.add(new Employee(3, "Brian", 52));

        // TODO - explore more on comparator options
        Comparator<Employee> comparator = Comparator.comparing(Employee::getAge);

        Employee minObject = emps.stream().min(comparator).get();
        Employee maxObject = emps.stream().max(comparator).get();

        System.out.println("minObject = " + minObject);
        System.out.println("maxObject = " + maxObject);


        System.out.println("----------- Max or Min etc operations -----------");
        Map<String, List<String>> people = new HashMap<>();
        people.put("John", Arrays.asList("555-1123", "555-3389"));
        people.put("Mary", Arrays.asList("555-2243", "555-5264"));
        people.put("Steve", Arrays.asList("555-6654", "555-3242"));

        List<String> phones = people.values().stream()
                .flatMap(Collection::stream) // flatmap produces a single stream out of stream of streams
                .collect(Collectors.toList());

        System.out.println(phones);

    }//main ends

}