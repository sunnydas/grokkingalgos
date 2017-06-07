package com.sunny.grokkingalgorithms.introtoalg;

import java.util.List;

/**
 * Created by sundas on 6/6/2017.
 */
public class ZeroOneKnapSackProblem {

   //http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/

  /**
   *
   * @param weights
   * @param values
   */
  public static void findMaxValue(int[] weights,int[] values,int capacity){
    int[][] knapSackMatrix = new int[weights.length + 1][capacity + 1];
    boolean[][] pathFinder = new boolean[weights.length + 1][capacity + 1];
    /*
    The idea is that we build a 2d matrix with a table like:
     0 1 2 3 4--- capacity
     1
     2
     3
     items
     we populate this matrix and then calculate max path bottom up.
     */
    //Initialize matrices
    for(int i = 0; i < weights.length ; i++){
      knapSackMatrix[i] = new int[capacity+1];
    }
    for(int i = 0; i < weights.length ; i++){
      pathFinder[i] = new boolean[capacity+1];
    }
    //populate the matrix
    // We donot need to worry abbout first row and first column
    // since the max vaklue that can be obtained from having a knapsack
    // with zero capcity is zero and max value obtained from considering none
    // of the items is also zero.
    for(int i = 1; i < knapSackMatrix.length ; i++){
      for(int j = 1; j < knapSackMatrix[i].length ; j++){
         /*
         So what is the maximum value that can e obtained for cell i,j ?
         It is max of one of the things:
         a.) value of i-1th row and jth column , this maps to max value obtained
         for previous item and not considering this item.
         b.) if weight fits and value obtained for current item + Item in (current capacity - current weight)
          */
        boolean included = false;
        // value for a.)
        int valueA = knapSackMatrix[i-1][j];
        int valueB = Integer.MIN_VALUE;
        // Constraint , the item must fit in the knapsack
        if(weights[i-1] <= j){
          // This essentially means , consider the current value and the max value of previous tem
          // which fits in the matrix.
          // this works because for every previous cell , the maximum value has already been considered. I
          // think this is the most non intuitive part of this solution.
          valueB = values[i-1] + knapSackMatrix[i-1][j - weights[i-1]];
        }
        //This is to consider the path where items are included or not.
        if(valueA <= valueB){
          included = true;
        }
        knapSackMatrix[i][j] = Math.max(valueA,valueB);
        pathFinder[i][j] = included;
      }
    }
    printMatrix(knapSackMatrix);
    System.out.println("------------------------------------------");
    printMatrixBoolean(pathFinder);
    System.out.println("------------------------------------------");
    // Find the items that contribute to the maximum value
    // start bottom right and work bottum up
    int indexR = pathFinder.length - 1;
    int indexC = pathFinder[0].length - 1;
    /*
    The logic is such that if the item was included , then we need to got to the index where current item's weight is
    subtracted in previous row. Else we just move one row up
     */
    while(indexR >= 0 && indexC >= 0){
      if(pathFinder[indexR][indexC]){
        System.out.println(" item = " + indexR + " " + indexC);
        indexC = indexC - weights[indexR - 1];
      }
      indexR--;
    }
  }

  /**
   *
   * @param input
   */
  public static void printMatrix(int[][] input){
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++){
        System.out.print(input[i][j]);
        System.out.print("  ");
      }
      System.out.println();
    }
  }

  /**
   *
   * @param input
   */
  public static void printMatrixBoolean(boolean[][] input){
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++){
        System.out.print(input[i][j]);
        System.out.print("  ");
      }
      System.out.println();
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    Given a knapscak of fixed capacity C
    and given set of items with weights and values
    find items that can be fitted into the knapsack , choosing it 1 or 0 times. The goal is to maximimse the value.
     */
    int capacity = 4;
    int weights[] = new int[]{2,2,1};
    int values[] = new int[]{3,1,3};
    findMaxValue(weights,values,capacity);
  }

}
