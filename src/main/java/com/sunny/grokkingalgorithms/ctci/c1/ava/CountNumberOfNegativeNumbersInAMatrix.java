package com.sunny.grokkingalgorithms.ctci.c1.ava;

/**
 * Created by sundas on 5/3/2018.
 */
public class CountNumberOfNegativeNumbersInAMatrix {


  public static int countNumberOfNegativeNumbersInMatrix(int[][] input){
    int count = 0;
    int i=0;
    int j = input[0].length - 1;
    while(i < input.length && j >= 0){
      if(input[i][j] < 0){
        count += j+1;
        i++;
      }
      else{
        j--;
      }
    }
    return count;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int input[][] = { {-3, -2, -1, 1},
        {-2, 2, 3, 4},
        {4, 5, 7, 8} };
    System.out.println(countNumberOfNegativeNumbersInMatrix(input));
  }
}
