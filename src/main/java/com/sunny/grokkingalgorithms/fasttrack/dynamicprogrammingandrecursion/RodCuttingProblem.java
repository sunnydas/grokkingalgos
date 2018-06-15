package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/15/2018.
 */
public class RodCuttingProblem {

  /*
  Given a ro of certain length and the price at cutting each
  rod at different lengths. How will we maximise profit for the rod cutting.
  For example:
  length = 1 2 3 4 5 6 7 8
  price = 1 5 8 9 10 17 17 20
  if we sell the rod of length 4 without cutting we get 9
  if we cut the rod in two pieces of length 2 each
  we get 10
   */

  /**
   *
   * @param length
   * @param price
   * @param rodLength
   * @param currentPrice
   * @return
   */
  public static int
     rodCutting(int[] length,int[] price,int rodLength){
    if(rodLength == 0){
      //System.out.println(path);
      //System.out.println(currentPrice);
      return 0;
    }
    //System.out.println(currentLength);
    //currentPrice += price[currentLength];
    int maxPrice = Integer.MIN_VALUE;
    for(int i = 1; i <= rodLength ; i++){
      maxPrice = Math.max(maxPrice,rodCutting(length,price,
          rodLength - length[i]) + price[length[i]]);
    }
    return maxPrice;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] length = new int[]{0,1,2,3,4,5,6,7,8};
    int[] price = new int[]{0,1,5,8,9,10,17,17,20};
    /*
    For rod of length 4
    we can get 10 (2*5)
     */
    System.out.println(rodCutting(length,price,4));
  }

}
