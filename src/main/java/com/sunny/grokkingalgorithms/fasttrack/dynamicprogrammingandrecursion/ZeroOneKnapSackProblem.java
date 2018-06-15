package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/15/2018.
 */
public class ZeroOneKnapSackProblem {

  /*
  N items each has
  weight[n]
  value[n]
  maximise value for knapsack of size n.
   */

  /**
   *
   * @param weights
   * @param values
   * @param k
   * @param n
   * @return
   */
  public static int knapSackDP(int[] values,int[] weights,int k,int n){
    int[][] dp = new int[n + 1][k+1];
    for(int i = 0; i < dp.length ; i++){
      for(int j = 0; j < dp[i].length ; j++){
        if(i == 0 || j== 0){
          dp[i][j] = 0;
          continue;
        }
        if(j  >= weights[i - 1]){
          dp[i][j] = Math.max(dp[i - 1][j],
              values[i - 1] + dp[i - 1][j - weights[i - 1]]);
        }
        else{
          dp[i][j] = dp[i - 1][j];
        }
      }
    }
    for(int i = 0 ; i < dp.length ; i++){
      for(int j = 0; j < dp[i].length ; j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return dp[n][k];
  }

  /**
   *
   * @param values
   * @param weights
   * @param k
   * @return
   */
  public static int knapSack(int[] values,int[] weights,int k,int n){
    if(n == 0 || k == 0){
      return 0;
    }
    if(weights[n - 1] > k){
      return knapSack(values,weights,k,n - 1);
    }
    /*
    nth item included
     */
    int x = knapSack(values,weights,k - weights[n - 1],n - 1) + values[n - 1];
    /*
    nth item not included
     */
    int y = knapSack(values,weights,k,n - 1);
    return Math.max(x,y);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] values = new int[]{60,100,120};
    int[] weights = new int[]{10,20,30};
    int k = 50;
    System.out.println(knapSack(values,weights,k,3));
    System.out.println(knapSackDP(values,weights,k,3));
    int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
    int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
    k = 30;
    System.out.println(knapSack(val,wt,k,val.length));
    System.out.println(knapSackDP(val,wt,k,val.length));
  }

}
