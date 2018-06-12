package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class PascalsTriangle {

  /*
  Print Pascal's triangle
 1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5
   */

  /**
   *
   * @param n
   */
  public static void printPascalsTriangl(int n){
    int[][] pascalTriangle = new int[n][n];
    /*
    Initialization
     */
    for(int i= 0; i < pascalTriangle.length ; i++){
      pascalTriangle[i] = new int[pascalTriangle.length];
    }
    pascalTriangle[0][0] = 1;
    for(int i = 1; i < pascalTriangle.length ; i++){
      for(int j = 0 ; j < pascalTriangle[i].length ; j++){
        /*
        current cell value = previour row[curCol] + previousrow[curCol -1]
         */
        pascalTriangle[i][j] = pascalTriangle[i-1][j];
        if(j-1 >= 0){
          pascalTriangle[i][j] += pascalTriangle[i-1][j-1];
        }
      }
    }
    /*
    Print
     */
    for(int i = 0 ; i < pascalTriangle.length ; i++){
      for(int j = 0 ; j < pascalTriangle[i].length ; j++){
        if(pascalTriangle[i][j] > 0) {
          System.out.print(pascalTriangle[i][j] + " ");
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
    printPascalsTriangl(6);
  }

}
