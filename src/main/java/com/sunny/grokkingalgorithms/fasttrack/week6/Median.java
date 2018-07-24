package com.sunny.grokkingalgorithms.fasttrack.week6;

import java.util.Arrays;

/**
 * Created by sundas on 7/24/2018.
 */
public class Median {

  /*
  The median
The median is the middle number. To calculate the median of any set of numbers, you need to write the numbers in order.

To find the median number:

Put all the numbers in numerical order.
If there is an odd number of results, the median is the middle number.
If there is an even number of results, the median will be the mean of the two central numbers.
   */

  /**
   *
   * @param input
   * @return
   */
  public static double findMedian(int[] input){
    double median = -1;
    Arrays.sort(input);
    int length = input.length;
    if(length%2 != 0){
      median = input[(length - 1)/2];
    }
    else{
      int mid1 = input[(length - 1)/2 + 1];
      int mid2 = input[(length - 1)/2];
      median = (mid1 + mid2)/2;
    }
    return median;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{9, 13, 9, 11, 9, 13, 11, 9, 10, 8, 11};
    System.out.println(findMedian(input));
    input = new int[]{5,  11,  12,  4,  8,  21};
    System.out.println(findMedian(input));
  }

}
