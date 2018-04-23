package com.sunny.grokkingalgorithms.gfg.ggl;

import java.util.*;

/**
 * Created by sundas on 4/23/2018.
 */
public class FindSecondNonRepeatedCharInString {


  /*
  Find second non repeated char ins tring.
   */

  /**
   *
   * @param str
   * @return
   */
  public static char findSecondNonRepeatedCharInString(String str){
    char secondNonRepeatedChar = '\0';
    Map<Character,Integer> tracker = new LinkedHashMap<>();
    for(int i = 1 ; i < str.length(); i++){
      char current = str.charAt(i);
      if(tracker.containsKey(current)){
        tracker.put(current,tracker.get(current) + 1);
      }
      else{
        tracker.put(current,1);
      }
    }
    Iterator<Map.Entry<Character,Integer>> iterator = tracker.entrySet().iterator();
    boolean first = false;
    while(iterator.hasNext()){
      Map.Entry<Character,Integer> entry = iterator.next();
      if(entry.getValue() == 1){
        if(!first){
          first = true;
        }
        else{
          secondNonRepeatedChar = entry.getKey();
        }
      }
    }
    return secondNonRepeatedChar;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String str = new String("aaaaacbbbbbdaaaabbb");
    System.out.println(findSecondNonRepeatedCharInString(str));
  }


}
