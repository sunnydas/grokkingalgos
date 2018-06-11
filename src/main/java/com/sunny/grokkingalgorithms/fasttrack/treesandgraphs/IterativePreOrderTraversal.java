package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.Stack;

/**
 * Created by sundas on 6/11/2018.
 */
public class IterativePreOrderTraversal {

  /*
  Iterative pre-order traversal.
   */

  /**
   *
   * @param root
   */
  public static void iterativePreOrder(BinaryTreeNode root){
    Stack<BinaryTreeNode> s1 = new Stack();
    if(root != null){
      s1.push(root);
      while(!s1.isEmpty()){
        /*
        We push right child before left child node
         */
        BinaryTreeNode current = s1.pop();
        System.out.println(current.data);
        if(current.right != null){
          s1.push(current.right);
        }
        if(current.left != null){
          s1.push(current.left);
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
    System.out.println("################################");
    System.out.println("recursive pre order");
    TreeUtils.preOrder(root);
    System.out.println("iterative pre order");
    iterativePreOrder(root);
  }

}
