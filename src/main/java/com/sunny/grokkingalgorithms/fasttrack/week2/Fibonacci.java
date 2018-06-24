package com.sunny.grokkingalgorithms.fasttrack.week2;

/**
 * Created by sundas on 6/24/2018.
 */
public class Fibonacci {

  /*
  Fibonacci using recursion
   */

  /**
   *
   * @param n
   * @return
   */
  public static long fibonacci(int n){
    if(n <=  1){
      return 1;
    }
    return fibonacci(n - 1) + fibonacci(n - 2);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    for(int i = 0 ; i < 20 ; i++){
      System.out.println(" fibonacci : " + fibonacci(i));
    }
  }

}
