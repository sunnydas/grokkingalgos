package com.sunny.grokkingalgorithms.gfg.vmw;

/**
 * Created by sundas on 4/10/2018.
 */
public class CountFrequencyOfAllElementsInAnArrya {

  /*
  Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated multiple times and some other elements can be absent from the array. Count frequency of all elements that are present and print the missing elements.

Examples:

Input: arr[] = Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated multiple times and some other elements can be absent from the array. Count frequency of all elements that are present and print the missing elements.

Examples:

Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1

Input: arr[] = {4, 4, 4, 4}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 0
        3 -> 0
        4 -> 4
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1

Input: arr[] = {4, 4, 4, 4}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 0
        3 -> 0
        4 -> 4
   */

  /**
   *
   * @param input
   */
   public static void findFrequencies(int[] input){
     /*
     The thing to remember is that numbers are in range 1 to n
      */
     int i = 0;
     while(i < input.length){
         if(input[i] > 0){
           int elemIndex = input[i] - 1;
           if(input[elemIndex] > 0){
             //preserve
             input[i] = input[elemIndex];
             input[elemIndex] = -1;
             //Note that i is not incremented here
           }
           else{
             input[elemIndex]--;
             //Processing for this index is no longer required
             input[i] = 0;
             i++;
           }
         }
       else{
           i++;
           continue;
         }
     }
     for(int j = 0 ; j < input.length ; j++){
       //if(input[i] < 0) {
       System.out.println(" j = " + (j + 1) + " count = " + Math.abs(input[j]));
       //}
       //else{
         //System.out.println(" i = " + (i + 1) + " count = " + 1);
       //}
     }
   }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{2, 3, 3, 2, 5};
    findFrequencies(input);
    System.out.println();
    input = new int[]{4, 4, 4, 4};
    findFrequencies(input);
    System.out.println();
    input = new int[]{1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
    findFrequencies(input);
    System.out.println();
    input = new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
    findFrequencies(input);
    System.out.println();
    input = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    findFrequencies(input);
  }

}
