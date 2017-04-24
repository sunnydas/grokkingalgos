package com.sunny.grokkingalgorithms.misc;

import java.util.Scanner;

/**
 * Created by sundas on 4/24/2017.
 */
public class TowerOfHanoiStandard {


  /**
   *
   * @param n
   * @param towerA
   * @param towerB
   * @param towerC
   */
  public static void towerOfHanoi(int n, String towerA,String towerB,String towerC){
    if(n == 0){
      return;
    }
    towerOfHanoi(n - 1,towerA,towerC,towerB);
    System.out.println(" Moving n = " + n + " to dest = " + towerB);
    towerOfHanoi(n - 1,towerC,towerB,towerA);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    // given A,B,C , you have move n discs from A to B.
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    towerOfHanoi(n,"A","B","C");
  }

}
