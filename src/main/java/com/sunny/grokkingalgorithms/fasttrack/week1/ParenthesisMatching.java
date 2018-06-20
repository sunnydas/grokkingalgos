package com.sunny.grokkingalgorithms.fasttrack.week1;

import java.util.Stack;

/**
 * Created by sundas on 6/20/2018.
 */
public class ParenthesisMatching {

  /**
   *
   * @param s
   * @return
   */
  public static boolean isMatched(String s){
    boolean matched = false;
    Stack<Character> stack = new Stack<>();
    int i = 0;
    while(i < s.length()){
      char bracket = s.charAt(i);
      if(bracket == '('){
        stack.push(bracket);
      }
      else{
        stack.pop();
      }
      i++;
    }
    matched = stack.isEmpty();
    return matched;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String input = "()()()((()))()()";
    System.out.println(isMatched(input));
    input = "(((((((((((((((((((((((())";
    System.out.println(isMatched(input));
  }
}
