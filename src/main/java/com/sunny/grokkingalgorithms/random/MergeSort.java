package com.sunny.grokkingalgorithms.random;

/**
 * Created by sundas on 4/24/2018.
 */
public class MergeSort {


  /**
   *
   * @param input
   * @return
   */
  public static int[] mergeSort(int[] input){
    input = performMergeSort(0, input.length - 1, input);
    return input;
  }

  /**
   *
   * @param start
   * @param end
   * @param input
   * @return
   */
  public static int[] performMergeSort(int start,int end,int[] input){
    if(start >= end){
      return input;
    }
    int mid = start + (end - start)/2;
    performMergeSort(start,mid,input);
    performMergeSort(mid + 1, end, input);
    input = merge(input,start,mid,mid+1,end);
    return input;
  }

  /**
   *
   * @param
   * @return
   */
  public static int[] merge(int[]  input,int start1,int end1,int start2,int end2){
    int[] merged = new int[(end1 - start1) + (end2 - start2) + 2];
    int i = start1;
    int j = start2;
    int mergedIndex = 0;
    while(i <= end1 && j <= end2){
      if(input[i] > input[j]){
        merged[mergedIndex] = input[j];
        j++;
      }
      else if(input[i] < input[j]){
        merged[mergedIndex] = input[i];
        i++;
      }
      mergedIndex++;
    }
    while(i <= end1){
      merged[mergedIndex] = input[i];
      mergedIndex++;
      i++;
    }
    while(j <= end2){
      merged[mergedIndex] = input[j];
      mergedIndex++;
      j++;
    }
    mergedIndex = 0;
    for(int index = start1 ; index <= end1 ; index++){
      input[index] = merged[mergedIndex];
      mergedIndex++;
    }
    for(int index = start2 ; index <= end2 ; index++){
      input[index] = merged[mergedIndex];
      mergedIndex++;
    }
    return merged;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{5,4,3,2,1,-1,100,10,-100,0};
    input = mergeSort(input);
    for(int i = 0 ; i < input.length ; i++){
      System.out.println(input[i]);
    }
  }

}
