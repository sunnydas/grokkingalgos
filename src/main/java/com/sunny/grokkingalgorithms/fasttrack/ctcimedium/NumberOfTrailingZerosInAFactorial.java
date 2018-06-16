package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

/**
 * Created by sundas on 6/16/2018.
 */
public class NumberOfTrailingZerosInAFactorial {

  /*
  Number of trailing zeros in n factorial
   */

  /**
   *
   * @param n
   * @return
   */
  public static int numTrailingZerosInNFactorial(int n){
    int trailingZeros = 0;
    for(int i = 2 ; i < n ; i++){
      int cur = i;
      while(cur % 5 == 0){
        trailingZeros++;
        cur = cur/5;
      }
    }
    return trailingZeros;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(numTrailingZerosInNFactorial(5));
    System.out.println(numTrailingZerosInNFactorial(6));
    System.out.println(numTrailingZerosInNFactorial(7));
    System.out.println(numTrailingZerosInNFactorial(15));
    System.out.println(numTrailingZerosInNFactorial(20));
  }
}
