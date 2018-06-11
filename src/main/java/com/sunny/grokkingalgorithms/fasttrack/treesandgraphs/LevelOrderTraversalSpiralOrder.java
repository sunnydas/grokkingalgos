package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

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
  }

}
