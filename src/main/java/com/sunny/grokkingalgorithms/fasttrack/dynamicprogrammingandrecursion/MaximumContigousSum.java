package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class MaximumContigousSum {

  /*
  Maximum contigous sub array
   */

  /**
   *
   * @param input
   * @return
   */
  public static String maximumContigousSubArray(int[] input){
    String maximumSubArray = null;
    int maxSum = Integer.MIN_VALUE;
    for(int i = 0; i < input.length ; i++){
      StringBuilder subArray = new StringBuilder();
      int curSum = 0;
      //int prevSum = 0;
      for(int j = i ; j < input.length ; j++){
        curSum += input[j];
        subArray.append(input[j]+ " ");
        if(curSum > maxSum){
          maxSum = curSum;
          maximumSubArray = subArray.toString();
        }
        /*if(prevSum > curSum){
          break;
        }*/
        //prevSum = curSum;
      }
    }
    return maximumSubArray;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{-2,-3,4,-1,-2,1,5,-3};
    System.out.println(maximumContigousSubArray(input));
  }
}
