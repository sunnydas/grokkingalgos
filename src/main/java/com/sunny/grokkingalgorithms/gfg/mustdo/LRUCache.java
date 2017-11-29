package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.*;

/**
 * This represents a cache value that will be stored on the LRU Cache. This has been done because we need to add
 * attribute freshnesstoken to represent age (based on usage). Please note that count will not work in LRU as a recently
 * added key,value pair will have low count which will cause it to be evicted defying LRU (might be useful for LFU).
 *
 * Created by sundas on 11/28/2017.
 */
class CacheEntry{

  private int value;
  private int key;

  @Override
  public String toString() {
    return "CacheEntry{" +
        "value=" + value +
        ", key=" + key +
        ", freshnessToken=" + freshnessToken +
        ", count=" + count +
        '}';
  }

  public int getFreshnessToken() {
    return freshnessToken;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CacheEntry that = (CacheEntry) o;

    if (getValue() != that.getValue()) return false;
    if (getKey() != that.getKey()) return false;
    if (getFreshnessToken() != that.getFreshnessToken()) return false;
    return getCount() == that.getCount();

  }

  @Override
  public int hashCode() {
    int result = getValue();
    result = 31 * result + getKey();
    result = 31 * result + getFreshnessToken();
    result = 31 * result + getCount();
    return result;
  }

  public void setFreshnessToken(int freshnessToken) {
    this.freshnessToken = freshnessToken;
  }

  private int freshnessToken;

  private int count;

  public int getKey() {
    return key;
  }

  public CacheEntry(int key, int value) {
    this.value = value;
    this.key = key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}

/**
 * Since we are using a PriorotyQueue we need a way to maintain ordering within the queue. The organization in the queue
 * is least to most. This comparator uses freshness token.
 */
class LRUComparator implements Comparator<CacheEntry> {

  @Override
  public int compare(CacheEntry o1, CacheEntry o2) {
    if(o1.getFreshnessToken() > o2.getFreshnessToken()){
      return 1;
    }
    else if(o1.getFreshnessToken() == o2.getFreshnessToken()){
      return 0;
    }
    else{
      return -1;
    }

  }
}

/**
 * LRU cache implementation using PriorityQueues (functions like a min heap).
 */
public class LRUCache {

  //https://practice.geeksforgeeks.org/problems/lru-cache/1

  /**
   * The back end map storing the key value
   */
    private Map<Integer,CacheEntry> backingMap;

  /**
   * Very important , the core of LRU eviction policy. However the issue is that the default implementation does not have
   * mechanism to updated the priority unless some mutating opeartion is performed like add,offer,poll. A better idea would be to use
   * own implementation of min heap which reorders if required based on access (like get).
    */
    private PriorityQueue<CacheEntry> lruImplementor;

    private int sizeLimit;

  /**
   * The barebones freshness token generator used to assign freshness tokens.
   */
    private int tokenGenerator;

    /*Inititalize an LRU cache with size N */
    public LRUCache(int N) {
      this.backingMap = new HashMap<>(N);
      this.sizeLimit = N;
      /*
      The comparator essentially drives the ordering for LRU.
       */
      this.lruImplementor = new PriorityQueue<>(N,new LRUComparator());
    }

    /*Returns the value of the key x if
     present else returns -1 */
    public int get(int x) {
      int result = -1;
      if(backingMap.containsKey(x)){
        CacheEntry cacheEntry = backingMap.get(x);
        result = cacheEntry.getValue();
        /*
        The remove add sequence is to update the priority queue with new priority based on the updated freshness token
        which is eventually based on access.
         */
        boolean removed = lruImplementor.remove(cacheEntry);
        //System.out.println(removed);
        // Update access count
        //cacheEntry.setCount(cacheEntry.getCount() + 1);
        cacheEntry.setFreshnessToken(tokenGenerator++);
        boolean added = lruImplementor.offer(cacheEntry);
        //System.out.println(added);
        //cacheEntry.setFreshnessToken(tokenGenerator++);
      }
      return result;
    }

