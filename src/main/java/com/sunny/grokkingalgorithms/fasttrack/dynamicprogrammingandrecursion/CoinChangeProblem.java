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
  public static int coinChange(int[] coins,int k){
    if(k == 0){
      return 0;
    }
    int count  = Integer.MAX_VALUE;
    for(int i = 0 ; i < coins.length ; i++){
      if(coins[i] <= k) {
        int found = coinChange(coins, k - coins[i]);
        if (found < count) {
          count = found + 1;
        }
      }
    }
    return count;
  }

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
    //System.out.println(coinChange(coins, k));
    coins = new int[]{1,2,5,10,12,20,50};
    k = 65;
    System.out.println(coinChangeGreedy(coins,k));
    //System.out.println(coinChange(coins, k));
    coins = new int[]{1,5,6,9};
    k = 11;
    System.out.println(coinChangeGreedy(coins,k));
    System.out.println(coinChange(coins, k));
  }

}
