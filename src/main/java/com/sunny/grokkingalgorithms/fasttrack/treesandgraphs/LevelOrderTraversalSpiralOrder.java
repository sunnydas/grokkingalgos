package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sundas on 6/11/2018.
 */
public class LevelOrderTraversalSpiralOrder {

  /*
  Level order traversal spiral order.
  L-R
  R-L
  L-R
  ...
   */

  /**
   *
   * @param root
   */
  public static void spiralOrderTraversalUsingDequeue(BinaryTreeNode root){
    if(root == null){
      return;
    }
    /*
    This technique is similar to two stacks but uses deque which simulates two
    stacks
     */
    /*
    Using linked list since we dont want to call sizeOf(tree) to use array based
    dequeue.
     */
    Deque<BinaryTreeNode> deque = new LinkedList<>();
    /*
    This marker provides the barrier between the two stacks
     */
    BinaryTreeNode marker = new BinaryTreeNode();
    deque.add(marker);
    /*
    Front of dequeue = stack1
    end of dequeue = stack2
     */
    deque.addFirst(root);
    /*
    If the only element in the dequeue is the marker , then we have
    processed the entire tree
     */
    while(deque.size() > 1){
      /*
      s1 processing
       */
      while(deque.peekFirst() != marker){
        BinaryTreeNode current = deque.pollFirst();
        System.out.print(current.data + " ");
        if(current.left != null){
          deque.addLast(current.left);
        }
        if(current.right != null){
          deque.addLast(current.right);
        }
      }
      /*
      s2 processing
       */
      while(deque.peekLast() != marker){
        BinaryTreeNode current = deque.pollLast();
        System.out.print(current.data + " ");
        if(current.right != null){
          deque.addFirst(current.right);
        }
        if(current.left != null){
          deque.addFirst(current.left);
        }
      }
    }
  }

  /**
   *
   * @param root
   */
  public static void spiralOrderTraversalUsingTwoStacks(
      BinaryTreeNode root){
    if(root == null){
      return;
    }
    Stack<BinaryTreeNode> s1 = new Stack<>();
    Stack<BinaryTreeNode> s2 = new Stack<>();
    s1.push(root);
    System.out.println();
    while(!s1.isEmpty()
        || !s2.isEmpty()){
      while(!s1.isEmpty()){
        BinaryTreeNode current = s1.pop();
        System.out.print(current.data + " ");
        if(current.left != null){
          s2.push(current.left);
        }
        if(current.right != null){
          s2.push(current.right);
        }
      }
      while(!s2.isEmpty()){
        BinaryTreeNode current = s2.pop();
        System.out.print(current.data + " ");
        if(current.right != null){
          s1.push(current.right);
        }
        if(current.left != null){
          s1.push(current.left);
        }
      }
    }
    System.out.println();
  }

  /**
   *
   * @param root
   */
  public static void spiralOrderTraversal(BinaryTreeNode root){
    if(root == null){
      return;
    }
    Stack<String> reverseOrderTracker = new Stack<>();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(levelMarker);
    /*
    Remember to toggle this flag
     */
    boolean reversePrint = false;
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      if(current == levelMarker){
        if(reversePrint){
          while(!reverseOrderTracker.isEmpty()){
            System.out.print(reverseOrderTracker.pop());
          }
        }
        //Important
        reversePrint = !reversePrint;
        System.out.println();
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        if(reversePrint){
          reverseOrderTracker.push(""+current.data + " ");
        }
        else{
          System.out.print(current.data + " ");
        }
        if(current.left != null){
          queue.add(current.left);
        }
        if(current.right != null){
          queue.add(current.right);
        }
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("###############");
    spiralOrderTraversal(root);
    System.out.println("################");
    spiralOrderTraversalUsingTwoStacks(root);
    System.out.println("##################");
    spiralOrderTraversalUsingDequeue(root);
  }

}
