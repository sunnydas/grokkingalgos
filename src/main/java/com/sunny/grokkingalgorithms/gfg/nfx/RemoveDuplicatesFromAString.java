package com.sunny.grokkingalgorithms.gfg.nfx;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sundas on 5/23/2018.
 */
public class RemoveDuplicatesFromAString {

  public static String removeDuplicates(String s){
    Set<Character> tracker = new HashSet<>();
    StringBuilder builder = new StringBuilder();
    for(int i = 0 ; i < s.length() ; i++){
      final char e = s.charAt(i);
      if(!tracker.contains(e)){
        builder.append(e);
        tracker.add(e);
      }
    }
    return builder.toString();
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s = "dgterttyrj,mi,iy";
    System.out.println(removeDuplicates(s));
  }
}
