package com.sunny.grokkingalgorithms.fasttrack.week6;

import java.util.Arrays;

/**
 * Created by sundas on 7/24/2018.
 */
public class Sort0and1 {

  /**
   *
   * @param input
   */
  public static void sort(int[] input){
    int i = 0;
    int j = input.length - 1;
    while(i < j){
      if(input[i] == 1){
        if(input[j] == 0){
          input[j] = 1;
          input[i] = 0;
          i++;
          j--;
        }
        else{
          while(j >= 0 && input[j] != 0
              && j > i){
            j--;
          }
          if(j >= 0
              && input[j] == 0
              && j > i){
            input[j] = 1;
            input[i] = 0;
            i++;
            j--;
          }
        }
      }
      else{
        i++;
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,0,1,0,1,0,1,1,0,1};
    sort(input);
    System.out.println(Arrays.toString(input));
    input = new int[]{1,1,1,1,1,1};
    sort(input);
    System.out.println(Arrays.toString(input));
    input = new int[]{0,0,0,0,0,0};
    sort(input);
    System.out.println(Arrays.toString(input));
    input = new int[]{1,1,1,1,0,1};
    sort(input);
    System.out.println(Arrays.toString(input));
  }



}
