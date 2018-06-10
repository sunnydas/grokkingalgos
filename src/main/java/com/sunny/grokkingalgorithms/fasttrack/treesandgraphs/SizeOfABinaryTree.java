package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/10/2018.
 */
public class SizeOfABinaryTree {

  /*
  Find size of a binary tree (total number of nodes in the tree)
   */

  /**
   *
   * @param root
   * @return
   */
  public static int sizeOf(BinaryTreeNode root){
    if(root == null){
      return 0;
    }
    return sizeOf(root.left) + sizeOf(root.right) + 1;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("################");
    System.out.println(sizeOf(root));
  }

}
