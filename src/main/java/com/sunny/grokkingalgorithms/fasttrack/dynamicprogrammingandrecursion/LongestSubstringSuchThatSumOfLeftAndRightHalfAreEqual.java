package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class LongestSubstringSuchThatSumOfLeftAndRightHalfAreEqual {


  /**
   * Find longest subsequence, such that sum of left half of subsequence and
   * sum of right half of subsequence are equal.
   */

  /**
   *
   * @param s
   * @return
   */
  public static String findLongestSubsequence(String s){
    int i = 0;
    String longestSubsequence = "";
    while(i < s.length()){
      /*
      Outer loop to drive iteration
       */
      String longestSubsequenceInRange = longestSubseQuenceInRange(s,i,s.length() - 1);
      if(longestSubsequenceInRange != null
          && longestSubsequenceInRange.length() > longestSubsequence.length()){
        longestSubsequence = longestSubsequenceInRange;
      }
      i++;
    }
    return longestSubsequence;
  }

  /**
   *
   * @param s
   * @param i
   * @param end
   * @return
   */
  public static String longestSubseQuenceInRange(String s,int i,int end){
    String longestSubsequence = null;
    int index = end;
    while(index >= i){
      if(isValid(s,i,index)){
        longestSubsequence = s.substring(i,index+1);
        break;
      }
      index--;
    }
    return longestSubsequence;
  }

  /**
   *
   * @param s
   * @param start
   * @param end
   * @return
   */
  public static boolean isValid(String s,int start,int end){
    boolean valid = true;
    if((end - start + 1)%2 != 0){
      valid = false;
      return valid;
    }
    int i = start;
    int j = end;
    int sumFirstHalf = 0;
    int sumSecondHalf = 0;
    while(i < j){
      sumFirstHalf += Integer.parseInt(""+s.charAt(i));
      sumSecondHalf += Integer.parseInt(""+s.charAt(j));
      i++;
      j--;
    }
    if(sumFirstHalf != sumSecondHalf){
      valid = false;
    }
    return valid;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s1 = "142124";
    String s2 = "9430723";
    String s3 = "123";
    String s4 = "1234";
    String s5 = "123407";
    System.out.println(findLongestSubsequence(s1));
    System.out.println(findLongestSubsequence(s2));
    System.out.println(findLongestSubsequence(s3));
    System.out.println(findLongestSubsequence(s5));
  }

}
