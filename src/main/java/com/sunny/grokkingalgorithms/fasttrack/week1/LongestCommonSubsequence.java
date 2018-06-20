package com.sunny.grokkingalgorithms.fasttrack.week1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sundas on 6/20/2018.
 */
public class LongestCommonSubsequence {

   /*
   LCS:
    */
  public static int findLCSConsecutive(int[] input){
    int maxSize = 0;
    Set<Integer> set = new HashSet<>();
    for(int i = 0 ; i < input.length ; i++){
      set.add(input[i]);
    }
    for(int i = 0 ; i < input.length ; i++){
      if(!set.contains(input[i] - 1)){
        /*
        Beginning of subsequence
         */
        int j = input[i];
        while(set.contains(j)){
          j++;
        }
        int cur = j - input[i];
        if(cur > maxSize){
          maxSize = cur;
        }
      }
    }
    return maxSize;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[]  input = new int[]{2, 1, 9, 4, 6, 3};
    /*
    output 1,2,3,4
     */
    System.out.println(findLCSConsecutive(input));
  }

}
