package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class NumberOfWaysToReachBottomRighTFromTopLeft {

  /*
  Count number of ways to reach bottom right from top left, if you are allowed to move
  only right or down.
   */

  /**
   *
   * @param m
   * @param n
   * @return
   */
  public static int countNumberOfWays(int m,int n){
    if(m == 1 && n == 1){
      return 1;
    }
    if(m <= 0 || n <= 0){
      return 0;
    }
    return countNumberOfWays(m-1,n) + countNumberOfWays(m,n-1);
  }
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(countNumberOfWays(2,2));
    System.out.println(countNumberOfWays(3,4));
  }

}
