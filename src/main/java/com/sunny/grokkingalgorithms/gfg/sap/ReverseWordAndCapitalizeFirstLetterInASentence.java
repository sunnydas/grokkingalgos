package com.sunny.grokkingalgorithms.gfg.sap;

/**
 * Created by sundas on 5/7/2017.
 */
public class ReverseWordAndCapitalizeFirstLetterInASentence {

  /*
  to reverse each word of a sentence with starting letter to be in CAPS
Input: my nAMe is john.
Output: Ym Eman Si Nhoj.
   */

  /**
   *
   * @param sentence
   * @return
   */
  public static String reverse(String sentence){
    String[] words = sentence.split(" ");
    StringBuilder reversed = new StringBuilder();
    for(String word : words){
      reversed.append(reverseAndCapitalize(word));
      /*
      If we want to preserve the spaces we can note down the indexes
       */
      reversed.append(" ");
    }
    return reversed.toString();
  }

  /**
   *
   * @param word
   * @return
   */
  public static String reverseAndCapitalize(String word){
    int left = 0;
    int right = word.length() - 1;
    char[] reversed = new char[word.length()];
    while(left < right){
      char rightChar = word.charAt(right);
      if(left == 0 && rightChar > 96){
        rightChar -= 32;
      }
      reversed[left] = rightChar;
      reversed[right] = word.charAt(left);
      left++;
      right--;
    }
    return String.valueOf(reversed);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String sentence = "my name is john";
    System.out.println(reverse(sentence));
  }
}
