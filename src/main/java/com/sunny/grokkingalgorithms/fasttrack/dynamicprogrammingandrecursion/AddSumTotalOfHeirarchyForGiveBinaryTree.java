package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/12/2018.
 */
public class AddSumTotalOfHeirarchyForGiveBinaryTree {

   /*
   Given a binary tree add the sum of all its nodes in the child hierarchy
   to the node
    */

  public static int addHierarchySumToAllNodes(BinaryTreeNode root){
    if(root == null){
      return 0;
    }
    int leftSum = addHierarchySumToAllNodes(root.left);
    int rightSum = addHierarchySumToAllNodes(root.right);
    root.data += leftSum + rightSum;
    return root.data;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("#####");
    addHierarchySumToAllNodes(root);
    TreeUtils.performBfsLevelMarker(root);
  }

}
