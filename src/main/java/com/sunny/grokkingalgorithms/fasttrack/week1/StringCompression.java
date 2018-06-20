package com.sunny.grokkingalgorithms.fasttrack.week1;

/**
 * Created by sundas on 6/20/2018.
 */
public class StringCompression {

  /**
   *
   * @param s
   * @return
   */
  public static String compress(String s){
    StringBuilder output = new StringBuilder();
    int i = 1;
    char curentChar = s.charAt(0);
    int currentCount = 1;
    while(i < s.length()){
      char c = s.charAt(i);
      if(curentChar == c){
        currentCount++;
        if(i == s.length() - 1){
          output.append((char)curentChar);
          output.append(currentCount);
        }
      }
      else{
        output.append((char)curentChar);
        output.append(currentCount);
        curentChar = c;
        currentCount = 1;
      }
      i++;
    }
    return output.toString();
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s = "AAAABBCDDDDD";
    /*
    should become : A3B2C1D5
     */
    System.out.println(compress(s));
    s = "ABCD";
    System.out.println(compress(s));
    s = "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA";
    System.out.println(compress(s));
  }
}
