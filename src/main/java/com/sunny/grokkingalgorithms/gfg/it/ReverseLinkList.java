package com.sunny.grokkingalgorithms.gfg.it;

class Node{
  public int data;
  public Node next;
}
/**
 * Reverse a linked list
 * Created by sundas on 2/15/2018.
 */
public class ReverseLinkList {

  /**
   *
   * @param input
   * @return
   */
  public static Node createLinkedList(int[] input){
    Node root = null;
    Node previous = null;
    for(int i = 0 ; i < input.length ; i++){
      Node current = new Node();
      current.data = input[i];
      if(previous != null){
        previous.next = current;
      }
      if(root == null){
        root = current;
      }
      previous = current;
    }
    return root;
  }

  /**
   *
   * @param root
   * @return
   */
  public static Node reverseLinkedList(Node root){
    Node current = root;
    Node previous = null;
    while(current != null){
      Node next = current.next;
      if(next == null){
        root = current;
      }
      current.next = previous;
      previous = current;
      current = next;
    }
    return root;
  }

  /**
   *
   * @param root
   */
  public static void printLinkedList(Node root){
    Node current = root;
    while(current != null){
      System.out.print(current.data);
      if(current.next != null) {
        System.out.print("->");
      }
      current = current.next;
    }
    System.out.println();
  }


  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5};
    Node root = createLinkedList(input);
    printLinkedList(root);
    root = reverseLinkedList(root);
    printLinkedList(root);
  }
}
