package com.sunny.grokkingalgorithms.fasttrack.week2;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/24/2018.
 */
public class HeightOfATree {

  /*
  Find height of a tree.
   */

  /**
   *
   * @param root
   * @return
   */
  public static int height(BinaryTreeNode root){
    if(root == null){
      return 0;
    }
    int leftHeight = height(root.left);
    int rightHeight = height(root.right);
    return Math.max(leftHeight,rightHeight) + 1;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("Height of tree = ");
    System.out.println(height(root));
  }

}
