package com.sunny.grokkingalgorithms.gfg.vmw;

import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

class OptimizedStack{

  private Node head;

  private int min = Integer.MAX_VALUE;

  /*
  During push we stored 2*x - prevMin
  while pop we see that
  2*curMin - (2*x - prevMin)
  curMin is nothing but the x
  2*x - 2*x + prevMin
   = prevMin

   Hence it works
   */

  /**
   *
   * @param data
   */
  public void push(int data){
    Node node = new Node();
    if(data >= min){
      node.data = data;
    }
    else{
      node.data = 2*data - min;
      min = data;
    }
    if(head == null){
      head = node;
    }
    else{
      node.next = head;
      head = node;
    }
  }

  /**
   *
   * @return
   */
  public int pop(){
    int data = Integer.MIN_VALUE;
    if(head != null){
      data = head.data;
      if(data < min){
        min = 2*min - data;
      }
      head = head.next;
    }
    return data;
  }


  /**
   *
   * @return
   */
  public boolean isEmpty(){
    return head==null;
  }


  /**
   *
   * @return
   */
  public int getMin(){
    int min = Integer.MAX_VALUE;
    if(!this.isEmpty()){
      min = this.min;
    }
    return min;
  }


  /**
   *
   * @return
   */
  public int peek(){
    int top = Integer.MAX_VALUE;
    if(!this.isEmpty()){
      top = head.data;
    }
    return top;
  }

}
/**
 * Created by sundas on 4/18/2018.
 */
public class ImplementStackToGetMinInConstantTimeANdSpace {

  /*
  How does this approach work?
When element to be inserted is less than minEle, we insert “2x – minEle”. The important thing to notes is, 2x – minEle will always be less than x (proved below), i.e., new minEle and while popping out this element we will see that something unusual has happened as the popped element is less than the minEle. So we will be updating minEle.

How 2*x - minEle is less than x in push()?
x < minEle which means x - minEle < 0

// Adding x on both sides
x - minEle + x < 0 + x

2*x - minEle < x

We can conclude 2*x - minEle < new minEle
While popping out, if we find the element(y) less than the current minEle, we find the new minEle = 2*minEle – y.

How previous minimum element, prevMinEle is, 2*minEle - y
in pop() is y the popped element?

 // We pushed y as 2x - prevMinEle. Here
 // prevMinEle is minEle before y was inserted
 y = 2*x - prevMinEle

 // Value of minEle was made equal to x
 minEle = x .

 new minEle = 2 * minEle - y
            = 2*x - (2*x - prevMinEle)
            = prevMinEle // This is what we wanted
   */

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    OptimizedStack optimizedStack = new OptimizedStack();
    for(int i = 1 ; i <= 5 ; i++){
      optimizedStack.push(i);
    }
    optimizedStack.push(-1);
    optimizedStack.push(10);
    optimizedStack.push(-100);
    optimizedStack.push(0);
    while(!optimizedStack.isEmpty()){
      System.out.println("min = " + optimizedStack.getMin());
      System.out.println(optimizedStack.pop());
    }
  }

}
