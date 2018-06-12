package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.List;

/**
 * Created by sundas on 6/12/2018.
 */
public class MinimumCostOfTravelBetweenStations {

  /*
  Find minimum cost of reaching n-1th  station from 0th station
   */

  /**
   *
    * @param costmatrix
   * @return
   */
  public static int findMinCostDP(int[][] costmatrix){
    int[] minCost = new int[costmatrix.length];
    /*
    Cost of going to same station is 0
     */
    minCost[0] = 0;
    /*
    There is only one way to reach first stations
     */
    minCost[1] = costmatrix[0][1];
    for(int i = 2; i < costmatrix.length ;i++){
      /*
      Try direct path
       */
      minCost[i] = costmatrix[0][i];
      /*
      try intermediate path. We start from 1 since 0,i has already been considerd
       */
      for(int j = 1; j <= i ; j++){
        int tempCost = minCost[j] + costmatrix[j][i];
        if(tempCost < minCost[i]){
          minCost[i] = tempCost;
        }
      }
    }
    return minCost[costmatrix.length - 1];
  }

  /**
   *
   * @param costMatrix
   * @param s
   * @param d
   * @param costCache
   * @return
   */
  public static int findMinimumCostUsingMemoization(int[][] costMatrix,
                                    int s,
                                    int d,
                                    int[][] costCache){
    /*
    If last but one station , only one way to go from s to d
     */
    if(s == d || s == (d-1)){
      return costMatrix[s][d];
    }
    int minCost = 0;
    if(costCache[s][d] == 0) {
    /*
    Try the direct cost
     */
      minCost = costMatrix[s][d];
    /*
    Try intermediate cost.
     */
      for (int i = s + 1; i < d; i++) {
        int curCost = findMinimumCost(costMatrix, s, i)
            + findMinimumCost(costMatrix, i, d);
        if (curCost < minCost) {
          minCost = curCost;
        }
      }
      costCache[s][d] = minCost;
    }
    else{
      minCost = costCache[s][d];
    }
    return minCost;
  }


  /**
   *
   * @param costMatrix
   * @param s
   * @param d
   *
   */
  public static int findMinimumCost(int[][] costMatrix,
                                    int s,int d
                                    ){
    /*
    If last but one station , only one way to go from s to d
     */
    if(s == d || s == (d-1)){
      return costMatrix[s][d];
    }
    /*
    Try the direct cost
     */
    int minCost = costMatrix[s][d];
    /*
    Try intermediate cost.
     */
    for(int i = s+1 ; i < d ; i++){
      int curCost = findMinimumCost(costMatrix,s,i)
          + findMinimumCost(costMatrix,i,d);
      if(curCost < minCost){
        minCost = curCost;
      }
    }
    return minCost;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    O to N-1 stations
    0th row represents 0th station and the cost of
    reaching each station (uptill n-1).
    Movement is only in the forward direction
     */
    int[][] costMatrix = new int[][]{
        {0,10,75,94},
        {-1,0,35,50},
        {-1,-1,0,80},
        {-1,-1,-1,0}
    };
    System.out.println(findMinimumCost(costMatrix, 0, costMatrix.length - 1));
    int[][] costCache = new int[][]{
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    System.out.println(findMinimumCostUsingMemoization(costMatrix,0,
        costMatrix.length - 1,costCache));
    System.out.println(findMinCostDP(costMatrix));
  }

}
