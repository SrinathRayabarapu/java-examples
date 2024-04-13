package com.dpattern.structural.composite;

/**
 *
 */
public class CompositePatternMain {

    public static void main(String[] args) {

        Directory directory = new Directory("Personal Files");
        directory.add(new File("My Resume.pdf"));

        Directory movies = new Directory("Books");
        movies.add(new File("ABC.pdf"));
        movies.add(new File("XYZ.pdf"));

        directory.add(movies);

        directory.ls();
    }

}