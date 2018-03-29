package com.sunny.grokkingalgorithms.gfg.it;

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
    else if(maxPositive - minPositive == 1){
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
    input = new int[]{0, 2, 3, -7, 6, 8, 1, -10, 15};
    System.out.println(findMimimumMissingPositiveNumber(input));
    input = new int[]{2, 3, 7, 6, 8, -1, -10, 15};
    System.out.println(findMimimumMissingPositiveNumber(input));
    input = new int[]{1, 1, 0, -1, -2};
    System.out.println(findMimimumMissingPositiveNumber(input));
  }


}
