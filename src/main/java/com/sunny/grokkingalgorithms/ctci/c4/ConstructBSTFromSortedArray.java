package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 3/19/2018.
 */
public class ConstructBSTFromSortedArray {

  /*
  Construct a BST from a sorted array with minim height
   */

  /**
   *
   * @param input
   * @return
   */
  public static BinaryTreeNode constructBST(int[] input,int startIndex,int endIndex){
    if(startIndex == endIndex){
      BinaryTreeNode node = new BinaryTreeNode();
      node.data = input[startIndex];
      return node;
    }
    BinaryTreeNode root = null;
    /*
    A BST of minimum height can be constructed if we keep using the mid point of the array as root,all elements to the
    left of the array are left children and all arrays to the right are right children.
     */
    int mid = startIndex + (endIndex - startIndex)/2;
    root = new BinaryTreeNode();
    root.data = input[mid];
    root.left = constructBST(input,startIndex,mid-1);
    root.right = constructBST(input,mid+1,endIndex);
    return root;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6,7};
    BinaryTreeNode root = constructBST(input,0,input.length - 1);
    TreeUtils.performBfs(root);
    System.out.println(CheckIfATreeIsBST.isBST(root));
    System.out.println("--------");
    TreeUtils.inorder(root);
  }

}