package com.sunny.grokkingalgorithms.gfg.sp;

/**
 * Created by sundas on 5/7/2017.
 */
public class FindSecondHighest {

  //Find second highest element in an unsorted array

  public static int findSecondHighest(int[] input){
    int secondHighest = Integer.MIN_VALUE;
    int firstHighest = Integer.MIN_VALUE;
    for(int i : input){
      if(i > firstHighest){
        if(firstHighest != Integer.MIN_VALUE){
          secondHighest = firstHighest;
        }
        firstHighest = i;
      }
      if(i > secondHighest && i < firstHighest){
        secondHighest = i;
      }
    }
    return secondHighest;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[]  input = {10,99,1,0,5,4,534,100,10,2,76};
    System.out.println(findSecondHighest(input));
    input = new int[]{1,1,1,1,1,1,1};
    System.out.println(findSecondHighest(input));
    input = new int[]{1,2,1,2,1,2,1,0};
    System.out.println(findSecondHighest(input));
    input = new int[]{-5,4,1,0,-20,2,3};
    System.out.println(findSecondHighest(input));
  }
}
