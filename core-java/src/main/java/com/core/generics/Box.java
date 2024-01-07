package com.core.generics;

/**
 * GenericType version of Box class. This also explains boundedness of parameters.
 * 
	E - Element (used extensively by the Java Collections Framework)
	K - Key
	N - Number
	T - Type
	V - Value
	S,U,V etc. - 2nd, 3rd, 4th types
 *  
 * @author srinath.rayabarapu
 *
 * @param <T>
 */
public class Box<T> {

	// T is for type
	private T t;

	public T getT() {
		return this.t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public <U extends Number> void inspect(U u){
		System.out.println("T : " + getT().getClass().getName());
		System.out.println("U : " + u.getClass().getName());
	}

	public static void main(String[] args) {
		Box<Integer> box = new Box<>();
		box.setT(10);
//		below is an error since it's expecting a number only
//		box.inspect("ss");

		box.inspect(12);
	}

}