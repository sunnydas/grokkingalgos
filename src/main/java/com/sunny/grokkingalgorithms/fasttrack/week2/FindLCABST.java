package com.sunny.grokkingalgorithms.fasttrack.week2;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/27/2018.
 */
public class FindLCABST {

  /*
  Find LCA BST
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
    if(root.data < a && root.data < b){
      return findLCABST(root.right,a,b);
    }
    else if(root.data > a && root.data > b){
      return findLCABST(root.left,a,b);
    }
    else{
      //is root the lca
      if(findNode(root,a) && findNode(root,b)){
        return root;
      }
      else{
        return null;
      }
    }
  }

  /**
   *
   * @param root
   * @param a
   * @return
   */
  public static boolean findNode(BinaryTreeNode root,int a){
    if(root == null){
      return false;
    }
    if(root.data == a){
      return true;
    }
    boolean found = findNode(root.left,a);
    if(!found){
      found = findNode(root.right,a);
    }
    return found;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println();
    System.out.println(findLCABST(root, 3, 11).data);
    System.out.println();
    System.out.println(findLCABST(root,9,10).data);
    System.out.println();
    System.out.println(findLCABST(root,6,8).data);
    System.out.println();
    System.out.println(findLCABST(root,8,10).data);
    System.out.println();
    System.out.println(findLCABST(root,25,34));
    System.out.println();
    System.out.println(findLCABST(root,3,34));
  }

}
