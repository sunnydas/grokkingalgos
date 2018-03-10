package com.sunny.grokkingalgorithms.ctci.c1;

/**
 * Created by sundas on 3/10/2018.
 */
public class IfOneStringIsPermutationOfAnother {

  /*
  Given a string , decide if one is a permutation of thr other
   */

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
  public static boolean isPermutationOfEachOther(String s1,String s2){
    boolean isPermutation = true;
    if(s1.length() == s2.length()){
      for(int i = 0 ; i < s1.length() ; i++){
        char c1 = s1.charAt(i);
        boolean found = false;
        for(int j = 0 ; j < s2.length() ; j++){
          if(s2.charAt(j) == c1){
            found = true;
            break;
          }
        }
        if(!found){
          isPermutation = false;
          break;
        }
      }
    }
    else{
      isPermutation = false;
    }
    return isPermutation;
  }

  public static boolean isPermutationOfEachOtherAlternate(String s1,String s2){
    boolean isPermutation = true;
    //Assumes only Ascii
    char[] countingSorter = new char[256];
    if(s1.length() == s2.length()){
    for(int i = 0 ; i < s1.length() ; i++){
      char c1 = s1.charAt(i);
      countingSorter[(int)c1]++;
    }
    for(int i = 0 ; i < s2.length() ; i++){
      char c1 = s2.charAt(i);
      if(countingSorter[(int)c1] == 0){
        isPermutation = false;
        break;
      }
    }
    }
    else{
     isPermutation = false;
    }
    return isPermutation;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s1 = "abc";
    String s2 = "bca";
    System.out.println(isPermutationOfEachOther(s1,s2));
    s1 = "abcbca";
    System.out.println(isPermutationOfEachOther(s1,s2));
    s1 = "aaa";
    s2 = "aaa";
    System.out.println(isPermutationOfEachOther(s1,s2));
    s1 = "abcd";
    s2 = "cabd";
    System.out.println(isPermutationOfEachOther(s1,s2));
    //
    System.out.println("Alternate #####");
    s1 = "abc";
    s2 = "bca";
    System.out.println(isPermutationOfEachOtherAlternate(s1,s2));
    s1 = "abcbca";
    System.out.println(isPermutationOfEachOtherAlternate(s1,s2));
    s1 = "aaa";
    s2 = "aaa";
    System.out.println(isPermutationOfEachOtherAlternate(s1,s2));
    s1 = "abcd";
    s2 = "cabd";
    System.out.println(isPermutationOfEachOtherAlternate(s1,s2));
  }
}
