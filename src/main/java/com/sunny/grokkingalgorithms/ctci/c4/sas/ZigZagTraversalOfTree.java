package com.sunny.grokkingalgorithms.ctci.c4.sas;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sundas on 4/7/2018.
 */
public class ZigZagTraversalOfTree {

  /*
  Zig zag traversal of a tree
   */

  /**
   *
   * @param root
   */
  public static void zigZagTraversal(BinaryTreeNode root){
    if(root != null){
      Queue<BinaryTreeNode> queue = new LinkedList<>();
      BinaryTreeNode levelMarker = new BinaryTreeNode();
      queue.add(root);
      queue.add(levelMarker);
      boolean reverse = false;
      Stack<BinaryTreeNode> reversePrinter = new Stack<>();
       while(!queue.isEmpty()){
        BinaryTreeNode current = queue.poll();
        if(current ==  levelMarker){
          if(reverse){
            while(!reversePrinter.isEmpty()){
              System.out.println(reversePrinter.pop().data);
            }
          }
          else{
            if(!queue.isEmpty()){
              queue.add(levelMarker);
            }
          }
          reverse = !reverse;
        }
         else{
          if(!reverse) {
            System.out.println(current.data);
          }
          else{
            reversePrinter.add(current);
          }
          if(current.left != null){
            queue.add(current.left);
          }
          if(current.right != null){
            queue.add(current.right);          }
        }
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println("zig zag");
    zigZagTraversal(root);
  }

}
