package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.Scanner;

/**
 * Created by sundas on 11/14/2017.
 */
public class MaximumIndex {
  //http://practice.geeksforgeeks.org/problems/maximum-index/0


  /**
   *
   * @param input
   */
  public static void printMaximumIndexBruteForce(int[] input){
    int maxDistanceBetweenJandI = 0;
    for(int i = 0 ; i < input.length ; i++){
      for(int j = i+1; j < input.length; j++){
        if(input[i] <= input[j] && (j-i) > maxDistanceBetweenJandI){
          maxDistanceBetweenJandI = j - i;
        }
      }
    }
    System.out.println(maxDistanceBetweenJandI);
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int numOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < numOfTestCases ; i++){
      int sizeOfArray = scanner.nextInt();
      int[] input = new int[sizeOfArray];
      for(int j = 0 ; j < input.length ; j++){
        input[j] = scanner.nextInt();
      }
      printMaximumIndexBruteForce(input);
    }
  }

}
