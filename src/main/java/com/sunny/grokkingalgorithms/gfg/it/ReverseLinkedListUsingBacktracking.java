package com.sunny.grokkingalgorithms.gfg.it;

/**
 * Created by sundas on 4/2/2018.
 */
public class ReverseLinkedListUsingBacktracking {


  private static Node reverseHead;

  /**
   *
   * @param root
   * @return
   */
   public static Node reverseLinkedListUsingBackTracking(Node root){
     /*
     Base case
      */
     if(root == null){
       return null;
     }
     Node next = reverseLinkedListUsingBackTracking(root.next);
     if(next == null){
       reverseHead = root;
     }
     else{
        next.next = root;
       //important otherwise we have an infinite loop
        root.next = null;
     }
     return root;
   }



  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5};
    Node root = ReverseLinkList.createLinkedList(input);
    ReverseLinkList.printLinkedList(root);
    reverseLinkedListUsingBackTracking(root);
    ReverseLinkList.printLinkedList(reverseHead);
  }

}
