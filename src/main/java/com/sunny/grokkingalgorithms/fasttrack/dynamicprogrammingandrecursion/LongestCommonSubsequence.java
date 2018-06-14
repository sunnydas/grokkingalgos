package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.*;

/**
 * Created by sundas on 6/14/2018.
 */
public class LongestCommonSubsequence {

  /*
  Given two strings find count of the longest common subsequence
   */

  /**
   * Memoized cache for storing results.
   */
  public static Map<String,Integer> cachedSizesOfLCS = new HashMap<>();

  public static int[][] memoizationCache = null;

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int findLCSRecursiveMemoizedAlternate(String s1,
                                     String s2,int x,int y){
    if(s1.length() == 0
        || s2.length() == 0){
      return 0;
    }
    if(memoizationCache[x][y] > 0){
      return memoizationCache[x][y];
    }
    if(s1.charAt(0)
        == s2.charAt(0)){
      int size = findLCSRecursiveMemoizedAlternate(s1.substring(1), s2.substring(1), x + 1, y + 1) + 1;
      memoizationCache[x][y] = size;
      return size;
    }
    else{
      int size1 = findLCSRecursiveMemoizedAlternate(s1.substring(1),
          s2,x+1,y);
      int size2 = findLCSRecursiveMemoizedAlternate(s1,
          s2.substring(1),x,y+1);
      int max = Math.max(size1,size2);
      memoizationCache[x][y] = max;
      return max;
    }
  }

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int findLCSRecursiveMemoized(String s1,
                                     String s2){
    if(cachedSizesOfLCS.containsKey(s1 + ":" + s2)){
      return cachedSizesOfLCS.get(s1 + ":" + s2);
    }
    if(s1.length() == 0
        || s2.length() == 0){
      return 0;
    }
    if(s1.charAt(0)
        == s2.charAt(0)){
      int size = findLCSRecursiveMemoized(s1.substring(1), s2.substring(1)) + 1;
      cachedSizesOfLCS.put(s1 + ":" + s2,size);
      return size;
    }
    else{
      int size1 = findLCSRecursiveMemoized(s1, s2.substring(1));
      int size2 = findLCSRecursiveMemoized(s1.substring(1), s2);
      int max = Math.max(size1,size2);
      cachedSizesOfLCS.put(s1 + ":" + s2,max);
      return max;
    }
  }

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int findLCSRecursive(String s1,
                                     String s2){
    if(s1.length() == 0
        || s2.length() == 0){
      return 0;
    }
    if(s1.charAt(0)
        == s2.charAt(0)){
      return findLCSRecursive(s1.substring(1),s2.substring(1)) + 1;
    }
    else{
      return Math.max(findLCSRecursive(s1,s2.substring(1)),
          findLCSRecursive(s1.substring(1),s2));
    }
  }

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
    public static int findLongestCommonSubsequence(String s1,
                                                   String s2){
      int maxCount = -1;
      int j = 0;
      for(int i = 0 ;i < s1.length() ; i++){
        int size = findSizeOfCommonSubsequence(s1,s2,i);
        if(size > maxCount){
          maxCount = size;
        }
      }
      return maxCount;
    }

  /**
   *
   * @param s1
   * @param s2
   * @param s1Begin
   * @return
   */
   public static int findSizeOfCommonSubsequence(String s1,String s2,
                                                 int s1Begin){
     int sizeOfSubsequence = 0;
     int s2Begin = 0;
     for(int i = s1Begin; i < s1.length() ; i++){
       for(int j = s2Begin; j < s2.length() ; j++){
         if(s1.charAt(i) == s2.charAt(j)){
           //System.out.print(s1.charAt(i) + " ");
           sizeOfSubsequence++;
           s2Begin = j + 1;
         }
       }
     }
     //System.out.println();
     return sizeOfSubsequence;
   }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s1 = "ABCDGH";
    String s2 = "AEDFHR";
    //LCS = ADH
    System.out.println(findLongestCommonSubsequence(s1, s2));
    System.out.println(findLCSRecursive(s1, s2));
    System.out.println(findLCSRecursiveMemoized(s1, s2));
    memoizationCache = new int[s1.length()][s2.length()];
    System.out.println(findLCSRecursiveMemoizedAlternate(s1,s2,0,0));
    /*
    “AGGTAB” and “GXTXAYB”
     */
    cachedSizesOfLCS = new HashMap<>();
    s1 = "AGGTAB";
    s2 = "GXTXAYB";
    System.out.println(findLongestCommonSubsequence(s1,s2));
    System.out.println(findLCSRecursive(s1, s2));
    System.out.println(findLCSRecursiveMemoized(s1, s2));
    memoizationCache = new int[s1.length()][s2.length()];
    System.out.println(
        findLCSRecursiveMemoizedAlternate(s1,s2,0,0));
  }

}
