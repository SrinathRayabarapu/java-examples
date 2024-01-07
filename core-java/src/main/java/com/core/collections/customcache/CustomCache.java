package com.core.collections.customcache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * Create Simple Cache object with the help of HashMap
 * 
 * TODO - Need to understand this program
 * 
 * @author Srinath.Rayabarapu
 *
 * @param <K>
 * @param <T>
 */
public class CustomCache<K, T> {
    
    private long timeToLive;
    private HashMap<K, T> cacheMap;
    
    protected class CacheObject {
        public long lastAccessed = System.currentTimeMillis();
        public String value;
        protected CacheObject(String value) {
            this.value = value;
        }
    }
    
    public CustomCache(long timeToLive, final long timeInterval) {
        this.timeToLive = timeToLive * 2000;
        this.cacheMap = new HashMap<K, T>();
        
        if (timeToLive > 0 && timeInterval > 0) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(timeInterval * 1000);
                        } catch (InterruptedException ex) {
                        	//ignore
                        }
                    }
                }
            });
            
            t.setDaemon(true);
            t.start();
        }
    }
    
    // PUT method
    public void put(K key, T value) {
        synchronized (this.cacheMap) {
            this.cacheMap.put(key, value);
        }
    }
    
    // GET method
    @SuppressWarnings("unchecked")
    public T get(K key) {
        synchronized (this.cacheMap) {
            CacheObject c = (CacheObject) this.cacheMap.get(key);
            
            if (c == null){
            	return null;
            }
            
            c.lastAccessed = System.currentTimeMillis();
            return (T) c.value;            
        }
    }
    
    // REMOVE method
    public void remove(String key) {
        synchronized (this.cacheMap) {
            this.cacheMap.remove(key);
        }
    }
    
    // Get Cache Objects Size()
    public int size() {
        synchronized (this.cacheMap) {
            return this.cacheMap.size();
        }
    }
    
    // CLEANUP method
    @SuppressWarnings("unchecked")
	public void cleanup() {
        
        long now = System.currentTimeMillis();
        ArrayList<String> deleteKey = null;
        
        synchronized (this.cacheMap) {
            Iterator<?> itr = this.cacheMap.entrySet().iterator();
            
            deleteKey = new ArrayList<String>((this.cacheMap.size() / 2) + 1);
            CacheObject c = null;
            
            while (itr.hasNext()) {
                String key = (String) itr.next();
                c = (CacheObject) ((Entry<?, ?>) itr).getValue();
                if (c != null && (now > (this.timeToLive + c.lastAccessed))) {
                    deleteKey.add(key);
                }
            }
        }
        
        for (String key : deleteKey) {
            synchronized (this.cacheMap) {
                this.cacheMap.remove(key);
            }
            
            Thread.yield();
        }
    }

}
