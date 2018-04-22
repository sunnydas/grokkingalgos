package com.sunny.grokkingalgorithms.gfg.ntx;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sundas on 4/22/2018.
 */
public class FindCountOfAnagrams {

  /*
  Given an array of strings , find the count of anagrams
   */

  /**
   *
   * @param input
   */
  public static void printAnagramsWithCount(String[] input){
    Map<String,Integer> countTable = new HashMap<>();
    for(int i = 0 ; i < input.length ; i++){
      String str = input[i];
      char[] rep = str.toCharArray();
      Arrays.sort(rep);
      String key = String.valueOf(rep);
      if(countTable.containsKey(key)){
        countTable.put(key,countTable.get(key)+1);
      }
      else{
        countTable.put(key,1);
      }
    }
    System.out.println(countTable);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] input = new String[]{"abba","acba","bbaa","ttres","baca","yiuryweuryw"};
    printAnagramsWithCount(input);
  }
}
