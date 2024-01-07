package com.core.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * practice on HashMap
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class HashMapMain {

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