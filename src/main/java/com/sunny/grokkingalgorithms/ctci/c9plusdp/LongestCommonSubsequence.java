package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.*;

/**
 * Created by sundas on 4/9/2018.
 */
public class LongestCommonSubsequence {

  /*
  We have discussed Overlapping Subproblems and Optimal Substructure properties in Set 1 and Set 2 respectively. We also discussed one example problem in Set 3. Let us discuss Longest Common Subsequence (LCS) problem as one more example problem that can be solved using Dynamic Programming.

LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”. So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison program that outputs the differences between two files), and has applications in bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
   */

  /**
   *
   * @param str1
   * @param str2
   * @return
   */
  public static int findLengthOfLongestCommonSubsequenceBruteForce(String str1,String str2){
    int length = Integer.MIN_VALUE;
    Set<String> allSubsequences1 = findAllSubsequences(str1);
    Set<String> allSubsequences2 = findAllSubsequences(str2);
    Iterator<String> iterator = allSubsequences1.iterator();
    while(iterator.hasNext()){
      String subsequence = iterator.next();
      if(allSubsequences2.contains(subsequence) && subsequence.length() > length){
        length = subsequence.length();
      }
    }
    return length;
  }

  /**
   *
   * @param str
   * @return
   */
  public static Set<String> findAllSubsequences(String str){
    if(str.equals("")){
      Set<String> subsequences = new HashSet<>();
      subsequences.add(str);
      return subsequences;
    }
    Set<String> subsequences = new HashSet<>();
    char current = str.charAt(0);
    str = new StringBuilder(str).deleteCharAt(0).toString();
    Set<String> childSubsequences = findAllSubsequences(str);
    for(String subsequence: childSubsequences){
      StringBuilder newSequence = new StringBuilder();
      newSequence.append(current);
      newSequence.append(subsequence);
      subsequences.add(newSequence.toString());
    }
    subsequences.addAll(childSubsequences);
    return subsequences;
  }


  /**
   *
   * @param str1
   * @param str2
   * @return
   */
  public static int findLengthOfLongestCommonSubsequence(String str1,String str2){
    int length = 0;
    /*abcdaf/ acbcf
    0 0 0 0 0 0 0
    0 1 1 1 1 1 1
    0 1 1 2 2 2 2
    0 1 2 2 2 2 2
    0 1 2 3 3 3 3
    0 1 2 3 3 3 4
     */
    int[][] matrix = new int[str2.length()+1][str1.length()+1];
    for(int i = 1; i < matrix.length; i++){
      for(int j = 1; j < matrix[i].length ; j++){
        /*
        Very important
         */
        /*
        If match then add max from previous + 1
         */
        if(str2.charAt(i-1) == str1.charAt(j - 1)){
          matrix[i][j] = matrix[i-1][j-1] + 1;
        }
        else{
          // previous left or before.
          matrix[i][j] = Math.max(matrix[i-1][j],matrix[i][j-1]);
        }
      }
    }
    ZeroOneKnapSackProblem.print2DMatrix(matrix);
    return matrix[str2.length()][str1.length()];
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String str1 =  "abcdaf";
    String str2 = "acbcf";
    System.out.println();
    System.out.println(findLengthOfLongestCommonSubsequence(str1,str2));
    System.out.println(findLengthOfLongestCommonSubsequenceBruteForce(str1,str2));
  }


}
