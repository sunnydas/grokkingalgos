package com.sunny.grokkingalgorithms.princeton.courses.part1;

/**
 * Created by sundas on 2/12/2018.
 */
public class BinarySearch {


  /**
   *
   * @param input
   * @return
   */
  public static int findUsingBinarySearch(int[] input,int key){
    int foundIndex = -1;
    int startIndex = 0;
    int endIndex = input.length - 1;
    while(startIndex <= endIndex){
      int mid = startIndex + (endIndex - startIndex)/2;
      if(input[mid] == key){
        foundIndex = mid;
        break;
      }
      if(input[mid] > key){
        endIndex = mid - 1;
      }
      else if(input[mid] < key){
        startIndex = mid + 1;
      }
    }
    return foundIndex;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5};
    System.out.println(findUsingBinarySearch(input,4));
    System.out.println(findUsingBinarySearch(input,2));
    System.out.println(findUsingBinarySearch(input,10));
    System.out.println(findUsingBinarySearch(input,-10));
    System.out.println(findUsingBinarySearch(input,0));
    System.out.println(findUsingBinarySearch(input,1));
    System.out.println(findUsingBinarySearch(input,5));
  }
}
