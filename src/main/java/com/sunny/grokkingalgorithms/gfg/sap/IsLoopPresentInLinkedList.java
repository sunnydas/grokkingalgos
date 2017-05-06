package com.sunny.grokkingalgorithms.gfg.sap;

/**
 * Created by sundas on 5/6/2017.
 */
public class IsLoopPresentInLinkedList {

  /**
   *
   * @param head
   * @return
   */
  public static boolean isLoopPresent(Node head){
    boolean loopPresent = false;
    if(head != null && head.next != null && head.next.next != null) {
      Node current = head;
      Node fast = head.next.next;
      while (current != null) {
        if (current == fast) {
          loopPresent = true;
          break;
        }
        int i = 0;
        while (i < 2) {
          if (fast != null) {
            fast = fast.next;
          }
          i++;
        }
        current = current.next;
      }
    }
    return loopPresent;
  }



  public static void main(String[] args) {
    Node node1 = new Node(1);
    Node node2 = new Node(2);
    node1.next = node2;
    Node node3 = new Node(3);
    node2.next = node3;
    Node node4 = new Node(4);
    node3.next = node4;
    Node node5 = new Node(5);
    node4.next = node5;
    Node node6 = new Node(6);
    node5.next = node6;
    Node node7 = new Node(7);
    node6.next = node7;
    Node node8 = new Node(8);
    node7.next = node8;
    node8.next = node3;
    System.out.println(isLoopPresent(node1));
  }

}
