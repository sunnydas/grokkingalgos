package com.sunny.grokkingalgorithms.ctci.c9plusdp;

/**
 * Created by sundas on 3/23/2018.
 */
public class RobotTraversal {

  /*
  A robot can move down or right , find number of ways it can reacha  point (x,y) fro (0,0)
   */

  /**
   *
   * @param matrix
   * @param x
   * @param y
   * @return
   */
  public static int countWaysToReachXY(int[][] matrix,int x,int y){
    int count = 0;
    count = countWaysRecursive(matrix,x,y,0,0);
    return count;
  }

  public static int countWaysRecursive(int[][] matrix,int x,int y,int i,int j){
    if(i >= matrix.length){
      return 0;
    }
    else if(j >= matrix[i].length){
      return 0;
    }
    if(i == x && j == y){
      return 1;
    }
    int count = 0;
    /*
    Go right
     */
    if(i < matrix.length && j+1 < matrix[i].length){
       count = countWaysRecursive(matrix,x,y,i,j+1);
    }
    /*
    Go down
     */
    if(i+1 < matrix.length && j < matrix[i].length){
      count += countWaysRecursive(matrix,x,y,i+1,j);
    }
    return count;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] robotPath = new int[][]{
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    System.out.println(countWaysToReachXY(robotPath,2,3));
  }
}
