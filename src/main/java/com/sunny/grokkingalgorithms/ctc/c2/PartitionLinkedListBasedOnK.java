package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import sun.awt.image.ImageWatched;

/**
 * Created by sundas on 3/14/2018.
 */
public class PartitionLinkedListBasedOnK {

  /*
  Given a value k , partition a given linked list such the all values < k are to the left and all values to the
  right are > k.
   */

  /**
   *
   * @param root
   * @param k
   * @return
   */
  public static Node partitionLinkedList(Node root, int k){
    /*
    Create two linked lists one with < k
    one with > k
    merge these two lists
     */
    Node leftRoot = null;
    Node leftOfKPrevious = null;
    Node rightRoot = null;
    Node rightOfKPrevious = null;
    Node current = root;
    Node partitionNode = null;
    while(current != null){
      if(current.data < k){
        /*
        Update left
         */
        Node left = new Node();
        left.data = current.data;
        if(leftRoot == null){
          leftRoot = left;
        }
        if(leftOfKPrevious != null){
          leftOfKPrevious.next = left;
        }
        leftOfKPrevious = left;
      }
      else if (current.data > k){
        /*
        Update right
         */
        Node right = new Node();
        right.data = current.data;
        if(rightRoot == null){
          rightRoot = right;
        }
        if(rightOfKPrevious != null){
          rightOfKPrevious.next = right;
        }
        rightOfKPrevious = right;
      }
      else{
        /*
        We want the partition point to exact, fi we do not do this the partition point may end up
        later or earlier in any of the left or
        right lists
         */
        partitionNode = new Node();
        partitionNode.data = current.data;
      }
      current = current.next;
    }
    /*
    Now merge the two lists abd partition point of it exists
     */
    if(partitionNode != null){
      if(leftOfKPrevious != null) {
        leftOfKPrevious.next = partitionNode;
      }
      if(leftRoot == null){
        leftRoot = partitionNode;
      }
      partitionNode.next = rightRoot;
    }
    else {
      leftOfKPrevious.next = rightRoot;
    }
    root = leftRoot;
    return root;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{100,11,3,6,1,2,2,1,2,3,4,5,6,7,8,1};
    Node root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = partitionLinkedList(root,4);
    LinkedListUtil.printLinkedList(root);
    System.out.println("next------------------------------");
    input = new int[]{100,11,3,6,1,2,2,1,2,3,4,5,6,7,8,1};
    root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = partitionLinkedList(root, 1);
    LinkedListUtil.printLinkedList(root);
    System.out.println("next--------------------------------");
    input = new int[]{100,11,3,6,1,2,2,1,2,3,4,5,6,7,8,1};
    root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = partitionLinkedList(root,100);
    LinkedListUtil.printLinkedList(root);
    System.out.println("next--------------------------------");
    input = new int[]{100,11,3,6,1,2,2,1,2,3,4,5,6,7,8,9,10,1};
    root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    root = partitionLinkedList(root,8);
    LinkedListUtil.printLinkedList(root);
  }
}
