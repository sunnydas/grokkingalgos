package com.sunny.grokkingalgorithms.misc;

/**
 * Created by sundas on 5/30/2018.
 */
public class Print100Times {


  public static void main(String[] args) {
    String name = "name";
    String str = "X";
    str = str.replaceAll("X", "XXXXXXXXXX");
    //System.out.println(str.length());
    str = str.replaceAll("X", "XXXXXXXXXX");
    //System.out.println(str.length());
    //str = str.replaceAll("X", "XXXXXXXXXX");
    //System.out.println(str.length());
    //System.out.println(str);
    str = str.replaceAll("X", name + "\n");
    System.out.println(str);
    System.out.println(str.codePointCount(0,str.length()-1));
  }


}
