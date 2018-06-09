package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.HashMap;
import java.util.Map;

class BSTPlaceHolder{
  int max = Integer.MIN_VALUE;
  int min = Integer.MAX_VALUE;
}
/**
 * Created by sundas on 6/9/2018.
 */
public class CheckIfATreeIsABSTOrNot {

  /*
  Check if a given binary tree is a BST or not.
   */

  public static Map<BinaryTreeNode,BSTPlaceHolder> minMaxHolder = new HashMap<>();


  static BinaryTreeNode previous;

  /**
   *
   * @param root
   * @param min
   * @param max
   * @return
   */
  public static boolean isBSTOptimized(BinaryTreeNode root,int min,int max){
    if(root == null){
      return true;
    }
    if(root.data < min
        || root.data > max){
      return false;
    }
    return (isBSTOptimized(root.left,min,root.data) && isBSTOptimized(root.right,root.data,max));
  }


  /**
   *
   * @param root
   * @return
   */
  public static boolean isBSTUsingInorderTraversal(BinaryTreeNode root){
    /*
    An empty tree is BST
     */
    if(root == null){
      return true;
    }
    //Go left
    boolean left = isBSTUsingInorderTraversal(root.left);
    if(left) {
      //Now previous has been populated
      if (previous == null
          || root.data > previous.data) {
        previous = root;
        //Go right now current root will be the predecessor to the next node
        boolean right = isBSTUsingInorderTraversal(root.right);
        if(right){
          return true;
        }
      }
    }
    return false;
  }


  /**
   *
   * @param root
   * @return
   */
  public static boolean isBST(BinaryTreeNode root){
    if(root == null){
      return true;
    }
    int maxOfLeftSubTree = findMaxAlt(root.left);
    int minOfRightSubTree = findMinAlt(root.right);
    if(root.data >= maxOfLeftSubTree
        && root.data < minOfRightSubTree){
      /*
      Check if subtrees are bst or not, bST condition for this node has been validated.The BST condition should hold true
       for every node in the tree.
       */
      return (isBST(root.left) && isBST(root.right));
    }
    /*
    Failed BST condistion so false,no need to check further.
     */
    return false;
  }


  /**
   *
   * @param root
   * @return
   */
  public static int findMaxAlt(BinaryTreeNode root){
    if(root == null){
      return Integer.MIN_VALUE;
    }
    if(minMaxHolder.containsKey(root) && minMaxHolder.get(root).max > Integer.MIN_VALUE){
      return minMaxHolder.get(root).max;
    }
    int left = findMaxAlt(root.left);
    int right = findMaxAlt(root.right);
    int max = Math.max(left,right);
    max = Math.max(root.data,max);
    BSTPlaceHolder bstPlaceHolder = null;
    if(minMaxHolder.get(root) != null){
      bstPlaceHolder = minMaxHolder.get(root);
    }
    else{
      bstPlaceHolder = new BSTPlaceHolder();
      minMaxHolder.put(root,bstPlaceHolder);
    }
    bstPlaceHolder.max = max;
    return max;
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findMinAlt(BinaryTreeNode root){
    if(root == null){
      return Integer.MAX_VALUE;
    }
    if(minMaxHolder.containsKey(root) && minMaxHolder.get(root).min < Integer.MAX_VALUE){
      return minMaxHolder.get(root).min;
    }
    int left = findMinAlt(root.left);
    int right = findMinAlt(root.right);
    int min = Math.min(left, right);
    min = Math.min(root.data,min);
    BSTPlaceHolder bstPlaceHolder = null;
    if(minMaxHolder.get(root) != null){
      bstPlaceHolder = minMaxHolder.get(root);
    }
    else{
      bstPlaceHolder = new BSTPlaceHolder();
      minMaxHolder.put(root,bstPlaceHolder);
    }
    bstPlaceHolder.min = min;
    return min;
  }






  /**
   *
   * @param root
   * @return
   */
  public static boolean isBSTBruteForce(BinaryTreeNode root){
    /*
    Empty tree is a BST
     */
    if(root == null){
      return true;
    }
    int maxOfLeftSubTree = findMax(root.left);
    int minOfRightSubTree = findMin(root.right);
    if(root.data >= maxOfLeftSubTree
        && root.data < minOfRightSubTree){
      /*
      Check if subtrees are bst or not, bST condition for this node has been validated.The BST condition should hold true
       for every node in the tree.
       */
      return (isBSTBruteForce(root.left) && isBSTBruteForce(root.right));
    }
    /*
    Failed BST condistion so false,no need to check further.
     */
    return false;
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findMax(BinaryTreeNode root){
    if(root == null){
      return Integer.MIN_VALUE;
    }
    int left = findMax(root.left);
    int right = findMax(root.right);
    int max = Math.max(left,right);
    max = Math.max(root.data,max);
    return max;
  }

  /**
   *
   * @param root
   * @return
   */
  public static int findMin(BinaryTreeNode root){
    if(root == null){
      return Integer.MAX_VALUE;
    }
    int left = findMin(root.left);
    int right = findMin(root.right);
    int min = Math.min(left,right);
    min = Math.min(root.data,min);
    return min;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println(isBSTBruteForce(root));
    System.out.println(isBST(root));
    System.out.println(isBSTUsingInorderTraversal(root));
    System.out.println(isBSTOptimized(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    System.out.println("########");
    root = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println(isBSTBruteForce(root));
    System.out.println(isBST(root));
    System.out.println(isBSTUsingInorderTraversal(root));
    System.out.println(isBSTOptimized(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
  }

}
