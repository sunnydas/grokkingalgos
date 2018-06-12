package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sundas on 6/12/2018.
 */
public class FibonacciNumbers {

   /*
   Fibonacci series
    */

  static Map<Integer,Long> memoizationCache = new HashMap<>();

  public static long fibonacciIterative(int n){
    if(n <= 0 || n == 1){
      return 1;
    }
    long a = 1;
    long b = 1;
    long c = 0;
    int index = 2;
    while(index <= n){
      c = a + b;
      a = b;
      b = c;
      index++;
    }
    return c;
  }

  public static long fibonacciUsingMemoization(int n){
    if(n == 1 || n <= 0){
      memoizationCache.put(1,1L);
      memoizationCache.put(0,1L);
      return 1;
    }
    if(memoizationCache.containsKey(n)){
      return memoizationCache.get(n);
    }
    long fibN = fibonacciUsingMemoization(n - 1) + fibonacciUsingMemoization(n - 2);
    memoizationCache.put(n,fibN);
    return fibN;
  }

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
    long begin = System.currentTimeMillis();
    System.out.println(fibonacci(50));
    System.out.println("time taken = " + (System.currentTimeMillis() - begin));
    System.out.println(fibonacciUsingMemoization(5));
    System.out.println(fibonacciUsingMemoization(6));
    System.out.println(fibonacciUsingMemoization(7));
    begin = System.currentTimeMillis();
    System.out.println(fibonacciUsingMemoization(50));
    System.out.println("time taken = " + (System.currentTimeMillis() - begin));
    System.out.println(fibonacciIterative(5));
    System.out.println(fibonacciIterative(6));
    System.out.println(fibonacciIterative(7));
    System.out.println(fibonacciIterative(50));
  }

}
