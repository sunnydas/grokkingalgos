package com.sunny.grokkingalgorithms.ctci.c3;

import java.util.Stack;

/**
 * Created by sundas on 3/18/2018.
 */
public class SortAStack {

  /*
  Sort a stack in ascending order
   */

  /**
   *
   * @param stack
   */
   public static void sortStack(Stack<Integer> stack){
     /*
     We will use two auxillary stack.
     Let us take an example of stack which has main = (5 4 3 2 1)
     Initially aux1 = ()
        aux2 = ()
        pop from main
        is aux2.top < current from main
         if yes empty aux2 untill aux.top > current
         repeat
      */
     Stack<Integer> aux1 = new Stack<>();
     Stack<Integer> aux2 = new Stack<>();
     //Start polling main stack for elements
     while(!stack.isEmpty()){
       int currentElem = stack.pop();
       /*
       current elemment is smaller than  the top soi we can safely add this element
        */
       if(!aux1.isEmpty() && currentElem <= aux1.peek()){
         aux1.push(currentElem);
       }
       /*
       First element add it to aux1
        */
       else if(aux1.isEmpty()){
         aux1.push(currentElem);
       }
       /*
       Now we have some work to do. We need to find a place for current element, we will now use aux2 to move elements
       that are less than current eleemnt to aux2, this will give us a logical slot for current element and then we can
       move back the elements from aux2 to aux1
        */
       else if(!aux1.isEmpty() && currentElem > aux1.peek()){
         while(!aux1.isEmpty() && currentElem > aux1.peek()){
           aux2.push(aux1.pop());
         }
         /*
         We have found a logical slot for current element
          */
         aux1.push(currentElem);
         /*
         Move all elements from aux2 to aux1
          */
         while(!aux2.isEmpty()){
           aux1.push(aux2.pop());
         }
       }
     }
     /*
     Copy aux1 to aux2
      */
     while(!aux1.isEmpty()){
       aux2.push(aux1.pop());
     }
     /*
     copy aux2 to main
      */
     while(!aux2.isEmpty()){
       stack.push(aux2.pop());
     }
   }



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    for(int i = 0 ; i <= 5 ; i++){
      stack.push(i);
    }
    System.out.println(stack);
    System.out.println(stack.peek());
    System.out.println("sort");
    sortStack(stack);
    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    }
    System.out.println("Next");
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(1);
    stack.push(4);
    stack.push(0);
    System.out.println(stack);
    System.out.println(stack.peek());
    System.out.println("sorting");
    sortStack(stack);
    while(!stack.isEmpty()){
      System.out.println(stack.pop());
    }
  }

}
