package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sundas on 6/29/2018.
 */
public class MaxSongs {

  /*
  Given an array of songs length and journey time, maximum number of songs that can be played during the journey.
Constraint:- Either song should be completed or should not be played.
Ex:- [2, 4, 3, 5, 5, 2, 4] and Journey time = 20
Output: � 5
[2, 4, 3, 5, 5, 2, 4, 3] and Journey time = 20
Output:- 6
   */

  /**
   *
   * @param input
   * @param journeyTime
   * @return
   */
  public static int maxSongs(List<Integer> input,int journeyTime){
    if(input.size() == 0 && journeyTime >= 0){
      return 0;
    }
    int cur = input.remove(0);
    int included = Integer.MIN_VALUE;
    int excluded = Integer.MIN_VALUE;
    if(journeyTime - cur >= 0) {
      included = maxSongs(new ArrayList<Integer>(input), journeyTime - cur) + 1;
    }
    if(journeyTime >= 0) {
      excluded = maxSongs(new ArrayList<Integer>(input), journeyTime);
    }
    return Math.max(included,excluded);
  }

  /**
   *
   * @param input
   * @param k
   * @return
   */
  public static int maxSongs(int[] input,int k){
    int max = 0;
    Arrays.sort(input);
    int curCount =  0;
    int i = 0;
    StringBuilder  builder = new StringBuilder();
    for(;i < input.length; i++){
      if(curCount + input[i] <= k) {
        curCount += input[i];
        builder.append(input[i]);
      }
      else{
        break;
      }
    }
    //System.out.println(builder.toString());
    max = i;
    return max;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{2, 4, 3, 5, 5, 2, 4};
    List<Integer> songs = new ArrayList<>();
    for(int i : input){
      songs.add(i);
    }
    int journeyTime = 20;
    System.out.println("recursive " + maxSongs(songs,journeyTime));
    System.out.println("sorting "+ maxSongs(input,20));
    input = new int[]{2, 4, 3, 5, 5, 2, 4, 3};
    System.out.println("sorting " + maxSongs(input,20));
    //System.out.println("recursive " + maxSongs(songs,journeyTime));
    input = new int[]{1,2,3,4};
    System.out.println(maxSongs(input,11));
    System.out.println(maxSongs(input,7));
    System.out.println(maxSongs(input,4));
    input = new int[]{50,2,1,3,4,5,80,19,23};
    System.out.println(maxSongs(input,100));
    //System.out.println(maxSongs(songs,100));
    System.out.println();
    songs = new ArrayList<>();
    for(int i : input){
      songs.add(i);
    }
    System.out.println(maxSongs(songs,100));
    System.out.println();
    input = new int[]{1,2,3,4};
    songs = new ArrayList<>();
    for(int i : input){
      songs.add(i);
    }
    System.out.println(maxSongs(songs,11));
    songs = new ArrayList<>();
    for(int i : input){
      songs.add(i);
    }
    System.out.println(maxSongs(songs,7));
    songs = new ArrayList<>();
    for(int i : input){
      songs.add(i);
    }
    System.out.println(maxSongs(songs,4));
  }

}
