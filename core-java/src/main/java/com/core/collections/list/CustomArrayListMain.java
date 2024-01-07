package com.core.collections.list;

import java.util.Arrays;

/**
 * creating custom array list which is iterable. It should have following operations -
 * add
 * get(index)
 * count
 * // iterator
 *
 * @author Srinath.Rayabarapu
 */
public class CustomArrayListMain {

    public static void main(String[] args) {

        CustomArrayList<Integer> list = new CustomArrayList<>(2);
        list.add(10);
        list.add(20);
//        list.add(30);
        System.out.println(list);

        int value = list.get(0);
        System.out.println(value);

        int count = list.count();
        System.out.println(count);

        value = list.get(2);
        System.out.println(value);

    }

}

/**
 * generic ArrayList class
 *
 * @param <T>
 */
class CustomArrayList<T> {

    private final int initialSize;
    private T[] items;
    private int currentIndex = 0;

    public CustomArrayList(int initialSize) {
        this.initialSize = initialSize;
        this.items = (T[]) new Object[initialSize];
    }

    public void add(T t) {
        if (currentIndex == items.length) {
            items = Arrays.copyOf(items, initialSize * 2);
        }
        items[currentIndex++] = t;
//        currentIndex++;
    }

    public T get(int index) {
        if (index < 0 || index > items.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return items[index];
    }

    public int count() {
        return currentIndex;
    }

    @Override
    public String toString() {
        String temp = "";
        for (Object ob : items) {
            if (ob != null) {
                temp = temp + ob + ',';
            }
        }
        String temp1 = temp.substring(0, temp.length() - 1);
        return "[" + temp1 + "]";
    }

}