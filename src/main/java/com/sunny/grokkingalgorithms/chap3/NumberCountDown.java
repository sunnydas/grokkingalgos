package com.sunny.grokkingalgorithms.chap3;

import java.util.Scanner;

/**
 * Created by sundas on 1/3/2017.
 */
public class NumberCountDown {

  /**
   *
   * @param n
   * @return
   */
  public static int printCountdown(int n){
    System.out.println(n);
    if(n == 0){
      return 0;
    }
    else{
      return printCountdown(--n);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    printCountdown(n);
  }
}
