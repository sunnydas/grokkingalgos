package com.sunny.grokkingalgorithms.fasttrack.week3;

/**
 * Created by sundas on 7/5/2018.
 */
public class ZigZagTraversalOfAMatrix {


  /**
   *
   * @param input
   */
  public static void zigZagTraversalOfAMatrix(int[][] input){
    boolean forward = true;
    for(int i = 0 ; i < input.length ; i++){
      if(forward){
        int j = 0;
        while(j < input[i].length){
          System.out.print(input[i][j] + " ");
          j++;
        }
        forward = false;
      }
      else{
        int j = input[i].length - 1;
        while(j >= 0){
          System.out.print(input[i][j] + " ");
          j--;
        }
        forward = true;
      }
      System.out.println();
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] input = new int[][]{
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,16}
    };
    zigZagTraversalOfAMatrix(input);
  }

}
