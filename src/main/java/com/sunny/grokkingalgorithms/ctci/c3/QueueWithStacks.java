package com.sunny.grokkingalgorithms.ctci.c3;

import java.util.Stack;

/**
 * Created by sundas on 3/17/2018.
 */
public class QueueWithStacks {

  /*
  Implement a queue using stacks
   */

   private Stack<Integer> stack1;

   private Stack<Integer> stack2;


  /**
   *
   */
  public QueueWithStacks() {
    this.stack1 = new Stack<>();
    this.stack2 = new Stack<>();
  }


  /**
   *
   * @param data
   */
  public void enqueue(int data){
    stack1.push(data);
  }


  /**
   *
   * @return
   */
  public int dequeue(){
    int elem = Integer.MIN_VALUE;
    while(!stack1.isEmpty()){
      stack2.push(stack1.pop());
    }
    if(!stack2.isEmpty()){
      elem = stack2.pop();
    }
    while(!stack2.isEmpty()){
      stack1.push(stack2.pop());
    }
    return elem;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6};
    QueueWithStacks queue = new QueueWithStacks();
    for(int i = 0 ; i < input.length ; i++){
      queue.enqueue(input[i]);
    }
    for(int i = 0 ; i < input.length ; i++){
      System.out.println(queue.dequeue());
    }
    queue.enqueue(9);
    queue.enqueue(3);
    System.out.println(queue.dequeue());
  }

}
