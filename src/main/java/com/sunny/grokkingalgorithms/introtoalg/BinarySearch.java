package com.sunny.grokkingalgorithms.introtoalg;

/**
 * Created by sundas on 6/3/2017.
 */
public class BinarySearch {


  /**
   *
   * @param input
   * @param start
   * @param end
   * @return
   */
  public static int binarySearchRecursive(int[] input,int start,int end,int needle){
    if(start > end){
      return -1;
    }
    int mid = (start + end)/2;
    //Found needle in haystack
    if(needle == input[mid]){
      return mid;
    }
    if(needle > input[mid]){
      // search right recursively
      return binarySearchRecursive(input,mid+1,end,needle);
    }
    else{
      //search left recursively
      return binarySearchRecursive(input,start,mid - 1,needle);
    }
  }

  /**
   *
   * @param input
   * @param needle
   * @return
   */
  public static int binarySearch(int[] input,int needle){
    if(input != null){
      int start = 0;
      int end = input.length - 1;
      while(start <= end){
        int mid = (start + end)/2;
        //Found
        if(input[mid] == needle){
          return mid;
        }
        // Go right
        if(needle > input[mid]){
          start = mid + 1;
        }
        //Go left
        else{
          end = mid - 1;
        }
      }
    }
    return -1;
  }



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = {1,3,4,17,17,25,45,46,100};
    System.out.println(binarySearch(input,900));
    System.out.println(binarySearch(input,46));
    System.out.println(binarySearchRecursive(input, 0, input.length - 1, 46));
    System.out.println(binarySearchRecursive(input, 0, input.length - 1, 900));
  }

}
