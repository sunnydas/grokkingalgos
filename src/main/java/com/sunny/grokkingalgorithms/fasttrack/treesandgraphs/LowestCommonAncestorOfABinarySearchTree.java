package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/11/2018.
 */
public class LowestCommonAncestorOfABinarySearchTree {

  /*
  Lowest common ancestor of a binary search tree
   */

  /**
   *
   * @param root
   * @return
   */
  public static BinaryTreeNode findLCABST(BinaryTreeNode root,int a,int b){
    if(root == null){
      return null;
    }
    /*
    Both nodes are on left root
     */
    if(root.data > a && root.data > b){
      return findLCABST(root.left,a,b);
    }
    /*
    Both nodes are on right of root
     */
    if(root.data < a && root.data < b){
      return findLCABST(root.right,a,b);
    }
    /*
    either: either  a or b are on either side of root
    or: a or b is the ancestor
     */
    else{
      return root;
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("#################");
    System.out.println(findLCABST(root,3,11).data);
    System.out.println(findLCABST(root,5,9).data);
    System.out.println(findLCABST(root,4,6).data);
    System.out.println(findLCABST(root,9,10).data);
    System.out.println(findLCABST(root,6,8).data);
    System.out.println(findLCABST(root,4,11).data);
    System.out.println(findLCABST(root,7,11).data);
    System.out.println(findLCABST(root,10,11).data);
    System.out.println(findLCABST(root,8,11).data);
  }

}
