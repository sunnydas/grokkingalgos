package com.sunny.grokkingalgorithms.fasttrack.week1;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/21/2018.
 */
public class CheckIfBinaryTreeIsFull {

  /**
   *
   * @param root
   * @return
   */
  public static boolean isFull(BinaryTreeNode root){
    if(root ==  null){
      return true;
    }
    if(root.right == null
        && root.right == null){
      return true;
    }
    if((root.left != null && root.right == null) ||
        (root.left == null && root.right != null)){
      return false;
    }
    boolean leftSubTreeFull = isFull(root.left);
    boolean rightSubTreeFull = isFull(root.right);
    return leftSubTreeFull && rightSubTreeFull;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println(isFull(root));
    System.out.println("##################");
    root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println(isFull(root));
  }

}
