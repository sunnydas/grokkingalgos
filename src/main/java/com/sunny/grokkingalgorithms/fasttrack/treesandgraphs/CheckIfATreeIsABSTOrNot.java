package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/9/2018.
 */
public class CheckIfATreeIsABSTOrNot {

  /*
  Check if a given binary tree is a BST or not.
   */

  /**
   *
   * @param root
   * @return
   */
  public static boolean isBSTBruteForce(BinaryTreeNode root){
    /*
    Empty tree is a BST
     */
    if(root == null){
      return true;
    }
    int maxOfLeftSubTree = findMax(root.left);
    int minOfRightSubTree = findMin(root.right);
    if(root.data >= maxOfLeftSubTree
        && root.data < minOfRightSubTree){
      /*
      Check if subtrees are bst or not, bST condition for this node has been validated.The BST condition should hold true
       for every node in the tree.
       */
      return (isBSTBruteForce(root.left) && isBSTBruteForce(root.right));
    }
    /*
    Failed BST condistion so false,no need to check further.
     */
    return false;
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findMax(BinaryTreeNode root){
    if(root == null){
      return Integer.MIN_VALUE;
    }
    int left = findMax(root.left);
    int right = findMax(root.right);
    int max = Math.max(left,right);
    max = Math.max(root.data,max);
    return max;
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findMin(BinaryTreeNode root){
    if(root == null){
      return Integer.MAX_VALUE;
    }
    int left = findMin(root.left);
    int right = findMin(root.right);
    int min = Math.min(left,right);
    min = Math.min(root.data,min);
    return min;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println(isBSTBruteForce(root));
    System.out.println("########");
    root = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println(isBSTBruteForce(root));
  }

}
