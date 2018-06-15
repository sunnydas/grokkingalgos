package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

/**
 * Created by sundas on 6/16/2018.
 */
public class SwapTwoVariablesWithoutTemp {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int a = 5;
    int b = 6;
    System.out.println(a);
    System.out.println(b);
    a += b;
    b = a - b;
    a -= b;
    System.out.println("swap");
    System.out.println(a);
    System.out.println(b);
    a = 9;
    b = 4;
    System.out.println(a);
    System.out.println(b);
    a += b;
    b = a - b;
    a -= b;
    System.out.println("swap");
    System.out.println(a);
    System.out.println(b);
    System.out.println("xor");
    a = 5;
    b = 6;
    System.out.println(a);
    System.out.println(b);
    a = a^b;
    b = a^b;
    a = a^b;
    System.out.println("swap");
    System.out.println(a);
    System.out.println(b);
  }

}
