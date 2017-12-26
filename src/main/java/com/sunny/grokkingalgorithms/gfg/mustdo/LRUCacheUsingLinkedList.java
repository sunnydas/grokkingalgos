package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
class LRUTracker<T>{
  LRUTracker prev;
  LRUTracker next;
  T data;

  @Override
  public String toString() {
    return "LRUTracker{" +
        "prev=" + prev +
        ", next=" + next +
        ", data=" + data +
        '}';
  }
}
class LruPolicy{

  private LRUTracker<Integer> front;

  private LRUTracker<Integer> rear;

  private int currentCapacity;

  public LruPolicy(int currentCapacity) {
    this.currentCapacity = currentCapacity;
  }

  /**
   *
   * @param data
   */
  public void addToFront(int data){
    LRUTracker<Integer> entry = new LRUTracker<>();
    entry.data = data;
    if(front == null){
      front = entry;
      rear = front;
    }
    else{
      entry.next = front;
      front.prev = entry;
      front = entry;
    }
  }


  /**
   *
   * @param entry
   */
  public void addToFront(LRUTracker<Integer> entry)
  {
    if(front == null){
      front = entry;
      rear = front;
    }
    else{
      entry.next = front;
      front.prev = entry;
      front = entry;
    }
  }

  /**
   *
   * @return
   */
  public LRUTracker<Integer> deleteFromEnd(){
    LRUTracker<Integer> deleted = null;
    if(rear != null){
      if(front == rear){
        front = null;
      }
      LRUTracker<Integer> temp = rear;
      rear = rear.prev;
      if(temp.prev != null){
        temp.prev.next = null;
        temp.prev = null;
      }
      deleted = temp;
    }
    return deleted;
  }


  /**
   *
   * @param key
   */
  public void updateLruTrackerPolicy(int key){
    LRUTracker<Integer> candidateNode = findCandidateNode(key);
    if(candidateNode != null && front != candidateNode){
      if(rear == candidateNode){
        deleteFromEnd();
      }
      else {
        if (candidateNode.prev != null) {
          candidateNode.prev.next = candidateNode.next;
        }
        if (candidateNode.next != null) {
          candidateNode.next.prev = candidateNode.prev;

        }
        candidateNode.prev = null;
        candidateNode.next = null;
      }
      addToFront(candidateNode);
    }
  }


  /**
   *
   * @param key
   * @return
   */
  public LRUTracker<Integer> findCandidateNode(int key){
    LRUTracker<Integer> candidateNode = null;
    LRUTracker<Integer> current = this.front;
    while(current != null){
      if(current.data == key){
        candidateNode = current;
        break;
      }
      current = current.next;
    }
    return candidateNode;
  }


  /**
   *
   * @param head
   */
  public static void printList(LRUTracker head){
    LRUTracker current = head;
    //System.out.println(current.data);
    while(current != null){
      System.out.println(current.data);
      current = current.next;
    }
  }

}
/**
 * LRU Cache implementation using LinkedList
 *
 * Created by sundas on 12/7/2017.
 */
public class LRUCacheUsingLinkedList {

 /* 1

      4
      87
  SET 94 16 SET 93 87 SET 63 22 SET 60 91 SET 41 27 GET 73 GET 12 GET 68 SET 31 83 GET 24 SET 30 36 GET 23 GET 70 SET 57 94 SET 30 43 SET 20 22 GET 38 GET 25 SET 14 71 GET 92 GET 57 SET 71 63 GET 82 SET 85 26 SET 6 37 GET 30 SET 25 58 SET 46 83 GET 68 GET 65 SET 88 51 GET 77 GET 89 GET 4 SET 100 55 GET 61 GET 69 SET 27 13 GET 95 SET 71 96 GET 79 SET 98 2 GET 18 GET 53 GET 2 GET 87 SET 90 66 GET 20 GET 30 SET 98 18 SET 76 82 SET 68 28 GET 98 SET 66 87 GET 84 SET 29 25 SET 30 33 SET 71 20 GET 9 SET 50 41 GET 24 GET 46 GET 52 SET 80 56 GET 65 GET 42 GET 94 GET 35 GET 25 GET 88 GET 44 SET 66 28 SET 33 37 SET 29 38 SET 75 8 SET 96 59 SET 36 38 SET 29 19 SET 29 12 SET 5 77 SET 14 64 GET 7 GET 5 GET 29 GET 70 SET 97 18 GET 44

*/
  /**
   * This time the idea is to use the linked list to keep track of freshness, the front of the list will represent the
   * freshest element in the cache, whereas the end of the linked list will represent the oldest one. Therefore, in case
   * of capacity crunch the element from the tail will be deleted (and subsequently removed from backing map). All new
   * elements will be added in front of the linkedlist. When we say element we mean the key.Essentially we will use a
   * front and rear pointer to keep track of the freshest and the most stele elements in the cache system.
   */

