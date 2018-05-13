package com.sunny.grokkingalgorithms.gfg.rlck;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sundas on 5/13/2018.
 */
public class DistinctPair {


  public static int numberOfPairs(int[] a,long k){
    int distinctPairs = 0;
    Arrays.sort(a);
    int i = 0;
    int j = a.length - 1;
    Set<Integer> tracker = new HashSet<>();
    while(i < j){
      if(a[i] + a[j] == k){
        if(!tracker.contains(a[i]) && !tracker.contains(a[j])) {
          distinctPairs++;
        }
        tracker.add(a[i]);
        tracker.add(a[j]);
        i++;
        j--;
      }
      while((a[i] + a[j]) > k){
        j--;
      }
      while((a[i] + a[j] < k)){
        i++;
      }
    }
    return distinctPairs;
  }

  public static void main(String[] args) {
    int[]  input = new int[]{1,3,46,1,3,9};
    System.out.println(numberOfPairs(input,47));
  }
}
