package com.sunny.grokkingalgorithms.chap2;

import java.util.Scanner;

/**
 * Created by sundas on 1/2/2017.
 */
public class SelectionSort {


  /**
   *
   * @param input
   * @return
   */
  public static int[] performSelectionSort(int[] input){
    for(int i = 0 ; i < input.length ; i++){
      int minIndex = findMinimum(input,i);
      int temp = input[minIndex];
      input[minIndex] = input[i];
      input[i] = temp;
    }
    return input;
  }

  /**
   *
   * @param input
   * @param index
   * @return
   */
  public static int findMinimum(int[] input,int index){
    int min = Integer.MAX_VALUE;
    int minIndex = -1;
    for(int i = index; i < input.length; i++){
      if(input[i] <= min){
        min = input[i];
        minIndex = i;
      }
    }
    return minIndex;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] input = new int[n];
    for(int i = 0 ; i < input.length ; i++){
      input[i] = scanner.nextInt();
    }
    int[] sorted = performSelectionSort(input);
    for(int data: sorted){
      System.out.println(data);
    }
  }
}
