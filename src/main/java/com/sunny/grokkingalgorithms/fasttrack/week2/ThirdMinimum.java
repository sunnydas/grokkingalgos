package com.sunny.grokkingalgorithms.fasttrack.week2;

/**
 * Created by sundas on 6/27/2018.
 */
public class ThirdMinimum {

  /**
   *
   * @param input
   * @return
   */
  public static int findThirdMinimum(int[] input){
    int firstMin = Integer.MAX_VALUE;
    int secondMin = Integer.MAX_VALUE;
    int thirdMin = Integer.MAX_VALUE;
    for(int i = 0 ; i < input.length ; i++){
      int cur =  input[i];
      if(cur < firstMin){
        thirdMin = secondMin;
        secondMin = firstMin;
        firstMin = cur;
      }
      else if(cur < secondMin){
        thirdMin = secondMin;
        secondMin = cur;
      }
      else if(cur < thirdMin){
        thirdMin = cur;
      }

    }
    return thirdMin;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{5,2,6,1,4,3,10,9};
    System.out.println(findThirdMinimum(input));
  }

}
