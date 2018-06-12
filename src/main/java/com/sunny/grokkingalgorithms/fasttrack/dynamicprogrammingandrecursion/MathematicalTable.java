package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class MathematicalTable {

  /*
  Print mathematical table of n
   */
  public static void printMathematicalTable(int n,int i){
    if(i == 11 || i <= 0){
      return;
    }
    System.out.println(" " + n + " X " + i + " = " + n*i);
    printMathematicalTable(n,i+1);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    printMathematicalTable(5,1);
  }

}
