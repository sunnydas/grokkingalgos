package com.sunny.grokkingalgorithms.chap4;

import java.util.Scanner;

/**
 * Created by sundas on 1/10/2017.
 */
public class FindMaximum {

  /**
   *
   * @param input
   * @param start
   * @param end
   * @return
   */
   public static int findMax(int[] input,int start,int end){
     int curMax = Integer.MIN_VALUE;
     if(start == end){
       curMax = input[start];
     }
     else{
       int mid = (end + start)/2;
       int tempMax = findMax(input,start,mid);
       if(tempMax > curMax){
         curMax = tempMax;
       }
       tempMax = findMax(input,mid+1,end);
       if(tempMax > curMax){
         curMax = tempMax;
       }
     }
     return curMax;
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
    System.out.println(findMax(input, 0, input.length - 1));
  }
}
