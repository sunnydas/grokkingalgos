package com.sunny.grokkingalgorithms.fasttrack.week5;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 7/17/2018.
 */
public class ReverseLinkedList {

  /**
   *
   * @param head
   * @return
   */
  public static Node reverse(Node head){
    Node prev = null;
    while(head != null){
      Node next = head.next;
      head.next = prev;
      prev = head;
      head = next;
    }
    return prev;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[]  input = new int[]{1,2,3,4,5};
    Node head = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(head);
    head = reverse(head);
    LinkedListUtil.printLinkedList(head);
  }

}
