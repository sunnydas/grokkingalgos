package com.sunny.grokkingalgorithms.ctci.c9plusdp;

/**
 * Created by sundas on 4/10/2018.
 */
public class LongestIncreasingSubsequence {
  /*
  The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence such that all elements of the subsequence are sorted in increasing order.
   For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
   */


  /**
   *
   * @param input
   * @return
   */
  public static int findLengthOfLongestIncreasingSubequence(int[] input){
    int[] stage = new int[input.length];
    int maxLength = Integer.MIN_VALUE;
    int[] path = new int[input.length];
    /*
    The longest increasing subsequence will at least be on length 1
     */
    for(int i = 0 ; i < input.length ; i++){
      stage[i] = 1;
      path[i] = i;
    }
    for(int i = 1 ; i < input.length ; i++){
      for(int j = 0 ; j < i ; j++){
        /*
        This is essentially the forumal
         */
        if(input[i] > input[j]){
          if(stage[j] + 1 > stage[i]){
            stage[i] = stage[j] + 1;
            //Store the previosu index here, this keeps track of path
            path[i] = j;
          }
        }
      }
    }
    int printPosition = 0;
    for(int i = 0 ; i < stage.length ; i++){
      if(stage[i] > maxLength){
        maxLength = stage[i];
        printPosition = i;
      }
    }
    System.out.println(input[printPosition]);
    for(int i = printPosition ; i >= 0 && path[i] != i ; i=path[i]){
      //if(path[i] != i) {
      System.out.println(input[path[i]]);
      //}
    }
    return maxLength;
  }

  /**
   *
   * @param input
   * @return
   */
  public static int findLongestIncreasingSubsequenceRecursive(int[] input){
    int maxLength = Integer.MIN_VALUE;
    /*
    The sequence will either start from any of the indexes.
     */
    for(int i = 0 ; i < input.length - 1 ; i++){
      int length = findLongestIncreasingSubsequenceRecursive(input,i+1,input[i]);
      if(length > maxLength){
        maxLength = length;
      }
    }
    return maxLength+1;
  }


  /**
   *
   * @param input
   * @param position
   * @param lastNumber
   * @return
   */
  public static int findLongestIncreasingSubsequenceRecursive(int[] input,int position,int lastNumber){
    if(position == input.length){
      return 0;
    }
    int l1 = 0;
    int l2 = 0;
    if(input[position] > lastNumber){
      l1 = findLongestIncreasingSubsequenceRecursive(input,position+1,input[position]) + 1;
    }
    //else{
    l2 = findLongestIncreasingSubsequenceRecursive(input,position+1,lastNumber);
    //}
    return Math.max(l1,l2);
  }

  /**
   *
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = {3,4,-1,0,6,2,3};
    System.out.println(" max length = " + findLengthOfLongestIncreasingSubequence(input));
    System.out.println(" max length recursive = " + findLongestIncreasingSubsequenceRecursive(input));
    input =  new int[]{10, 22, 9, 33, 21, 50, 41, 60, 80};
    System.out.println(" max length = " + findLengthOfLongestIncreasingSubequence(input));
    System.out.println(" max length recursive = " + findLongestIncreasingSubsequenceRecursive(input));
  }

}
