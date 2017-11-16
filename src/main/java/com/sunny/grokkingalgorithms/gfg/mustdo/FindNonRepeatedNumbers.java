package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.*;

/**
 * Created by sundas on 11/16/2017.
 */
public class FindNonRepeatedNumbers {
  //http://practice.geeksforgeeks.org/problems/finding-the-numbers/0


  /**
   *
   * @param input
   */
  public static void printFoundNumbersUsingHashing(int[] input,int n){
    Set<Integer> repeatTracker = new HashSet<>();
    /*
    Iterate over input
     */
    for(int i = 0 ; i < input.length ; i++){
      if(repeatTracker.contains(input[i])){
        repeatTracker.remove(input[i]);
      }
      else{
        repeatTracker.add(input[i]);
      }
    }
    //System.out.println(repeatTracker);
    Iterator<Integer> iterator = repeatTracker.iterator();
    int[] placeHolder = new int[2];
    int index = 0;
    while(iterator.hasNext()){
      int nonRepeatedVal = iterator.next();
      if(index == 1){
        if(placeHolder[0] > nonRepeatedVal){
          int temp = placeHolder[0];
          placeHolder[0] = nonRepeatedVal;
          placeHolder[1] = temp;
        }
        else{
          placeHolder[index] = nonRepeatedVal;
        }
      }
      else{
        placeHolder[0] = nonRepeatedVal;
      }
      index++;
    }
    System.out.println("" + placeHolder[0] + " " + placeHolder[1]);
  }

  /**
   *
   *
   * @param input
   */
  public static void printFoundNumbersUsingEditorialSolution(int[] input){
    /*
    Refer to this for explanation of logic
     */
    //xor all elements in the array
    int xoredVals = input[0];
    for(int i = 1 ; i < input.length ; i++){
      xoredVals ^= input[i];
    }
    // Get right most set bit refer bit magic
    int xoredSetBit = xoredVals & ~(xoredVals - 1);
    //Set division
    int a = 0;
    int b = 0;
    for(int i = 0 ; i < input.length ; i++){
      if((input[i] & xoredSetBit) > 0){
        a ^= input[i];
      }
      else{
        b ^= input[i];
      }
    }
    if(a < b){
      System.out.println(a + " " + b);
    }
    else{
      System.out.println(b + " " + a);
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    1
2
1 2 3 2 1 4
     */
    Scanner  scanner = new Scanner(System.in);
    int numOftestCases = scanner.nextInt();
    for(int i = 0 ; i < numOftestCases ; i++){
      int n = scanner.nextInt();
      int[] input = new int[2*n+2];
      for(int j = 0 ; j < input.length ; j++){
        input[j] = scanner.nextInt();
      }
      //printFoundNumbersUsingHashing(input, n);
      printFoundNumbersUsingEditorialSolution(input);
    }
  }

}
