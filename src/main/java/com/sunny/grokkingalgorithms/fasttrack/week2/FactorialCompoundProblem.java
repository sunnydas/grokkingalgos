package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by sundas on 6/28/2018.
 */
public class FactorialCompoundProblem {
  /*
  a.) Given an array find factorial of all numbers
  b.) then find sum of digits of the calculated fact
   c.) find number of leafing zeros
   d.) find diff between b and c
   e.) return min d.)
   */

  private static Map<Long,Long> factCache = new HashMap<>();

  /**
   *
   * @param input
   * @return
   */
  public static long compoundFactorial(long[] input){
    long min = Integer.MAX_VALUE;
    /*
    Find factorial of every number in input
     */
    for(int i = 0 ; i < input.length ; i++){
      input[i] = fact(input[i]);
    }
    System.out.println(Arrays.toString(input));
    long[] leadingZeros = new long[input.length];
    for(int i = 0 ; i < input.length ; i++){
      leadingZeros[i] = findLeadingZeros(input[i]);
    }
    System.out.println(Arrays.toString(leadingZeros));
    long[] diff = new long[input.length];
    for(int i = 0 ; i < input.length ; i++){
      diff[i] = input[i] - leadingZeros[i];
    }
    for(int i = 0 ; i < diff.length ; i++){
      if(diff[i] < min){
        min = diff[i];
      }
    }
    return min;
  }

  /**
   *
   * @param n
   * @return
   */
  public static long findLeadingZeros(long n){
    String s = String.valueOf(n);
    int i = s.length() - 1;
    long leadingZerosCount = 0;
    while(i >= 0){
      if(s.charAt(i) == '0'){
        leadingZerosCount++;
      }
      else{
        break;
      }
      i--;
    }
    return leadingZerosCount;
  }

  /**
   *
   * @param n
   * @return
   */
  public static long fact(long n){
    if(factCache.containsKey(n)){
      return factCache.get(n);
    }
    if (n <= 1) {
      factCache.put(1L,1L);
      return 1L;
    }
    factCache.put(n,n*fact(n - 1));
    return factCache.get(n);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    long[] input = new long[]{9,8,1,7,12};
    System.out.println(compoundFactorial(input));
  }

}
