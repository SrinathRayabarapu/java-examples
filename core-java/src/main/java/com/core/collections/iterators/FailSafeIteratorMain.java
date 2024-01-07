package com.core.collections.iterators;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Below classes use FailSafe Iterators:
 * ConcurrentHashMap, CopyOnWriteArrayList etc
 *
 * @author Srinath.Rayabarapu
 */
public class FailSafeIteratorMain {

    public static void main(String[] args) {

        //Note: Map interface doesn't maintain the order of insertion - because it works on Hashing!
        Map<String, String> tempMap = new ConcurrentHashMap<>();
        tempMap.put("abc", "abc");
        tempMap.put("abc1", "abc1");
        tempMap.put("abc2", "abc2");

        Iterator<Entry<String, String>> iterator = tempMap.entrySet().iterator();
        while (iterator.hasNext()) {
            tempMap.put("abc4", "abc4");
            //iterator is OK with changes
            System.out.println(iterator.next());
        }
    }

}