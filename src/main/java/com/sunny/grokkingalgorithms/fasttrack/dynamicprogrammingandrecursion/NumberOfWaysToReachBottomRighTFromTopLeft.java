package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class NumberOfWaysToReachBottomRighTFromTopLeft {

  /*
  Count number of ways to reach bottom right from top left, if you are allowed to move
  only right or down.
   */

  public static int countNumberOfWaysDP(int m,int n){
    int[][] dp = new int[m][n];
    for(int j = 1; j < dp[0].length ; j++){
      dp[0][j] = 1;// there is only way to reach this cell
    }
    for(int i = 1; i < dp.length ; i++){
      dp[i][0] = 1;// there is only way to reach this cell
    }
    for(int i = 1; i < dp.length ; i++){
      for(int j = 1; j < dp[i].length ; j++){
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }
    for(int i = 0 ; i < dp.length ; i++){
      for(int j = 0 ; j < dp[i].length ; j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return dp[m-1][n-1];
  }

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
    System.out.println("######################");
    System.out.println(countNumberOfWaysDP(2,2));
    System.out.println(countNumberOfWaysDP(3,4));
  }

}
