package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
import sun.reflect.generics.tree.Tree;

/**
 * Created by sundas on 6/9/2018.
 */
public class FindInOrderSuccessorInABST {

  /*
  Find inorder successor of a given node in a BST.
  We have links to parent;
   */

  /**
   *
   * @param root
   * @return
   */
  public static BinaryTreeNode findInOrderSuccessorAlt(BinaryTreeNode root,int data){
    if(root == null){
      return  null;
    }
    if(root.data == data){
      /*
      If current node has a right child, find leftmost node
      in right subtree
       */
      if(root.right != null){
         return findLeftMostNodeInTree(root.right);
      }
      else {
        BinaryTreeNode currentParent = root.parent;
        BinaryTreeNode son = root;
        while(currentParent != null
            && currentParent.left != son){
          son = currentParent;
          currentParent = son.parent;
        }
        return currentParent;
      }
    }
    BinaryTreeNode found = findInOrderSuccessor(root.left,data);
    if(found == null){
      found = findInOrderSuccessor(root.right,data);
    }
    return found;
  }

  /**
   *
   * @param root
   * @return
   */
  public static BinaryTreeNode findLeftMostNodeInTree(BinaryTreeNode root){
    if(root == null){
      return null;
    }
    BinaryTreeNode current = root;
    while(current != null
        && current.left != null){
      current = current.left;
    }
    return  current;
  }

  /**
   * This implementation is incorrect
   *
   * @param root
   * @param data
   * @return
   */
  public static BinaryTreeNode findInOrderSuccessor(BinaryTreeNode root,int data){
    System.out.println("This implementation is incorrect");
    /*
    Not found: base case
     */
    if(root == null){
      return null;
    }
    /*
    Conditions:
    a.) If current node has no right child and is left child of parent , then parent is the successor
    b.) If current node has right child, then right child is succesor
    c.) If current node has no right child and is the right child of parent, then recurse and
    find first node with a right child.
     */
    /*
    Found the node in question
     */
    if(root.data == data){
      /*
      Does this node have a right child, if yes then succesor must on the right
       */
      if(root.right != null){
        BinaryTreeNode current = root.right;
        /*
        The leftmost node in the right subtree is the successor
         */
        while(current != null){
          if(current.left == null){
            return current;
          }
          current = current.left;
        }
      }
      /*
      This node does not have a right child, so is it the left child of its
      parent? then parent is the successor
       */
      else if(root.parent != null
          && root.parent.left == root){
        return root.parent;
      }
      /*
      This node does not have a right sub child and is not the left child of its
      parent , so it should be the right child of its parent. Now we need to recurse
      up its parents to find the node which has the first right child (Obviously excluding
      the current node's parent)
       */
      else if(root.parent != null
          && root.parent.right == root){
        BinaryTreeNode currentParent = root.parent;
        BinaryTreeNode son = root;
        while(currentParent != null){
          if(currentParent.right != null
              && currentParent.right != son){
            return currentParent;
          }
          son = currentParent;
          currentParent = currentParent.parent;
        }
      }
      else{
        return null;
      }
    }
    BinaryTreeNode found = findInOrderSuccessor(root.left,data);
    if(found == null){
      found = findInOrderSuccessor(root.right,data);
    }
    return found;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBSTWithParents();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("######");
    TreeUtils.inorder(root);
    System.out.println("#########");
    System.out.println(findInOrderSuccessor(root, 7).data);
    System.out.println(findInOrderSuccessor(root, 8).data);
    System.out.println(findInOrderSuccessor(root, 9).data);
    System.out.println(findInOrderSuccessor(root, 10).data);
    System.out.println(findInOrderSuccessor(root, 11));
    System.out.println(findInOrderSuccessor(root, 3).data);
    System.out.println(findInOrderSuccessor(root, 4).data);
    System.out.println(findInOrderSuccessor(root, 5).data);
    System.out.println(findInOrderSuccessor(root, 6).data);
    System.out.println("#######Alternate############");
    System.out.println(findInOrderSuccessorAlt(root, 7).data);
    System.out.println(findInOrderSuccessorAlt(root, 8).data);
    System.out.println(findInOrderSuccessorAlt(root, 9).data);
    System.out.println(findInOrderSuccessorAlt(root, 10).data);
    System.out.println(findInOrderSuccessorAlt(root, 11));
    System.out.println(findInOrderSuccessorAlt(root, 3).data);
    System.out.println(findInOrderSuccessorAlt(root, 4).data);
    System.out.println(findInOrderSuccessorAlt(root, 5).data);
    System.out.println(findInOrderSuccessorAlt(root, 6).data);
  }

}
