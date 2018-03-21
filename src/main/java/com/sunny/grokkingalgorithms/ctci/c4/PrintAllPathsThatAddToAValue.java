package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 3/21/2018.
 */
public class PrintAllPathsThatAddToAValue {

  /*
  Print all possible paths that add to value
   */

  /**
   *
   * @param root
   * @param k
   */
   public static void printPossiblePaths(BinaryTreeNode root,int k){
     int depth = depth(root);
     int[] paths = new int[depth];
     printPossiblePaths(root,k,paths,0);
   }

   public static void printPossiblePaths(BinaryTreeNode root,int k,int[] paths,int level){
     if(root == null){
       return;
     }
     paths[level] = root.data;
     /*
     Does this node add up to the sum
      */
     int runningSum = 0;
     for(int i = level ; i >= 0 ; i--){
       runningSum += paths[i];
       if(runningSum == k){
         printPath(paths,i,level);
       }
     }
     printPossiblePaths(root.left,k,paths,level+1);
     printPossiblePaths(root.right,k,paths,level+1);
     paths[level] = Integer.MIN_VALUE;
   }

  /**
   *
   * @param paths
   * @param start
   * @param end
   */
  public static void printPath(int[] paths,int start,int end){
    for(int i = start ; i <= end ; i++){
      System.out.print(paths[i] + "->");
    }
    System.out.println();
  }

  /**
   *
   *
   * @param root
   * @return
   */
   public static int depth(BinaryTreeNode root){
     if(root == null){
       return 0;
     }
     return 1 + Math.max(depth(root.left),depth(root.right));
   }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root);
    printPossiblePaths(root, 8);
    printPossiblePaths(root,9);
    printPossiblePaths(root,7);
    printPossiblePaths(root,4);
    printPossiblePaths(root,6);
  }

}