package com.sunny.grokkingalgorithms.gfg.adb;

/**
 * Created by sundas on 5/25/2018.
 */
public class SortZeroOneTwos {

  /*
  Sort an array of 0s, 1s and 2s
Given an array A[] consisting 0s, 1s and 2s, enqueue a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.
Examples:

Input :  {0, 1, 2, 0, 1, 2}
Output : {0, 0, 1, 1, 2, 2}

Input :  {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
Output : {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
   */

  /**
   *
   * @param input
   */
  public static void sort(int[] input){
    int[] tracker = new int[3];
    for(int i = 0 ; i < input.length ; i++) {
      tracker[input[i]]++;
    }
    int index = 0;
    for(int i = 0; i < tracker.length ;i++){
      while(tracker[i] > 0){
        input[index] = i;
        index++;
        tracker[i]--;
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = {0, 1, 2, 0, 1, 2};
    sort(input);
    for(int i : input){
      System.out.println(i);
    }
    System.out.println("#########");
    input = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
    sort(input);
    for(int i : input){
      System.out.println(i);
    }
  }
}
