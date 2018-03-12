package com.sunny.grokkingalgorithms.ctci.c1;

/**
 * Created by sundas on 3/12/2018.
 */
public class MatrixRotation {

  /*
  Rotate a matrix by 90 degrees clockwise

       1 2 3
       4 5 6
       7 8 9
        becomes
        7  4  1
        8  5  2
        9  6  3
   */

  /**
   *
   * @param input
   * @return
   */
  public static int[][] rotateBy90(int[][] input){
    //We will be copying the rotated elements in this array
    int[][] rotated = new int[input.length][input.length];
    /*
    If we look properly, we will see that 90 degrees rotation clockwise means
    all the rows become columns and the columsn become vice versa
    1st row becomes last column
    second row becomes second columns
    and 3rd row becomes 1st column
     */
    int columnIndex = rotated[0].length - 1;
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++ ){
        rotated[j][columnIndex] = input[i][j];
      }
      columnIndex--;
    }
    return rotated;
  }


  public static void printMatrix(int[][] input){
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++){
        System.out.print(input[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] matrix = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    printMatrix(matrix);
    int[][] rotated = rotateBy90(matrix);
    System.out.println("After rotation ....");
    if(rotated != null){
      printMatrix(rotated);
    }
    System.out.println("next");
    matrix = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}
    };
    printMatrix(matrix);
    rotated = rotateBy90(matrix);
    System.out.println("After rotation ....");
    if(rotated != null){
      printMatrix(rotated);
    }
  }


}
