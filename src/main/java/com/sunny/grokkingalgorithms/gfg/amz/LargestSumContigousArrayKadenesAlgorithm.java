package com.sunny.grokkingalgorithms.gfg.amz;

import java.util.Scanner;

/**
 * Created by sundas on 3/22/2017.
 */
public class LargestSumContigousArrayKadenesAlgorithm {

  /*
  https://en.wikipedia.org/wiki/Maximum_subarray_problem
   */


  /**
   *
   * @param input
   * @return
   */
  public static int findLargestSumContigousKadaneAlgo(int[] input){
    int largestSum = Integer.MIN_VALUE;
    /*
    Keep running sum , for every i check if previous sum needs to be included or not
     */
    int maxEbdingSoFar = Integer.MIN_VALUE;
    for(int i = 0 ; i < input.length ; i++){
      int currentValue = input[i];
      if(maxEbdingSoFar == Integer.MIN_VALUE && largestSum == Integer.MIN_VALUE){
        maxEbdingSoFar = currentValue;
      }
      else{
        maxEbdingSoFar = Math.max(currentValue,maxEbdingSoFar + currentValue);
        largestSum = Math.max(maxEbdingSoFar,largestSum);
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
    System.out.println(findLargestSumContigousKadaneAlgo(input));
  }
}
