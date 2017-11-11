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
      findContinousSubArray(input,totalSum);
    }
  }

}
