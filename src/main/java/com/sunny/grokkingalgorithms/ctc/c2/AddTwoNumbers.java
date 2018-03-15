package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/15/2018.
 */
public class AddTwoNumbers {

  /*
  Add two numbers represented by linked list
  7->1->6  + 5->9->2
  617 + 295
  912
  stored as 2->1->9
   */

  /**
   *
   * @param numberA
   * @param numberB
   * @return
   */
  public static Node addTwoNumbers(Node numberA,Node numberB){
    Node sumRoot = null;
    int previousCarry = 0;
    Node aRunner = numberA;
    Node bRunner = numberB;
    Node previousDigitNode = null;
    /*
    Assuming that both the linked lists are of same size
     */
    while(aRunner != null && bRunner != null){
      int tempSum = aRunner.data + bRunner.data + previousCarry;
      int currentDigit = tempSum%10;
      previousCarry = tempSum/10;
      Node currentdigitNode = new Node();
      currentdigitNode.data = currentDigit;
      if(sumRoot == null){
        sumRoot = currentdigitNode;
      }
      if(previousDigitNode != null){
        previousDigitNode.next = currentdigitNode;
      }
      previousDigitNode = currentdigitNode;
      aRunner = aRunner.next;
      bRunner = bRunner.next;
    }
    if(previousCarry > 0){
      Node currentDigitNode = new Node();
      currentDigitNode.data = previousCarry;
      if(previousDigitNode != null){
        previousDigitNode.next = currentDigitNode;
      }
    }
    return sumRoot;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{7,1,6};
    Node numberA = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(numberA);
    input = new int[]{5,9,2};
    Node numberB = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(numberB);
    Node sumRoot = addTwoNumbers(numberA, numberB);
    LinkedListUtil.printLinkedList(sumRoot);
    System.out.println("next.......");
    input = new int[]{7,1,9};
    numberA = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(numberA);
    input = new int[]{5,9,9};
    numberB = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(numberB);
    sumRoot = addTwoNumbers(numberA,numberB);
    LinkedListUtil.printLinkedList(sumRoot);

  }

}
