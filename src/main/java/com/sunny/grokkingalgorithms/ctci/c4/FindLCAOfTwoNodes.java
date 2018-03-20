package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
class AndB{
public boolean a;
public boolean b;
    }
class OpHolder{
  public BinaryTreeNode aNode;
  public BinaryTreeNode bNode;
  public BinaryTreeNode lca;

  @Override
  public String toString() {
    return "OpHolder{" +
        "aNode=" + aNode +
        ", bNode=" + bNode +
        ", lca=" + lca +
        '}';
  }
}
/**
 * Created by sundas on 3/20/2018.
 */
public class FindLCAOfTwoNodes {

  /*
  Find LCA of two nodes in a binary tree
   */

  public static OpHolder findLCAMain(int a,int b,BinaryTreeNode root){
    AndB andB = new AndB();
    areAndBBothPresent(root,a,b,andB);
    /*
    safety check
     */
    if(!andB.a || !andB.b){
      return null;
    }
    OpHolder holder = findLCA(a,b,root);
    if(holder != null && (holder.aNode != null || holder.bNode != null)){
      if(holder.aNode != null){
        holder.lca = holder.aNode;
      }
      else if(holder.bNode != null){
        holder.lca = holder.bNode;
      }
    }
    return holder;
  }

  /**
   *
   * @param root
   * @param a
   * @param b
   * @return
   */
  public static AndB areAndBBothPresent(BinaryTreeNode root,int a,int b,AndB andB){
    if(root == null){
      return andB;
    }
    if(root.data == a){
      andB.a = true;
    }
    if(root.data == b){
      andB.b = true;
    }
    areAndBBothPresent(root.left, a, b, andB);
    areAndBBothPresent(root.right,a,b,andB);
    return andB;
  }


  /**
   *
   * @param a
   * @param b
   * @return
   */
  public static OpHolder findLCA(int a,int b,BinaryTreeNode root){
    /*
    Cant we use simple post order to do this
     */
    if(root == null){
      return null;
    }
    OpHolder leftHolder = findLCA(a,b,root.left);
    if(leftHolder != null && leftHolder.lca != null){
      return leftHolder;
    }
    OpHolder rightHolder = findLCA(a,b,root.right);
    if(rightHolder != null && rightHolder.lca != null){
      return rightHolder;
    }
    if(root.data == a){
      OpHolder holder = null;
      if(leftHolder != null){
        leftHolder.aNode = root;
        holder = leftHolder;
      }
      if(rightHolder != null){
        rightHolder.aNode = root;
        holder = rightHolder;
      }
      else{
        holder = new OpHolder();
        holder.aNode = root;
      }
      return holder;
    }
    else if(root.data == b){
      OpHolder holder = null;
      if(leftHolder != null){
        leftHolder.bNode = root;
        holder = leftHolder;
      }
      if(rightHolder != null){
        rightHolder.bNode = root;
        holder = rightHolder;
      }
      else{
        holder = new OpHolder();
        holder.bNode = root;
      }
      return holder;
    }
    /*
    Both a and b are on the same side
     */
    else if((leftHolder != null && leftHolder.aNode != null && leftHolder.bNode != null)
        || (rightHolder != null && rightHolder.aNode != null && rightHolder.bNode != null)){
      return findEitherNode(a,b,root);
    }
    /*
    They are on either sides of this root
     */
    else if(leftHolder != null && rightHolder != null && (leftHolder.aNode != null || leftHolder.bNode != null)
        && (rightHolder.aNode != null || rightHolder.bNode != null)){
      OpHolder holder = new OpHolder();
      holder.lca = root;
      return holder;
    }
    else if(leftHolder != null && (leftHolder.aNode != null || leftHolder.bNode != null)){
      /*
      It is possible that we did not search b
       */
      return leftHolder;
    }
    else if(rightHolder != null && (rightHolder.aNode != null || rightHolder.bNode != null)){
      return rightHolder;
    }
    return null;
  }


  /**
   *
   * @param a
   * @param b
   * @return
   */
  public static OpHolder findEitherNode(int a,int b,BinaryTreeNode root){
    if(root == null){
      return null;
    }
    if(root.data == a || root.data == b){
      OpHolder holder = new OpHolder();
      holder.lca = root;
      return holder;
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
    System.out.println();
    TreeUtils.performPostOrder(root);
    System.out.println("Processing");
    System.out.println(findLCAMain(2,3,root).lca.data);
    System.out.println(findLCAMain(4, 5, root).lca.data);
    System.out.println(findLCAMain(2, 4, root).lca.data);
    System.out.println(findLCAMain(4,7,root).lca.data);
    System.out.println(findLCAMain(6, 7, root).lca.data);
    System.out.println(findLCAMain(1,3,root).lca.data);
    System.out.println(findLCAMain(5,6,root).lca.data);
    System.out.println(findLCAMain(4,6,root).lca.data);
    System.out.println(findLCAMain(1,10,root));
  }

}
