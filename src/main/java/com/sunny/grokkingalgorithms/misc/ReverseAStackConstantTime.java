package com.sunny.grokkingalgorithms.misc;

import java.util.Stack;

/**
 * Created by sundas on 5/10/2017.
 */
public class ReverseAStackConstantTime {

  // Given  s stack reverse it in o(1)

  public static Stack<Integer> reverse(Stack<Integer> input){
    if(input.isEmpty()){
      return input;
    }
    // empty the list
    int cur = input.pop();
    reverse(input);
    // insert each element at bottom of current stack
    insertAtBottom(input,cur);
    return input;
  }

  public static void insertAtBottom(Stack<Integer> input,int curValue){
    if(input.isEmpty()){
      input.push(curValue);
    }
    else{
      int val = input.pop();
      insertAtBottom(input, curValue);
      input.push(val);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Stack<Integer> input = new Stack<>();
    input.push(1);
    input.push(2);
    input.push(3);
    input.push(4);
    System.out.println(input);
    Stack<Integer> output = reverse(input);
    System.out.println(output);
    while(!output.isEmpty()){
      System.out.println(output.pop());
    }
    System.out.println(output);
    input.push(8);
    input.push(7);
    input.push(6);
    input.push(5);
    input.push(4);
    input.push(3);
    input.push(2);
    input.push(1);
    System.out.println(input);
    output = reverse(input);
    System.out.println(output);
    while(!output.isEmpty()){
      System.out.println(output.pop());
    }
  }

}
