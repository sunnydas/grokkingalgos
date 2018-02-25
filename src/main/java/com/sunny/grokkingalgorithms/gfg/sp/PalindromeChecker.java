package com.sunny.grokkingalgorithms.gfg.sp;

/**
 * Created by sundas on 5/6/2017.
 */
public class PalindromeChecker {


  /**
   *
   * @return
   */
  public static boolean isPalindrome(String str){
    boolean isPalindrome = false;
    if(str != null && str.length() > 0) {
      int left = 0;
      int right = str.length() - 1;
      while(left < right){
        if(str.charAt(left) == ' '){
          left++;
        }
        if(str.charAt(right) == ' '){
          right--;
        }
        if(str.charAt(left) != str.charAt(right)){
          break;
        }
        left++;
        right--;
      }
      if(left < right){
        isPalindrome = false;
      }
      else{
        isPalindrome = true;
      }
    }
    return isPalindrome;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String str1 = "a b                                                      b a ";
    String str2 = "malayalam";
    String str3 = "normal sentence";
    System.out.println(isPalindrome(str1));
    System.out.println(isPalindrome(str2));
    System.out.println(isPalindrome(str3));
  }
}
