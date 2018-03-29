package com.sunny.grokkingalgorithms.gfg.it;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sundas on 3/29/2018.
 */
public class FindMinMissingNumber {

  /*
  Find minimum missing positive number from an array unsorted in O(n) time

   Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  {0, 2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2
   */


  /**
   *
   * @param input
   * @return
   */
  public static int findMissingMinimumPostiveOptimized(int[] input){
    /*
    The logic is that we use something similar to counting sort.
    Let us understand by an example:
    {0, 2, 3, -7, 6, 8, 1, -10, 15 }
    1.) Get rid of negatives
       {2,3,6.8,1,15}
     indexes =    0,1,2,3,4,5
    2.) find numbers
     iter 1: 2,-3 ,6,8,1,15
     iter 2: 2,-3,-6,8,1,15
     iter 3; 2,-3,-6,8,1,-15
     iter 4: 2,-3,-6,8,1,-15
     iter 5: -2,-3,-6,8,1,-15
     iter 6: -2,-3,-6,8,1,-15
      First positive number at index 3 so missing number is 4.
     */
    int start = seggregate(input);
    int[] shifted = new int[input.length - start];
    int j = 0;
    for(int i = start; i < input.length ; i++){
      shifted[j] = input[i];
      j++;
    }
    return findMissingPositiveAfterSeggregation(shifted,start);
  }

  /**
   *
   * @param input
   */
  public static int seggregate(int[] input){
    int j = 0;
    for(int i = 0 ; i < input.length ; i++){
      if(input[i] <= 0){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        j++;
      }
    }
    return j;
  }


  /**
   *
   * @param input
   * @return
   */
  public static int findMissingPositiveAfterSeggregation(int[] input,int offset){
    for(int i = 0 ; i < input.length ; i++){
      if(Math.abs(input[i])-1 >= 0
          && Math.abs(input[i]) - 1< input.length && input[Math.abs(input[i]) - 1] > 0){
        input[Math.abs(input[i]) - 1] = -input[Math.abs(input[i]) - 1];
      }
    }
    for(int i = 0 ; i < input.length ; i++){
      if(input[i] > 0){
        return i+1;
      }
    }
    return input.length + 1;
  }

  /**
   *
   * @param input
   * @return
   */
  public static int findMimimumMissingPositiveNumber(int[] input){
    /*
    This o(n) time and o(n) space
     */
    int min = Integer.MAX_VALUE;
    /*
    min positive and max positive
     */
    int minPositive = Integer.MAX_VALUE;
    int maxPositive = Integer.MIN_VALUE;
    for(int i = 0 ; i < input.length ; i++){
      if(input[i] >= 0 && input[i] < minPositive){
        minPositive = input[i];
      }
      if(input[i] >= 0 && input[i] > maxPositive){
        maxPositive = input[i];
      }
    }
    /*
    Found min positive and max positive, this is our range we use something like counting sort.
     */
    int[] tracker = new int[maxPositive + 1];
    /*
    Populate tracker
     */
    for(int i = 0 ; i < input.length ; i++){
      /*
      In range ?
       */
      if(input[i] >= minPositive && input[i] <= maxPositive){
        tracker[input[i]] = 1;
      }
    }
    //System.out.println(minPositive);
    //System.out.println(maxPositive);
    /*
    Now find missing positive number
    a.) min +ve number > 0 then we just need to look one slot left
    b.) normal case min +ve number missing is in array
    c.) min +ve number outside array (the it will be max + 1).
     */
    if(maxPositive - minPositive > 1){
      if(minPositive > 0){
        min = minPositive - 1;
      }
      else {
        /*
        Start from beginning of range and find fist missing number that will be the first missing positive integer
         */
        for (int i = minPositive; i < tracker.length; i++) {
          if(tracker[i] == 0){
            min = i;
            break;
          }
        }
      }
    }
    else if((maxPositive - minPositive) == 1){
      min = maxPositive + 1;
    }
    return min;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = {-10,7,-5,4,2};
    System.out.println(findMimimumMissingPositiveNumber(input));
    System.out.println("optimized");
    System.out.println(findMissingMinimumPostiveOptimized(input));
    input = new int[]{0, 2, 3, -7, 6, 8, 1, -10, 15};
    System.out.println(findMimimumMissingPositiveNumber(input));
    System.out.println("optimized");
    System.out.println(findMissingMinimumPostiveOptimized(input));
    input = new int[]{2, 3, 7, 6, 8, -1, -10, 15};
    System.out.println(findMimimumMissingPositiveNumber(input));
    System.out.println("optimized");
    System.out.println(findMissingMinimumPostiveOptimized(input));
    input = new int[]{1, 1, 0, -1, -2};
    System.out.println(findMimimumMissingPositiveNumber(input));
    System.out.println("optimized");
    System.out.println(findMissingMinimumPostiveOptimized(input));
  }


}
