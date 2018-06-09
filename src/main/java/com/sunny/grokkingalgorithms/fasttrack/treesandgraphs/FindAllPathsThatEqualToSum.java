package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 6/9/2018.
 */
public class FindAllPathsThatEqualToSum {

  /*
  Find all paths that equal to a given number
   */
  public static void findAllPathsThatEqualToSum(BinaryTreeNode root,int k){
    int depth = findDepthOfTree(root);
    int[] path = new int[depth];
    findAllPathsThatEqualToSum(root,0,k,path);
  }

  /**
   *
   * @param root
   * @param level
   * @param k
   * @param path
   */
  public static void findAllPathsThatEqualToSum(BinaryTreeNode root,int level,int k,int[] path){
    if(root == null){
      return;
    }
    path[level] = root.data;
    int curSum = 0;
    for(int i = level ; i >= 0 ; i--){
      curSum += path[i];
      if(curSum == k){
        printPath(i,level,path);
      }
    }
    findAllPathsThatEqualToSum(root.left,level+1,k,path);
    findAllPathsThatEqualToSum(root.right,level+1,k,path);
  }

  public static void printPath(int start,int end,int[] path){
    System.out.println();
    for(int i = start ; i <= end; i++){
      System.out.print(path[i] + ",");
    }
  }


  /**
   *
   * @param root
   * @return
   */
   public static int findDepthOfTree(BinaryTreeNode root){
     if(root == null){
       return 0;
     }
     return Math.max(findDepthOfTree(root.left),findDepthOfTree(root.right)) + 1;
   }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("##################");
    findAllPathsThatEqualToSum(root, 24);
    findAllPathsThatEqualToSum(root, 12);
  }

}
