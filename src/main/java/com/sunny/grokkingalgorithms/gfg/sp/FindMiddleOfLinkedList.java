package com.sunny.grokkingalgorithms.gfg.sp;

/**
 * Created by sundas on 5/7/2017.
 */
public class FindMiddleOfLinkedList {

  public static Node findMiddle(Node head){
    Node slow = head;
    Node middle = slow;
    if(head != null && head.next != null && head.next.next != null){
      Node fast = head.next.next;
      while(slow != null && fast != null) {
        int i = 0;
        while (i < 2 && fast != null) {
          fast = fast.next;
          i++;
        }
        slow = slow.next;
      }
      middle = slow;
    }
    return middle;
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
    LinkedListEvenNodeReturn.printLinkedList(node1);
    Node node = findMiddle(node1);
    System.out.println(node.data);
    Node node6 = new Node(6);
    node5.next = node6;
    Node node7 = new Node(7);
    node6.next = node7;
    LinkedListEvenNodeReturn.printLinkedList(node1);
    node = findMiddle(node1);
    System.out.println(node.data);
    Node node8 = new Node(8);
    node7.next = node8;
    LinkedListEvenNodeReturn.printLinkedList(node1);
    node = findMiddle(node1);
    System.out.println(node.data);
    Node node9 = new Node(9);
    node8.next = node9;
    LinkedListEvenNodeReturn.printLinkedList(node1);
    node = findMiddle(node1);
    System.out.println(node.data);
  }
}
