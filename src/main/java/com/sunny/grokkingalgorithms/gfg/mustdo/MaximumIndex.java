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

  /**
   *
   * @param input
   */
  public static void printMaximumIndexEditorialSolution(int[] input){
    int maxDistance = Integer.MIN_VALUE;
    /*
    This solution is an implementaion of an editorial for the same problem
     */
    // We use two auxillary arrays minTrcker and maxTracker
    // Logic for minTracker , choose minTRacker[i] = Min(input[i],minTracker[i-1]) 1<=i<n
    // Logic for maxTracker, choose maxTracker[i] = Max(input[i],maxTracker[i+1]) n-2>=i>=0
    //Populate min tracker
    int[] minTracker = new int[input.length];
    minTracker[0] = input[0];
    for(int i = 1 ; i < input.length ; i++){
      minTracker[i] = Math.min(input[i],minTracker[i-1]);
    }
    //Populate maxTracker
    int[] maxTracker = new int[input.length];
    maxTracker[maxTracker.length - 1] = input[input.length - 1];
    for(int i = maxTracker.length - 2; i >= 0 ; i--){
      maxTracker[i] = Math.max(input[i],maxTracker[i+1]);
    }
    // Now we have the arrays populated
    // Time to find distance
    int i=0 ;
    int j  = 0;
    while(i < input.length && j < input.length){
      if(minTracker[i] <= maxTracker[j]){
        maxDistance = Math.max(maxDistance,Math.abs(i-j));
        j++;
      }
      else{
        i++;
      }
    }
    System.out.println(maxDistance);
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
      //printMaximumIndexBruteForce(input);
      printMaximumIndexEditorialSolution(input);
    }
  }

}
