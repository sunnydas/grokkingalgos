package com.sunny.grokkingalgorithms.chap4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sundas on 1/11/2017.
 */
public class QuickSort {

  /**
   *
   * @param input
   * @param start
   * @param end
   * @return
   */
  public static int[] performQuickSort(int[] input,int start,int end){
    if(end <= start){
      //System.out.println(" end = " + end);
      //System.out.println(" start = " + start);
      return input;
    }
    else {
      int pivot = (end + start)/2;
      int pivotElement = input[pivot];
      int[] modified = new int[end - start + 1];
      int right = modified.length - 1;
      int left = 0;
      //Partition
      for(int i = start; i <= end; i++){
        if(input[i] <= input[pivot] && i != pivot){
          modified[left] = input[i];
          left++;
        }
        if(input[i] > input[pivot] && i != pivot){
          modified[right] = input[i];
          right--;
        }
      }
      int pivotIndex = -1;
      //Found exact location for pivot element
      if(left == right){
        modified[left] = pivotElement;
        pivotIndex = start + left;
      }
      int index = 0;
      //copy pivoted element to partially sorted array
      for(int i = start; i <= end ; i++){
        input[i] = modified[index];
        /*if(input[i] == pivotElement){
          pivotIndex = i;
        }*/
        index++;
      }
      //debug
   /*   System.out.println(" end = " + end);
      System.out.println(" start = " + start);
      System.out.println(" pivot = " + pivot);
      for(int i = 0 ; i < input.length ; i++){
        System.out.print(input[i] + " ");
      }
      System.out.println();
      System.out.println(" ### start = " + start + " left  " + left + " end " + end);*/
      // Run quick sort on rest
      //System.out.println(" ### start = " + start + " pivot  " + pivotIndex + " end " + end + " left " + left + " right " + right);
      input = performQuickSort(input, start, pivotIndex - 1);
      input = performQuickSort(input, pivotIndex + 1, end);

    }
    return input;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] input = new int[n];
    for(int i = 0 ; i < n ; i++){
      input[i] = scanner.nextInt();
    }
    int[] output = performQuickSort(input,0,input.length - 1);
    for(int i : output){
      System.out.println(i);
    }
  }
}
