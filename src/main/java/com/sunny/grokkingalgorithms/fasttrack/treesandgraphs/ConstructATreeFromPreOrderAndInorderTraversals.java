package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/11/2018.
 */
public class ConstructATreeFromPreOrderAndInorderTraversals {

  /*
  Construct a tree using pre order and inorder traversa;s
   */

  static int preOrderIndex = 0;

  /**
   *
   * @param inorder
   * @param preOrder
   * @param start
   * @param end
   * @return
   */
  public static BinaryTreeNode createBTree(int[] inorder,int[] preOrder,
                                           int start,int end){
    if(start > end){
      return null;
    }
    int i;
    for(i = start; i <= end ; i++){
      if(preOrder[preOrderIndex] == inorder[i]){
        break;
      }
    }
    BinaryTreeNode node = new BinaryTreeNode();
    node.data = preOrder[preOrderIndex++];
    node.left = createBTree(inorder,preOrder,start,i-1);
    node.right = createBTree(inorder,preOrder,i+1,end);
    return node;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int inorder[]  = {-7,-6,-5,-4,-3,-2,1,2,3,16,6,10,11,12,14};
    int preorder[] = {3,-2,-3,-4,-5,-6,-7,1,2,16,10,6,12,11,14};
    BinaryTreeNode root = createBTree(inorder,preorder,0,inorder.length - 1);
    TreeUtils.performBfsLevelMarker(root);
  }


}
