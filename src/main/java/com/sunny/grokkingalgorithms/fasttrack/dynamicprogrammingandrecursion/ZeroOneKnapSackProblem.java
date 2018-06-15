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
  }

}