    /*Sets the key x with value y in the LRU cache */
    public void set(int x, int y) {
      if(backingMap.containsKey(x)) {
        /*
        We do not need to worry about capacity if itis an update operation
         */
        CacheEntry cacheEntry = backingMap.get(x);
        boolean removed = lruImplementor.remove(cacheEntry);
        //System.out.println(removed);
        cacheEntry.setValue(y);
        //cacheEntry.setCount(cacheEntry.getCount() + 1);
        cacheEntry.setFreshnessToken(tokenGenerator++);
        //cacheEntry.setTimStamp(System.currentTimeMillis());
        backingMap.put(x, cacheEntry);
        boolean added = lruImplementor.offer(cacheEntry);
        //System.out.println(added);
      }
      else{
        /*
      Capacity reached. Eviction logic.
       */
        while(this.backingMap.size() >= this.sizeLimit){
          CacheEntry cacheEntry = lruImplementor.poll();
          if(cacheEntry != null) {
            this.backingMap.remove(cacheEntry.getKey());
          }
        }
        // New entry in LRU cache
        CacheEntry cacheEntry = new CacheEntry(x,y);
        //cacheEntry.setCount(1);
        cacheEntry.setFreshnessToken(tokenGenerator++);
        //cacheEntry.setTimStamp(System.currentTimeMillis());
        backingMap.put(x, cacheEntry);
        boolean added = lruImplementor.add(cacheEntry);
        //System.out.println(added);
      }
      /*System.out.println("in set " + lruImplementor);
      System.out.println(backingMap);
      System.out.println("-------------------------");*/
    }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    Input:
4
87
SET 94 16 SET 93 87 SET 63 22 SET 60 91 SET 41 27 GET 73 GET 12 GET 68 SET 31 83 GET 24 SET 30 36 GET 23 GET 70 SET 57 94 SET 30 43 SET 20 22 GET 38 GET 25 SET 14 71 GET 92 GET 57 SET 71 63 GET 82 SET 85 26 SET 6 37 GET 30 SET 25 58 SET 46 83 GET 68 GET 65 SET 88 51 GET 77 GET 89 GET 4 SET 100 55 GET 61 GET 69 SET 27 13 GET 95 SET 71 96 GET 79 SET 98 2 GET 18 GET 53 GET 2 GET 87 SET 90 66 GET 20 GET 30 SET 98 18 SET 76 82 SET 68 28 GET 98 SET 66 87 GET 84 SET 29 25 SET 30 33 SET 71 20 GET 9 SET 50 41 GET 24 GET 46 GET 52 SET 80 56 GET 65 GET 42 GET 94 GET 35 GET 25 GET 88 GET 44 SET 66 28 SET 33 37 SET 29 38 SET 75 8 SET 96 59 SET 36 38 SET 29 19 SET 29 12 SET 5 77 SET 14 64 GET 7 GET 5 GET 29 GET 70 SET 97 18 GET 44
    correct output: -1 -1 -1 -1 -1 -1 -1 -1 -1 94 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 18 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 77 12 -1 -1

     1
2
8
SET 1 101 GET 1 GET 1 SET 2 102 GET 1 SET 3 103 GET 2 GET 1

     */
    Scanner scanner = new Scanner(System.in);
    int numOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < numOfTestCases ; i++){
      int cacheSize = scanner.nextInt();
      LRUCache lruCache = new LRUCache(cacheSize);
      int numOfQueries = scanner.nextInt();
      for(int j = 0 ; j < numOfQueries ; j++){
        String queryType = scanner.next();
        if(queryType.equalsIgnoreCase("SET")){
          int x = scanner.nextInt();
          int y = scanner.nextInt();
          lruCache.set(x,y);
        }
        else{
          int x = scanner.nextInt();
          System.out.print(lruCache.get(x) + " ");
        }
      }
      System.out.println();
    }
  }
}
