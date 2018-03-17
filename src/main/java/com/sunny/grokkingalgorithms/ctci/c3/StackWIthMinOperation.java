package com.sunny.grokkingalgorithms.ctci.c3;

import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/17/2018.
 */
public class StackWIthMinOperation {

  /*
  Implement a stack such that push, pop and min operate in O(1) time
   */

   /*
   I am using linked list to represent a stack push into head and read from head
    */

    private Node dataStack;

    private Node minHolderStack;

  @Override
  public String toString() {
    return "StackWIthMinOperation{" +
        "dataStack=" + dataStack +
        ", minHolderStack=" + minHolderStack +
        '}';
  }

  /**
   *
   * @param data
   */
    public void push(int data){
      if(dataStack == null){
        dataStack = new Node();
        dataStack.data = data;
        if(minHolderStack == null){
          Node node = new Node();
          node.data = data;
          minHolderStack = node;
        }
      }
      else{
        Node dataNode = new Node();
        dataNode.data = data;
        dataNode.next = dataStack;
        dataStack = dataNode;
        if(minHolderStack != null
            && data < minHolderStack.data){
          Node node = new Node();
          node.data = data;
          node.next = minHolderStack;
          minHolderStack = node;
        }
      }
    }


  /**
   *
   * @return
   */
    public int pop(){
      if(dataStack == null){
        throw new UnsupportedOperationException("sata stack is empty");
      }
      int data = dataStack.data;
      dataStack = dataStack.next;
      if(minHolderStack != null
          && data == minHolderStack.data){
        minHolderStack = minHolderStack.next;
      }
      return data;
    }

  /*
  The logic for min tracking. Use another stack
  keep the current minim on the stack , if a new element comes and
  we see that it is lessser than the current top if stack we push ito to the min stack
  Let us see an example:

  {3,8,1,5}
  minStack = ()
  push 3
  minstack = (3)
  push 8
  minStack = (3)
  push 1
  min stack = (1,3)
  push 5
  min stack = (1,3)

  main stack = (5,1,8,3)
  pop() = 5
  min stack =  (1,3)
  pop() = 1
  min stack = (3)
  pop() = 8
  min stack = (3)
  pop() = 3
  min stack = ()
   */


  /**
   *
   * @return
   */
    public int min(){
      if(minHolderStack == null){
        return Integer.MAX_VALUE;
      }
      return minHolderStack.data;
    }



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,0,-1,-200,100,-100,10};
    StackWIthMinOperation stackWIthMinOperation = new StackWIthMinOperation();
    for(int i = 0 ; i < input.length ; i++){
      stackWIthMinOperation.push(input[i]);
      System.out.println(stackWIthMinOperation.min());
    }
    for(int i = 0 ; i < input.length ; i++){
      System.out.println("Pop and min together");
      System.out.println(stackWIthMinOperation.pop());
      System.out.println(stackWIthMinOperation.min());
    }
  }

}