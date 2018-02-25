package com.sunny.grokkingalgorithms.gfg.sp;

import java.util.Scanner;

/**
 * Created by sundas on 5/4/2017.
 */
public class IsAPOrGP {

  /*
  The question was to identify whether given 3 integers belong to an AP or a GP. The main function was implemented we had to implement the is_AP or is_GP methods.
   */


  /**
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static boolean isAP(int a, int b , int c){
    return (c-b) == (b-a);
  }


  /**
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static boolean isGP(int a , int b, int c){
    boolean isGp = false;
    if(a != 0 && b != 0 && c!= 0){
      isGp = ((c/b) != 0 && (b/a) != 0) ? c/b == b/a : false;
    }
    return isGp;
  }


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    int c = scanner.nextInt();
    System.out.println(isAP(a,b,c));
    System.out.println(isGP(a,b,c));
  }
}
