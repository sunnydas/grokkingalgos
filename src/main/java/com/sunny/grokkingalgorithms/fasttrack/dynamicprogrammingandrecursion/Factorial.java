package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class Factorial {

  /**
   *
   * @param n
   * @return
   */
  public static long factorialIterative(int n){
    if(n <= 1){
      return 1;
    }
    int fact = 1;
    int index = 2;
    while(index <= n){
      fact *= index;
      index++;
    }
    return fact;
  }

  /**
   *
   * @param n
   * @return
   */
  public static int factorial(int n){
    if(n <= 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    return n*factorial(n-1);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(factorial(1));
    System.out.println(factorial(2));
    System.out.println(factorial(3));
    System.out.println(factorial(4));
    System.out.println(factorial(5));
    System.out.println(factorial(10));
    System.out.println("################");
    System.out.println(factorialIterative(1));
    System.out.println(factorialIterative(2));
    System.out.println(factorialIterative(3));
    System.out.println(factorialIterative(4));
    System.out.println(factorialIterative(5));
    System.out.println(factorialIterative(10));
  }

}
