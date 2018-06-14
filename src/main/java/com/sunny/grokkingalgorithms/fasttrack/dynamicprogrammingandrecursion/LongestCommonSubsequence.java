package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sundas on 6/14/2018.
 */
public class LongestCommonSubsequence {

  /*
  Given two strings find count of the longest common subsequence
   */

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
    System.out.println(findLongestCommonSubsequence(s1,s2));
    System.out.println(findLCSRecursive(s1,s2));
    /*
    “AGGTAB” and “GXTXAYB”
     */
    s1 = "AGGTAB";
    s2 = "GXTXAYB";
    System.out.println(findLongestCommonSubsequence(s1,s2));
    System.out.println(findLCSRecursive(s1,s2));
  }

}
