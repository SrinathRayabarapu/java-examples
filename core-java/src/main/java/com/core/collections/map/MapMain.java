package com.core.collections.map;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * use this class to test all map related scenarios
 * 
 * @author Srinath.Rayabarapu
 *
 */
public class MapMain {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>(1);
		System.out.println(map.size());
		map.put("one", "one");
		System.out.println(map.size());
		map.put("two", "two");
		System.out.println(map.size());


		Map<String, String> map1 = Map.ofEntries(
				new AbstractMap.SimpleEntry("application.integration.identity.url", "one"),
				new AbstractMap.SimpleEntry("application.integration.payment-api.url", "two")
		);
		System.out.println("map1 = " + map1);

		Map<String, String> map2 = new HashMap<>();
		map2.put("application.integration.identity.url", "one");
		map2.put("application.integration.payment-api.url", "two");
		System.out.println("map2 = " + map2);

	}

}
