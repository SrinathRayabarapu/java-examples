package com.core.generics;

/**
 * class to hold key and value pairs.
 *
 * @author Srinath.Rayabarapu
 *
 * @param <K>
 * @param <V>
 */
public class Pair<K, V> {

    private K key;
    private V value;

    //default constructor
    public Pair(K key, V value){
        this.key = key;
        this.value = value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
