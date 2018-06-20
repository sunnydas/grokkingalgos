package com.sunny.grokkingalgorithms.fasttrack.week1;

/**
 * Created by sundas on 6/20/2018.
 */
public class SumOfUpperPyramindInAMatrix {
  /*
  Find sum of upper pyramid ina  matrix
   */

  /**
   *
   * @param matrix
   * @return
   */
  public static int findSUmOfUpperPyramid(int[][] matrix){
    int sum = 0;
    for(int i = 0 ; i < matrix.length ; i++){
      for(int j = 0 ; j < matrix[i].length ; j++){
        if(i >= j){
          sum += matrix[i][j];
        }
      }
    }
    return sum;
  }

  public static int findSUmOfUpperPyramidAlternate(int[][] matrix){
    int sum = 0;
    for(int i = 0 ; i < matrix.length ; i++){
      for(int j = i ; j < matrix[i].length ; j++){
        //if(i >= j){
        sum += matrix[i][j];
        //}
      }
    }
    return sum;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {8,7,6,5},
        {4,3,2,1}
    };
    /*
    answer should be 43
     */
    System.out.println(findSUmOfUpperPyramid(matrix));
    System.out.println(findSUmOfUpperPyramidAlternate(matrix));
  }

}
