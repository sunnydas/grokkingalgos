package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by sundas on 6/13/2018.
 */
public class EditDistance {

  /**
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int findMinimumEditDistanceDP(String s1,String s2){
    int[][] editDP = new int[s1.length() + 1][s2.length() + 1];
    /*
    Populate row 1
     */
    for(int j = 0 ; j < editDP[0].length ; j++){
      editDP[0][j] = j;
    }
    /*
    Populate column 1
     */
    for(int i = 1; i < editDP.length ; i++){
      editDP[i][0] = i;
    }
    for(int i = 1; i < editDP.length ;i++){
      for(int j = 1 ; j < editDP[i].length ; j++){
        if(s1.charAt(i - 1) == s2.charAt(j - 1)){
          editDP[i][j] = editDP[i - 1][j - 1];
        }
        else{
          editDP[i][j] = Math.min(Math.min(editDP[i - 1][j - 1],
              editDP[i - 1][j]),
              editDP[i][j-1]) + 1;
        }
      }
    }
    for(int i = 0 ; i < editDP.length ; i++){
      for(int j = 0 ; j < editDP[i].length ; j++){
        System.out.print(editDP[i][j] + " ");
      }
      System.out.println();
    }
    return editDP[editDP.length - 1][editDP[0].length - 1];
  }

  /*
  Calculate minimu edit distance (inder/replace/remove) of changing
  one string to another
   */

  public static int findMinimumEditDistanceUsingRecursion(String s1,
                                                          String s2){
    if(s1 == null && s2 == null){
      return 0;
    }
    if(s1 == null || s1.equals("")){
      return s2.length();
    }
    if(s2 == null || s2.equals("")){
      return s1.length();
    }
    /*
    Both characters are ewual check for min edit distance next
     */
    if(s1.charAt(0) == s2.charAt(0)){
      return findMinimumEditDistanceUsingRecursion(s1.substring(1),
          s2.substring(1));
    }
    int i = Integer.MAX_VALUE;
    int d = Integer.MAX_VALUE;
    int u = Integer.MAX_VALUE;
    i = findMinimumEditDistanceUsingRecursion(s2.charAt(0) + s1,s2);
    d = findMinimumEditDistanceUsingRecursion(s1.substring(1),s2);
    u = findMinimumEditDistanceUsingRecursion(s1.substring(1),s2.substring(1));
    return Math.min(Math.min(i,d),u) + 1;
  }

  /**
   * Minimum edit distance to convert s1 to s2
   *
   *
   * @param s1
   * @param s2
   * @return
   */
  public static int minEditDistance(String s1,String s2){
    int minEditDistance = 0;
    /*
    If both strings are equal min edit distance
    will be the unmatched characters
     */
    if(s1.length() == s2.length()){
      int index = 0;
      while(index < s1.length()){
        if(s1.charAt(index) != s2.charAt(index)){
          minEditDistance++;
        }
        index++;
      }
    }
    else if(s2.length() > s1.length()){
      int commonCharactersSize = 0;
      StringBuilder s1Builder = new StringBuilder(s1);
      StringBuilder s2Builder = new StringBuilder(s2);
      for(int i = 0 ; i < s2Builder.length() ; i++){
        int curIndex = -1;
        if((curIndex =
            s1Builder.indexOf(""+s2Builder.charAt(i))) != -1){
          s1Builder.replace(curIndex,curIndex+1,"*");
          commonCharactersSize++;
        }
      }
      minEditDistance =  s2.length() - commonCharactersSize;
    }
    else{
      /*
      s1.length > s2.length
       */
      int commonCharactersSize = 0;
      StringBuilder s1Builder = new StringBuilder(s1);
      StringBuilder s2Builder = new StringBuilder(s2);
      for(int i = 0 ; i < s1Builder.length() ; i++){
        int curIndex = -1;
        if((curIndex =
            s2Builder.indexOf(""+s1Builder.charAt(i))) != -1){
          s2Builder.replace(curIndex,curIndex+1,"*");
          commonCharactersSize++;
        }
      }
      minEditDistance =  s1.length() - commonCharactersSize;
    }
    return minEditDistance;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(minEditDistance("SUNDAY","SATURDAY"));
    System.out.println(minEditDistance("CAT","CAR"));
    System.out.println(minEditDistance("MATE","SALT"));
    System.out.println(minEditDistance("SORT","SPORT"));
    System.out.println(minEditDistance("SPORT","SORT"));
    System.out.println(minEditDistance("RETURNY","REB"));
    System.out.println(minEditDistance("ABCD","XYZ"));
    System.out.println(minEditDistance("XYZ","ABCD"));
    System.out.println(minEditDistance("ABCD","AYZ"));
    System.out.println(minEditDistance("BARK","ARK"));
    System.out.println("#######");
    System.out.println(findMinimumEditDistanceUsingRecursion("SUNDAY", "SATURDAY"));
    System.out.println(findMinimumEditDistanceUsingRecursion("CAT", "CAR"));
    System.out.println(findMinimumEditDistanceUsingRecursion("MATE", "SALT"));
    System.out.println(findMinimumEditDistanceUsingRecursion("SORT", "SPORT"));
    System.out.println(findMinimumEditDistanceUsingRecursion("SPORT", "SORT"));
    System.out.println(findMinimumEditDistanceUsingRecursion("RETURNY", "REB"));
    System.out.println(findMinimumEditDistanceUsingRecursion("ABCD", "XYZ"));
    System.out.println(findMinimumEditDistanceUsingRecursion("XYZ", "ABCD"));
    System.out.println(findMinimumEditDistanceUsingRecursion("ABCD", "AYZ"));
    System.out.println(findMinimumEditDistanceUsingRecursion("BARK", "ARK"));
    System.out.println("######################");
    System.out.println(findMinimumEditDistanceDP("SUNDAY", "SATURDAY"));
    System.out.println(findMinimumEditDistanceDP("CAT", "CAR"));
    System.out.println(findMinimumEditDistanceDP("MATE", "SALT"));
    System.out.println(findMinimumEditDistanceDP("SORT", "SPORT"));
    System.out.println(findMinimumEditDistanceDP("SPORT", "SORT"));
    System.out.println(findMinimumEditDistanceDP("RETURNY", "REB"));
    System.out.println(findMinimumEditDistanceDP("ABCD", "XYZ"));
    System.out.println(findMinimumEditDistanceDP("XYZ", "ABCD"));
    System.out.println(findMinimumEditDistanceDP("ABCD", "AYZ"));
    System.out.println(findMinimumEditDistanceDP("BARK","ARK"));
  }

}
