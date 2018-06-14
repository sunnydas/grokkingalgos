package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import java.util.*;

/**
 * Created by sundas on 6/14/2018.
 */
public class SubSetSum {

  /*
  Given an array of non negative integers and a positive number X.
  Check if a subset exists such that sum is equal to X.
  For example:
  3 2 7 1
  X= 6
  subset = 3,2,1
   */


  /**
   *
   * @param input
   * @param k
   * @return
   */
  public static boolean isSubSetPossibleDP(int[] input,int k){
    boolean[][] dp = new boolean[input.length][k + 1];
    /*
    First column will always be true
     */
    for(int i = 0 ; i < dp.length ; i++){
      dp[i][0] = true;
    }
    /*
    First row will be true only when input[0] ==  j
     */
    for(int j = 1; j < dp[0].length ; j++){
      if(j == input[0]){
        dp[0][j] = true;
      }
    }
    /*
    Now first row and firs columns are populated correctly.
    Time to process
     */
    for(int i = 1 ; i < dp.length ; i++){
      int v = input[i];
      for(int j = 1 ; j < dp[i].length ; j++){
        if(v > j){
          /*
          Take from previous row
           */
          dp[i][j] = dp[i - 1][j];
        }
        else{
          /*
          Subtract current value and see if previous subset was valid
           */
          dp[i][j] = dp[i-1][j] || dp[i - 1][j - v];
        }
      }
    }
    for(int i = 0; i < dp.length ; i++){
      for(int j = 0 ; j < dp[i].length ; j++){
        System.out.print(dp[i][j] + " ");
      }
      System.out.println();
    }
    return dp[input.length - 1][k];
  }

  /**
   *
   * @param input
   * @param k
   * @return
   */
  public static boolean isSubSetPossible(List<Integer> input,int k){
    if(k == 0){
      return true;
    }
    if(input == null || input.size() <= 0){
      return false;
    }
    List<Integer> cloned = new ArrayList<>(input);
    int current = cloned.remove(0);
    boolean possible1 = isSubSetPossible(cloned,k - current);
    boolean possible2 = isSubSetPossible(cloned,k);
    return possible1 || possible2;
  }

  /**
   *
   *
   * @param input
   * @return
   */
  public static Set<String> findAllSubsetsEqualToSum(List<Integer> input,int k){
    Set<String> subSets = findAllPossibleSubSets(input);
    System.out.println(subSets);
    System.out.println(subSets.size());
    Set<String> possibleSubsets = new HashSet<>();
    if(subSets != null && !subSets.isEmpty()){
      for(String s : subSets){
        int sum = findSum(s);
        if(sum == k){
          possibleSubsets.add(s);
        }
      }
    }
    return possibleSubsets;
  }

  /**
   *
   * @param s
   * @return
   */
  public static int findSum(String s){
    int sum = 0;
    if(s != null){
      for(int i = 0 ; i < s.length() ; i++){
        sum += Integer.parseInt(""+s.charAt(i));
      }
    }
    return sum;
  }

  /**
   *
   * @param input
   * @return
   */
  public static Set<String> findAllPossibleSubSets(List<Integer> input){
    if(input.size() <= 0){
      Set<String> emptySet = new HashSet<>();
      emptySet.add("");
      return emptySet;
    }
    int firstElem = input.get(0);
    List<Integer> cloned = new ArrayList<>(input);
    cloned.remove(0);
    Set<String> childSubsets = findAllPossibleSubSets(cloned);
    Set<String> subsetsAtCurrentLevel = new HashSet<>();
    if(childSubsets != null
        && !childSubsets.isEmpty()){
      if(childSubsets.size() == 1
          && childSubsets.contains("")){
        childSubsets.add(""+firstElem);
        subsetsAtCurrentLevel.addAll(childSubsets);
      }
      else{
        Iterator<String> iterator = childSubsets.iterator();
        while(iterator.hasNext()){
          String set = iterator.next();
          if(set != null){
            String newSet = firstElem + set;
            subsetsAtCurrentLevel.add(newSet);
          }
        }
        subsetsAtCurrentLevel.addAll(childSubsets);
      }
    }
    return subsetsAtCurrentLevel;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    List<Integer> input = new ArrayList<>();
    input.add(3);
    input.add(2);
    input.add(7);
    input.add(1);
    int k = 6;
    System.out.println(findAllSubsetsEqualToSum(input,k));
    System.out.println(isSubSetPossible(input, 6));
    System.out.println(isSubSetPossible(input, 100));
    System.out.println("##### dp #####:wq" +
        "");
    int[] input1 = new int[]{3,2,7,1};
    System.out.println(isSubSetPossibleDP(input1,6));
    input1 = new int[]{2, 3, 7, 8};
    System.out.println(isSubSetPossibleDP(input1,11));
  }
}
