package com.sunny.grokkingalgorithms.fasttrack.week1;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/21/2018.
 */
public class CheckIfBinaryTreeIsComplete {

  /*
  In the array representation of a binary tree, if the parent next is assigned an index of �i� and left child gets assigned an index of �2*i + 1� while the right child is assigned an index of �2*i + 2�. If we represent the above binary tree as an array with the respective indices assigned to the different nodes of the tree above from top to down and left to right.

Hence we proceed in the following manner in order to check if the binary tree is complete binary tree.

Calculate the number of nodes (count) in the binary tree.
Start recursion of the binary tree from the root next of the binary tree with index (i) being set as 0 and the number of nodes in the binary (count).
If the current next under examination is NULL, then the tree is a complete binary tree. Return true.
If index (i) of the current next is greater than or equal to the number of nodes in the binary tree (count) i.e. (i>= count), then the tree is not a complete binary. Return false.
Recursively check the left and right sub-trees of the binary tree for same condition. For the left sub-tree use the index as (2*i + 1) while for the right sub-tree use the index as (2*i + 2).
   */

  /**
   *
   * @param root
   * @return
   */
  public static int countNodes(BinaryTreeNode root){
    if(root ==  null){
      return 0;
    }
    return countNodes(root.left) + countNodes(root.right)+ 1;
  }

  /**
   *
   * @param root
   * @param index
   * @param totalNodes
   * @return
   */
  public static boolean isComplete(BinaryTreeNode root,
                                   int index,
                                   int totalNodes){
    if(root ==  null){
      return true;
    }
    if(index > totalNodes){
      return false;
    }
    return isComplete(root.left,2*index+1,totalNodes)
        && isComplete(root.right,2*index+2,totalNodes);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root);
    int nodeCount = countNodes(root);
    System.out.println(isComplete(root,0,nodeCount));
  }
}
