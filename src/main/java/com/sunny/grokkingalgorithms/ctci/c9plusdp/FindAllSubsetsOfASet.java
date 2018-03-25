package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 3/25/2018.
 */
public class FindAllSubsetsOfASet {

  /*
  Find all subsets of a set
   */

  /**
   *
   * @param input*
   * @return
   */
  public static List<List<Integer>> findAllSubsetsOFASet(List<Integer> input){
    if(input ==  null || input.size() <= 0){
      List<List<Integer>> subsets = new ArrayList<>();
      List<Integer> subset = new ArrayList<>();
      subsets.add(subset);
      return subsets;
    }
    int current = input.remove(0);
    List<List<Integer>> subsets = new ArrayList<>();
    //for(int i = 0; i < input.size() ; i++){
      List<List<Integer>> children = findAllSubsetsOFASet(input);
      if(children != null){
        if(children.isEmpty()){
          List<Integer> prependList = new ArrayList<>();
          prependList.add(current);
          subsets.add(prependList);
        }
        else {
          for (List<Integer> child : children) {
            List<Integer> prependedChild = new ArrayList<>(child);
            prependedChild.add(0,current);
            subsets.add(prependedChild);
          }
          subsets.addAll(children);
        }
      }
    //}
    return subsets;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    List<Integer> set = new ArrayList<>();
    set.add(1);
    set.add(2);
    set.add(3);
    set.add(4);
    set.add(5);
    List<List<Integer>> subsets = findAllSubsetsOFASet(set);
    System.out.println(subsets);
    System.out.println(subsets.size());
  }

}
