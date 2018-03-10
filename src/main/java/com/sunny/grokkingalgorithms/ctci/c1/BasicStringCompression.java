package com.sunny.grokkingalgorithms.ctci.c1;

/**
 * Created by sundas on 3/10/2018.
 */
public class BasicStringCompression {

  /*
  Perform basic string compression
  aabbcc
  becomes
  a2b2c2
  abc
  becomes
  well
  abc
   */

  /**
   *
   * @param s
   * @return
   */
  public static String performBasicCompression(String s){
    if(countCompression(s) >= s.length()){
      return s;
    }
    StringBuilder compressionBuilder = new StringBuilder();
    int localCount =  0;
    char previous = s.charAt(0);
    for(int i = 1; i < s.length() ; i++){
      char currentChar = s.charAt(i);
      if(currentChar == previous){
        localCount++;
      }
      else{
        /*
        time to reset update count for character
         */
        updateCompressionValue(compressionBuilder, localCount, previous);
        /*
        resetting
         */
        localCount = 0;
        previous = currentChar;
      }
      //Corner case for last element
      if(i == (s.length() - 1)){
        updateCompressionValue(compressionBuilder, localCount, previous);
      }
    }
    return compressionBuilder.toString();
  }

  /**
   *
   * @param s
   * @return
   */
  public static int countCompression(String s){
    int count = 1;
    for(int i = 1 ; i < s.length() ; i++){
      if(s.charAt(i) == s.charAt(i-1)){
        count++;
      }
    }
    return count;
  }

  private static void updateCompressionValue(StringBuilder compressionBuilder, int localCount, char previous) {
    compressionBuilder.append(previous);
    if(localCount > 0) {
      compressionBuilder.append(localCount + 1);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s = "aaabbccccccddefgh";
    System.out.println(performBasicCompression(s));
    s = "abcdefgh";
    System.out.println(performBasicCompression(s));
    s = "abaldjaaaabbbbbc";
    System.out.println(performBasicCompression(s));
    s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbdakd;lakd;lakd;ladk;aldka;lsdk;lasdk;lasdkas;ldk;alsdk;alsdk;aleeeeeeeee";
    System.out.println(performBasicCompression(s));
    s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";
    System.out.println(performBasicCompression(s));
    s = "aa";
    System.out.println(performBasicCompression(s));
  }
}
