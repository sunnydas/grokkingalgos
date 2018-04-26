package com.sunny.grokkingalgorithms.random;

/**
 * Created by sundas on 4/25/2018.
 */
public class QuickSort {

 /* *//*
  Implement quick sort
   *//*
  public static int[] quickSort(int[] input,int start,int end){
    if(start >= end){
      return input;
    }
    int pivot = start + (end - start)/2;
    int pivotElement = input[pivot];
    int[]  helper = new int[end - start + 1];
    int leftIndex = 0;
    int rightIndex = helper.length - 1;
     *//*
    Partition left
     *//*
    int i = start;
    while(i <= pivot - 1){
      if(input[i] <= input[pivot]){
        helper[leftIndex] = input[i];
        leftIndex++;
      }
      else{
        helper[rightIndex] = input[i];
        rightIndex--;
      }
      i++;
    }
    *//*
    Partition right
     *//*
    int j = end;
    while(j > pivot){
      if(input[j] > input[pivot]){
        helper[rightIndex] = input[j];
        rightIndex--;
      }
      else{
        helper[leftIndex] = input[j];
        leftIndex++;
      }
      j--;
    }
    *//*
    Insert pivot element
     *//*
    helper[leftIndex] = pivotElement;
    *//*
    Copy back to main array this makes this particular implementation equal to merge sort
     *//*
    int l = 0;
    for(int k = start ; k <= end ; k++,l++ ){
      input[k] = helper[l];
    }
    input = quickSort(input,start,pivot);
    input = quickSort(input,pivot+1,end);
    return input;
  }
*/

  /*
  Implement quick sort
   */
  public static int[] quickSortAlternate(int[] input,int start,int end){
    if(start >= end){
      return input;
    }
    int pivot = start + (end - start)/2;
    int pivotElement = input[pivot];
    int i = start;
    int j = end;
    while(i <= j){
      while(input[i] < pivotElement){
        i++;
      }
      while(input[j] > pivotElement){
        j--;
      }
      if(i <= j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
        i++;
        j--;
      }
    }
    input = quickSortAlternate(input,start,j);
    input = quickSortAlternate(input,i,end);
    return input;
  }
  
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
   /* int[] input = new int[]{5,4,3,2,1,-1,-2,-3,100,10,0};
    input = quickSort(input,0, input.length - 1);
    for(int i : input){
      System.out.println(i);
    }
    System.out.println("--------------");
    input = new int[]{1,2,3,4,5};
    input = quickSort(input,0, input.length - 1);
    for(int i : input){
      System.out.println(i);
    }*/
    System.out.println("Alternate");
    int[] input = new int[]{5,4,3,2,1,-1,-2,-3,100,10,0};
    input = quickSortAlternate(input, 0, input.length - 1);
    for(int i : input){
      System.out.println(i);
    }
  }
}
