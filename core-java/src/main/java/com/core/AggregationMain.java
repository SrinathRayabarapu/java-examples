package com.core;

import java.util.List;

/**
 * If A and B are associated with each other, such that B can exist without being associated with A, then this
 * association is known as Aggregation.
 *
 * Since Organization has Person as employees, the relationship between them is Aggregation.
 *
 * Ref: https://javarevisited.blogspot.com/2014/02/ifference-between-association-vs-composition-vs-aggregation.html#axzz7TXj5Yd6k
 */
public class AggregationMain {

}

class Organisation {
    private List<Person> employees;
}

class Person {

}
