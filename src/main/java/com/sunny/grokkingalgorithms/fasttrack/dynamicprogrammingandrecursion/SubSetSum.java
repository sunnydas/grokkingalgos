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
  }
}
