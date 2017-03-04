package com.sunny.grokkingalgorithms.harryhe.chap2;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sundas on 3/4/2017.
 */
class MyString{
  private String data;

  public MyString(String val){
    this.data = val;
  }
}
public class HashCodeVerifier {
  
  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Map<String,Integer> map1 = new HashMap<>();
    String str1 = new String("Hello World");
    String str2 = new String("Hello World");
    map1.put(str1,new Integer(10));
    map1.put(str2,new Integer(20));
    MyString str3 = new MyString("Hello World");
    MyString str4 = new MyString("Hello World");
    Map<MyString,Integer> map2 = new HashMap<>();
    map2.put(str3,new Integer(10));
    map2.put(str4,new Integer(20));
    System.out.println(map1.get(str1));
    System.out.println(map2.get(str3));
  }
}
