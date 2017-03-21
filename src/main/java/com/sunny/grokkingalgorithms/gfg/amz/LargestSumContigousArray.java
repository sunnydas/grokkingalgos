package com.sunny.grokkingalgorithms.gfg.amz;

import java.util.Scanner;

/**
 * Created by sundas on 3/21/2017.
 */
public class LargestSumContigousArray {

  /*
  http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
  Can have negative numbers
   */

  /**
   * Attemp1: Brute force
   *
   *
   * @param input
   * @return
   */
  public static int largestSumContigousArray(int[] input){
    int largestSum = Integer.MIN_VALUE;
    for(int i = 0 ; i < input.length ; i++){
      int currentSum = findMaxInSubsequence(i,input);
      if(currentSum > largestSum){
        largestSum = currentSum;
      }
    }
    return largestSum;
  }

  /**
   *
   * @param index
   * @param input
   * @return
   */
  public static int findMaxInSubsequence(int index,int[] input){
    int largestSum = Integer.MIN_VALUE;
    int currentSum = Integer.MIN_VALUE;
    for(int i = index ; i < input.length ; i++){
      if(currentSum == Integer.MIN_VALUE){
        currentSum = input[i];
        largestSum = currentSum;
      }
      else{
        currentSum += input[i];
        if(currentSum > largestSum){
          largestSum = currentSum;
        }
      }
    }
    return largestSum;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*8
        -2 -3 4 -1 -2 1 5 -3
    7*/
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] input = new int[n];
    for(int i = 0 ; i < input.length ; i++){
      input[i] = scanner.nextInt();
    }
    System.out.println(largestSumContigousArray(input));
  }
}
