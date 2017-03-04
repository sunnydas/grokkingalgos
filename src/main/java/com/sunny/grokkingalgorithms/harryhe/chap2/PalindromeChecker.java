package com.sunny.grokkingalgorithms.harryhe.chap2;

import java.util.Scanner;


/**
 * Created by sundas on 3/4/2017.
 */
public class PalindromeChecker {

  /*
  Check if a positive number is palindrome or not
   */
  public static boolean isPalindromeV1(int number){
    boolean palindrome = true;
    String str = ""+number;
    int i = 0;
    int j = str.length() - 1;
    while(i < j){
      if(str.charAt(i) != str.charAt(j)){
        palindrome = false;
        break;
      }
      i++;
      j--;
    }
    // o(n) time + o(n) space
    return palindrome;
  }


  public static boolean isPalindromeV2(int number){
    return reverseNumber(number) == number;
  }

  public static int reverseNumber(int number){
    int reverse = 0;
    while(number > 0){
      reverse = reverse*10 + number%10;
      number = number/10;
    }
    return reverse;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int number = scanner.nextInt();
    System.out.println(isPalindromeV1(number));
    System.out.println(isPalindromeV2(number));
  }

}
