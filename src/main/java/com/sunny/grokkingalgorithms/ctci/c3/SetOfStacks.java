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
   * Pops an element from a specific stack
   *
   * @param stackIndex
   * @return
   */
  public int popAt(int stackIndex){
    /*
       So if we pop an element from a stack , if there are stacks after this stack which are filled we may have to
       fill it to preserve stack ordering. We dont have to worry about stacks before this stack, only stacks that are
        after this. Essentially we have created a hold in this stack and that needs to be filled out by shuffling
        elements from other stacks that follow this stack.
     */
    int elem = Integer.MAX_VALUE;
    if(stackIndex < stacks.length && stacks[stackIndex] != null && !stacks[stackIndex].isEmpty()){
      elem = stacks[stackIndex].pop();
      shiftElementsFromNextStacks(stackIndex);

    }
    return elem;
  }

  private void shiftElementsFromNextStacks(int stackIndex) {
  /*
  Now if we have stacks fater this which are full, we have essentially created the hole. SO we need to shift one
  element from next stack to this stack and repeat until we have done this for all stacks
   */
    int stackPointer = stackIndex;
      /*
      If there are next stacks which have elements in them
       */
    while((stackPointer+1) < stacks.length
        && stacks[stackPointer+1] != null && !stacks[stackPointer+1].isEmpty()){
      Stack<Integer> auxillaryStack = new Stack<>();
      //Copy next stack elements to auxillary stack
      while(!stacks[stackPointer+1].isEmpty()){
        auxillaryStack.push(stacks[stackPointer+1].pop());
      }
      // push last element of next stack to current stack
      if(!auxillaryStack.isEmpty()){
        stacks[stackPointer].push(auxillaryStack.pop());
      }
      //Copy back the auxillary elements to next stack
      while(!auxillaryStack.isEmpty()){
        stacks[stackPointer+1].push(auxillaryStack.pop());
      }
      //Repeat
      stackPointer++;
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,0,-1,-200,100,-100,10};
    SetOfStacks setOfStacks = new SetOfStacks(3,4);
    for(int i = 0 ; i < input.length ; i++){
      setOfStacks.push(input[i]);
    }
    System.out.println(setOfStacks.popAt(1));
    setOfStacks.push(120);
    System.out.println("Bulk pop");
    for(int i = 0 ; i < input.length ; i++){
      System.out.println(setOfStacks.pop());
    }
    System.out.println("done");
  }

}
