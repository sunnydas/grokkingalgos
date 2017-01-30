package com.sunny.grokkingalgorithms.chap4;

import java.util.Scanner;

/**
 * Created by sundas on 1/30/2017.
 */
public class MultiplicationTable {

  //Creating a multiplication table with all the elements in the array. So if your array is [2, 3, 7, 8, 10], you first multiply every element by 2, then multiply every element by 3, then by 7, and so on.


  /**
   * multiply
   */
  public static void printMultiplicationTable(int[] input){
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0; j < input.length ; j++){
        System.out.print(input[i]*input[j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[]  input = new int[n];
    for(int i = 0 ; i < n ; i++){
      input[i] = scanner.nextInt();
    }
    printMultiplicationTable(input);
  }
}
