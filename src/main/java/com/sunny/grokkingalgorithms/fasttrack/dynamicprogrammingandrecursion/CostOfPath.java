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
    Found bottom node rebound technique
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
  }

}
