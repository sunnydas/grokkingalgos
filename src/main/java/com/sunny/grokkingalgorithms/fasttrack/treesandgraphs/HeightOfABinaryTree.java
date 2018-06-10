package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/10/2018.
 */
public class HeightOfABinaryTree {

  /*
  Calculate height of a binary tree, number of edges from root to deepest leaf
   */

  /**
   *
   * @param root
   * @return
   */
  public static int heightOf(BinaryTreeNode root){
    if(root == null){
      return 0;
    }
    int leftHeight = heightOf(root.left);
    int rightHeight = heightOf(root.right);
    return Math.max(leftHeight,rightHeight) + 1;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("#################");
    System.out.println(heightOf(root));
  }

}
