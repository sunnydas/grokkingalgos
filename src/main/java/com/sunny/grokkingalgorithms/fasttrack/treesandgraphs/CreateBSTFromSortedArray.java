package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/9/2018.
 */
public class CreateBSTFromSortedArray {

  /*
  Given a sorted array create a BST with minimum height
   */

  /**
   *
   * @param input
   * @return
   */
  public static BinaryTreeNode createBSTWithMinimumHeight(int[] input,
                                                          int start,int end){
    if(start > end){
      return null;
    }
    BinaryTreeNode root = new BinaryTreeNode();
    int mid = start + (end - start)/2;
    root.data = input[mid];
    root.left = createBSTWithMinimumHeight(input,start,mid - 1);
    root.right = createBSTWithMinimumHeight(input,mid+1,end);
    return root;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{1,2,3,4,5,6};
    BinaryTreeNode root = createBSTWithMinimumHeight(input,0,input.length - 1);
    TreeUtils.performBfsLevelMarker(root);
  }

}
