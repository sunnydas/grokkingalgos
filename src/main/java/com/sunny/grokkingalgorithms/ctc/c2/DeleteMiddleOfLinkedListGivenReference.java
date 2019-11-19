package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/14/2018.
 */
public class DeleteMiddleOfLinkedListGivenReference {

  /*
  Given reference to a next , delete it from the linked list.If it is last element you
  will not be delete it.

  a->b->c->d
  delete c
  after deletion
  a->b->d
   */

  /**
   *
   * @param middle
   */
  public static void deleteNodeFromMiddle(Node middle){
    if(middle != null
        && middle.next != null){
      /*
      Copy next next's value into middle which is essentailly line overwriting existing middle's value and then
      delete next
       */
      middle.data = middle.next.data;
      middle.next = middle.next.next;
    }
  }

  /**
   *
   * @param root
   * @return
   */
  public static Node findMiddleOfLinkedList(Node root){
    /*
    Once again we use the fast runner apporach. The fast runner covers twice as much noes as slow
     runner so when fast runner will be at the end, slow runner will be in the middle
     */
    Node slowRunner = root;
    Node fastRunner = root;
    while(fastRunner != null && slowRunner != null){
      slowRunner = slowRunner.next;
      fastRunner = fastRunner.next;
      if(fastRunner != null){
        fastRunner = fastRunner.next;
      }
    }
    //Now slow runner is at the middle
    return slowRunner;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,7,8};
    Node root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    Node middle = findMiddleOfLinkedList(root);
    System.out.println(middle.data);
    deleteNodeFromMiddle(middle);
    LinkedListUtil.printLinkedList(root);
  }
}
