package com.dpattern.structural.prototype;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @EPAM
 */
public class PrototypePatternMain {

    public static void main(String[] args) throws CloneNotSupportedException {

        ColorStore colorStore = new ColorStore();
        Color blue = colorStore.getColor("blue");
        Color red = colorStore.getColor("red");

        blue.printColor();
        red.printColor();
    }

}

class ColorStore {

    private Map<String, Color> colors = new HashMap<>();

    // single place where the original(complex) object construction happens
    public ColorStore() {
        BlueColor blue = new BlueColor();
        blue.addColor();
        colors.put("blue", blue);
        RedColor red = new RedColor();
        red.addColor();
        colors.put("red", red);
    }

    public Color getColor(String coloName) throws CloneNotSupportedException {
        return (Color) colors.get(coloName).clone();
    }

}

@Slf4j
abstract class Color implements Cloneable {

    String coloName;

    abstract void addColor();

    // object replication happens here - care needs to be taken whether we need shallow or deep cloning
    // based on requirements
    // default is - Shallow cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    void printColor(){
        log.info("Object color is {}", coloName);
    }
}

@Slf4j
class BlueColor extends Color {

    public BlueColor() {
        log.info("BlueColor object created");
    }

    @Override
    void addColor() {
        coloName = "blue";
    }
}

@Slf4j
class RedColor extends Color {

    public RedColor() {
        log.info("RedColor object created");
    }

    @Override
    void addColor() {
        coloName = "red";
    }
}