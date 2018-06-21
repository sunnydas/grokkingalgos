package com.sunny.grokkingalgorithms.fasttrack.week1;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 6/21/2018.
 */
public class FindLoopInLinkedList {

  /**
   *
   * @param head
   * @return
   */
  public static boolean hasLoop(Node head){
    boolean hasLoop = false;
    Node fastPtr = head.next;
    if(fastPtr != null){
      fastPtr = fastPtr.next;
    }
    Node slowPtr = head;
    while(fastPtr != null){
      if(slowPtr == fastPtr){
        hasLoop = true;
        break;
      }
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
      if(fastPtr != null){
        fastPtr = fastPtr.next;
      }
    }
    return hasLoop;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Node head = LinkedListUtil.createCircularListProper();
    LinkedListUtil.printCircularList(head);
    System.out.println(hasLoop(head));
  }
}
