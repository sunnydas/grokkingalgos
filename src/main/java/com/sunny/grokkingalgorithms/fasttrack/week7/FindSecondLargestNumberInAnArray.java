package com.sunny.grokkingalgorithms.fasttrack.week7;

/**
 * Created by sundas on 7/29/2018.
 */
public class FindSecondLargestNumberInAnArray {


  /**
   *
   * @param input
   * @return
   */
  public static int findSecondLargest(int[] input){
    int firstLargest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;
    for(int i : input){
      if(i > firstLargest){
        secondLargest = firstLargest;
        firstLargest = i;
      }
      else if(i > secondLargest){
        secondLargest = i;
      }
    }
    return secondLargest;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{7,1,4,2,6,3};
    System.out.println(findSecondLargest(input));
  }

}