  private int cacheSize;

  private Map<Integer,Integer> backingStore;

  private LruPolicy lruPolicy;


  /**
   *
   * @param cacheSize
   */
  public LRUCacheUsingLinkedList(int cacheSize) {
    this.cacheSize = cacheSize;
    this.backingStore = new HashMap<>();
    this.lruPolicy = new LruPolicy(cacheSize);
  }




  /**
   *
   * @param x
   * @return
   */
  public int get(int x){
    int result = -1;
    if(backingStore.containsKey(x)){
      result = backingStore.get(x);
      this.lruPolicy.updateLruTrackerPolicy(x);
    }
    return result;
  }


  /**
   *
   * @param x
   * @param y
   */
  public void set(int x, int y){
    /*if(backingStore.containsKey(x)){
      this.lruPolicy.updateLruTrackerPolicy(x);
    }
    else{
      if(currentCapacity >= cacheSize){
        LRUTracker<Integer> tracker = this.lruPolicy.deleteFromEnd();
        if(tracker != null) {
          backingStore.remove(tracker.data);
          currentCapacity--;
        }
      }
      this.lruPolicy.addToFront(x);
      currentCapacity++;
    }*/
    if(backingStore.containsKey(x)){
      this.lruPolicy.updateLruTrackerPolicy(x);
      backingStore.put(x, y);
    }
    else{
      while(backingStore.size() >= cacheSize){
        LRUTracker<Integer> tracker = this.lruPolicy.deleteFromEnd();
        if(tracker != null) {
          backingStore.remove(tracker.data);
        }
      }
      this.lruPolicy.addToFront(x);
      backingStore.put(x,y);
    }
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
    inputDriver();

    /*LruPolicy lruPolicy = new LruPolicy(5);
    lruPolicy.addToFront(1);
    lruPolicy.addToFront(2);
    lruPolicy.addToFront(3);
    lruPolicy.addToFront(4);
    lruPolicy.addToFront(5);
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.deleteFromEnd();
    System.out.println("##################");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.deleteFromEnd();
    System.out.println("##################");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.deleteFromEnd();
    System.out.println("##################");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.deleteFromEnd();
    System.out.println("##################");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.deleteFromEnd();
    System.out.println("##################");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.addToFront(1);
    lruPolicy.addToFront(2);
    lruPolicy.addToFront(3);
    lruPolicy.addToFront(4);
    lruPolicy.addToFront(5);
    lruPolicy.updateLruTrackerPolicy(3);
    System.out.println("################## after update");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.updateLruTrackerPolicy(1);
    System.out.println("################## after update");
    lruPolicy.printList(lruPolicy.getFront());
    lruPolicy.updateLruTrackerPolicy(1);
    System.out.println("################## after update");
    lruPolicy.printList(lruPolicy.getFront());*/
  }

  private static void inputDriver() {
    Scanner scanner = new Scanner(System.in);
    int numOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < numOfTestCases ; i++){
      int cacheSize = scanner.nextInt();
      LRUCacheUsingLinkedList lruCache = new LRUCacheUsingLinkedList(cacheSize);
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
