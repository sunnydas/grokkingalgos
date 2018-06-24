package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 */
class VersionComparator implements Comparator<String>{

  @Override
  public int compare(String o1, String o2) {
    if(o1 != null
        && o2 != null){
      String[] o1Versions = o1.split("\\.");
      String[] o2Versions = o2.split("\\.");
      int o1Index = 0;
      int o2Index = 0;
      int compareVal = Integer.MAX_VALUE;
      while(o1Index < o1Versions.length
          && o2Index < o2Versions.length){
        if(Integer.parseInt(o1Versions[o1Index]) <
            Integer.parseInt(o2Versions[o2Index])){
          compareVal = -1;
          break;
        }
        else if(Integer.parseInt(o1Versions[o1Index]) >
            Integer.parseInt(o2Versions[o2Index])){
          compareVal = 1;
          break;
        }
        o1Index++;
        o2Index++;
      }
      if(compareVal == Integer.MAX_VALUE){
        /*
        We havent reached a decision yet so we know that
        one string was gerater than the other
         */
         compareVal = o1Versions.length - o2Versions.length;
      }
      return compareVal;
    }
    return 1;
  }
}
/**
 * Created by sundas on 6/24/2018.
 */
public class SortVersionInfo {

  /*
  Given a list of versions (in string format). The versions can have invalid characters (requires cleaning). Print the list in sorted order of increasing versions.
Input: ["1.2.34", "$5.j8", "3.4#", "3.45"]
output: 1.2, 3.4, 3.45
   */

  /**
   *
   * @param input
   * @return
   */
  public static String[] cleanAndSort(String[] input){
    /*
    Clean input
     */
    cleanInput(input);
    /*
    Sort input
     */
    Arrays.parallelSort(input,new VersionComparator());
    return input;
  }

  /**
   *
   * @param input
   */
  public static void cleanInput(String[] input){
     if(input != null){
       /*String regex = "[^0-9][.]*";
       Pattern pattern = Pattern.compile(regex);*/
       for(int i = 0 ; i < input.length ; i++){
         String s = input[i];
         StringBuilder builder = new StringBuilder();
         int j = 0;
         int builderIndex = 0;
         while(j < s.length()){
           char c = s.charAt(j);
           if(Character.isDigit(c) ||
               c == '.'){
             builder.append(c);
             builderIndex++;
           }
           if(j == s.length() - 1
               && builder.charAt(builderIndex - 1) == '.'){
             builder.deleteCharAt(builderIndex - 1);
           }
           j++;
         }
         if(builder.charAt(0) == '.'){
           builder.deleteCharAt(0);
         }
         input[i] = builder.toString();
       }
     }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] input = new String[]{"1.2.$$", "$5.j8", "3.4#", "3.45","@.2.4"};
    System.out.println("Input = " + Arrays.toString(input));
    System.out.println("Sorted = "
        + Arrays.toString(cleanAndSort(input)));
  }

}
