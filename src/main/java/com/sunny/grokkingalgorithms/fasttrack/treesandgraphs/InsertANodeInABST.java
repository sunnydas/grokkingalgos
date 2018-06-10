package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/10/2018.
 */
public class InsertANodeInABST {

  /*
  Insert a node in a binary search tree
   */

  /**
   *
   * @param root
   */
   public static void insertIntoBST(BinaryTreeNode root,int key,BinaryTreeNode parent,boolean leftChild){
     /*
     Essentially find an empty spot and insert it , fullfiling the BST criteria.
      */
     if(root == null){
       BinaryTreeNode node = new BinaryTreeNode();
       node.data = key;
       /*
       We need to know the direction
        */
       if(parent != null){
         if(leftChild){
           parent.left = node;
         }
         else{
           parent.right = node;
         }
       }
       return;
     }
     if(root.data == key){
       return;
     }
     /*
     Go left
      */
     if(key < root.data){
       insertIntoBST(root.left,key,root,true);
     }
     /*
     Go right
      */
     else{
       insertIntoBST(root.right,key,root,false);
     }
   }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("############################");
    insertIntoBST(root, 12, null, false);
    System.out.println("Inserting 12");
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("############################");
    System.out.println("Inorder traversal");
    TreeUtils.inorder(root);
    insertIntoBST(root, 2, null, false);
    System.out.println("Inserting 12");
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("############################");
    System.out.println("Inorder traversal");
    TreeUtils.inorder(root);
    insertIntoBST(root, 8, null, false);
    System.out.println("Inserting 8");
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("############################");
    System.out.println("Inorder traversal");
    TreeUtils.inorder(root);
    insertIntoBST(root, 1, null, false);
    System.out.println("Inserting 1");
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("############################");
    System.out.println("Inorder traversal");
    TreeUtils.inorder(root);
  }

}
