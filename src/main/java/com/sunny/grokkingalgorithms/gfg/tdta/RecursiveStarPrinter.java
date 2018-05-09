package com.sunny.grokkingalgorithms.gfg.tdta;

/**
 * Created by sundas on 5/9/2018.
 */
public class RecursiveStarPrinter {

  /**
   *
   * @param t
   */
  public static void q(int t){
    if(t > 1){
      q(t/2);
      q(t/2);
    }
    System.out.println("*");
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    q(5);
  }

}
