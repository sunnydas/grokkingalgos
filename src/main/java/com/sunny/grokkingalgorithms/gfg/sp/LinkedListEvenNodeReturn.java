package com.sunny.grokkingalgorithms.gfg.sp;

/**
 * Created by sundas on 5/4/2017.
 */
class Node{

  public Node(int data) {
    this.data = data;
  }

  Node next;

  @Override
  public String toString() {
    return "Node{" +
        "next=" + next +
        ", data=" + data +
        '}';
  }

  int data;


}
public class LinkedListEvenNodeReturn {


  // construct a linked list and return only those nodes whose value is even.

  /**
   *
   * @param head
   */
  public static void printEvenNodes(Node head){
    Node current = head;
    while(current != null){
      if(current.data % 2 == 0){
        System.out.print(current.data);
        System.out.print("->");
      }
      current = current.next;
    }
    System.out.println();
  }


  // we need to delete the node containing even values and we need to make a new linkedlist of only even nodes.

  public static Node createEvenListFromOriginal(Node head){
    Node previous = null;
    Node current = head;
    Node newHead = null;
    Node newCurrent = null;
    while(current != null){
      if(current.data % 2 == 0){
        if(newHead == null){
          newHead = new Node(current.data);
          newCurrent = newHead;
        }
        else{
          Node next = new Node(current.data);
          newCurrent.next = next;
          newCurrent = next;
        }
        if(previous != null){
          previous.next = current.next;
        }
      }
      previous = current;
      current = current.next;
    }
    return newHead;
  }


  public static void printLinkedList(Node head){
    Node current = head;
    while(current != null){
      System.out.print(current.data);
      System.out.print("->");
      current = current.next;
    }
    System.out.println();
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
    printLinkedList(node1);
    printEvenNodes(node1);
    printLinkedList(createEvenListFromOriginal(node1));
    printLinkedList(node1);
  }
}
