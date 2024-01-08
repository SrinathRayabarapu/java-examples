package com.dsalgo.arrays;

import java.util.Iterator;

/**
	Implement a Circular Array class that supports an array-like data structure which
	can be efficiently rotated. The class should use a generic type, and should support
	iteration via the standard for (Obj o : circularArray) notation.

 * @author Srinath.Rayabarapu
 */
public class CircularArraywithCustomIteratorDemo {
	
	public static void main(String[] args) {
		
	}
}

class CircularArray<T> implements Iterable<T>{

	private T[] items;
	private int head = 0;
	private int size;
	
	public int getSize() {
		return this.size;
	}

	public T[] getItems() {
		return items;
	}
	
	public CircularArray(int size) {
		items = (T[])new Object[size];
	}
	
	public void rotate(int shiftRight){
		head = convert(shiftRight);
	}

	private int convert(int index) {
		if(index < 0){
			index = index + items.length;
		}
		//this calculation is important - as it will give a rotated index
		return (head + index) % items.length;
	}
	
	public T get(int index){
		if(index < 0 || index >= items.length){
			System.out.println("Not valid index!");
			return null;
		}
		return items[convert(index)];
	}
	
	public void set(int index, T val){
		items[convert(index)] = val;
	}

	@Override
	public Iterator<T> iterator() {
		return new CircularIterator<T>(this);
	}

}

/**
 * custom iterator - cool
 * @author srayabar
 */
class CircularIterator<TI> implements Iterator<TI> {
	private int _current;
	private TI[] _items;
	
	public CircularIterator(CircularArray<TI> circularArray) {
		this._items = circularArray.getItems();
	}
	
	@Override
	public boolean hasNext() {
		return _current < _items.length-1;
	}

	@Override
	public TI next() {
		_current ++;
		//_current should be a converted index
		return this._items[_current];
	}
}