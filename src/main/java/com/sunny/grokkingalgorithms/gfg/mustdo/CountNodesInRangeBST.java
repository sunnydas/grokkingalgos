package com.sunny.grokkingalgorithms.gfg.mustdo;

import com.sunny.grokkingalgorithms.gfg.mustdo.util.*;
import com.sunny.grokkingalgorithms.gfg.mustdo.util.Node;

/**
 * Created by sundas on 11/26/2017.
 */
public class CountNodesInRangeBST {


  //https://practice.geeksforgeeks.org/problems/count-bst-nodes-that-lie-in-a-given-range/1


  /**
   *
   * @param root
   * @param low
   * @param high
   * @return
   */
  public static int getCountOfNode(com.sunny.grokkingalgorithms.gfg.mustdo.util.Node root, int low, int high)
  {
    int count = 0;
    count = getCountRecursiveInorder(root,low,high,count);
    return count;
  }

  /**
   *
   * @param root
   * @param low
   * @param high
   * @param count
   * @return
   */
  public static int getCountRecursiveInorder(Node root,int low, int high,int count){
    if(root == null){
      return count;
    }
    count = getCountRecursiveInorder(root.left,low,high,count);
    if(low <= root.data && root.data <= high){
      count++;
    }
    count = getCountRecursiveInorder(root.right,low,high,count);
    return count;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {

  }
}
