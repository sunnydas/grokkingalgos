package com.sunny.grokkingalgorithms.chap4;

import java.util.Scanner;

/**
 * Created by sundas on 1/10/2017.
 */
public class BinarySearch {

  /**
   *
   * @param input
   * @param start
   * @param end
   * @return
   */
  public static int binarySearch(int[] input,int start,int end,int key){
    int found = -1;
    if(start == end){
      if(input[start] == key){
        found = start;
      }
    }
    else{
      int mid = (end + start)/2;
      if(key <= input[mid]){
        found = binarySearch(input,start,mid,key);
      }
      else{
        found = binarySearch(input,mid+1,end,key);
      }
    }
    return found;
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
    int k = scanner.nextInt();
    System.out.println(binarySearch(input, 0, input.length - 1,k));

  }
}
