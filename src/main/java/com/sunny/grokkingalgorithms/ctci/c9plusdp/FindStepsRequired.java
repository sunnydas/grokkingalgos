package com.sunny.grokkingalgorithms.ctci.c9plusdp;

/**
 * Created by sundas on 3/22/2018.
 */
public class FindStepsRequired {

   /*
   A child is running up the stairs, he can take one step, two steps or three steps at a time. Calculate
   how many possible ways can he reach the top
    */

  public static int possibleWays = 0;

  /**
   *
   * @param n
   * @return
   */
  public static void findPossibleSteps(int n){
    if(n == 0){
      possibleWays++;
      return;
    }
    else if(n < 0){
      return;
    }
    findPossibleSteps(n-1);
    findPossibleSteps(n-2);
    findPossibleSteps(n-3);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    findPossibleSteps(4);
    System.out.println(possibleWays);
  }
}
