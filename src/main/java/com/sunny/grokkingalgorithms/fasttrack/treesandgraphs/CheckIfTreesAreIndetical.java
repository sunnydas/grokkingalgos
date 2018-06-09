package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/9/2018.
 */
public class CheckIfTreesAreIndetical {

  /*
  Check if two give binary trees are identical.
   */

  /**
   *
   * @param root1
   * @param root2
   * @return
   */
  public static boolean isIdentical(BinaryTreeNode root1,BinaryTreeNode root2){
    if(root1 == null && root2 == null){
      return true;
    }
    /*
    One of them is null
     */
    if(root1 == null || root2 == null){
      return false;
    }
    if(root1.data != root2.data){
      return false;
    }
    return (isIdentical(root1.left, root2.left) && isIdentical(root1.right,root2.right));
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode t1 = TreeUtils.createBST();
    System.out.println(isIdentical(t1,t1));
    BinaryTreeNode t2 = TreeUtils.createUnBalancedBinaryTree();
    System.out.println(isIdentical(t1,t2));
  }

}
