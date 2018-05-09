package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 5/8/2018.
 */
public class ReverseLinkedListBasedOnPattern {

  /*
  2. Given a Single Linked List, reverse the list whenever a �1� is encountered

i/p: 2->3->4->5->1->10->11->12->1->13->14

o/p: 5->4->3->2->1->12->11->10->1->13->14
   */

  /**
   *
   * @param head
   * @param pattern
   * @return
   */
  public static Node reverseLinkedListBasedOnPattern(Node head,int pattern){
    Node begin = head;
    Node current = head;
    Node previous = null;
    Node previousSubListTail = null;
    /*
    Tricky stitching
     */
    while(current != null){
      if(current.data == pattern){
        reverseInRange(begin,previous,current);
        if(head == begin){
          head = previous;
        }
        if(previousSubListTail != null){
          previousSubListTail.next = previous;
        }
        previousSubListTail = current;
        begin = current.next;
      }
      previous = current;
      current = current.next;
    }
    return head;
  }

  /**
   *
   * @param begin
   * @param end
   */
  public static void reverseInRange(Node begin,Node end,Node patternNode){
    Node current = begin;
    Node previous = null;
    while(current != patternNode){
      Node next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    /*
    now begin has become tail
     */
    begin.next = patternNode;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{2,3,4,5,1,10,11,12,1,13,14};
    //int[] input = new int[]{2,3,4,5,1};
    Node node = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(node);
    System.out.println("reversed");
    node = reverseLinkedListBasedOnPattern(node,1);
    LinkedListUtil.printLinkedList(node);
    System.out.println("#######################");
    input = new int[]{2,3,4,5,1};
    node = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(node);
    System.out.println("reversed");
    node = reverseLinkedListBasedOnPattern(node,1);
    LinkedListUtil.printLinkedList(node);
    System.out.println("#######################");
    input = new int[]{2,3,4,5,6};
    node = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(node);
    System.out.println("reversed");
    node = reverseLinkedListBasedOnPattern(node,1);
    LinkedListUtil.printLinkedList(node);
  }

}
