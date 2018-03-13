package com.sunny.grokkingalgorithms.ctci.c1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 3/13/2018.
 */
class Holder2D{
   public int i;
   public int j;
}
public class SetRowAndColumnToZero {

  /*
  if an element in an MXN matrix is zeror, the entire row and column is set to 0.
   */

  /**
   *
   * @param matrix
   * @return
   */
  public static int[][] setToZero(int[][] matrix){
    List<Holder2D> markPoints = new ArrayList<>();
    /*
    First paas to find mark points
     */
    for(int i = 0; i < matrix.length ; i++){
      for(int j  = 0; j < matrix[i].length ; j++){
        if(matrix[i][j] == 0){
          Holder2D holder2D = new Holder2D();
          holder2D.i = i;
          holder2D.j = j;
          markPoints.add(holder2D);
        }
      }
    }
    /*
    Second passs to change all rows and columsn corresponding to markpoints to zero
     */
    for(Holder2D holder2D : markPoints){
      int i = holder2D.i;
      int j = holder2D.j;
      paintWithZeros(matrix,i,j);
    }
    return matrix;
  }

  public static void paintWithZeros(int[][] matrix,int i,int j){
    /*
    Paint row and co,un
     */
    for(int index = 0; index < matrix[i].length ; index++){
      matrix[i][index] = 0;
    }
    /*
    Paint column
     */
    for(int index = 0;index < matrix.length ; index++){
      matrix[index][j] = 0;
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1,2,3},
        {4,0,6},
        {7,8,9}
    };
    MatrixRotation.printMatrix(matrix);
    int[][] modified = setToZero(matrix);
    MatrixRotation.printMatrix(modified);
    System.out.println("Next");
    matrix = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,0}
    };
    MatrixRotation.printMatrix(matrix);
    modified = setToZero(matrix);
    MatrixRotation.printMatrix(modified);
  }

}
