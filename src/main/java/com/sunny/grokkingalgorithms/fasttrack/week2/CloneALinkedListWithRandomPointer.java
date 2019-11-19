package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.HashMap;
import java.util.Map;

class Node
{
  int data;//Node data
  Node next, random;//Next and random reference

  //Node constructor
  public Node(int data)
  {
    this.data = data;
    this.next = this.random = null;
  }
}
/**
 * Created by sundas on 6/25/2018.
 */
public class CloneALinkedListWithRandomPointer {

  Node head;//Linked list head reference

  // Linked list constructor
  public CloneALinkedListWithRandomPointer(Node head)
  {
    this.head = head;
  }

  // push method to put data always at the head
  // in the linked list.
  public void push(int data)
  {
    Node node = new Node(data);
    node.next = this.head;
    this.head = node;
  }

  // Method to print the list.
  void print()
  {
    Node temp = head;
    while (temp != null)
    {
      Node random = temp.random;
      int randomData = (random != null)? random.data: -1;
      System.out.println("Data = " + temp.data +
          ", Random data = "+ randomData);
      temp = temp.next;
    }
  }

  /*
  Clone a linked list with next and random pointer | Set 1
You are given a Double Link List with one pointer of each next pointing to the next next just like in a single link list. The second pointer however CAN point to any next in the list and not just the previous next. Now enqueue a program in O(n) time to duplicate this list. That is, enqueue a program which will create a copy of this list.

Let us call the second pointer as arbit pointer as it can point to any arbitrary next in the linked list.
   */

  /**
   *
   * @return
   */
  public CloneALinkedListWithRandomPointer clone() {
    /*
    The idea is to use Hashing. Below is algorithm.
1. Traverse the original linked list and make a copy in terms of data.
2. Make a hash map of key value pair with original linked list next and copied linked list next.
3. Traverse the original linked list again and using the hash map adjust the next
and random reference of cloned linked list nodes.
     */
    Map<Node,
        Node> map = new HashMap<>();
    Node current = this.head;
    Node cloneHead = null;
    while(current != null){
      map.put(current,new Node(current.data));
      current = current.next;
    }
    current = this.head;
    while(current != null){
      Node clone = map.get(current);
      if(cloneHead ==  null){
        cloneHead = clone;
      }
      clone.next = map.get(current.next);
      clone.random = map.get(current.random);
      current = current.next;
    }
    CloneALinkedListWithRandomPointer clone =
        new CloneALinkedListWithRandomPointer(cloneHead);
    return clone;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    // Pushing data in the linked list.
    CloneALinkedListWithRandomPointer list = new CloneALinkedListWithRandomPointer(new Node(5));
    list.push(4);
    list.push(3);
    list.push(2);
    list.push(1);

    // Setting up random references.
    list.head.random = list.head.next.next;
    list.head.next.random =
        list.head.next.next.next;
    list.head.next.next.random =
        list.head.next.next.next.next;
    list.head.next.next.next.random =
        list.head.next.next.next.next.next;
    list.head.next.next.next.next.random =
        list.head.next;

    // Making a clone of the original linked list.
    CloneALinkedListWithRandomPointer clone = list.clone();

    // Print the original and cloned linked list.
    System.out.println("Original linked list");
    list.print();
    System.out.println("\nCloned linked list");
    clone.print();

  }
}
