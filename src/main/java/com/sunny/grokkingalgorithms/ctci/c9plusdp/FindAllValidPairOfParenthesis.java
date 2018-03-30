package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * Created by sundas on 3/30/2018.
 */
public class FindAllValidPairOfParenthesis {

  /*
  Given a  umber n:
  Find all valid pair of parenthesis
  for example:
  n = 2
  (()) ()()
   */

  /**
   *
   * @param n
   * @return
   */
  public static List<String> findAllValidPairOfParenthesis(int n){
    List<String> combinations = new ArrayList<>();
    populateAndPrintValidNPairParenthesisCombinations("",2*n,combinations);
    List<String> validCombinations = new ArrayList<>();
    for(String combination : combinations){
      if(isValidCombination(combination)){
        validCombinations.add(combination);
      }
    }
    return validCombinations;
  }

  /**
   *
   * @param combination
   * @return
   */
  public static boolean isValidCombination(String combination){
    boolean isValid = true;
    isValid = isCombinationPossible(combination);
    if(!isValid){
      return isValid;
    }
    Stack<String> matchStack = new Stack<>();
    for(int i = 0 ; i < combination.length() ; i++){
      char bracket = combination.charAt(i);
      if(bracket == '('){
        matchStack.push(""+bracket);
      }
      else if(bracket == ')'){
        if(!matchStack.isEmpty() && matchStack.peek().equals(""+'(')){
         matchStack.pop();
        }
        else{
          isValid = false;
          break;
        }
      }
    }
    if(!matchStack.isEmpty()){
      isValid = false;
    }
    return isValid;
  }

  /**
   *
   * @param combination
   * @return
   */
  public static boolean isCombinationPossible(String combination){
    boolean possible = true;
    int openBrackets = 0;
    int closeBrackets = 0;
    for(int i = 0 ; i < combination.length() ; i++){
      if(combination.charAt(i) == '('){
        openBrackets++;
      }
      else if(combination.charAt(i) == ')'){
        closeBrackets++;
      }
    }
    if(openBrackets != closeBrackets && ((openBrackets+closeBrackets)/2) != openBrackets){
      possible = false;
    }
    return possible;
  }


  public static void populateAndPrintValidNPairParenthesisCombinations(String s,int n,List<String> combinations){
    if(s != null && s.length() == n){
      System.out.println(s);
      combinations.add(s);
      return;
    }
    if(s == null){
      return;
    }
    populateAndPrintValidNPairParenthesisCombinations(s + "(", n, combinations);
    populateAndPrintValidNPairParenthesisCombinations(s + ")", n, combinations);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int n = 3;
    System.out.println(findAllValidPairOfParenthesis(n));
    //System.out.println(isValidCombination("())("));
  }
}
