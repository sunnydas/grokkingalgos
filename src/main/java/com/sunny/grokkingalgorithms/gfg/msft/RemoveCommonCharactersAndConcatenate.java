package com.sunny.grokkingalgorithms.gfg.msft;

import java.util.*;

/**
 * Created by sundas on 4/30/2018.
 */
public class RemoveCommonCharactersAndConcatenate {

  /*
  Two strings are given. Modify 1st string such that all the common characters of the 2nd strings have to be removed and the uncommon characters of the 2nd string have to be concatenated with uncommon characters of the 1st string.

Note: If the modified string is empty then print '-1'.

Input:
The first line consists of an integer T i.e number of test cases. The first line of each test case consists of a string s1.The next line consists of a string s2.

Output:
Print the required output.

Constraints:
1<=T<=200
1<=|Length of Strings|<=100

Example:
Input:
2
aacdb
gafd
abcs
cxzca

Output:
cbgf
bsxz
   */

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
  public static String removeAndConcatenate(String s1,String s2){
    String finalStr = null;
    String s3 = s1.concat(s2);
    StringBuilder stringBuilder = new StringBuilder();
    char[] s3chars = s3.toCharArray();
    for(int i = 0; i < s3chars.length ; i++){
       boolean duplicate = false;
       for(int j = 0; j < s3chars.length ; j++){
         if(i == j){
           continue;
         }
         if(s3chars[i] == s3chars[j]){
           duplicate = true;
           break;
         }
       }
      if(!duplicate){
        stringBuilder.append(s3chars[i]);
      }
    }
    finalStr = stringBuilder.toString();
    return finalStr;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s1 = "aacdb";
    String s2 = "gafd";
    System.out.println(removeAndConcatenate(s1,s2));
    s1 = "abcs";
    s2 = "cxzca";
    System.out.println(removeAndConcatenate(s1,s2));
  }
}
