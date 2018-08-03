package com.sunny.grokkingalgorithms.fasttrack.week8;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sundas on 8/3/2018.
 */
public class FindPairsEqualToK {


  /**
   *
   * @param input
   * @param k
   * @return
   */
  public static Set<Set<Integer>> findPairs(int[] input,int k){
    Set<Set<Integer>> pairs = new HashSet<>();
    Set<Integer> lookup = new HashSet<>();
    for(int i : input){
      lookup.add(i);
    }
    for(int i = 0 ; i < input.length ; i++){
      int current = input[i];
      if(current <= k){
        if(lookup.contains(k - current)){
          Set<Integer> pair = new HashSet<>();
          pair.add(current);
          pair.add(k - current);
          pairs.add(pair);
        }
      }
    }
    return pairs;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{7,2,3,5,1,8,6};
    System.out.println(findPairs(input,9));
  }

}
