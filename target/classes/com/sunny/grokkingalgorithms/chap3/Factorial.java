package com.sunny.grokkingalgorithms.chap3;

import java.util.Scanner;

/**
 * Created by sundas on 1/3/2017.
 */
public class Factorial {

  /**
   *
   * @param n
   * @return
   */
  public static long factorial(long n){
    if(n <= 1){
      return 1;
    }
    else{
     return n*factorial(--n);
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    long n = scanner.nextLong();
    System.out.println(factorial(n));
  }
}
