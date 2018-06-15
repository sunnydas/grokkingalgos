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
  public static int longestPalindromicSubsequenceDP(String s){
   int[][] dp = new int[s.length()][s.length()];
   for(int i = 0 ; i < dp.length ; i++){
     dp[i][i] = 1;
   }
   for(int l = 2 ; l <= s.length() ; l++){
     for(int i = 0 ; i < s.length() - l + 1; i++){
       int j = i + l - 1;
       if(l == 2
           && s.charAt(i) == s.charAt(j)){
         dp[i][j] = 2;
       }
       else if(s.charAt(i)
           == s.charAt(j)){
         dp[i][j] = 2 + dp[i + 1][j - 1];
       }
       else{
         dp[i][j] = Math.max(dp[i][j - 1],
             dp[i + 1][j]);
       }
     }
   }
   for(int i = 0 ; i < dp.length ; i++){
     for(int j = 0 ; j < dp[i].length ; j++){
       System.out.print(dp[i][j] + " ");
     }
     System.out.println();
   }
   return dp[0][dp[0].length - 1];
  }

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
    System.out.println(longestPalindromicSubsequenceDP(s));
    String str = "agbdba";
    System.out.println(longestPalindromicSubsequence(str));
    System.out.println(longestPalindromicSubsequenceDP(str));
  }

}
