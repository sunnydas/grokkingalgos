package com.sunny.grokkingalgorithms.gfg.amz;

/**
 * Created by sundas on 6/16/2017.
 */
public class FindFirstCharOfEveryWord {


  // http://www.geeksforgeeks.org/string-containing-first-letter-every-word-given-string-spaces/


  /**
   *
   * @param str
   * @return
   */
  public static String findFirstCharacterOfEveryWord(String str){
    StringBuilder builder = new StringBuilder();
    if(str != null){
      //The following regex line is very important
      String[] myWords = str.split("(\\s)+");
      for(String word : myWords){
        if(word != null) {
          builder.append(word.charAt(0));
        }
      }
    }
    return builder.toString();
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String input = "Hello     this is a new     string    with multiple spaces    check it out   ";
    System.out.println(findFirstCharacterOfEveryWord(input));
  }

}
