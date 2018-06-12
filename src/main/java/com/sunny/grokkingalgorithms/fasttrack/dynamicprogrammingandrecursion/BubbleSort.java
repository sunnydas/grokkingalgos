package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class BubbleSort {

  /**
   *
   * @param input
   */
  public static void recursiveBubbleSort(int[] input,int n){
    if(n == 0){
      return;
    }
    for(int j = 0 ; j < n-1; j++){
      swap(input,j);
    }
    recursiveBubbleSort(input,n-1);
  }

  public static void iterativeBubbleSort(int[] input){
    int n = input.length;
    for(int i = 0 ; i < n ; i++){
      for(int j = 0; j < n - i - 1 ; j++){
        swap(input, j);
      }
    }
  }

  private static void swap(int[] input, int j) {
    if(input[j] > input[j+1]){
      int temp = input[j];
      input[j] = input[j+1];
      input[j+1] = temp;
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{5,4,3,2,1};
    iterativeBubbleSort(input);
    for(int i = 0; i < input.length ; i++){
      System.out.println(input[i]);
    }
    iterativeBubbleSort(input);
    System.out.println("#####");
    for(int i = 0; i < input.length ; i++){
      System.out.println(input[i]);
    }
    System.out.println("recursive");
    input = new int[]{5,4,3,2,1,0,-1,-2,11,5};
    recursiveBubbleSort(input,input.length);
    for(int i = 0; i < input.length ; i++){
      System.out.println(input[i]);
    }
    recursiveBubbleSort(input,input.length);
    System.out.println("#####");
    for(int i = 0; i < input.length ; i++){
      System.out.println(input[i]);
    }
  }

}
