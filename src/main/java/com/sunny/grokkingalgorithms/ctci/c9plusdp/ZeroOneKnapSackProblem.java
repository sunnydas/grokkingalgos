package com.sunny.grokkingalgorithms.ctci.c9plusdp;

/**
 * Created by sundas on 3/27/2018.
 */
public class ZeroOneKnapSackProblem {

  /*
  0/1 Knapsack problem using dynamic programming

  weight[] = 1 3 4 5
  values[] = 1 4 5 7

  weight should not exceed 7
   */

  /**
   *
   * @param weights
   * @param values
   * @param capacity
   * @return
   */
  public static int knapSack(int[] weights,int[] values,int capacity){
    int max = Integer.MIN_VALUE;
    int[][] itemMatrix = new int[values.length][capacity+1];
    //boolean[][] pathMatrix = new boolean[values.length][capacity+1];
    for(int i = 0 ; i < itemMatrix.length ; i++){
      for(int j = 1 ; j < itemMatrix[i].length ; j++){
        if((i-1) < 0){
          itemMatrix[i][j] = values[i];
        }
        else if(weights[i] > j){
          itemMatrix[i][j] = itemMatrix[i-1][j];
        }
        else{
          int includeValue = values[i];
          if(j - weights[i] >= 0){
            includeValue += itemMatrix[i-1][j - weights[i]];
          }
          itemMatrix[i][j] = Math.max(includeValue,itemMatrix[i-1][j]);
        }
      }
    }
    print2DMatrix(itemMatrix);
    max = itemMatrix[values.length - 1][capacity];
    //printPath(pathMatrix,weights,capacity);
    /*max = itemMatrix[values.length - 1][capacity];
    int i = itemMatrix.length - 1;
    int j = itemMatrix[i].length - 1;
    System.out.println("Path:");
    int runCapacity = capacity;
    while(i >= 0 && j >=0){
      if(i-1 < 0){
        System.out.println("item = " + i + " weight = " + weights[i] + " values = " + values[i]);
        i = i - 1;
      }
      else if(itemMatrix[i][j] != itemMatrix[i-1][j]){
        System.out.println(" item = " + i + " weight = " + weights[i] + " value " + values[i]);
        j = runCapacity - weights[i];
        runCapacity = runCapacity - weights[i];
        i = i - 1;
        //System.out.println(j);
      }
      else{
        i = i - 1;
      }
    }*/
    return max;
  }



  public static void print2DMatrix(int[][] input){
    for(int i = 0; i < input.length ; i++){
      for(int j = 0 ; j < input[i].length ; j++){
        System.out.print(input[i][j] + " ");
      }
      System.out.println();
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] weights = {1,3,4,5};
    int[] values = {1,4,5,7};
    int capacity = 7;
    int max = knapSack(weights,values,capacity);
    System.out.println(" max " + max);
    //System.out.println(getItemsInOptimalSolution());
  }



}
