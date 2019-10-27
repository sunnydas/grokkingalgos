package com.sunny.grokkingalgorithms.boot2019.systemdesign;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCacheAlt {

    private int maxCapacity;

    private LinkedHashMap<Integer,Integer> cache;

    public LRUCacheAlt(int capacity) {
        this.maxCapacity = capacity;
        this.cache = new LinkedHashMap<Integer, Integer>(maxCapacity,100.0f,true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest)
            {
                return size() > maxCapacity;
            }
        };
    }

    public int get(int key) {
        int val = -1;
        if(cache.containsKey(key)){
            val = cache.get(key);
        }
        return val;
    }

    public void set(int key, int value) {
        cache.put(key,value);
    }

    public static void main(String[] args) {
        LRUCacheAlt lruCache = new LRUCacheAlt(2);
        lruCache.set(1,0);
        lruCache.set(2,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        lruCache.set(3,2);
        System.out.println();
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println();
        lruCache = new LRUCacheAlt(2);
        lruCache.set(1, 10);
        lruCache.set(5, 12);
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.set(6, 14);
        System.out.println(lruCache.get(5));
        lruCache = new LRUCacheAlt(2);
        // 7 2 G 2 S 2 6 G 1 S 1 5 S 1 2 G 1 G 2
        System.out.println();
        System.out.println(lruCache.get(2));
        lruCache.set(2,6);
        System.out.println(lruCache.get(1));
        lruCache.set(1,5);
        lruCache.set(1,2);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println();
        //6 2 S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
        lruCache = new LRUCacheAlt(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        lruCache.set(2,3);
        lruCache.set(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }


}
