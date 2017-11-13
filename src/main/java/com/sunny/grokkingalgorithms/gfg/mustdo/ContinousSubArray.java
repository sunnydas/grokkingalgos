package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.Scanner;

/**
 * Created by sundas on 11/11/2017.
 */
public class ContinousSubArray {

  /*
  http://practice.geeksforgeeks.org/problems/subarray-with-given-sum/0
   */

  /**
   *
   * @param input
   * @param totalSum
   */
  public static void findContinousSubArray(int[] input,int totalSum){
    int startIndex = -1;
    int endIndex = -1;
    int runningSum = 0;
    boolean found = false;
    for(int i = 0 ; i < input.length ; i++){
      startIndex = i;
      runningSum = input[i];
      if(runningSum > totalSum){
        continue;
      }
      else if(runningSum == totalSum){
        endIndex = i;
        break;
      }
      for(int j = i+1; j < input.length; j++){
        runningSum += input[j];
        if(runningSum > totalSum){
          runningSum = 0;
          startIndex = -1;
          endIndex = -1;
          break;
        }
        else if(runningSum == totalSum){
          endIndex = j;
          found = true;
          break;
        }
        else{
          endIndex = j;
        }
      }
      if(found){
        break;
      }
    }
    if(found) {
      System.out.println((startIndex + 1) + " " + (endIndex + 1));
    }
    else{
      System.out.println(-1);
    }
  }


   /**
   * @param input
   * @param totalSum
   */
  public static void findContinousSubArrayv2(int[]  input, int totalSum){
    int startIndex = -1;
    int endIndex = -1;
    /*
    We will try to use DP
     */
    // initialize matrix for calculating sums
    int[][] partialSums = new int[input.length][input.length];
    /*
    Example on how it will work
    suppose we have array = [1,2,3] and we have to find sum 5
    The matrix will look like:
         1 3 6
         x 2 5
         x x 3
        the startIndex = 1 , end Index = 2
     */
    partialSums = populatePartialSumMatrix(input,partialSums);
    //printMatrix(partialSums);
    /*
    Now we just have to search the sum in the matrix
     */
    boolean found = false;
    int rowTracker = 0;
    int colTracker = 0;
    for(int i = rowTracker; i < partialSums.length ; i++){
      for(int j = colTracker; j < partialSums.length; j++){
        if(partialSums[i][j] == totalSum){
          startIndex = i;
          endIndex = j;
          found = true;
          break;
        }
      }
      if(found){
        break;
      }
      rowTracker++;
      colTracker++;
    }
    if(startIndex >= 0 && endIndex >= 0) {
      System.out.println((startIndex + 1) + " " + (endIndex+1));
    }
    else{
      System.out.println(-1);
    }
  }

  /**
   *
   * @param matrix
   */
  public static void printMatrix(int[][] matrix){
    for(int i = 0 ; i < matrix.length ; i++){
      for(int j = 0 ; j < matrix.length ; j++){
        System.out.print(matrix[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  /**
   *
   * @param input
   * @param partialSumMatrix
   * @return
   */
  public static int[][] populatePartialSumMatrix(int[]  input,int[][] partialSumMatrix){
    int offset = 0;
    int rowTracker = 0;
    int colTracker = 0;
    int runningSum = 0;
    for(int i = rowTracker; i < partialSumMatrix.length ; i++){
      for(int j = colTracker; j < partialSumMatrix[i].length ; j++){
        int placeHolderVal = 0;
        if((i - 1) >= 0){
          placeHolderVal = partialSumMatrix[i - 1][j] - offset;
        }
        else{
          runningSum += input[j];
          placeHolderVal = runningSum ;
        }
        partialSumMatrix[i][j] = placeHolderVal;
      }
      offset = partialSumMatrix[rowTracker][colTracker];
      rowTracker++;
      colTracker++;
    }
    return partialSumMatrix;
  }

  /**
   *
   * @param input
   * @param totalSum
   */
  public static void findContiguousSubArrayV3(int[] input, int totalSum){
    int begin = 0;
    int index = 0;
    int startIndex = -1;
    int endIndex = -1;
    int runningSum = 0;
    while(index < input.length){
      runningSum += input[index];
      while(runningSum > totalSum && begin < index){
        runningSum -= input[begin];
        begin++;
      }
      if(runningSum == totalSum){
        endIndex = index;
        startIndex = begin;
        break;
      }
      index++;
    }
    if(startIndex >= 0 && endIndex >= 0) {
      System.out.println((startIndex + 1) + " " + (endIndex+1));
    }
    else{
      System.out.println(-1);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < numOfTestCases ;i++){
      int sizeOfArray = scanner.nextInt();
      int totalSum = scanner.nextInt();
      int[] input = new int[sizeOfArray];
      for(int j = 0 ; j < sizeOfArray ; j++){
        input[j] = scanner.nextInt();
      }
      //findContinousSubArray(input,totalSum);
      //findContinousSubArrayv2(input, totalSum);
      findContiguousSubArrayV3(input, totalSum);
    }
  }

}
