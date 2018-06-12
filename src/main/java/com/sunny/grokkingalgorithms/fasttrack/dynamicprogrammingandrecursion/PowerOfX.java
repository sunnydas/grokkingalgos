package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class PowerOfX {

  /**
   *
   * @param x
   * @param n
   * @return
   */
  public static int power(int x,int n){
    if(n==0){
      return 1;
    }
    if(x==1){
      return 1;
    }
    return x*power(x,n-1);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(power(2,5));
    System.out.println(power(5,0));
    System.out.println(power(10,2));
    System.out.println(power(1,100));
  }

}
