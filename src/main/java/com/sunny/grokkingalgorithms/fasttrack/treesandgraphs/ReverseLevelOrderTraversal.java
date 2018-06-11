package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sundas on 6/11/2018.
 */
public class ReverseLevelOrderTraversal {

  /*
  Reverse level order traversal, We need to preserve the direction
  at each level.
   */

  /**
   *
   * @param root
   */
  public static void reverseLeveLOrderTraversal(BinaryTreeNode root){
    if(root == null){
      return;
    }
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(levelMarker);
    Stack<String> levels = new Stack<>();
    String level = null;
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      if(current == levelMarker){
        if(level != null){
          levels.push(level);
          level = null;
        }
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        if(level == null){
          level = "";
        }
        level += current.data + " ";
        if(current.left != null){
          queue.add(current.left);
        }
        if(current.right != null){
          queue.add(current.right);
        }
      }
    }
    while(!levels.isEmpty()){
      System.out.println(levels.pop());
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
    reverseLeveLOrderTraversal(root);
  }

}
