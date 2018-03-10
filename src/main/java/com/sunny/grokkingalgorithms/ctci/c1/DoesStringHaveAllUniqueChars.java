package com.sunny.grokkingalgorithms.ctci.c1;

/**
 * Created by sundas on 3/10/2018.
 */
public class DoesStringHaveAllUniqueChars {

  /*
  Does string have all unique characters without extra data structures
   */

  /**
   *
   * @param s
   * @return
   */
  public static boolean areAllChractersUnique(String s){
    boolean isUnique = true;
    for(int i = 0 ; i < s.length() ; i++){
      for(int j = i+1; j < s.length() ; j ++){
        if(s.charAt(i) == s.charAt(j)){
          isUnique = false;
          break;
        }
      }
    }
    return isUnique;
  }


  public static void main(String[] args) {
    String s = "abc";
    System.out.println(areAllChractersUnique(s));
    s = "def";
    System.out.println(areAllChractersUnique(s));
    s = "aabbccrgfs";
    System.out.println(areAllChractersUnique(s));
    s = "a";
    System.out.println(areAllChractersUnique(s));
    s = "abcdefghijklmnopraqa";
    System.out.println(areAllChractersUnique(s));
  }

}
