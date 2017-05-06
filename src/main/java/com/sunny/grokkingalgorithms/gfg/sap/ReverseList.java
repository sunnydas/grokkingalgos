package com.sunny.grokkingalgorithms.gfg.sap;

/**
 * Created by sundas on 5/7/2017.
 */
public class ReverseList {


  /**
   *
   * @param head
   * @return
   */
  public static Node reverseList(Node head){
    Node previous = null;
    Node current = head;
    while(current != null){
      Node next = current.next;
      current.next = previous;
      previous = current;
      head = previous;
      current = next;
    }
    return head;
  }


  /**
   *
   * @param args
   */
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
    LinkedListEvenNodeReturn.printLinkedList(node1);
    Node node = reverseList(node1);
    LinkedListEvenNodeReturn.printLinkedList(node);
  }

}
