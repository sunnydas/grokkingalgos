package com.sunny.grokkingalgorithms.fasttrack.week6;

import java.util.Stack;

/**
 * Created by sundas on 7/26/2018.
 */
public class StackSorter {

  /*
  Given a stack sort it in ascending order.
   */

  /**
   *
   * @param stack
   */
  public static Stack<Integer> stackSorter(Stack<Integer> stack){

    //System.out.println(stack);
    Stack<Integer> aux = new Stack<>();
    while(!stack.isEmpty()){
      int data = stack.peek();
      if(aux.isEmpty()){
        aux.push(data);
        stack.pop();
      }
      else{
        while(!aux.isEmpty()
            && data < aux.peek()){
          stack.push(aux.pop());
        }
        /*
        Found place
         */
        aux.push(data);
        while(!stack.isEmpty()
            && stack.peek() != data){
          aux.push(stack.pop());
        }
        stack.pop();
      }
    }
    while(!aux.isEmpty()){
      stack.push(aux.pop());
    }
    //System.out.println(stack);
    return stack;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{5,1,4,2,3,10,0};
    //int[] input = new int[]{0,1};
    Stack<Integer> stack = new Stack<>();
    for(int i : input){
      stack.push(i);
    }
    System.out.println(stack);
    stackSorter(stack);
    while (!stack.isEmpty()){
      System.out.println(stack.pop());
    }
    //stackSorter(input);
  }

}