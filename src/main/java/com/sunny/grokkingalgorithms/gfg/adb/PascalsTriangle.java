package com.sunny.grokkingalgorithms.gfg.adb;

/**
 * Created by sundas on 5/26/2018.
 */
public class PascalsTriangle {

  /*
   Pascal’s Triangle
Pascal’s triangle is a triangular array of the binomial coefficients.
Write a function that takes an integer value n as input and prints first n lines of the Pascal’s triangle. Following are the first 6 rows of Pascal’s Triangle.

1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
    */

  /**
   *
   * @param n
   */
  public static void pascalsTriangle(int n){
    int[][] matrix = new int[n][n];
    for(int i = 0 ; i < n; i++){
      matrix[i] = new  int[n];
    }
    matrix[0][0] = 1;
    System.out.println(matrix[0][0]);
    for(int i = 1 ; i < n; i++){
      for(int j = 0 ; j < n ; j++){
        matrix[i][j] = matrix[i-1][j];
        if(j-1 >= 0){
          matrix[i][j] += matrix[i-1][j-1];
        }
        if(matrix[i][j] > 0) {
          System.out.print(matrix[i][j] + " ");
        }
      }
      System.out.println();
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    pascalsTriangle(6);
  }
}
