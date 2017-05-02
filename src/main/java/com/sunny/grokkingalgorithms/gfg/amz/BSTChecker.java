package com.sunny.grokkingalgorithms.gfg.amz;

import com.sunny.grokkingalgorithms.gfg.amz.util.AlgoUtil;
import com.sunny.grokkingalgorithms.gfg.amz.util.BinaryNode;

import java.util.Scanner;
class Node {
  int data;
  Node left;
  Node right;

  public Node() {
  }

  public Node(int data) {

    this.data = data;
  }
}
/**
 * Created by sundas on 4/7/2017.
 */
public class BSTChecker {


  //http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/

  //https://www.hackerrank.com/challenges/is-binary-search-tree

  /**
   *
   * @param root
   * @return
   */
  public static boolean checkBST(Node root){
    boolean isBST = false;
    if(root == null){
      isBST = true;
    }
    else{
      int maxLeft = findMaximum(root.left, Integer.MIN_VALUE);
      int minRight = findMinimum(root.right, Integer.MAX_VALUE);
      if(root.data > maxLeft && root.data < minRight){
        isBST = true;
      }
      else{
        isBST = false;
      }
      isBST = isBST && checkBST(root.left) && checkBST(root.right);
    }
    return isBST;
  }

  /**
   * Better solution
   *
   * http://www.ideserve.co.in/learn/check-if-a-binary-tree-is-a-binary-search-tree
   *
   * @param root
   * @return
   */
  public static boolean checkBSTOptimized(Node root){
    return isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
  }

  public static boolean isBST(Node root,int min,int max){
    if(root == null){
      return true;
    }
    if(root.data <= min || root.data >= max){
      return false;
    }
    return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findMaximum(Node root,int max){
    if(root != null){
      if(root.data > max){
        max = root.data;
      }
      int left = findMaximum(root.left, max);
      max = Math.max(max,left);
      int right = findMaximum(root.right, max);
      max = Math.max(max,right);
    }

    return max;
  }


  /**
   *
   * @param root
   * @return
   */
  public static int findMinimum(Node root, int min){
    if(root != null){
      if(root.data < min){
        min = root.data;
      }
      int left = findMinimum(root.left, min);
      min = Math.min(min,left);
      int right = findMinimum(root.right, min);
      min = Math.min(min, right);
    }
    return min;
  }

}
