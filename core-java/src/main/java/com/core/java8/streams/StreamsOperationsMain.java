package com.core.java8.streams;

import com.core.java8.streams.to.Dish;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * different examples on predicates
 *
 * @author Srinath.Rayabarapu
 */
public class StreamsOperationsMain {

    public static void main(String[] args) {

        // TODO - work on different types of predicates

        List<Dish> menu = Arrays.asList(
                new Dish("pork", false, 800, Dish.Type.MEAT),
                new Dish("beef", false, 700, Dish.Type.MEAT),
                new Dish("chicken", false, 400, Dish.Type.MEAT),
                new Dish("french fries", true, 530, Dish.Type.OTHER),
                new Dish("rice", true, 350, Dish.Type.OTHER),
                new Dish("season fruit", true, 120, Dish.Type.OTHER),
                new Dish("pizza", true, 550, Dish.Type.OTHER),
                new Dish("prawns", false, 300, Dish.Type.FISH),
                new Dish("salmon", false, 450, Dish.Type.FISH));

        Predicate<Dish> booleanPredicate = dish -> dish.getCalories() > 300;

        //example 1
        List<String> collect = menu.stream()
                .filter(booleanPredicate).
                map(Dish::getName)//extracts only name
                .limit(3)//limits to first 3
                .collect(Collectors.toList()); // you can print here also

        collect.stream().forEach(System.out::println);//prints the value

    }

}
