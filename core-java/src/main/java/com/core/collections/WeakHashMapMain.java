package com.core.collections;

import java.util.Map;
import java.util.WeakHashMap;

/**
 * WeakHashMap related operations
 *
 * @author Srinath.Rayabarapu
 */
public class WeakHashMapMain {

	public static void main(String[] args) {
		Map<DemoClass, Integer> weakMap = new WeakHashMap<>();
		
		weakMap.put(new DemoClass(10, 5), 100);//weak references, will get GC'd
		weakMap.put(new DemoClass(5, 10), 200);//weak references, will get GC'd
		
		DemoClass demoClass = new DemoClass(10, 10);
		weakMap.put(demoClass, 300);//strong reference, will not GC'd
		
		System.out.println("Before : " + weakMap.size());
		
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		System.gc();
		
		System.out.println("After : " + weakMap.size()); //no guarantee GC would run but if runs then the size is 1
	}

}

class DemoClass {
	int x;
	int y;
	public DemoClass(int x, int y) {
		this.x = x;
		this.y = y;
	}
}