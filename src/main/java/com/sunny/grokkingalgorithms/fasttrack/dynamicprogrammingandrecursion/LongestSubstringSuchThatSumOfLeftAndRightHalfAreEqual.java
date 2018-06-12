package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/12/2018.
 */
public class LongestSubstringSuchThatSumOfLeftAndRightHalfAreEqual {


  /**
   * Find longest subsequence, such that sum of left half of subsequence and
   * sum of right half of subsequence are equal.
   */

  public static String longestSubsequenceOptimized(String s){
    int len = s.length();
    int maxLength = 0;
    String longestSubsequence = "";
    for(int i = 0; i < len - 2 ; i++){
      int left = i;
      int right = i + 1;
      int leftSum = 0;
      int rightSum = 0;
      while(right < len && left >= 0){
        leftSum += s.charAt(left) - '0';
        rightSum += s.charAt(right) - '0';
        if(leftSum == rightSum){
          if((right - left + 1) > maxLength){
            maxLength = (right - left + 1);
            longestSubsequence = s.substring(left,right+1);
          }
        }
        left--;
        right++;
      }
    }
    return longestSubsequence;
  }

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
    System.out.println("################## optimized");
    System.out.println(longestSubsequenceOptimized(s1));
    System.out.println(longestSubsequenceOptimized(s2));
    System.out.println(longestSubsequenceOptimized(s3));
    System.out.println(longestSubsequenceOptimized(s5));
  }

}
