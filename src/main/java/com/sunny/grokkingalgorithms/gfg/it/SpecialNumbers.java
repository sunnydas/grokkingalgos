package com.sunny.grokkingalgorithms.gfg.it;

/**
 * Created by sundas on 3/5/2018.
 */
public class SpecialNumbers {

  /*You have been an integer n and an array of size n as input. You have to print the count of special numbers in an array.
  A number is said to be special if it is divisible by at least one other element of the array.

  Eg: Input: 3 Output: 2 ( 2 and 3 because they are divisible by 1)

      1 2 3*/

  /**
   *
   * @param input
   * @return
   */
  public static int countSpecialNumbers(int[] input){
    int specialNumberCount = 0;
    for(int i = 0 ; i < input.length ; i++){
      for(int j = 0 ; j < input.length ; j++){
        if(i == j){
          continue;
        }
        if(input[i] > input[j] && input[j] != 0
            && input[i]%input[j] == 0){
          specialNumberCount++;
          break;
        }
      }
    }
    return  specialNumberCount;
  }

  public static void main(String[] args) {
    int[]  input = new int[]{1,2,3};
    System.out.println(countSpecialNumbers(input));
    input = new int[]{2,4,6};
    System.out.println(countSpecialNumbers(input));
    input = new int[]{2,4,6,8};
    System.out.println(countSpecialNumbers(input));
    input = new int[]{9,8,3,4,2,10};
    System.out.println(countSpecialNumbers(input));
  }
}
