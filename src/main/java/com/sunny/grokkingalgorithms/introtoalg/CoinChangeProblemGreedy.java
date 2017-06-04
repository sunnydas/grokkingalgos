package com.sunny.grokkingalgorithms.introtoalg;

/**
 * Created by sundas on 6/4/2017.
 */
public class CoinChangeProblemGreedy {


  /**
   *
   * @param wallet
   * @param target
   */
  public static void printGreedyApproach(int[][] wallet,int target){
    int curSum = 0;
     //Assuming sorted descending (this is important for greedy to work).
      for(int i = 0 ; i < wallet.length;){
        int candidate = wallet[i][0];
        if(wallet[i][1] > 0 && curSum + candidate <= target){
          curSum += candidate;
          System.out.println("candidate = " + candidate);
          System.out.println(curSum);
          //Reduce wallet count
          wallet[i][1]--;
        }
        else{
          i++;
        }
      }

  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    // 2 d arra representing denomination , number available
    int[][] wallet = new int[][]{{10, 10},
        {5, 5},
        {2, 2},
        {1, 1}
    };
    printGreedyApproach(wallet,18);
  }
}
