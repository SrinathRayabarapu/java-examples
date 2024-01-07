package com.core.java8.streams;

import com.core.java8.streams.to.Bar;
import com.core.java8.streams.to.Foo;
import com.core.java8.streams.to.Outer;
import com.core.java8.streams.to.Person;

import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * advanced operations on list, map etc
 *
 * @author Srinath.Rayabarapu
 */
public class StreamsAdvanceMain {

    public static void main(String[] args) {

        // List, Set related operations
        List<Person> personsList = Arrays.asList(
                new Person("Max", 18),
                new Person("Peter", 23),
                new Person("Pamela", 20),
                new Person("David", 12));

        // List filtering with name starting with P and collect it to a Set
        Set<Person> personsSet = personsList
                .stream()
                .filter(p -> p.toString().startsWith("P"))
                .collect(Collectors.toSet()); //useful for collecting to different collection

        // List print
        personsSet.forEach(System.out::println);

        System.out.println("------");

        Double collect = personsList
                .stream()
                .collect(Collectors.averagingInt(Person::getAge));//averaging age to an int

        System.out.println(collect);

        System.out.println("------");

        // averaging an int value in List
        IntSummaryStatistics collect2 = personsList
                .stream()
                .collect(Collectors.summarizingInt(Person::getAge));//terminal operator to summarize all stats

        System.out.println(collect2); //IntSummaryStatistics{count=4, sum=76, min=12, average=19.000000, max=23}

        System.out.println("------");

        // List filtering based on age and collecting to a String with delimiters, prefix and Suffix
        String collect3 = personsList
                .stream()
                .filter(p -> p.getAge() >= 18)
                .map(Person::getName)
                .collect(Collectors.joining(" and ", "In India ", " are eligible to Vote!"));//forms a string with a delimiter and prefix and suffix

        System.out.println(collect3);

        System.out.println("------");

        // little complex one
        Collector<Person, StringJoiner, String> personNameCollector = Collector.of(//custom collector to concat names with |
                () -> new StringJoiner(" | "),        //supplier
                (j, p) -> j.add(p.getName().toUpperCase()), //accumulator
                (j1, j2) -> j2.merge(j1),                    //combiner
                StringJoiner::toString);                    //finisher

        String collect5 = personsList
                .stream()
                .collect(personNameCollector);

        System.out.println(collect5);

        System.out.println("------");

        List<Foo> foos = new ArrayList<>();

        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));//each foo will have 3 bars

        foos.stream()
                .flatMap(f -> f.bars.stream()) //accepts a function which can return stream of objects
                .forEach(b -> System.out.println(b.name));

        System.out.println("------");

        IntStream.range(1, 4)
                .mapToObj(i -> new Foo("Foo" + i))
                .peek(f -> IntStream.range(1, 4) //intermediate operation which allows actions on each element
                        .mapToObj(i -> new Bar("Bar " + i + " <- " + f.name))
                        .forEach(f.bars::add)
                )
                .flatMap(f -> f.bars.stream()) //returns streams
                .forEach(b -> System.out.println(b.name));

        System.out.println("------");

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter : %s - [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map : %s - [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> {
                    System.out.format("foreach : %s - [%s]\n", s, Thread.currentThread().getName());
                });

        personsList
                .stream()
                .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)//reduces a collection based on comparison condition
                .ifPresent(System.out::println);

        System.out.println("------");

        Person reduce = personsList
                .stream()
                .reduce(new Person("", 0), (p1, p2) -> {//reduces to a single object by performing an operation across whole collection
                    p1.name += p2.name;
                    p1.age += p2.age;
                    return p1;
                });

        System.out.format("name=%s; age=%s\n", reduce.getName(), reduce.getAge());

        System.out.println("------");

        Integer reduce2 = personsList
                .stream()
                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println(reduce2);

        System.out.println("------");

        Integer reduce3 = personsList
                .stream()
                .reduce(
                        0, //indentity value
                        (sum, p) -> {//normal stream will be handled here only
                            System.out.format("accumulator sum=%s; age=%s\n", sum, p.age);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {
                            System.out.format("combiner sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        }
                );

        System.out.println(reduce3);

        System.out.println("------");

        Integer reduce4 = personsList
                .parallelStream() //for parallel streams - data source should be splittable
                .reduce(
                        0, //indentity value
                        (sum, p) -> {//normal stream will be handled here only
                            System.out.format("accumulator sum=%s; age=%s\n", sum, p.age);
                            return sum += p.age;
                        },
                        (sum1, sum2) -> {//parallel streams are handled here
                            System.out.format("combiner sum1=%s; sum2=%s\n", sum1, sum2);
                            return sum1 + sum2;
                        }
                );

        System.out.println(reduce4);

        System.out.println("------");


        //MAP related
        Map<Integer, List<Person>> collectMap = personsList
                .stream()
                .collect(Collectors.groupingBy(Person::getAge));//groups to a map

        collectMap.forEach((age, person) -> System.out.format("age %s : %s\n", age, person));

        System.out.println("------");

        Map<Integer, String> collect4 = personsList
                .stream()
                .collect(Collectors.toMap( //converting to a map
                        Person::getAge, //key mapper
                        Person::getName, //value mapper
                        (name1, name2) -> name1 + ";" + name2 //merge logic - in case if the keys are same
                ));

        System.out.println(collect4);

        System.out.println("------");


        // OTHER
        Outer outer = new Outer();
        //old way
        if (outer.nested != null && outer.nested.inner != null) { //nested checks can be avoided using flatmap
            System.out.println(outer.nested.inner.foo);
        }

        System.out.println("------");

        //Optional way
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);

        System.out.println("------");

        ForkJoinPool joinPool = new ForkJoinPool();
        int parallelism = joinPool.getParallelism();//max number of threads that can run - counts hyper threading
        System.out.println(parallelism);

        System.out.println("------");

    } // main ends here

} //class ends