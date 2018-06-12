package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class BinarySearch {

  /*
  Implement binary search using recursion
   */

  /**
   *
   * @param input
   * @param start
   * @param end
   * @return
   */
  public static int binarySearch(int[] input,
                                 int start,int end,int key){
    if(start > end){
      return -1;
    }
    int mid = start + (end - start)/2;
    if(input[mid] == key){
      return mid;
    }
    else if(input[mid] < key){
      return binarySearch(input,mid+1,end,key);
    }
    else{
      return binarySearch(input,start,mid-1,key);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{-10,-2,0,1,2,4,5,10,98};
    System.out.println(binarySearch(input,0,input.length-1,5));
    System.out.println(binarySearch(input,0,input.length-1,-10));
    System.out.println(binarySearch(input,0,input.length-1,98));
    System.out.println(binarySearch(input,0,input.length-1,1000));
    System.out.println(binarySearch(input,0,input.length-1,1));
  }

}
