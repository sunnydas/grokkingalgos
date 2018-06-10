package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
import sun.reflect.generics.tree.Tree;

import java.util.Stack;

/**
 * Created by sundas on 6/10/2018.
 */
public class IterativePostOrderTraversalUsing2Stacks {

  /*
  Iterative post order traversal using two stacks
   */

  /**
   *
   * @param root
   */
  public static void iterativePostOrderTraversalUsing2Stacks(BinaryTreeNode root){
    Stack stack1 = new Stack();
    Stack stack2 = new Stack();
    stack1.push(root);
    while(!stack1.isEmpty()){
      BinaryTreeNode node = (BinaryTreeNode) stack1.pop();
      stack2.push(node);
      if(node.left != null){
        stack1.push(node.left);
      }
      if(node.right != null){
        stack1.push(node.right);
      }
    }
    while(!stack2.isEmpty()){
      System.out.println(((BinaryTreeNode) stack2.pop()).data);
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performPostOrder(root);
    System.out.println("##################");
    iterativePostOrderTraversalUsing2Stacks(root);
  }

}
