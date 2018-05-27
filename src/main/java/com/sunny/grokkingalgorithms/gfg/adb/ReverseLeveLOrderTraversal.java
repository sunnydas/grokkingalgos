package com.sunny.grokkingalgorithms.gfg.adb;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Level{

  LinkedList<BinaryTreeNode> level;

}
/**
 * Created by sundas on 5/27/2018.
 */
public class ReverseLeveLOrderTraversal {

  /**
   * Reverse Level Order Traversal
   We have discussed level order traversal of a post in previous post. The idea is to print last level first, then second last level, and so on. Like Level order traversal, every level is printed from left to right.

   Example Tree
   Example Tree

   Reverse Level order traversal of the above tree is “4 5 2 3 1”.

   Both methods for normal level order traversal can be easily modified to do reverse level order traversal.
   */


  /**
   *
   * @param root
   */
  public static void reverseLevelOrderTraversal(BinaryTreeNode root){
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(root);
    queue.add(levelMarker);
    Stack<Level> levels = new Stack<>();
    LinkedList<BinaryTreeNode> levelNodes = null;
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      if(current == levelMarker){
        if(levelNodes != null) {
          Level level = new Level();
          level.level = levelNodes;
          levels.push(level);
          levelNodes = null;
        }
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        if(levelNodes == null){
          levelNodes = new LinkedList<>();
        }
        levelNodes.add(current);
        if(current.left != null){
          queue.add(current.left);
        }
        if(current.right != null){
          queue.add(current.right);
        }
      }
    }
    while(!levels.isEmpty()){
      Level level = levels.pop();
      LinkedList<BinaryTreeNode> levelNodeElements = level.level;
      for(BinaryTreeNode node : levelNodeElements){
        System.out.println(node.data);
      }
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println("#######");
    reverseLevelOrderTraversal(root);
  }

}
