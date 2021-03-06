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

   /*
   Approach:

Say child has to take n steps.
At every step the child has 3 options, to take 1 step, 2 step or 3 steps.
So if child take 1 step then find the number of ways to complete n-1 steps +1.
Similarly if child take 2 steps then find the number of ways to complete n-2 steps +1.
If child take 3 step then find the number of ways to complete n-3 steps +1.
So total number of ways to complete n steps = No of ways to complete (n-1)steps + No of ways to complete (n-2)steps + No of ways to complete (n-3)steps +1.
    */

  /**
   *
   * @param n
   * @param map
   * @return
   */
  public static int findPossibleStepsDP(int n,int[] map){
    if(n == 0){
      return 1;
    }
    if(n < 0){
      return 0;
    }
    if(map[n] > 0){
      return map[n];
    }
    else {
      map[n] = findPossibleStepsDP(n - 1, map) + findPossibleStepsDP(n - 2, map) + findPossibleStepsDP(n - 3, map);
    }
    return map[n];
  }


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
   * @param n
   * @return
   */
  public static void findPossibleStepsTwo(int n){
    if(n == 0){
      possibleWays++;
      return;
    }
    else if(n < 0){
      return;
    }
    findPossibleSteps(n-1);
    findPossibleSteps(n-2);
    //findPossibleSteps(n-3);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    findPossibleSteps(4);
    System.out.println(possibleWays);
    possibleWays = 0;
    findPossibleSteps(3);
    System.out.println(possibleWays);
    possibleWays = 0;
    long start = System.currentTimeMillis();
    findPossibleSteps(30);
    System.out.println(possibleWays);
    System.out.println(" Time taken = " + ((System.currentTimeMillis() - start)) / 100 + " seconds");
    System.out.println(findPossibleStepsDP(4, new int[5]));
    System.out.println(findPossibleStepsDP(3,new int[4]));
    start = System.currentTimeMillis();
    System.out.println(findPossibleStepsDP(30,new int[31]));
    System.out.println(" Time taken = " + ((System.currentTimeMillis() - start))/100 + " seconds");
    possibleWays = 0;
    findPossibleStepsTwo(2);
    System.out.println(possibleWays);
  }
}
