package com.sunny.grokkingalgorithms.gfg.ncr;

class Node{
  int data;
  Node next;
}
/**
 * Created by sundas on 2/17/2018.
 */
public class DeleteEvenNodes {

  /*
  Delete nodes with even data, for example:
   1 2 3 4 5 6
   becomes
   1 3 5
   */


  /**
   *
   * @param root
   * @return
   */
  public static Node deleteEven(Node root){
    Node current = root;
    Node previous = null;
    while(current != null){
      if(current.data % 2 == 0){
        if(current == root){
          root = current.next;
        }
        if(previous != null){
          previous.next = current.next;
        }
      }
      else{
        previous = current;
      }
      current = current.next;
    }
    return root;
  }


  /**
   *
   * @param input
   * @return
   */
  public static Node populateLinkedList(int[] input){
    Node root = null;
    Node previous = null;
    for(int i = 0 ; i < input.length ; i++){
      Node current = new Node();
      current.data = input[i];
      if(root == null){
        root = current;
      }
      if(previous != null){
        previous.next = current;
      }
      previous = current;
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
      if(current.next != null){
        System.out.print("->");
      }
      current = current.next;
    }
    System.out.println();
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6};
    Node root = populateLinkedList(input);
    printLinkedList(root);
    Node deletedList = deleteEven(root);
    printLinkedList(deletedList);
    System.out.println("#############################");
    input = new int[]{2,1,4,3,5,7,6};
    root = populateLinkedList(input);
    printLinkedList(root);
    deletedList = deleteEven(root);
    printLinkedList(deletedList);
  }
}
