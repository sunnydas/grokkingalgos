package com.sunny.grokkingalgorithms.gfg.vmw;

/**
 * Created by sundas on 4/10/2018.
 */
public class ReverseAString {

  /*
  Given an array (or string), the task is to reverse the array/string.

Examples :

Input  : arr[] = {1, 2, 3}
Output : arr[] = {3, 2, 1}

Input :  arr[] = {4, 5, 1, 2}
Output : arr[] = {2, 1, 5, 4}
   */

  /**
   *
   * @param input
   * @return
   */
  public static int[] reverse(int[]  input){
    int i = 0;
    int j = input.length - 1;
    while(i < j){
      int temp = input[i];
      input[i] = input[j];
      input[j] = temp;
      i++;
      j--;
    }
    return input;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1, 2, 3};
    int[] output =  reverse(input);
    for(int i = 0 ; i < output.length ; i++){
      System.out.print(output[i] + " ");
    }
    System.out.println();
    input = new int[]{4, 5, 1, 2};
    output =  reverse(input);
    for(int i = 0 ; i < output.length ; i++){
      System.out.print(output[i] + " ");
    }
  }
}
