package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.*;

/**
 * Find all subsets of a set
 *
 * Created by sundas on 1/5/2018.
 */
public class SubsetsOfASet {

  /**
   *
   * @param masterSet
   * @return
   */
  public static List<String> findAllSubsets(String masterSet){
    List<String> subSets = findAllSubsetsRecursive(masterSet);
    return subSets;
  }

  public static List<String> findAllSubsetsRecursive(String masterSet){
    /*
    How does this work?
    Let us take an example:

    abc

        step1: a taken out bc
                step 2: b taken c
                      step 3: c taken out ""
                             step 4: base case hit add empty string to list
                        back track to step 3 : add c to the list so now we have [c, ""]
                    back track to step 2: add b to all elements to list [b,c,"",bc]
                back track to step 1: add a to all elements to list [a,b,c,"",abc,ab,bc,ac]
          done
     */
    List<String> subsets = new ArrayList<>();
    if(masterSet == null || masterSet.length() == 0){
      subsets.add("");
      return subsets;
    }
    if(masterSet.length() > 0) {
      char current = masterSet.charAt(0);
      String newStr = masterSet.substring(1);
      //System.out.println(newStr);
      List<String> childSubSets = findAllSubsetsRecursive(newStr);
      //System.out.println(" child subsets " + childSubSets);
      if(childSubSets.size() > 0){
        for(String s : childSubSets){
          if(!s.trim().equals("")) {
            String comb1 = current + s;
            //SString comb2 = s + current;
            subsets.add(comb1);
            //subsets.add(comb2);
          }
          else{
            subsets.add(""+current);
          }
        }
        subsets.addAll(childSubSets);
      }
    }
    return subsets;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String masterSet = scanner.next();
    List<String> subsets = findAllSubsets(masterSet);
    System.out.println(subsets.size());
    System.out.println(subsets);
  }

}
