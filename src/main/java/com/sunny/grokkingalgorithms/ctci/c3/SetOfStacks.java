package com.sunny.grokkingalgorithms.ctci.c3;

import java.util.Stack;

/**
 * Created by sundas on 3/17/2018.
 */
public class SetOfStacks {

   /*
   In real world if stacks get too high, it might topple over. Implement a set of stacks such that when a threshold is
   reached for a certain stack it spills over to the next one and so on.Push and pop should behave as if there was
   only one stack.
    */

  private Stack<Integer>[] stacks;

  private int threshHold;

  private int currentStackIndex;

  /**
   *
   * @param threshHold
   * @param stackSetSize
   */
  public SetOfStacks(int threshHold,int stackSetSize){
    this.threshHold = threshHold;
    stacks = new Stack[stackSetSize];
  }


  /**
   *
   * @param data
   */
  public void push(int data){
    Stack currentStack = stacks[currentStackIndex];
    //If first time initialize first stack
    if(currentStack == null){
      stacks[currentStackIndex] = new Stack<>();
      stacks[currentStackIndex].push(data);
    }
    //Capacity reached spill over to next
    else if(currentStack.size() >= threshHold){
      currentStackIndex++;
      if(currentStackIndex >= stacks.length){
        throw new UnsupportedOperationException("Maximum capacity reached");
      }
      stacks[currentStackIndex] = new Stack<>();
      stacks[currentStackIndex].push(data);
    }
    else{
      //Normal case
      stacks[currentStackIndex].push(data);
    }
  }


  /**
   *
   * @return
   */
  public int pop(){
    /*
    Try to see if current stack has any elements
     */
    if(!stacks[currentStackIndex].isEmpty()){
      return stacks[currentStackIndex].pop();
    }
    /*
    Maybe it is in the previous stack
     */
    else{
      currentStackIndex--;
      if(currentStackIndex >= 0){
        return stacks[currentStackIndex].pop();
      }
      else{
        throw new UnsupportedOperationException("No Data Found");
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,0,-1,-200,100,-100,10};
    SetOfStacks setOfStacks = new SetOfStacks(4,3);
    for(int i = 0 ; i < input.length ; i++){
      setOfStacks.push(input[i]);
    }

    for(int i = 0 ; i < input.length ; i++){
      System.out.println(setOfStacks.pop());
    }
  }

}
