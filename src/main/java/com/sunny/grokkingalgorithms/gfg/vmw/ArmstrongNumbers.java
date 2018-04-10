package com.sunny.grokkingalgorithms.gfg.vmw;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 4/10/2018.
 */
public class ArmstrongNumbers {

  /*
  Given a number x, determine whether the given number is Armstrong number or not. A positive integer of n digits is called an Armstrong number of order n (order is number of digits) if.

abcd... = pow(a,n) + pow(b,n) + pow(c,n) + pow(d,n) + ....
Example:

Input : 153
Output : Yes
153 is an Armstrong number.
1*1*1 + 5*5*5 + 3*3*3 = 153

Input : 120
Output : No
120 is not a Armstrong number.
1*1*1 + 2*2*2 + 0*0*0 = 9

Input : 1253
Output : No
1253 is not a Armstrong Number
1*1*1*1 + 2*2*2*2 + 5*5*5*5 + 3*3*3*3 = 723

Input : 1634
Output : Yes
1*1*1*1 + 6*6*6*6 + 3*3*3*3 + 4*4*4*4 = 1634
   */


  /**
   *
    * @param n
   * @return
   */
  public static boolean isArmstrong(int n){
    boolean isArmstrong = false;
    int dividend = n;
    int divisor = 10;
    int order = 0;
    List<Integer> digits = new ArrayList<>();
    while(dividend > divisor){
      int quotient = dividend/divisor;
      int remainder = dividend%divisor;
      digits.add(remainder);
      dividend = quotient;
      order++;
    }
    if(dividend > 0){
      digits.add(dividend);
      order++;
    }
    int sum = 0;
    for(Integer num : digits){
      sum += Math.pow(num,order);
    }
    if(sum == n){
      isArmstrong = true;
    }
    return isArmstrong;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int a = 153;
    int b = 120;
    int c = 1253;
    int d = 1634;
    int e = 371;
    int f = 407;
    int g = 0;
    int h = 1;
    int i = 370;
    System.out.println(isArmstrong(a));
    System.out.println(isArmstrong(b));
    System.out.println(isArmstrong(c));
    System.out.println(isArmstrong(d));
    System.out.println(isArmstrong(e));
    System.out.println(isArmstrong(f));
    System.out.println(isArmstrong(g));
    System.out.println(isArmstrong(h));
    System.out.println(isArmstrong(i));
  }



}
