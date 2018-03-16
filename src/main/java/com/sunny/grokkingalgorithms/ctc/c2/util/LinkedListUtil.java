package com.sunny.grokkingalgorithms.ctc.c2.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

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

  public static NodeGeneric createLinkedList(String[] input){
    NodeGeneric head = null;
    NodeGeneric previous = null;
    for(int i = 0 ; i < input.length ; i++){
      NodeGeneric node = new NodeGeneric();
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
   */
  public static void printLinkedList(NodeGeneric root){
    NodeGeneric current = root;
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
   */
  public static void printCirlularLinkedList(Node root){
    Node current = root;
    System.out.println();
    Set<Node> traversalSet = new HashSet<>();
    while(current != null){
      if(traversalSet.contains(current)){
        System.out.println(current.data);
        break;
      }
      System.out.print(current.data);
      System.out.print("->");
      traversalSet.add(current);
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

  public static Node createCircularList(){
    Node root = null;
    int[] input = new int[]{1,2,3,4,5,6,7,8,9};
    Node thirdNode = null;
    Node prev = null;
    for(int i = 0 ; i < input.length ; i++){
      Node node = new Node();
      node.data = input[i];
      if(i == 2){
        thirdNode = node;
      }
      if(i == 8){
        prev.next = node;
        node.next = thirdNode;
        break;
      }
      if(root == null){
        root = node;
      }
      if(prev != null){
        prev.next = node;
      }
      prev = node;
    }
    return root;
  }


}
