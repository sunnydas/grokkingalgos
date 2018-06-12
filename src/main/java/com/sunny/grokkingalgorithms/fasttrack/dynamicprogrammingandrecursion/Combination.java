package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class Combination {

  /*
  C(n,m) = C(n-1,m) + C(n-1,m-1)
   */

  /**
   *
   * @param n
   * @param m
   * @return
   */
  public static long combination(int n,int m){
    if(n == 0 || m == 0 || n == m){
      return 1;
    }
    return combination(n-1,m) + combination(n-1,m-1);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(combination(5,4));
  }


}
