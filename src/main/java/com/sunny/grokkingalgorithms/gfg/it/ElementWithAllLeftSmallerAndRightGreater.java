package com.sunny.grokkingalgorithms.gfg.it;

import java.util.Scanner;

/**
 * Created by sundas on 9/9/2017.
 */
public class ElementWithAllLeftSmallerAndRightGreater {

  /*
  http://practice.geeksforgeeks.org/problems/unsorted-array/0

  Given an unsorted array of size N. Find the first element in array such that all of its left elements are smaller and all right elements to it are greater than it.
   */

  /**
   *
   * @param arr
   * @return
   */
  public static int findElementWithLeftSmallerAndRightGreaterBruteForce(int[] arr){
    int elem = -1;
    if(arr.length > 1){
      for(int i = 1; i <= arr.length - 2; i++){
        if(isLeftLessThanOrEqualTo(arr[i],arr,i-1) && isRightGreaterThanOrEqualTo(arr[i],arr,i+1)){
          elem = arr[i];
          break;
        }
      }
    }
    return elem;
  }

  /**
   *
   * @param elem
   * @param arr
   * @param j
   * @return
   */
  public static boolean isLeftLessThanOrEqualTo(int elem,int[] arr,int j){
    boolean yes = false;
    int i = 0;
    while(i <= j){
      if(arr[i] > elem){
        break;
      }
      i++;
    }
    if(i == (j + 1)){
      yes = true;
    }
    return yes;
  }

  /**
   *
   * @param elem
   * @param arr
   * @param j
   * @return
   */
  public static boolean isRightGreaterThanOrEqualTo(int elem,int[] arr,int j){
    boolean yes = false;
    int i = j;
    while(i <= (arr.length - 1)){
      if(arr[i] < elem){
        break;
      }
      i++;
    }
    if(i == arr.length){
      yes = true;
    }
    return yes;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Number of test cases");
    int noOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < noOfTestCases ; i++){
      int lengthOfArray = scanner.nextInt();
      int[] arr = new int[lengthOfArray];
      for(int j = 0 ; j < lengthOfArray ; j++){
        arr[j] = scanner.nextInt();
      }
      System.out.println(findElementWithLeftSmallerAndRightGreaterBruteForce(arr));
    }
  }



}
