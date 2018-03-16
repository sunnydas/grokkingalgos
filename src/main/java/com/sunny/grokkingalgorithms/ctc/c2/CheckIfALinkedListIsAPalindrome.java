package com.sunny.grokkingalgorithms.ctc.c2;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.ctc.c2.util.NodeGeneric;

class OutputHolder{

  boolean isPalindrome;
  NodeGeneric root;
}
/**
 * Created by sundas on 3/16/2018.
 */
public class CheckIfALinkedListIsAPalindrome {

  /*
  Check if a linked list is plaindrome
  a->b-> b -> a
   */

  /**
   *
   * @param root
   * @return
   */
  public static boolean isPalindrome(NodeGeneric root){
    boolean isPalindrome = false;
    /*
    The idea behind this is that we go to the end of the list while keeping some track of head
    when we start comparing with head
       then (n-1) from end and head. next and so on
       We use the holkder to return more than one value
     */
    isPalindrome = isPalindromebackTracker(root,root).isPalindrome;
    return isPalindrome;
  }

  /**
   *
   * @param current
   * @param root
   * @return
   */
  public static OutputHolder isPalindromebackTracker(NodeGeneric current, NodeGeneric root){
    /*
    Base condition let back tracking begin
     */
    if(current == null){
      OutputHolder outputHolder = new OutputHolder();
      outputHolder.isPalindrome = true;
      outputHolder.root = root;
      return outputHolder;
    }
    OutputHolder outputHolder = isPalindromebackTracker(current.next,root);
    if(!outputHolder.isPalindrome){
      return outputHolder;
    }
    else{
      /*
      No need to compare till ned of list
       */
      if(current == root){
        return outputHolder;
      }
      OutputHolder currentHolder = new OutputHolder();
      if(current.data == outputHolder.root.data){
        currentHolder.isPalindrome = true;
      }
      else{
        currentHolder.isPalindrome = false;
      }
      currentHolder.root = root.next;
      return currentHolder;
    }
  }



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String[] input = new String[]{"a","b","b","a"};
    NodeGeneric root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    System.out.println(isPalindrome(root));
    System.out.println("next......");
    input = new String[]{"a","b","b","c"};
    root = LinkedListUtil.createLinkedList(input);
    LinkedListUtil.printLinkedList(root);
    System.out.println(isPalindrome(root));

  }

}
