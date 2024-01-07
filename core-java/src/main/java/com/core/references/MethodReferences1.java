package com.core.references;

/**
 * class to demo super class and interface method implementation details <p>
 * 
 * @author srayabar
 *
 */
public class MethodReferences1 extends SuperTest implements Base{ //no compilation error since super class has Interface method implemented
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4};
		call(arr[0], arr);
		System.out.println(arr[0] + "," + arr[1]);
		
	}

	private static void call(int i, int[] arr) {
		arr[i] = 6;
		i = 5;
	}

}


interface Base{
	void method();
}

class SuperTest{
	public void method() { //this is considered as Base interface method implementation
		System.out.println("hey");
	}
}