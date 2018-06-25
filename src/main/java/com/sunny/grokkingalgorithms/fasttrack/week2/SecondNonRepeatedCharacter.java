package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by sundas on 6/25/2018.
 */
public class SecondNonRepeatedCharacter {

  /**
   *
   * @return
   */
  public static char secondNonRepeated(String s){
    char secondNonRepeated = '\0';
    int count = 0;
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
        if(count == 1) {
          secondNonRepeated = entry.getKey();
          break;
        }
        count++;
      }
    }
    return secondNonRepeated;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s = "aaaaaaaaabbbbbbbbccccdddddddeffffffghhhhhhhi";
    System.out.println(secondNonRepeated(s));
  }

}
