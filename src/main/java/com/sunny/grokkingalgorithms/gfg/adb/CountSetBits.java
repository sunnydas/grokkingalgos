package com.sunny.grokkingalgorithms.gfg.adb;

/**
 * Created by sundas on 5/23/2018.
 */
public class CountSetBits {

  /*
  Count set bits in an integer
Write an efficient program to count number of 1s in binary representation of an integer.

Examples

Input : n = 6
Output : 2
Binary representation of 6 is 110 and has 2 set bits

Input : n = 13
Output : 3
Binary representation of 13 is 1101 and has 3 set bits
   */

  /**
   *
   * @param n
   * @return
   */
  public static int countSetBits(int n){
    int setBits = 0;
    int mask = 1;
    int loopCount = 0;
    while(loopCount < 32){
      int val = n&mask;
      if(val == 1){
        setBits++;
      }
      n = n>>1;
      loopCount++;
    }
    return setBits;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(countSetBits(6));
    System.out.println(countSetBits(13));
    System.out.println(countSetBits(5));
    System.out.println(countSetBits(8));
    System.out.println(countSetBits(16));
    System.out.println(countSetBits(17));
  }

}

