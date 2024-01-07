package com.core.collections;

import java.io.IOException;
import java.util.*;

/**
 * sorting a map keys based on their values
 * 
 * Problem: For each decimal number will be converted to their binary number and the number of 1's count is stored in a map. 
 * Based on 1's count the key values should be sorted
 * 
 * @author srayabar
 *
 */
public class SortMapBasedOnValuesThenKeysMain {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);

		int n = 0;
		n = Integer.parseInt(in.nextLine().trim());
		int[] elements = new int[n];
		int element;
		for (int i = 0; i < n; i++) {
			element = Integer.parseInt(in.nextLine().trim());
			elements[i] = element;
		}

		// call rearrange function
		int[] results = rearrange(elements);

		for (int i = 0; i < results.length; i++) {
			System.out.println(String.valueOf(results[i]));
		}
	}
	
    /**
     * Complete the function below.
     * DONOT MODIFY anything outside this function!
     */
    static int[] rearrange(int[] elements) {
    	
        int[] jk = {};
        List<Integer> list = new ArrayList<>();
        
        for(int i : elements) {
        	list.add(i);
        }
        
        Collections.sort(list);
        
        //System.out.println("sorted list : " + list);
        
        Map<Integer, Integer> map = new TreeMap<>();
        
    	for(int i : list) {
    		String binaryString = Integer.toBinaryString(i);
    		int count = 0;
    		for(int j=0; j<binaryString.length(); j++) {
    			if(binaryString.charAt(j) == '1') {
    				count ++;
    			}
    		}
			map.put(i, count);
    	}
    	
    	//System.out.println("binary map : " + map);
    	
    	Map<Integer, Integer> sortedMap = sortByValues(map);
    	
    	//System.out.println("sorted map : " + sortedMap);
    	
    	int[] ass = new int[sortedMap.keySet().size()];
    	int counter = 0;
    	for(Integer i : sortedMap.keySet()) {
    		ass[counter] = i.intValue();
    		counter++;
    	}
    	
    	return ass;
    }
    
    /**
     * this is key part: a generic method which accepts Map and and compares the values and then keys based on generic comparator
     * 
     * @param map
     * @return
     */
	public static <K extends Comparable<K>, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) {
		
		Comparator<K> valueComparator = new Comparator<K>() {
			
			public int compare(K k1, K k2) {
				int compare = map.get(k1).compareTo(map.get(k2));
				if (compare == 0) {
					//values are same then check keys
					if(k1.compareTo(k2) != 0) {
						return k1.compareTo(k2);
					}
					return 1;
				}
				return compare;
			}
		};

		Map<K, V> sortedByValues = new TreeMap<>(valueComparator);
		sortedByValues.putAll(map);
		return sortedByValues;
	}

}