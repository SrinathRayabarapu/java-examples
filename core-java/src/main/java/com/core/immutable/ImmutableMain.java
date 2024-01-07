package com.core.immutable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Making Immutable class :-
 * 1. Make class final
 * 2. Make all the fields 'private' and 'final' so that the value can be assigned only once
 * 3. Don't provide any methods that changes the status of fields like setter methods
 * 4. Initialize all the fields via a constructor performing deep copy
 * 5. Perform cloning of objects in getter methods rather than returning the original object references
 *  
 * @author Srinath.Rayabarapu
 *
 */
public class ImmutableMain {

	public static void main(String[] args) {

		ImmutableClass immutable1 = new ImmutableClass("one", "type1", new HashMap<>());
		System.out.println(immutable1.hashCode());
		immutable1 = new ImmutableClass("one", "type1", new HashMap<>());
		System.out.println(immutable1.hashCode());

		//these two objects cann't be modified once they created

	}

}

final class ImmutableClass{

	private final String className;
	private final String classType;
	private final HashMap<String,String> testMap;

	public ImmutableClass(String name, String type, Map<String,String> map) {
		this.className = name;
		this.classType = type;

		//deep copy - to not to allow incoming map references being used directly
		HashMap<String,String> tempMap=new HashMap<>();
		String key;
		Iterator<String> it = map.keySet().iterator();
		while(it.hasNext()){
			key=it.next();
			tempMap.put(key, map.get(key));
		}
		this.testMap=tempMap;
	}

	public HashMap<String, String> getTestMap() {
		// shallow copy! - to not pass the map directly
		return (HashMap<String, String>) this.testMap.clone();
	}

	public String getClassName() {
		return this.className;
	}

	public String getClassType() {
		return this.classType;
	}

	@Override
	public String toString() {
		return "className :" + this.className + ",classType :" + this.classType;
	}

}
