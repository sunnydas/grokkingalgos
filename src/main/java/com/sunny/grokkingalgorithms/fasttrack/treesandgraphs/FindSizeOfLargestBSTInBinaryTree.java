package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/11/2018.
 */
class BSTChecker{
  boolean isBST;
  int size;
  int min;
  int max;
}
public class FindSizeOfLargestBSTInBinaryTree {

  /**
   *
   * @param root
   * @return
   */
  public static BSTChecker findLargestBST(BinaryTreeNode root){
    if(root == null){
      BSTChecker bstChecker = new BSTChecker();
      bstChecker.isBST = true;
      bstChecker.max = Integer.MIN_VALUE;
      bstChecker.min = Integer.MAX_VALUE;
      bstChecker.size = 0;
      return bstChecker;
    }
    BSTChecker leftCheck = findLargestBST(root.left);
    BSTChecker rightCheck = findLargestBST(root.right);
    /*
    Both left and right sub trees are BSTs
     */
    if(leftCheck.isBST && rightCheck.isBST){
      /*
      Is it still a bst with this root included ?
       */
      if(leftCheck.max < root.data
          && rightCheck.min > root.data){
        /*
        We can reuse the same place holder
         */
        leftCheck.size = leftCheck.size + rightCheck.size + 1;
        leftCheck.isBST = true;
        /*
        This takes care of updating the min max from leaf nodes (since
        we have a logic where we set integre.min_value and integer.max_value)
         */
        leftCheck.min = (root.left == null)? root.data : leftCheck.min;
        leftCheck.max = (root.right == null)? root.data : rightCheck.max;
        return leftCheck;
      }
      else{
        BSTChecker bstChecker = new BSTChecker();
        bstChecker.size = Math.max(leftCheck.size,rightCheck.size);
        return bstChecker;
      }
    }
    else{
      //Either of the two subtrees are not bsts, just return the
      //size
      BSTChecker bstChecker = new BSTChecker();
      bstChecker.size = Math.max(leftCheck.size,rightCheck.size);
      return bstChecker;
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("####################");
    System.out.println(findLargestBST(root).size);
  }

}