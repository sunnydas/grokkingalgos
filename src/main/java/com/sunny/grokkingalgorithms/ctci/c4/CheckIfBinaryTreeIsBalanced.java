package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

class OutputHolder{

  public boolean isBalanced;
  public int height;

}
/**
 * Created by sundas on 3/18/2018.
 */
public class CheckIfBinaryTreeIsBalanced {

  /*
  Check if a  binary tree is balancd. By Balanced we mean heights of left and right sub tree should not differ by more
  than one.
  Height of next
The height of a next is the number of edges on the longest path between that next and a leaf.
   */


  /**
   *
   * @param root
   * @return
   */
  public static OutputHolder isBalanced(BinaryTreeNode root){
    /*
    Base condition a null tree is a balanced tree
     */
    if(root == null){
      OutputHolder outputHolder = new OutputHolder();
      outputHolder.height = 0;
      outputHolder.isBalanced = true;
      return outputHolder;
    }
    /*
    left subtree
     */
    OutputHolder left =  isBalanced(root.left);
    if(left.isBalanced){
      /*
      right subtree
       */
      OutputHolder right = isBalanced(root.right);
      if(right.isBalanced){
        //compare heights
        if(Math.abs(left.height - right.height) > 1){
          OutputHolder outputHolder = new OutputHolder();
          outputHolder.isBalanced = false;
          return outputHolder;
        }
        else{
          OutputHolder outputHolder = new OutputHolder();
          outputHolder.isBalanced = true;
          outputHolder.height = Math.max(left.height,right.height) + 1;
          return outputHolder;
        }
      }
      else{
        return right;
      }
    }
    else {
      return left;
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println(isBalanced(root).isBalanced);
    root = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println(isBalanced(root).isBalanced);
  }
}
