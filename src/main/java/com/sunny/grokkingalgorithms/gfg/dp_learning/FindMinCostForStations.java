package com.sunny.grokkingalgorithms.gfg.dp_learning;

/**
 * Created by sundas on 5/11/2017.
 */
public class FindMinCostForStations {

  // http://www.geeksforgeeks.org/find-the-minimum-cost-to-reach-a-destination-where-every-station-is-connected-in-one-direction/


  /**
   * We try to find the min cost from start = 0 to destination = N-1
   * Recursive solution no dp.
   *
   * @param costMatrix
   * @return
   */
  public static int findMinCost(int[][] costMatrix,int source,int destination){
    int minCost = Integer.MAX_VALUE;
    /*
    Min cost is basically to find the minimum cost of all possible paths from source to destination,
    including the one that is direct.
     */
    //Boundaries
    if(source == destination || source + 1 == destination){
      return costMatrix[source][destination];
    }
    //find direct cost
    int directCost = costMatrix[source][destination];
    //find alternates
    //If we put <= in condition this will loop forever,because it will always call
    // findMinCost(costMatrix,source,i)
    for(int i = source + 1; i < destination ; i++){
       int cost = findMinCost(costMatrix,source,i) + findMinCost(costMatrix,i,destination);
       if(cost < minCost){
         minCost = cost;
      }
    }
    if(directCost < minCost){
      minCost = directCost;
    }
    return minCost;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int INF = Integer.MIN_VALUE;
    int cost[][] = { {0, 15, 80, 90},
        {INF, 0, 40, 50},
        {INF, INF, 0, 70},
        {INF, INF, INF, 0}
    };
    System.out.println("min cost=" + findMinCost(cost,0,cost.length - 1));
  }

}
