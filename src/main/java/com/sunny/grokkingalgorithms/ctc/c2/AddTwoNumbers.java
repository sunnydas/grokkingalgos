package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;

/**
 * Created by sundas on 3/15/2018.
 *
 * where both numbers are of same length
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

  /*
  Add two numbers represented by linked list
  6->1->7  + 2->9->5
  617 + 295
  912
  stored as 9->1->2
   */

  private static Node sumNodeRoot = null;

  /**
   *
   * @param numberA
   * @param numberB
   * @return
   */
  public static Node addTwoNumbersForward(Node numberA,Node numberB){
    addTwoNumbersUsingBacktracking(numberA,numberB);
    return sumNodeRoot;
  }


  /**
   *
   * @param numberA
   * @param numberB
   * @return
   */
  public static int addTwoNumbersUsingBacktracking(Node numberA,Node numberB){
    /*
       The return type integere rrpresents a carry from previous step. We navigate to end of the two lists and then keep
        adding.
     */
    if(numberA == null && numberB == null){
      return 0;
    }
    int previousCarry = addTwoNumbersUsingBacktracking(numberA.next,numberB.next);
    int sum = numberA.data + numberB.data + previousCarry;
    int currentDigitSum = sum%10;
    int carry = sum/10;
    if(sumNodeRoot == null){
      sumNodeRoot = new Node();
      sumNodeRoot.data = currentDigitSum;
    }
    else{
      Node currentDigit = new Node();
      currentDigit.data = currentDigitSum;
      currentDigit.next = sumNodeRoot;
      sumNodeRoot = currentDigit;
    }
    return carry;
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
    System.out.println("----now stored in forward order");
    input = new int[]{6,1,7};
    numberA = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(numberA);
    input = new int[]{2,9,5};
    numberB = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(numberB);
    sumRoot = addTwoNumbersForward(numberA, numberB);
    LinkedListUtil.printLinkedList(sumRoot);
  }

}
