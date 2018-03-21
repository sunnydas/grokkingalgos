package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 3/21/2018.
 */
public class CheckTreeIsSubTreeOfAnotherTree {

  /*
  Given tow binary trees T1 and T2 , check if T2 is subtree of T1. subtree means they should be identical in value
  and shape
   */

  /**
   *
   * @param t1
   * @param t2
   * @return
   */
  public static boolean isT2SubsetOfT1(BinaryTreeNode t1,BinaryTreeNode t2){
    /*
    The idea is that we search T1 for a node mantching t2 and then
    we perform a preorder traversal together. Assumes all keys are unique.
     */
    boolean isSubTree = false;
    BinaryTreeNode found = findt2InT1(t1,t2);
    if(found != null){
       isSubTree = traverseTogetherAndCheck(found,t2);
    }
    return isSubTree;
  }

  /**
   *
   * @param t1
   * @param t2
   * @return
   */
  public static boolean traverseTogetherAndCheck(BinaryTreeNode t1,BinaryTreeNode t2){
    /*
    Not sure of this base conditions
     */
    if(t1 == null && t2 == null){
      return true;
    }
    if(t2 == null){
      return true;
    }
    if(t1 == null){
      return false;
    }
    if(t1.data != t2.data){
      return false;
    }
    boolean match = traverseTogetherAndCheck(t1.left,t2.left);
    if(!match){
      return false;
    }
    match = traverseTogetherAndCheck(t1.right,t2.right);
    if(!match){
      return false;
    }
    return true;
  }

  /**
   *
    * @param t1
   * @param t2
   * @return
   */
  public static BinaryTreeNode findt2InT1(BinaryTreeNode t1,BinaryTreeNode t2){
    if(t1 == null){
      return null;
    }
    if(t1.data == t2.data){
      return t1;
    }
    BinaryTreeNode found = findt2InT1(t1.left,t2);
    if(found == null){
      found = findt2InT1(t1.right,t2);
    }
    return found;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode t1 = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(t1);
    BinaryTreeNode t2 = TreeUtils.createT2AsSubsetOfBalancedTree();
    System.out.println(isT2SubsetOfT1(t1,t2));
    t2 = TreeUtils.createT2AsSubsetOfBalancedTreeAlt();
    System.out.println(isT2SubsetOfT1(t1,t2));
    t2 = TreeUtils.createUnBalancedBinaryTree();
    System.out.println(isT2SubsetOfT1(t1,t2));
  }

}
