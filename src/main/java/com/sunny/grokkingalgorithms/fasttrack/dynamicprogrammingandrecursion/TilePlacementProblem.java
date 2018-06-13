package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class TilePlacementProblem {

  /*
  Given an empty plot of size 2xN , we have tiles of size 2x1.
  We want to place tiles such that entire plot is covered. Tiles can be placed
  horizontally or vertically. Write a function that returns the total number
  of ways the plot can be covered without breaking any tiles.
   */

  /**
   *
   * @param n
   * @return
   */
  public static int countWays(int n){
    if(n == 1){
      return 1;
    }
    if(n == 2){
      return 2;
    }
    if(n == 0){
      return 0;
    }
    return countWays(n-1) + countWays(n-2);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(countWays(5));
  }

}
