package com.sunny.grokkingalgorithms.java.concurrency_2018;

/**
 * Created by sundas on 2/18/2018.
 */
public class MatrixMultiplicationSequential {


  /*
  https://www.mathsisfun.com/algebra/matrix-multiplying.html
   */


  /**
   * Multiply two matrices sequential implementation
   *
   *
   * @param a
   * @param b
   * @return
   */
  public static int[][] multiply(int[][] a,int[][] b){
    int[][] product = new int[a.length][b[0].length];
    // a's indexes
    int i = 0;
    int j = 0;
    // b's indexes
    int k = 0;
    // product's indexes
    int m = 0;
    // For every row of a
    while(i < a.length){
      int mulCount = 0;
      int n = 0;
      int l = 0;
      // for every column in b dot product
      while(mulCount < b[0].length) {
        // this is anew calculation
        int sum = 0;
        // dot product of a's row and b's columns values
        while (j < a[0].length && k < b.length) {
          sum += a[i][j] * b[k][l];
          j++;
          k++;
        }
        product[m][n] = sum;
        n++;
        j = 0;
        k = 0;
        mulCount++;
        l++;
      }
      m++;
      i++;
    }
    return product;
  }

  public static void print2DMatrix(int[][] input){
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++){
        System.out.print(input[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
    System.out.println();
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] a = new int[][]{
        {1,2,3},
        {4,5,6}
    };
    print2DMatrix(a);
    int[][] b = new int[][]{
        {7,8},
        {9,10},
        {11,12}
    };
    print2DMatrix(b);
    int[][] product = multiply(a,b);
    print2DMatrix(product);
  }

}
