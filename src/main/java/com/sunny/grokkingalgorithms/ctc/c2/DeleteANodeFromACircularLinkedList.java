package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 4/20/2018.
 */
public class DeleteANodeFromACircularLinkedList {

  /*
  Delete a node from a cicrcular linked list
   */

  public static Node deleteANodeFromACircularLinkedList(Node root,int data){
    Node current = root;
    Node previous = null;
    boolean traversedOnce = false;
    while(current != null && (!traversedOnce || current != root)){
      if(current.data == data){
        /*
        Found node to delete
         */
        if(current == root){
          /*
          We need to update the last pointer to point to the next of current
           */
          Node finder = current.next;
          while(finder.next != root){
            finder = finder.next;
          }
          finder.next = current.next;
          root = current.next;
          current = null;
          break;
        }
        else if(current.next == root){
          /*
           Last node
           */
          previous.next = root;
          current = null;
          break;
        }
        else{
          previous.next = current.next;
          current = null;
          break;
        }
      }
      if(!traversedOnce){
        traversedOnce = true;
      }
      previous = current;
      current = current.next;
    }
    return root;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Node root = LinkedListUtil.createCircularListProper();
    LinkedListUtil.printCircularList(root);
    root = deleteANodeFromACircularLinkedList(root, 1);
    System.out.println("===================");
    LinkedListUtil.printCircularList(root);
    System.out.println("===============");
    root = deleteANodeFromACircularLinkedList(root, 5);
    LinkedListUtil.printCircularList(root);
    System.out.println("==========================");
    root = deleteANodeFromACircularLinkedList(root, 9);
    LinkedListUtil.printCircularList(root);
  }

}
