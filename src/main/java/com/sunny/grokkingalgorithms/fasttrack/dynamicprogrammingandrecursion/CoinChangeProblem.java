package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.Arrays;

/**
 * Created by sundas on 6/14/2018.
 */
public class CoinChangeProblem {

  /*
  Given an infinite supply of coins of N different denominations.
  Find minimum combinations of denominations that add up to N
   */

  /**
   *
   * @param coins
   * @param k
   * @return
   */
  public static String coinChangeGreedy(int[] coins,int k){
    Arrays.sort(coins);
    StringBuilder coinChange = new StringBuilder();
    for(int i = coins.length - 1 ; i >= 0 ; i--){
      int coin = coins[i];
      if(coin <= k){
        int quotient = k/coin;
        int remainder = k%coin;
        coinChange.append(coin + "*" + quotient + ",");
        k = remainder;
      }
      if(k == 0){
        break;
      }
    }
    return coinChange.toString();
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] coins = new int[]{1,2,5,10,20,50};
    int k = 65;
    System.out.println(coinChangeGreedy(coins,k));
    coins = new int[]{1,2,5,10,12,20,50};
    k = 65;
    System.out.println(coinChangeGreedy(coins,k));
    coins = new int[]{1,5,6,9};
    k = 11;
    System.out.println(coinChangeGreedy(coins,k));
  }

}
