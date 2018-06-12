package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class TowerOfHanoi {


  /**
   *
   * @param s
   * @param d
   * @param e
   * @param n
   */
  public static void towerOfHanoi(char s,char d,char e,int n){
    if(n <= 0){
      return;
    }
    towerOfHanoi(s,e,d,n-1);
    System.out.println("Moving n th disk = " + n + " from s = " + s + " to " +
        " d = " + d);
    towerOfHanoi(e,d,s,n-1);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    towerOfHanoi('s','d','e',3);
  }

}
