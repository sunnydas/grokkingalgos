package com.sunny.grokkingalgorithms.fasttrack.week8;

import java.util.Arrays;

/**
 * Created by sundas on 7/31/2018.
 */
public class ReverseString {

  /**
   *
   * @param input
   * @return
   */
  public static char[] reverse(char[] input){
    int i = 0;
    int j = input.length - 1;
    while(i < j){
      char temp = input[j];
      input[j] = input[i];
      input[i] = temp;
      i++;
      j--;
    }
    return input;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    char[] input = new char[]{'a','b','c','d'};
    System.out.println(Arrays.toString(reverse(input)));
  }

}
