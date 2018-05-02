package com.sunny.grokkingalgorithms.ctc.c2.ava;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
class Payload{

  Node root;
  boolean curStatus;

  @Override
  public String toString() {
    return "Payload{" +
        "root=" + root +
        ", curStatus=" + curStatus +
        '}';
  }
}
/**
 * Created by sundas on 5/2/2018.
 */
public class CheckIfALinkedListIsPlaindrome {


  /**
   *
   * @param root
   * @return
   */
  public static Payload isPalindrome(Node root,Node current){
    if(current == null){
      Payload payload = new Payload();
      payload.root = root;
      payload.curStatus = true;
      return payload;
    }
    Payload payload = isPalindrome(root,current.next);
    if(payload.curStatus == false){
      return payload;
    }
    else{
      if(payload.root.data == current.data){
        payload.curStatus = true;
        payload.root = payload.root.next;
        return payload;
      }
      else{
        payload.curStatus = false;
        return payload;
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,2,1};
    Node root = LinkedListUtil.createLinkedList(input);
    Payload payload = isPalindrome(root,root);
    System.out.println(payload.curStatus);
    input = new int[]{1,2,3,4,5};
    root = LinkedListUtil.createLinkedList(input);
    payload = isPalindrome(root,root);
    System.out.println(payload.curStatus);
  }

}
