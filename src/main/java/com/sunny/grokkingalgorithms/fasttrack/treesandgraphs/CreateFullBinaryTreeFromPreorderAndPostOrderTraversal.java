package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/11/2018.
 */
public class CreateFullBinaryTreeFromPreorderAndPostOrderTraversal {

  /*
  Create full binary tree using pre order and post order traversals
   */

  static int preOrderIndex;

  /**
   *
   * @param preOrder
   * @param postOrder
   * @return
   */
  public static BinaryTreeNode createTree(int[] preOrder,int[] postOrder,int start,int end){
    if(start > end
        || preOrderIndex >= preOrder.length){
     return null;
    }
    BinaryTreeNode current = new BinaryTreeNode();
    current.data = preOrder[preOrderIndex++];
    if(start == end ||  preOrderIndex >= preOrder.length){
      return current;
    }
    int i;
    for(i = start ; i <= end ; i++){
      if(preOrder[preOrderIndex] == postOrder[i]){
        break;
      }
    }
    if(i <= end) {
      current.left = createTree(preOrder, postOrder, start, i);
      current.right = createTree(preOrder, postOrder, i + 1, end);
    }
    return current;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int preorder[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
    int postorder[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
    BinaryTreeNode root = createTree(preorder,postorder,0,preorder.length - 1);
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("###");
    TreeUtils.inorder(root);
  }

}
