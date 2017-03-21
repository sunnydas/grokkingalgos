package com.sunny.grokkingalgorithms.gfg.amz;

import java.util.Scanner;

/**
 * Created by sundas on 3/21/2017.
 */
public class LargestRegionInBooleanMatrix {

  /*
  Problem : http://www.geeksforgeeks.org/find-length-largest-region-boolean-matrix/
   */

  /**
   * Attempt 1:
   * Remarks : Main thig is sto worrk about array index out of bounds exception
   *
   *
   * @param booleanMatrix
   * @return
   */
  public static int findLengthOfLargestRegion(int[][] booleanMatrix){
    int largestRegion = 0;
    int[][] traversalTracker = new int[booleanMatrix.length][booleanMatrix[0].length];
    for(int i = 0 ; i < booleanMatrix.length ; i++){
      for(int j = 0 ; j < booleanMatrix[i].length ; j++){
        if(booleanMatrix[i][j] == 1){
          int totalLengthOfRegion = calculateLength(i,j,booleanMatrix,traversalTracker);
          //System.out.println(totalLengthOfRegion);
          if(totalLengthOfRegion > largestRegion){
            largestRegion = totalLengthOfRegion;
          }
        }
      }
    }
    return largestRegion;
  }


  /**
   *
   * @param i
   * @param j
   * @param booleanMatrix
   * @param traversalMatrix
   * @return
   */
  public static int calculateLength(int i, int j,
                                    int[][] booleanMatrix,
                                    int[][] traversalMatrix){
    int length = 0;
    if( (i < 0) || (j < 0) || (i >= booleanMatrix.length) || (j >= booleanMatrix[i].length) ||
         (traversalMatrix[i][j] == 1) || (booleanMatrix[i][j] != 1)){
      return length;
    }
    else{
      length += 1;
      traversalMatrix[i][j] = 1;
      //Same row
      length += calculateLength(i,j+1,booleanMatrix,traversalMatrix);
      length += calculateLength(i,j-1,booleanMatrix,traversalMatrix);
      //previous row
      length += calculateLength(i-1,j,booleanMatrix,traversalMatrix);
      length += calculateLength(i-1,j-1,booleanMatrix,traversalMatrix);
      length += calculateLength(i-1,j+1,booleanMatrix,traversalMatrix);
      //Next row
      length += calculateLength(i+1,j,booleanMatrix,traversalMatrix);
      length += calculateLength(i+1,j+1,booleanMatrix,traversalMatrix);
      length += calculateLength(i+1,j-1,booleanMatrix,traversalMatrix);
    }
    return length;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int rows = scanner.nextInt();
    int columns = scanner.nextInt();
    int[][] matrix = new int[rows][columns];
    for(int i = 0 ; i < rows; i++){
      for(int j = 0 ; j < columns ; j++){
        matrix[i][j] = scanner.nextInt();
      }
    }
    scanner.close();
    //System.out.println(matrix.length);
    System.out.println(findLengthOfLargestRegion(matrix));
  }

}
