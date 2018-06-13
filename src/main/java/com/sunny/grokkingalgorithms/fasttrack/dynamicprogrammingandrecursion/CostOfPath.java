package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class CostOfPath {

  /*
  We are given a matrix where each cell denotes the cost at
  that cell. So the cost of reaching a cell j from cell i , is sum of all
  costs for a path from  i to j, we can move down or right. We have
  to find minimum cost from moving from top lect cell to bottom right cell.
   */

  static  int minCost = Integer.MAX_VALUE;

  /**
   *
   * @param costMatrix
   * @param i
   * @param j
   * @return
   */
  public static void findMinCost(int[][] costMatrix,
                                int i,
                                int j,
                                int curCost,
                                 String path){
    path += costMatrix[i][j] + "->";
    curCost += costMatrix[i][j];
    /*
    Found bottom node rebound technique
     */
    if(i == costMatrix.length - 1
        && j == costMatrix[i].length - 1){
      /*
      Reached end
       */
      if(curCost < minCost){
        System.out.println("Cost: " + curCost);
        System.out.println("Path: " + path);
        minCost = curCost;
      }
      return;
    }
    if(i+1 < costMatrix.length) {
      findMinCost(costMatrix, i + 1, j, curCost,path);
    }
    if(j+1 < costMatrix[i].length) {
      findMinCost(costMatrix, i, j + 1, curCost,path);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] costMatrix = new int[][]{
        {1,3,5,8},
        {4,2,1,7},
        {4,3,2,3}
           };
    findMinCost(costMatrix,0,0,0,"");
    System.out.println(minCost);
  }

}
