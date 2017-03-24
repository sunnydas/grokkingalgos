package com.sunny.grokkingalgorithms.gfg.amz.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sundas on 3/22/2017.
 */
public class AlgoUtil {


  /**
   * Basically an implementation of n C R
   *
   *
   * @param input
   * @return
   */
  public static List<List<Integer>> generatePowerSet(List<Integer> input,List<List<Integer>> combinations){
    if(input.size() <= 0){
      return combinations;
    }
    else if(input.size() == 1){
      combinations.add(input);
      return combinations;
    }
    else{
      for(int i = 0 ; i < input.size(); i++){
        // Very crucial code.
        int currentElement = input.remove(0);
        combinations = generatePowerSet(input, combinations);
        combinations = insertionFlow(combinations,currentElement);
        List<Integer> selfCombination = new ArrayList<>();
        selfCombination.add(currentElement);
        combinations.add(selfCombination);
      }
    }
    return combinations;
  }

  /**
   *
   * @param source
   * @return
   */
  public static List<Integer> copy(List<Integer> source,int index){
    List<Integer> destination = new ArrayList<>();
    for(int i = index; i < source.size() ; i++){
      destination.add(new Integer(source.get(i)));
    }
    return destination;
  }

  /**
   *
   * @param combinations
   * @param val
   * @return
   */
  public static List<List<Integer>> insertionFlow(List<List<Integer>> combinations,int val){
    List<List<Integer>> newcOmbinations = new ArrayList<>();
    for(int i = 0 ; i < combinations.size() ; i++){
      List<Integer> combination = combinations.get(i);
      //for(int j = 0 ; j < combination.size() ; j++){
      List<Integer> newCombination = copy(combination,0);
      newCombination.add(val);
      newcOmbinations.add(newCombination);
      //}
    }
    combinations.addAll(newcOmbinations);
    return combinations;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    List<Integer> input = new ArrayList<>();
    for(int i = 0 ; i < n ; i++){
      input.add(scanner.nextInt());
    }
    List<List<Integer>> combinations = new ArrayList<>();
    System.out.println(generatePowerSet(input, combinations));
    System.out.println(combinations.size());
  }

}
