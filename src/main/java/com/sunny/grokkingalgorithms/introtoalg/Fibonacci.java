package com.sunny.grokkingalgorithms.introtoalg;

/**
 * Created by sundas on 6/3/2017.
 */
public class Fibonacci {


  public static long fibonacciIterative(int n){
    long nMinus2 = 1;
    long nMinus1 = 1;
    long fib = 1;
    int index = 2;
    while(index <= n){
      fib = nMinus1 + nMinus2;
      nMinus2 = nMinus1;
      nMinus1 = fib;
      index++;
    }
    return fib;
  }

  public static long fibonaccirecursive(int n){
    if(n <= 1){
      //System.out.println(1);
      return 1;
    }
    return fibonaccirecursive(n-1) + fibonaccirecursive(n-2);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(fibonaccirecursive(8));
    System.out.println(fibonacciIterative(80));
  }
}
