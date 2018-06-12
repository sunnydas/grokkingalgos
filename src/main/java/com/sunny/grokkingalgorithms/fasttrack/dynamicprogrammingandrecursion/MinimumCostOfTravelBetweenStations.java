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
    System.out.println(findMinimumCost(costMatrix,0,costMatrix.length - 1));
  }

}
