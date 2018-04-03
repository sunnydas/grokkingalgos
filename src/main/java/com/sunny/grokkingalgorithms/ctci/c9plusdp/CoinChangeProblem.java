package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.Arrays;

/**
 * Created by sundas on 4/3/2018.
 */
public class CoinChangeProblem {

  /*
  Given a set of coin changes and a value , print number of ways we can
  get to a particular value.

  {5,2,1}
  value = rs 10

  one option 5x2
  another 5 + 2 1 + 2
  etc

   */

  private static int totalCount;

  /**
   *
   * @param coins
   * @param value
   */
  public static void printNumberOfWays(int[] coins,int value,String curValue,int count){
    /*
    Found a possible combination
     */
    if(count == value){
      System.out.println(curValue);
      totalCount++;
    }
    /*
    Hit boundary
     */
    if(count > value){
      return;
    }
    for(int i = 0 ; i < coins.length ; i++){
      printNumberOfWays(coins,value,curValue+coins[i],count+coins[i]);
    }
  }

  /**
   *
   * @param coins
   * @param value
   * @param curValue
   */
  public static void printNumberOfWaysGreedy(int[] coins,int value,String curValue){
    /*
    Sort it to choose the max values
     */
    Arrays.sort(coins);
    printNumberOfWaysGreedyRecursive(coins,value,curValue,coins.length - 1);
  }

  /**
   *
   * @param coins
   * @param value
   * @param curValue
   */
  public static void printNumberOfWaysGreedyRecursive(int[] coins,int value,String curValue,int currentCoinIdex){
    if(value <= 0){
      return;
    }
    else if(value%coins[currentCoinIdex] == 0){
      curValue += coins[currentCoinIdex] + " * " + (value/coins[currentCoinIdex]);
      System.out.println(curValue);
    }
    else if(coins[currentCoinIdex] > value) {
      printNumberOfWaysGreedyRecursive(coins,value,curValue,--currentCoinIdex);
    }
    else{
      int rem = value%coins[currentCoinIdex];
      int div = value/coins[currentCoinIdex];
      curValue += (div) +  " * " + coins[currentCoinIdex] + "-->";
      printNumberOfWaysGreedyRecursive(coins,value - div*coins[currentCoinIdex],curValue,--currentCoinIdex);
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] coins = new int[]{5,2,1};
    int value = 20;
    printNumberOfWays(coins,value,"",0);
    System.out.println(totalCount);
    printNumberOfWaysGreedy(coins,value,"");
  }

}
