package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 *
 */
class BalancedTreeCheck{
   boolean areChildSubTreesBalanced;
   int height;
}
/**
 * Created by sundas on 6/9/2018.
 */
public class CheckIfATreeIsBalanced {

  /*
  Given a binary tree find if the tree is balanced.By balanced we mean that the heights of any two subtrees in
  the tree do not differ by more than 1.
   */

  /**
   *
   * @param root
   * @return
   */
  public static BalancedTreeCheck isBalanced(BinaryTreeNode root){
    /*
    Base condition an empty tree is balanced
     */
    if(root == null){
      BalancedTreeCheck balancedTreeCheck = new BalancedTreeCheck();
      balancedTreeCheck.areChildSubTreesBalanced = true;
      balancedTreeCheck.height = 0;
      return balancedTreeCheck;
    }
    /*
    Check place holder for current node
     */
    BalancedTreeCheck currentCheck = new BalancedTreeCheck();
    /*
    First traverse left subtree
     */
    BalancedTreeCheck leftSubTreeCheck = isBalanced(root.left);
    /*
    Only makes sense to proceed if the subtree was balanced
     */
    if(leftSubTreeCheck.areChildSubTreesBalanced){
      /*
      Proceed to right subtree
       */
      BalancedTreeCheck rightSubTreeCheck = isBalanced(root.right);
      if(rightSubTreeCheck.areChildSubTreesBalanced){
        /*
        Actual check
         */
        if(Math.abs(leftSubTreeCheck.height - rightSubTreeCheck.height) > 1){
           currentCheck.areChildSubTreesBalanced = false;
        }
        else{
          currentCheck.areChildSubTreesBalanced = true;
          currentCheck.height = Math.max(leftSubTreeCheck.height,rightSubTreeCheck.height) + 1;
        }
      }
    }
    return currentCheck;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root1 = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root1);
    System.out.println(isBalanced(root1).areChildSubTreesBalanced);
    System.out.println("#########");
    BinaryTreeNode root2 = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root2);
    System.out.println(isBalanced(root2).areChildSubTreesBalanced);
  }

}
