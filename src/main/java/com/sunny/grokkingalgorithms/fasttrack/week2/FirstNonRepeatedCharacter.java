package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.*;

/**
 * Created by sundas on 6/25/2018.
 */
public class FirstNonRepeatedCharacter {

  /**
   *
   * @return
   */
  public static char firstNonRepeated(String s){
    char firstNonRepeated = '\0';
    Map<Character,Integer> tracker = new LinkedHashMap<>();
    for(int i = 0 ; i < s.length() ; i++){
      final char key = s.charAt(i);
      if(tracker.containsKey(key)){
        tracker.put(key,tracker.get(key) + 1);
      }
      else{
        tracker.put(key,1);
      }
    }
    Iterator<Map.Entry<Character,Integer>> iterator = tracker.
        entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<Character,Integer> entry = iterator.next();
      if(entry.getValue() == 1){
        firstNonRepeated = entry.getKey();
        break;
      }
    }
    return firstNonRepeated;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s = "aaaaaaaaabbbbbbbbccccdddddddeffffffg";
    System.out.println(firstNonRepeated(s));
  }

}
