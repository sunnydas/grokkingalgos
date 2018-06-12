package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class FibonacciNumbers {

   /*
   Fibonacci series
    */

  /**
   *
   * @param n
   */
  public static int fibonacci(int n){
    if(n <= 0 || n == 1){
      return 1;
    }
    int fibonacci = fibonacci(n-1) + fibonacci(n-2);
    return fibonacci;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(fibonacci(5));
    System.out.println(fibonacci(6));
    System.out.println(fibonacci(7));
  }

}
