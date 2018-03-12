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


  /**
   *
   * @param matrix
   * @return
   */
  public static int[][] rotateBy90InPlace(int[][] matrix){
    int length = matrix.length - 1;
    /*
    In place rotation works for square matrix
     */
    /*
    1 2 3
    4 5 6
    7 8 9
    layer 1
    1,3 ,9 and 7 are the important co ordinates
    7 2 1
    4 5 6
    9 8 3
    step 2 for layer 1
    7 4 1
    8 5 2
    9 6 3
    layer 1 has heen rotated
    layer 2 is just 5 and there is no need for rotation
     */
    /*
    Outer loop represents layer so in each later two rows are considered
     */
    for(int i = 0 ; i <= (length/2) ; i++){
      /*
      We do not eed to worry about previous layer since it is already rotaed
       */
      /*
      For each cell in layer
       */
      for(int j = i; j < (length - i) ; j++){
        /*
        1 2
        3 4
        i=0, j = 0
        p1 = 1
        p2 = 2 (0,length - 1)
        p3 = 4
        p4 = 3
         */
        int p1 = matrix[i][j];
        int p2 = matrix[j][length - i];
        int p3 = matrix[length - i][length - j];
        int p4 = matrix[length- j][i];
        //Swap
        matrix[i][j] = p4;
        matrix[j][length] = p1;
        matrix[length - i][length - j] = p2;
        matrix[length - j][i] = p3;
      }
    }
    return matrix;
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
    System.out.println("In place");
    matrix = new int[][]{
        {1,2,3},
        {4,5,6},
        {7,8,9}
    };
    printMatrix(matrix);
    rotated = rotateBy90InPlace(matrix);
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
    rotated = rotateBy90InPlace(matrix);
    System.out.println("After rotation ....");
    if(rotated != null){
      printMatrix(rotated);
    }
  }


}
