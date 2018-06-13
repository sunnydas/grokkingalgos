package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class NumberOfWaysToScore {

  /*
  A player can score 3,5 or 10 in one move. Count number of unique ways
   to reach score of n
   */

  public static int totalCount;

  /**
   *
   * @param n
   * @return
   */
  public static int countNumberOfWaysToReachScoreNDP(int n){
    int[] numWays = new int[n+1];
    numWays[0] = 1;
    for(int i = 1 ; i <= n ; i++){
      if(i - 3 >= 0){
        numWays[i] += numWays[i - 3];
      }
      if(i - 5 >= 0){
        numWays[i] += numWays[i - 5];
      }
      if(i - 10 >= 0){
        numWays[i] += numWays[i - 10];
      }
    }
    return numWays[n];
  }

  /**
   *
   * @param n
   * @param scoreTrace
   */
  public static void countNumberOfWaysToReachScoreN(int n,String scoreTrace){
    if(n == 0){
      totalCount++;
      System.out.println(scoreTrace);
      return;
    }
    if(n < 0){
      return;
    }
    //scoreTrace += n + "-";
    countNumberOfWaysToReachScoreN(n - 3,scoreTrace + (3 + "-"));
    countNumberOfWaysToReachScoreN(n - 5,scoreTrace + (5 + "-"));
    countNumberOfWaysToReachScoreN(n - 10,scoreTrace + (10 + "-"));
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    countNumberOfWaysToReachScoreN(13,"");
    System.out.println(totalCount);
    System.out.println("###########");
    System.out.println(countNumberOfWaysToReachScoreNDP(13));
  }

}
