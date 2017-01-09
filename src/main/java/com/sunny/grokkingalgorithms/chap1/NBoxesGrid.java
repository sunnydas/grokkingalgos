package com.sunny.grokkingalgorithms.chap1;

import java.util.Scanner;

/**
 * Created by sundas on 12/29/2016.
 */
public class NBoxesGrid {

  /**
   *
   * @param n
   */
  public static void drawGrid(int n){
    //output n*n matrix
    int k = 0;
    for(int i = 0 ; i < n ; i++){
      for(int j = 0 ; j < n ; j++){
        System.out.print(++k);
        System.out.print(" ");
      }
      System.out.println();
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    drawGrid(n);
  }
}
