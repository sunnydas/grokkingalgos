package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.*;
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
   * @param curParenthesis
   * @param count
   * @param lefParenCount
   * @param rightparenCount
   * @param parenthesis
   */
  public static void findValidParenthesisOptimized(char[] curParenthesis,int count,int lefParenCount,int rightparenCount,
                                                    List<String> parenthesis){
    if(lefParenCount < 0  || rightparenCount < 0){
      return;
    }
    if(rightparenCount == 0 && lefParenCount == 0){
      String val = String.valueOf(curParenthesis);
      parenthesis.add(val);
    }
    else{
      if(lefParenCount > 0){
        curParenthesis[count] = '(';
        findValidParenthesisOptimized(curParenthesis,count+1,lefParenCount-1,rightparenCount,parenthesis);
      }
      /*
      Most important point
       */
      if(rightparenCount >  lefParenCount){
        curParenthesis[count] = ')';
        findValidParenthesisOptimized(curParenthesis,count+1,lefParenCount,rightparenCount-1,parenthesis);
      }
    }
  }


  /**
   *
   * @param n
   * @return
   */
  public static Set<String> findAllValidaPairOfParenthesisAlternate(int n){
    if(n <= 0){
      return null;
    }
    if(n == 1){
      String pair = "()";
      Set<String> set = new HashSet<>();
      set.add(pair);
      return set;
    }
    Set<String> currentSet = new HashSet<>();
    List<String> childList = findAllValidPairOfParenthesis(n-1);
    if(childList != null && !childList.isEmpty()){
      for(String parenthesis : childList){
        for(int i = 0 ; i < parenthesis.length() ; i++){
          //if(parenthesis.charAt(i) == '('){
          String newParenthesis = insertAtIndex(parenthesis,i);
          currentSet.add(newParenthesis);
          //}
        }
        currentSet.add("()" + parenthesis);
      }
      //currentList.addAll(childList);
    }
    return currentSet;
  }


  /**
   *
   * @param s
   * @param index
   * @return
   */
  public static String insertAtIndex(String s, int index){
    StringBuilder builder = new StringBuilder(s);
    builder.insert(index,"()");
    return builder.toString();
  }

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
      //System.out.println(s);
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
    int n = 6;
    System.out.println(findAllValidPairOfParenthesis(n));
    //System.out.println(isValidCombination("())("));
    System.out.println(findAllValidaPairOfParenthesisAlternate(n));
    List<String> validParenthesis = new ArrayList<>();
    char[] currentStr = new char[2*n];
    findValidParenthesisOptimized(currentStr,0,n,n,validParenthesis);
    System.out.println(validParenthesis);
  }
}
