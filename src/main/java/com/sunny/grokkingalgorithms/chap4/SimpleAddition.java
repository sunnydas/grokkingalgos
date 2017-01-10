package com.sunny.grokkingalgorithms.chap4;

import java.util.Scanner;

/**
 * Created by sundas on 1/10/2017.
 */
public class SimpleAddition {

  /**
   *
   * @param input
   * @return
   */
  public static int calculateSum(int[] input,int start,int end){
    int sum = 0;
    if(start == end){
      sum = input[start];
    }
    else{
      int mid = (end + start)/2;
      sum += calculateSum(input,start,mid);
      sum += calculateSum(input,mid+1,end);
    }
    return sum;
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
    System.out.println(calculateSum(input,0,input.length - 1));
  }
}
