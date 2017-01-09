package com.sunny.grokkingalgorithms.chap1;

import java.util.Scanner;

/**
 * Created by sundas on 12/29/2016.
 */
public class BinarySearch {

  /**
   *
   * @param input
   * @param key
   * @return
   */
  public static int binarySearch(int[] input,int key){
    int foundIndex = -1;
    int begin = 0;
    int end = input.length - 1;
    int mid = (end + begin)/2;
    while(begin <= end){
      if(input[mid] == key){
        foundIndex = mid;
        break;
      }
      else if(input[mid] > key){
        end = mid;
      }
      else{
        begin = mid + 1;
      }
      /*mid = (end + begin)/2;
      System.out.println(mid);
      System.out.println(begin);
      System.out.println(end);
      System.out.println("--------------------------");*/
    }
    if(foundIndex < 0 && input[mid] == key){
      foundIndex = mid;
    }
    return foundIndex;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int input[] = new int[n];
    for(int i = 0 ; i < input.length ; i++){
      input[i] = scanner.nextInt();
    }
    int k = scanner.nextInt();
    System.out.println(binarySearch(input,k));
  }

}
