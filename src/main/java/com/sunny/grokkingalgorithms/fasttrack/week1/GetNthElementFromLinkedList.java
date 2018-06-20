package com.sunny.grokkingalgorithms.fasttrack.week1;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 6/20/2018.
 */
public class GetNthElementFromLinkedList {

  /**
   *
   * @param head
   * @return
   */
  public static Node getNthNodeFromEnd(Node head,int n){
    Node fastPtr = head;
    Node slowPtr = head;
    Node nthNode = null;
    int count = 0;
    while(count < n
        && fastPtr != null){
      fastPtr = fastPtr.next;
      count++;
    }
    if(count < n){
      return null;
    }
    while (fastPtr != null) {
      slowPtr = slowPtr.next;
      fastPtr = fastPtr.next;
    }
    nthNode = slowPtr;
    return nthNode;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[]  input = new int[]{1,2,3,4,5};
    Node head = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(head);
    System.out.println(getNthNodeFromEnd(head, 1).data);
    System.out.println(getNthNodeFromEnd(head,2).data);
    System.out.println(getNthNodeFromEnd(head,3).data);
    System.out.println(getNthNodeFromEnd(head,4).data);
    System.out.println(getNthNodeFromEnd(head,5).data);
    System.out.println(getNthNodeFromEnd(head,6));
  }
}
