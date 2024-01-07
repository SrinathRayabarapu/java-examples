package com.core.collections;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Program to check the concurrency between a synchronized hashmap vs concurrent hashmap
 *
 * @author Srinath.Rayabarapu
 */
@Slf4j
public class ConcurrentHashMapVsSynchronizedMapMain {

	private static final int THREAD_POOL_SIZE = 5;

	public static void main(String[] args) throws InterruptedException {
 
		// HashTable is synchronised
		Map<String, Integer> hashTableObject = new Hashtable<>();
		performTest(hashTableObject);
 
		// HashMap is by default is not synchronised. We can make it synchronised like below
		Map<String, Integer> synchronizedMapObject = Collections.synchronizedMap(new HashMap<>());
		performTest(synchronizedMapObject);
 
		// Synchronised version of HashMap
		Map<String, Integer> concurrentHashMapObject = new ConcurrentHashMap<>();
		performTest(concurrentHashMapObject);
 
	}
 
	public static void performTest(final Map<String, Integer> testingMap) throws InterruptedException {
 
		log.info("Test started for: " + testingMap.getClass());
		long averageTime = 0;
		for (int i = 0; i < 5; i++) {
 
			long startTime = System.nanoTime();
			ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
 
			for (int j = 0; j < THREAD_POOL_SIZE; j++) {
				executorService.execute(() -> {

					for (int i1 = 0; i1 < 500000; i1++) {
						Integer randomNumber = (int) Math.ceil(Math.random() * 550000);

						// Retrieve value. We are not using it anywhere
						Integer value = testingMap.get(String.valueOf(randomNumber));

						// Put value
						testingMap.put(String.valueOf(randomNumber), randomNumber);
					}
				});
			}
 
			// Make sure executor stops
			executorService.shutdown();

			// Blocks until all tasks have completed execution after a shutdownSessionFactory request
			executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);

			long entTime = System.nanoTime();
			long totalTime = (entTime - startTime) / 1000000L;
			averageTime += totalTime;

			log.info("500K entries added/retrieved in " + totalTime + " ms");
		}

		log.info("For " + testingMap.getClass() + " the average time is " + averageTime / 5 + " ms\n");
	}

}