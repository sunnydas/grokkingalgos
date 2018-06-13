package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/13/2018.
 */
public class StringInterleaving {

  /*
  Give two strings a and b and a third string c. Check if
  c is an interleaving of a and b
  for example: c = xabyczd is an interleaving of a = xyz and b = abcd
   */

  /**
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static boolean isInterLeavingRecursion(String a,String b,String c){
    if(a.equals("") && b.equals("") && c.equals("")){
      return true;
    }
    if(c.equals("")){
      return false;
    }
    if(a.equals("") && b.equals("")){
      return false;
    }
    boolean first = false;
    boolean second = false;
    if(a.charAt(0) == c.charAt(0)){
      first = isInterLeaving(a.substring(1),b,c.substring(1));
    }
    if(b.charAt(0) == c.charAt(0)){
      second = isInterLeaving(a,b.substring(1),c.substring(1));
    }
    return first || second;
  }

  /**
   *
   * @param a
   * @param b
   * @param c
   * @return
   */
  public static boolean isInterLeaving(String a,String b,String c){
    boolean interLeaved = false;
    if(a == null || b == null || c == null){
      return interLeaved;
    }
    if(c.length() != (a.length() + b.length())){
      return interLeaved;
    }
    /*
    Check if a's characters exist and are in order
     */
    StringBuilder cBuilder = new StringBuilder(c);
    int aIndex = 0;
    while(aIndex < a.length()){
      char current = a.charAt(aIndex);
      int index = -1;
      if((index = cBuilder.indexOf(""+current)) >= 0){
        cBuilder.deleteCharAt(index);
      }
      aIndex++;
    }
    if(cBuilder.toString().equals(b)){
      interLeaved = true;
    }
    return interLeaved;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String a = "xyz";
    String b = "abcd";
    String c = "xabyczd";
    System.out.println(isInterLeaving(a,b,c));
    System.out.println(isInterLeavingRecursion(a, b, c));
    System.out.println();
    a = "sunny";
    b = "das";
    c = "sdaunnys";
    System.out.println(isInterLeaving(a,b,c));
    System.out.println(isInterLeavingRecursion(a, b, c));
    System.out.println();
    a = "ten";
    b = "twenty";
    c = "tentwentu";
    System.out.println(isInterLeaving(a,b,c));
    System.out.println(isInterLeavingRecursion(a, b, c));
  }
}
