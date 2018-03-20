package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class BSTOutputHolder{

  public BinaryTreeNode found;
  public boolean doParentCheck;
  public BinaryTreeNode child;

}
/**
 * Created by sundas on 3/20/2018.
 */
public class FindNextInOrderSuccessorInBST {

  /*
  Given a node find the next inorder successor in a BST.
   */


  /**
   *
   * @param nodeData
   * @param root
   * @return
   */
  public static BinaryTreeNode findNextInorderSuccesor(int nodeData,BinaryTreeNode root){
    /*
    The idea is that we find the node in question using pre order, the parent is passed along.
    Once we find the node. We need to check:
    a.) if node has right child , then right child is inorder successor.
    b.) else if node has no right child but is a left child of the parent, then the parent is the
     in order successor/
    c.) else if node has no right child but is the right child of the , then we have to up the stack and find a parent
       with a right child, that right child will be the inorder successor for this node.
     */
    BinaryTreeNode node = null;
    Queue<BinaryTreeNode> parents = new LinkedList<>();
    BinaryTreeNode successor = null;
    node =  findNode(nodeData,root,parents);
    /*
    Found node
     */
    if(node != null){
      successor = findInorderSuccessor(node,parents);
    }
    return successor;
  }

  /**
   *
   * @param root
   * @param parents
   * @return
   */
  public static BinaryTreeNode findInorderSuccessor(BinaryTreeNode root,Queue<BinaryTreeNode> parents){
    if(root == null){
      return null;
    }
    BinaryTreeNode succesor = null;
    /*
    If root has right child then succesor is the min of right subtree
     */
    if(root.right != null){
      /*
      dirty hack too lazy to change return type
       */
      int min = CheckIfATreeIsBST.min(root.right);
      succesor = new BinaryTreeNode();
      succesor.data = min;
    }
    /*
    else if root ahs no right child but is the left child of its parent, then parent is the succesor
     */
    else if(root.right == null && (!parents.isEmpty() && parents.peek().left == root)){
      succesor = parents.peek();
    }
    /*
    Now we need to traverse up the parents and see if any of the parents have a right child, then that right child will
       be the successor
     */
    else if(root.right == null){
      while(!parents.isEmpty()){
        BinaryTreeNode parent = parents.poll();
        /*
        The right child should not be the current node.
         */
        if(parent != null
            && parent.left == root){
          succesor = parent;
          break;
        }
        /*
        We need to do this because we have to ensure that the right child of a parent is not some node on the already
         traversed path.
         */
        root = parent;
      }
    }
    return succesor;
  }

  public static BinaryTreeNode findNode(int nodeData,BinaryTreeNode root,Queue<BinaryTreeNode> parents){
    /*
    Base case
    */
    if(root == null){
      return null;
    }
    BinaryTreeNode found = null;
    if(root.data == nodeData){
     found = root;
    }
    else{
      /*
      The thing to note here is atht we need to traverse only the parents of this node.Other paths are irrelevant.
      We use a queue here while going back (backtracking).
       */
      found = findNode(nodeData,root.left,parents);
      if(found != null){
        parents.add(root);
      }
      else{
        found = findNode(nodeData,root.right,parents);
        if(found != null){
          parents.add(root);
        }
      }
    }
    return found;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfs(root);
    System.out.println(".......");
    TreeUtils.inorder(root);
    System.out.println("Processing ... ");
    /*System.out.println(findNextInorderSuccesor(4,root).data);
    System.out.println(findNextInorderSuccesor(3,root).data);
    System.out.println(findNextInorderSuccesor(10,root).data);
    System.out.println(findNextInorderSuccesor(9,root).data);
    System.out.println(findNextInorderSuccesor(8,root).data);
    System.out.println(findNextInorderSuccesor(7,root).data);
    System.out.println(findNextInorderSuccesor(6,root).data);
    System.out.println(findNextInorderSuccesor(5,root).data);
    System.out.println(findNextInorderSuccesor(11,root).data);
    System.out.println(findNextInorderSuccesor(1,root));*/
    System.out.println(findNextInorderSuccesor(4,root).data);
    System.out.println(findNextInorderSuccesor(3,root).data);
    System.out.println(findNextInorderSuccesor(10,root).data);
    System.out.println(findNextInorderSuccesor(9,root).data);
    System.out.println(findNextInorderSuccesor(8,root).data);
    System.out.println(findNextInorderSuccesor(7,root).data);
    System.out.println(findNextInorderSuccesor(6,root).data);
    System.out.println(findNextInorderSuccesor(5, root).data);
    System.out.println(findNextInorderSuccesor(11,root));
    System.out.println(findNextInorderSuccesor(1, root));
    System.out.println(findNextInorderSuccesor(2,root));
  }

}