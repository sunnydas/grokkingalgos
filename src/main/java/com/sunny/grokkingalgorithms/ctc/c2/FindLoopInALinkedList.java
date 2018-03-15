package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/15/2018.
 */
public class FindLoopInALinkedList {

   /*
   If a loop exists in a linked list , find the starting point of the loop
    */


  /**
   *
   * @param root
   * @return
   */
   public static Node findIfLoopExistsAndFindStartingPoint(Node root){
     Node loopStartNode = null;
     /*
      First we have to detect whether a loop exists
       */
     Node fastRunner = root;
     Node slowRunner = root;
     /*
     Fast runner moves twics as fast as slow runner
     If fast runner meets slow runner, w have a loop
      */
     boolean loopFound = false;
     while(fastRunner != null){
       if(fastRunner != root && fastRunner == slowRunner){
         loopFound = true;
         break;
       }
       slowRunner = slowRunner.next;
       fastRunner = fastRunner.next;
       if(fastRunner.next != null){
         fastRunner = fastRunner.next;
       }
     }
     if(loopFound){
       //Now we know that we have found a loop
       // Move slow runner to start of list
       // Keep fast runner as its
       // Move each runner one step at a time
       // te meetimg point is the start
       slowRunner = root;
       while(slowRunner != fastRunner){
         slowRunner = slowRunner.next;
         fastRunner = fastRunner.next;
       }
       loopStartNode = slowRunner;
     }
     return loopStartNode;
   }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Node root = LinkedListUtil.createCircularList();
    LinkedListUtil.printCirlularLinkedList(root);
    root = findIfLoopExistsAndFindStartingPoint(root);
    if(root == null){
      System.out.println("No loop exists");
    }
    else{
      System.out.println("Loop exists and starting point is = " + root.data);
    }
  }
}
