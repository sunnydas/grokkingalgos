package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 5/16/2018.
 */
public class RootToLeafEqualsSum {

  /*
  Given a binary tree and a number, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals the given number. Return false if no such path can be found.



For example, in the above tree root to leaf paths exist with following sums.

21 –> 10 – 8 – 3
23 –> 10 – 8 – 5
14 –> 10 – 2 – 2

So the returned value should be true only for numbers 21, 23 and 14. For any other number, returned value should be false.
   */

  /**
   *
   * @param root
   * @param k
   * @param sum
   * @return
   */
  public static boolean rootToLeafPath(BinaryTreeNode root, int k,int sum){
    if(root == null){
      return false;
    }
    sum += root.data;
    if(root.right == null && root.left == null){
      if(sum == k){
        return true;
      }
    }
    boolean found = rootToLeafPath(root.left,k,sum);
    if(!found){
      found = rootToLeafPath(root.right,k,sum);
    }
    return found;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println(rootToLeafPath(root,7,0));
  }
}
