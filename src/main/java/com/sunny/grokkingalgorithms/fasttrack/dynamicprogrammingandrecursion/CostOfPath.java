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

  static int[][] minCostCache;

  public static int findMinimumCostUsingDP(int[][] costMatrix){
    /*
    This 2d array stores the minim values
     */
    int[][] dpmatrix = new int[costMatrix.length][costMatrix[0].length];
    dpmatrix[0][0] = costMatrix[0][0];
    /*
     Populate top row cumulative sum
      */
    for(int j = 1 ; j < dpmatrix[0].length ; j++){
      dpmatrix[0][j] = dpmatrix[0][j - 1] + costMatrix[0][j];
    }
    /*
    Populate top column, cumulative sum
     */
    for(int i = 1 ; i < dpmatrix.length ; i++){
      dpmatrix[i][0] = dpmatrix[i - 1][0] + costMatrix[i][0];
    }
    /*
    Populate rest of the matrix
     */
    for(int i = 1; i < dpmatrix.length ; i++){
      for(int j = 1; j < dpmatrix[i].length ; j++){
        dpmatrix[i][j] = Math.min(dpmatrix[i - 1][j],dpmatrix[i][j - 1]) + costMatrix[i][j];
      }
    }
    for(int i = 0 ; i < dpmatrix.length ; i++){
      for(int j = 0 ; j < dpmatrix[i].length ; j++){
        System.out.print(dpmatrix[i][j] + " ");
      }
      System.out.println();
    }
    return dpmatrix[dpmatrix.length - 1][dpmatrix[dpmatrix.length - 1].length - 1];
  }

  public static int findMinimumCostMemoized(int[][] costMatrix,int i,int j){
    /*
    Cache call
     */
    if(minCostCache[i][j] != 0){
      return minCostCache[i][j];
    }
    //curSum += costMatrix[i][j];
    /*
    Found cell
     */
    if(i == 0
        && j == 0){
      minCostCache[0][0] = costMatrix[0][0];
      return minCostCache[0][0];
    }
    int x = Integer.MAX_VALUE;
    int y = Integer.MAX_VALUE;
    if(i - 1 >= 0){
      x = findMinimumCostMemoized(costMatrix,i - 1,j);
    }
    if(j - 1 >= 0){
      y = findMinimumCostMemoized(costMatrix,i,j - 1);
    }
    minCostCache[i][j] = Math.min(x,y) + costMatrix[i][j];
    return minCostCache[i][j];
  }

  public static int findMinCostBottomUp(int[][] costMatrix,
                                        int i,
                                        int j,
                                        int curCost,
                                        String path){
    curCost += costMatrix[i][j];
    path += costMatrix[i][j] + "-";
    if(i == 0 && j == 0){
      System.out.println(path);
      /*
      Found cell
       */
      return curCost;
    }
    int x = Integer.MAX_VALUE;
    int y = Integer.MAX_VALUE;
    if(i - 1 >= 0){
      x = findMinCostBottomUp(costMatrix, i - 1, j, curCost, path);
    }
    if(j - 1 >= 0){
      y = findMinCostBottomUp(costMatrix, i, j - 1, curCost, path);
    }
    return Math.min(x,y);
  }

  /**
   *
   * @param costMatrix
   * @param i
   * @param j
   * @param curCost
   * @return
   */
  public static int findMinCost(int[][] costMatrix,
                                int i,
                                int j,
                                int curCost){
    curCost += costMatrix[i][j];
    if(i == costMatrix.length -1 &&
        j == costMatrix[i].length - 1){
      /*
      Reached end
       */
      return curCost;
    }
    int minCost = Integer.MAX_VALUE;
    if(i+1 < costMatrix.length){
      int tempCost = findMinCost(costMatrix,i+1,j,curCost);
      minCost = Math.min(tempCost,minCost);
    }
    if(j+1 < costMatrix[i].length){
      int tempCost = findMinCost(costMatrix,i,j+1,curCost);
      minCost = Math.min(tempCost,minCost);
    }
    return minCost;
  }


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
    Found bottom next rebound technique
     */
    if(i == costMatrix.length - 1
        && j == costMatrix[i].length - 1){
      System.out.println("Path: " + path);
      /*
      Reached end
       */
      if(curCost < minCost){
        System.out.println("Cost: " + curCost);
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
    System.out.println("#########");
    System.out.println(findMinCost(costMatrix,0,0,0));
    System.out.println("#########");
    System.out.println(findMinCostBottomUp(costMatrix,
        costMatrix.length - 1,
        costMatrix[costMatrix.length - 1].length - 1,
        0,""));
    System.out.println("###############");
    minCostCache = new int[costMatrix.length][costMatrix[0].length];
    System.out.println(findMinimumCostMemoized(costMatrix,costMatrix.length - 1,
        costMatrix[costMatrix.length - 1].length - 1));
    System.out.println("##################");
    System.out.println(findMinimumCostUsingDP(costMatrix));
  }

}
