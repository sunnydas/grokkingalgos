package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

/**
 * Created by sundas on 6/16/2018.
 */
public class MaxOfTwoNumbersWithoutIfElse {

  /*
  Max of two number without using if else.
   */

  /**
   *
   * @param a
   * @param b
   * @return
   */
  public static int max(int a,int b){
    int max = 0;
    /*
    Find diff
     */
    int c = a - b;
    /*
    sign of the diff
     */
    int k = (c>>32)&0x1;
    /*System.out.println(k);
    System.out.println(k*c);
    System.out.println(-k*c);*/
    max = (a - k*c);
    return max;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int a = 5;
    int b = 6;
    System.out.println(max(a,b));
  }

}
