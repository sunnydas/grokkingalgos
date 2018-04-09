package com.sunny.grokkingalgorithms.gfg.vmw;

import java.util.*;

class Entry implements Comparable<Entry>{
  int key;
  int count;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Entry entry = (Entry) o;

    if (key != entry.key) return false;
    //return count == entry.count;
    return true;
  }

  @Override
  public String toString() {
    return "Entry{" +
        "key=" + key +
        ", count=" + count +
        '}';
  }

  @Override
  public int hashCode() {
    int result = key;
    result = 31 * result;
    return result;
  }

  @Override
  public int compareTo(Entry o) {
    if(this.count > o.count){
      return 1;
    }
    else if(this.count == o.count){
      return 0;
    }
    else{
      return -1;
    }
  }
}
/**
 * Created by sundas on 4/10/2018.
 */
public class TopKRecurringNumbers {

  /*
  Given an array of numbers, return the top k recurring numbers along with their count.
   */


  /**
   *
   * @param input
   * @param k
   */
   public static void findTopKRecurring(int[] input,int k){
     Map<Entry,Entry> countTable = new HashMap<>();
     for(int i = 0 ; i < input.length ; i++){
       Entry entry = new Entry();
       entry.key = input[i];
       if(countTable.containsKey(entry)){
         entry.count = countTable.get(entry).count + 1;
         //System.out.println(entry);
         countTable.remove(entry);
         countTable.put(entry, entry);
         //System.out.println(countTable);
       }
       else{
         entry.count = 1;
         countTable.put(entry,entry);
       }
     }
     //System.out.println(countTable);
     PriorityQueue<Entry> recordFetcher = new PriorityQueue<>(Comparator.<Entry>reverseOrder());
     Iterator<Entry> entryIterator = countTable.keySet().iterator();
     //System.out.println(countTable.size());
     while(entryIterator.hasNext()){
       Entry key  = entryIterator.next();
       //System.out.println(key);
       recordFetcher.add(key);
     }
     //System.out.println(recordFetcher);
     for(int i = 0 ; i < k ; i++){
       if(!recordFetcher.isEmpty()){
         Entry entry = recordFetcher.poll();
         System.out.println(" key = " + entry.key + " count = " + entry.count);
       }
     }
   }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,-1,5,6,7,1,5,6,6,6,1,2};
    findTopKRecurring(input, 3);
  }

}
