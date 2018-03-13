package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/13/2018.
 */
public class RemoveDuplicatesFromLinkedList {

  /*
  Write code to delete duplicates from a single linke list
   */

  /**
   *
   * @param root
   * @return
   */
  public static Node removeDuplicatesFromLinkedList(Node root){
    Node current = root;
    while(current != null){
      int data = current.data;
      removeDuplicateNodeIfFound(current.next,data,current);
      current = current.next;
    }
    return root;
  }

  public static void removeDuplicateNodeIfFound(Node currentNode,int searchItem,Node previous){
    while(currentNode != null){
      if(currentNode.data == searchItem){
        if(previous != null){
          previous.next = currentNode.next;
          currentNode.next = null;
          currentNode = previous;
        }
      }
      previous = currentNode;
      currentNode = currentNode.next;
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,5,6,7,8};
    Node root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = removeDuplicatesFromLinkedList(root);
    LinkedListUtil.printLinkedList(root);
    input = new int[]{8,2,3,4,5,5,6,7,8};
    root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = removeDuplicatesFromLinkedList(root);
    LinkedListUtil.printLinkedList(root);
    input = new int[]{8,8,3,4,5,5,7,7,8};
    root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = removeDuplicatesFromLinkedList(root);
    LinkedListUtil.printLinkedList(root);
  }


}
