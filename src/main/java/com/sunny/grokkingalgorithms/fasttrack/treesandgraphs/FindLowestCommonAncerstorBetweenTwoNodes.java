package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
import com.tangosol.util.Binary;
import sun.reflect.generics.tree.Tree;

class SearchHolder{

  BinaryTreeNode a;
  BinaryTreeNode b;

}
/**
 * Created by sundas on 6/9/2018.
 */
class Holder{
  BinaryTreeNode a;
  BinaryTreeNode b;
  BinaryTreeNode lca;
}
public class FindLowestCommonAncerstorBetweenTwoNodes {

  /*
  Given two nodes, you have to find the lowest common ancestor
  between two nodes. Assume that both nodes exist in the tree.
   */

  /**
   *
   * @param root
   * @param a
   * @param b
   * @return
   */
  public static BinaryTreeNode findLCA(BinaryTreeNode root,int a,int b) {
    if (root == null) {
      return null;
    }
    /*
    Algorithm : If we find any of the node , we return the node to the parent
    parent checks is both the left and right are not null, if yes it knows that itself (parent)
    is the root.If any of the left or right are not null return that value (bubble up) to its parent
     */
    if(root.data == a
        || root.data == b){
      return root;
    }
    BinaryTreeNode left = findLCA(root.left,a,b);
    BinaryTreeNode right = findLCA(root.right,a,b);
    if(left != null
        && right != null){
      return root;
    }
    else if(left != null){
      return left;
    }
    else if(right != null){
      return right;
    }
    return null;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("#######################");
    System.out.println(findLCA(root, 4, 7).data);
    System.out.println(findLCA(root,2,3).data);
    System.out.println(findLCA(root,2,4).data);
    System.out.println(findLCA(root, 3, 6).data);
    System.out.println(findLCA(root,1,7).data);
    System.out.println("##########################");
    root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("#######################");
    System.out.println(findLCA(root, 4, 7).data);
    //System.out.println(findLCA(root,2,3).data);
    //System.out.println(findLCA(root,2,4).data);
    System.out.println(findLCA(root, 3, 6).data);
    //System.out.println(findLCA(root,1,7).data);
    System.out.println(findLCA(root, 3, 11).data);
    System.out.println(findLCA(root, 6, 8).data);
    System.out.println(findLCA(root, 8, 10).data);
    System.out.println(findLCA(root, 8, 11).data);
    System.out.println(findLCA(root, 5, 9).data);
    System.out.println(findLCA(root, 8, 9).data);
    System.out.println(findLCA(root, 4, 11).data);
    System.out.println(findLCA(root, 7, 11).data);
    System.out.println(findLCA(root, 5, 6).data);
  }

}
