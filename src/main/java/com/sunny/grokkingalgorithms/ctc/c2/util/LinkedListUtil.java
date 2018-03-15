package com.sunny.grokkingalgorithms.ctc.c2.util;

/**
 * Created by sundas on 3/13/2018.
 */
public class LinkedListUtil {


  /**
   *
   * @param input
   * @return
   */
  public static Node createLinkedList(int[] input){
    Node head = null;
    Node previous = null;
    for(int i = 0 ; i < input.length ; i++){
      Node node = new Node();
      node.data = input[i];
      if(head == null){
        head = node;
      }
      if(previous != null){
        previous.next = node;
      }
      previous = node;
    }
    return head;
  }


  /**
   *
   * @param root
   */
  public static void printLinkedList(Node root){
    Node current = root;
    System.out.println();
    while(current != null){
      System.out.print(current.data);
      System.out.print("->");
      current = current.next;
    }
    System.out.println();
  }

  /**
   *
   * @param root
   * @param padding
   * @return
   */
  public static Node padLinkedListWIthZerosFromFromHead(Node root,int padding){
    for(int i = 0 ; i < padding ; i++){
      Node node = new Node();
      node.data = 0;
      node.next = root;
      root = node;
    }
    return root;
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findLengthOfLinkedList(Node root){
    int count = 0;
    Node current = root;
    while(current != null){
      count++;
      current = current.next;
    }
    return count;
  }


}
