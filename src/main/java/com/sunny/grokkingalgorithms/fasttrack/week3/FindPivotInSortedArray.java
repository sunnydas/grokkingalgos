package com.sunny.grokkingalgorithms.fasttrack.week3;

/**
 * Created by sundas on 7/6/2018.
 */
public class FindPivotInSortedArray {

  /*
  Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 3
Output : Found at index 8

Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
         key = 30
Output : Not found

Input : arr[] = {30, 40, 50, 10, 20}
        key = 10
Output : Found at index 3
   */

  /**
   *
   * @param input
   * @return
   */
  public static int findPivot(int[] input,int start,int end){
    if(start > end){
      return -1;
    }
    int mid = start + (end - start)/2;
    int pivot = -1;
    if((mid - 1 >= 0 && input[mid] < input[mid - 1])
        || (mid + 1 < input.length && input[mid+1] < input[mid])){
      return mid;
    }
    if(mid - 1 >= 0 && input[mid] > input[mid - 1]){
      pivot = findPivot(input,start,mid - 1);
    }
    if(pivot < 0 && mid + 1 < input.length && input[mid] < input[mid + 1]){
      pivot = findPivot(input,mid + 1,end);
    }
    return pivot;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = {5, 6, 7, 8, 9, 10, 1, 2, 3};
    System.out.println(findPivot(input,0,input.length - 1));
    input = new int[]{5, 6, 7, 8, 9, 10, 1, 2, 3};
    System.out.println(findPivot(input,0,input.length - 1));
    input = new int[]{30, 40, 50, 10, 20};
    System.out.println(findPivot(input,0,input.length - 1));
    input = new int[]{10,11,12,3,4,5};
    System.out.println(findPivot(input,0,input.length - 1));
  }

}
