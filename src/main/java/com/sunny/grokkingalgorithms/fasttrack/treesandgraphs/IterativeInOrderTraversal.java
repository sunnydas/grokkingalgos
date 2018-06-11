package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.Stack;

/**
 * Created by sundas on 6/11/2018.
 */
public class IterativeInOrderTraversal {

  /*
  Iterative inorder traversal.
   */

  /**
   *
   * @param root
   */
  public static void iterativeInorderTraversal(BinaryTreeNode root){
    Stack<BinaryTreeNode> s1 = new Stack<>();
    if(root != null) {
      while (true) {
        if(root != null){
          s1.push(root);
          root = root.left;
        }
        else if(root == null){
          if(s1.isEmpty()){
            break;
          }
          BinaryTreeNode current = s1.pop();
          System.out.println(current.data);
          root = current.right;
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
    System.out.println("##################");
    iterativeInorderTraversal(root);
  }

}
