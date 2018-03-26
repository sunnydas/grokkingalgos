package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 3/26/2018.
 */
public class FindAllPermutationsOfAString {


   /*
   Given a string find all its permutaions
    */
  public static List<String> findAllPermutationsOfAString(String input){
    if(input.equals("")){
      List<String> perm = new ArrayList<>();
      perm.add("");
      return perm;
    }
    char val = input.charAt(0);
    input = input.substring(1);
    List<String> perms = new ArrayList<>();
    List<String> childPerms = findAllPermutationsOfAString(input);
    if(childPerms != null){
      /*
      empty string case
       */
      if(!childPerms.isEmpty() && childPerms.size() == 1 && childPerms.get(0).equals("")){
        perms.add(""+val);
        perms.addAll(childPerms);
      }
      else{
        for(String s : childPerms) {
          for(int i = 0 ; i <= s.length() ; i++){
            StringBuilder builder = new StringBuilder(s);
            builder.insert(i,val);
            perms.add(builder.toString());
          }
        }
        perms.addAll(childPerms);
      }
    }
    return perms;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String input = "abcd";
    List<String> permutations = findAllPermutationsOfAString(input);
    System.out.println(permutations);
    System.out.println(permutations.size());
  }


}
