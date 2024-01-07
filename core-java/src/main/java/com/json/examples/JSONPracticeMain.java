package com.json.examples;

import com.util.JSONUtility;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * class for all JSON related examples and practice
 * 
 * @author srayabar
 *
 */
public class JSONPracticeMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		JSONPracticeMain conversions = new JSONPracticeMain();
		System.out.println("JSON from Map : "+JSONUtility.jsonFromMap(conversions.getDataMap()));		
		System.out.println("Map from JSON : "+JSONUtility.mapFromJson(conversions.getDataJSON()));
		
		
		
		JSONObject prefObj = new JSONObject("{'srinath' : true}");
		if(prefObj.getBoolean("srinath")) {
			System.out.println("found");
		}
		if(!prefObj.has("srina")) {
			System.out.println("Not found");
		}
		
		
		
	}
	
	/**
	 * Method to get a Map which uses for creating JSON out of it
	 * @return Map
	 */
	private Map<String, Object> getDataMap(){
		
		Map<String, Object> map = new HashMap<>();
		map.put("one", 1);
		map.put("two", 2);
		map.put("three", 3);
		map.put("four", 4);
		map.put("five", 5);
		
		return map;
	}
	
	/**
	 * Mehtod to get a JSON String for creating Map out of it
	 * @return
	 */
	private String getDataJSON(){
		String json = "{\"one\":\"1\"},{\"two\":\"2\"}";
		return json;
	}

}
