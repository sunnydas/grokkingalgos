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
    a = "sunny";
    b = "das";
    c = "sdaunnys";
    System.out.println(isInterLeaving(a,b,c));
    a = "ten";
    b = "twenty";
    c = "tentwentu";
    System.out.println(isInterLeaving(a,b,c));
  }
}
