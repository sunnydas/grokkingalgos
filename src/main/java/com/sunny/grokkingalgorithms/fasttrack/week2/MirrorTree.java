package com.sunny.grokkingalgorithms.fasttrack.week2;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/25/2018.
 */
public class MirrorTree {

  /**
   *
   * @param root
   * @return
   */
  public static BinaryTreeNode mirror(BinaryTreeNode root){
    if(root == null){
      return null;
    }
    BinaryTreeNode left = mirror(root.left);
    BinaryTreeNode right = mirror(root.right);
    root.left = right;
    root.right = left;
    return root;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("Mirror : ");
    root = mirror(root);
    TreeUtils.performBfsLevelMarker(root);
  }

}
