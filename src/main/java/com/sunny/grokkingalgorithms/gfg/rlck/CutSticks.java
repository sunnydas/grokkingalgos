package com.sunny.grokkingalgorithms.gfg.rlck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 5/13/2018.
 */
public class CutSticks {


  /**
   *
   * @param lengths
   * @return
   */
  public static int[] cutSticks(int[] lengths){
    List<Integer> sticksLeft = new ArrayList<>();
    sticksLeft.add(countSticksRemaining(lengths));
    while(!noSticksLeft(lengths)){
      int min = findMin(lengths);
      //if(min > 0){
        lengths = updateStickLengths(lengths, min);
        int count = countSticksRemaining(lengths);
        if(count > 0){
          sticksLeft.add(count);
        }
        else{
          break;
        }
      //}
    }
    int[] sticks = new int[sticksLeft.size()];
    for(int i = 0 ; i < sticksLeft.size() ; i++){
      sticks[i] = sticksLeft.get(i);
    }
    return sticks;
  }

  public static int[] updateStickLengths(int[] lengths,int min){
    for(int i = 0 ; i < lengths.length ; i++){
      if(lengths[i] > 0) {
        lengths[i] = lengths[i] - min;
      }
    }
    return lengths;
  }


  public static int countSticksRemaining(int[] sticks){
    int count = 0;
    for(int i = 0 ; i < sticks.length ; i++){
      if(sticks[i] > 0){
        count++;
      }
    }
    return count;
  }

  public static int findMin(int[] sticks){
    int curMin = Integer.MAX_VALUE;
    for(int i = 0 ; i < sticks.length ; i++){
      if(sticks[i] == 0){
        continue;
      }
      if(sticks[i] < curMin){
       curMin = sticks[i];
      }
    }
    if(curMin == Integer.MAX_VALUE){
      curMin = 0;
    }
    return curMin;
  }

  public static boolean noSticksLeft(int[] sticks){
    return countSticksRemaining(sticks) < 0;
  }


  public static void main(String[] args) {
    int[] input = new int[]{5,4,4,2,2,8};
    int[] sticks = cutSticks(input);
    for(int i : sticks){
      System.out.println(i);
    }
  }

}
