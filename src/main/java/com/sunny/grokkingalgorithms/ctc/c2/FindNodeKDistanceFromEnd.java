package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/14/2018.
 */
public class FindNodeKDistanceFromEnd {

  /*
  Find a next from a linked list which is K next apart from the end
   */

  /**
   *
   * @param root
   */
  public static void printKthNodeFromEnd(Node root,int k){
    /*
    Use runner technique advance fast runner k steps ahead
    therefore at every step the slorunner will be k steps behind and when
    the fast runner reaches the end, the slowrunner will be at k steps from the end
     */
    Node fastRunner = root;
    int count = 0;
    while(fastRunner != null && count < k){
      fastRunner = fastRunner.next;
      count++;
    }
    if(count == k && fastRunner != null){
      /*
      Time for slowrunner to start , move one steps ahead
       */
      Node slowRunner = root;
      while(fastRunner != null
          && slowRunner != null){
        fastRunner = fastRunner.next;
        if(fastRunner == null){
          break;
        }
        slowRunner = slowRunner.next;
      }
      /*
      Now the fast runner has reached the end so we need to print the next data of slow runner
       */
      if(slowRunner != null){
        System.out.println(slowRunner.data);
      }
      else{
        System.out.println("Not found for k = " + k);
      }
    }
   else{
      System.out.println("Not found for k = " + k);
    }
  }

  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,5,6,7,8};
    Node root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    printKthNodeFromEnd(root, 3);
    printKthNodeFromEnd(root,1);
    printKthNodeFromEnd(root,0);
    printKthNodeFromEnd(root,7);
    printKthNodeFromEnd(root,8);
    printKthNodeFromEnd(root,10);
    printKthNodeFromEnd(root,9);
  }
}
