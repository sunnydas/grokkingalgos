package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/15/2018.
 */
public class LongestPalindromicSubsequence {

  /*
  Longest subsequence which is also a palindrome.
  BBABCBCAB
  longest subsequence = BABCBAB
   */

  /**
   *
   * @param s
   * @return
   */
  public static int longestPalindromicSubsequence(String s){
    if(s == null
        || s.length() <= 0){
      return 0;
    }
    if(s.length() == 1){
      return 1;
    }
    if(s.charAt(0) == s.charAt(s.length() - 1)){
      return longestPalindromicSubsequence(s.substring(1,s.length() - 1)) + 2;
    }
    else{
      return Math.max(longestPalindromicSubsequence(s.substring(1)),
          longestPalindromicSubsequence(s.substring(0,s.length() - 1)));
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
     String s = "BBABCBCAB";
    System.out.println(longestPalindromicSubsequence(s));
  }

}
