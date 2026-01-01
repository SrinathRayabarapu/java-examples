package com.core.java8.streams;

import com.core.comparable.Employee;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Demonstrates Java 8 Stream API features and operations.
 * 
 * <p>The Stream API provides a declarative approach to data processing,
 * focusing on "what" to do rather than "how" to do it. This class covers:</p>
 * 
 * <ul>
 *   <li>Creating streams from collections and arrays</li>
 *   <li>Intermediate operations: filter, map, sorted, flatMap</li>
 *   <li>Terminal operations: forEach, collect, findFirst, anyMatch, noneMatch</li>
 *   <li>Specialized streams: IntStream, mapping between stream types</li>
 *   <li>Aggregation operations: max, min, average</li>
 *   <li>Reusing streams with Supplier</li>
 * </ul>
 * 
 * <p>Key concepts demonstrated:</p>
 * <ul>
 *   <li>Streams are lazily evaluated - intermediate operations don't execute until a terminal operation is invoked</li>
 *   <li>Streams can only be consumed once - attempting to reuse throws IllegalStateException</li>
 *   <li>Use Supplier to create reusable stream pipelines</li>
 *   <li>flatMap is used to flatten nested collections into a single stream</li>
 * </ul>
 *
 * @author Srinath.Rayabarapu
 * @see java.util.stream.Stream
 * @see java.util.stream.Collectors
 */
public class StreamsMain {

    /**
     * Main method demonstrating various Stream API operations.
     * 
     * <p>Examples include:</p>
     * <ul>
     *   <li>Filtering, mapping, and sorting strings</li>
     *   <li>Finding first element with Optional</li>
     *   <li>Working with IntStream for numeric operations</li>
     *   <li>Finding max/min elements with Comparator</li>
     *   <li>Using flatMap to flatten nested collections</li>
     * </ul>
     *
     * @param args command-line arguments (not used)
     */
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