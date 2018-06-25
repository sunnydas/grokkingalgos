package com.sunny.grokkingalgorithms.fasttrack.week2;

/**
 * Created by sundas on 6/25/2018.
 */
public class StringPatternMatching {

  /*
  Naive approach
   */

  /**
   *
   * @param s
   * @param pattern
   * @return
   */
  public static int match(String s, String pattern){
    int index = -1;
    /*
    Sliding window approach
     */
    for(int i = 0 ; i < s.length() ; i++){
      char current = s.charAt(i);
      boolean subStringExists = checkIfSubStringExists(s,i,pattern);
      if(subStringExists){
        index = i;
        break;
      }
      else if(pattern.length()
          > (s.length() - 1 - i + 1)){
        break;
      }
    }
    return index;
  }

  /**
   *
   * @param s
   * @param i
   * @param pattern
   * @return
   */
  public static boolean checkIfSubStringExists(String s,
                                               int i,
                                               String pattern){
    boolean matched = false;
    int count =  0;
    for(int j = 0 ; j < pattern.length() ; j++){
      if(i < s.length()
          && s.charAt(i) == pattern.charAt(j)){
        count++;
        i++;
      }
      else{
        break;
      }
    }
    if(count == pattern.length()){
      matched = true;
    }
    return matched;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s =  "abcdefgh";
    String pattern = "cde";
    System.out.println(match(s,pattern));
    pattern = "xyz";
    System.out.println(match(s,pattern));
    s = "abc";
    pattern = "abc";
    System.out.println(match(s,pattern));
    pattern = "abcd";
    System.out.println(match(s,pattern));
  }


}
