package com.sunny.grokkingalgorithms.ctci.c1;

/**
 * Created by sundas on 3/13/2018.
 */
public class IsS2ARotationOfS1 {

  /*
  Given two strings , check if s2 is a rotation of s1 we are given a function substring
  wateebottle is a rotation of erbottlewat
   */

  public static boolean isRotation(String s1,String s2){
    return isSubString(s1+s1,s2);
  }

  /*
  Check if s2 is a substring of s1
   */
  public static boolean isSubString(String s1,String s2){
    return s1.contains(s2);
  }

  public static void main(String[] args) {
    String s1 = "waterbottle";
    String s2 = "erbottlewat";
    System.out.println(isRotation(s1,s2));
    s1 = "waterbottles";
    s2 = "erbottlewat";
    System.out.println(isRotation(s1,s2));
  }
}
