package com.sunny.grokkingalgorithms.boot2019.systemdesign;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LRUCache {

    private int maxCapacity;

    private LinkedList<Integer> evictionQueue;

    private Map<Integer,Integer> cache;

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.evictionQueue = new LinkedList();
        this.cache = new HashMap();
    }

    public int get(int key) {
        int val = -1;
        if(cache.containsKey(key)){
            val = cache.get(key);
            evictionQueue.remove(new Integer(key));
            //deleteFromQueue(key);
            evictionQueue.addFirst(new Integer(key));
        }
        return val;
    }

    public void deleteFromQueue(int key){
        int i = 0;
        while(i < evictionQueue.size()){
            if(evictionQueue.get(i).equals(key)){
                evictionQueue.remove(i);
                break;
            }
            i++;
        }
    }

    public void set(int key, int value) {
        if(cache.containsKey(key)){
            updateCache(key, value);
        }
        else {
            if (cache.size() == maxCapacity) {
                int delKey = evictionQueue.removeLast();
                cache.remove(delKey);
            }
            addToCache(key, value);
        }
    }

    private void updateCache(int key, int value) {
        cache.put(key, value);
        //deleteFromQueue(key);
        evictionQueue.remove(new Integer(key));
        evictionQueue.addFirst(new Integer(key));
    }

    private void addToCache(int key, int value) {
        cache.put(key, value);
        evictionQueue.addFirst(new Integer(key));
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
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
        lruCache = new LRUCache(2);
        lruCache.set(1, 10);
        lruCache.set(5, 12);
        System.out.println(lruCache.get(5));
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(10));
        lruCache.set(6, 14);
        System.out.println(lruCache.get(5));
        lruCache = new LRUCache(2);
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
        lruCache = new LRUCache(2);
        lruCache.set(2,1);
        lruCache.set(1,1);
        lruCache.set(2,3);
        lruCache.set(4,1);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
    }


}
