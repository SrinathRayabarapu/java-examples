package com.core.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Demonstrates HashMap behavior and concurrency issues in Java.
 * 
 * <p>HashMap is a widely used implementation of the Map interface that stores
 * key-value pairs. This class explores various HashMap operations and highlights
 * important concurrency considerations.</p>
 * 
 * <h3>Key Characteristics of HashMap:</h3>
 * <ul>
 *   <li>Allows one null key and multiple null values</li>
 *   <li>Not synchronized (not thread-safe)</li>
 *   <li>Provides O(1) average time complexity for get/put operations</li>
 *   <li>Initial capacity and load factor affect performance</li>
 * </ul>
 * 
 * <h3>Concurrency Issues Demonstrated:</h3>
 * <ul>
 *   <li>ConcurrentModificationException when iterating and modifying simultaneously</li>
 *   <li>Race conditions with multiple threads accessing the same HashMap</li>
 *   <li>Solutions: ConcurrentHashMap, Collections.synchronizedMap()</li>
 * </ul>
 *
 * @author Srinath.Rayabarapu
 * @see java.util.HashMap
 * @see java.util.concurrent.ConcurrentHashMap
 */
@Slf4j
public class HashMapMain {

	/**
	 * Main method demonstrating HashMap operations and concurrency scenarios.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {

		testMultiThreadHashMapModifications();

//		//decide size depends on the logic
//		Map<String, String> map = new HashMap<>(0);
//
//		map.put("1", "one");
//		map.put("2", "Second");
//		map.put("3", "Third");
//		map.put("4", "Four");
//		map.put("5", "Five");
//
//		System.out.println("Before : " + map);
//
//		Set<String> set = map.keySet();
//
//		set.remove("1");
//
//		System.out.println("After : " + map);
//
//		Map<String, String> hashMap = new ConcurrentHashMap<>();
//		hashMap.put("b", "b");
//		hashMap.put("c", "c");
//
//		for (String key : hashMap.keySet()){
//			hashMap.put("a", "");
//		}
//
//		System.out.println(hashMap);

	}

	/**
	 * Demonstrates the dangers of modifying a HashMap from multiple threads.
	 * 
	 * <p>This method creates two threads:</p>
	 * <ul>
	 *   <li>Thread 1: Continuously puts new entries into the map</li>
	 *   <li>Thread 2: Continuously iterates over the map's keySet</li>
	 * </ul>
	 * 
	 * <p>This scenario typically causes a {@link java.util.ConcurrentModificationException}
	 * because HashMap's iterators are fail-fast. To avoid this, use ConcurrentHashMap
	 * or synchronize access to the map.</p>
	 * 
	 * <p><b>Warning:</b> This method runs indefinitely and may throw exceptions.</p>
	 */
	public static void testMultiThreadHashMapModifications(){
		Map<Integer, Integer> map = new HashMap<>();

		Runnable runnable1 = () -> {
			int counter = 0;
			while(true){
				map.put(counter, new Random().nextInt());
				counter++;
			}
		};

		Runnable runnable2 = () -> {
			int counter = 0;
			while(true){
				for(Integer key : map.keySet()){
					log.info("{}", key);
				}
			}
		};

		new Thread(runnable1).start();
		new Thread(runnable2).start();
	}

}