package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
import com.tangosol.util.Binary;
import sun.reflect.generics.tree.Tree;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

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
  public static int findLCAAlt(BinaryTreeNode root,int a,int b){
    Set pathA = new LinkedHashSet<>();
    findPath(root, a, pathA);
    Set pathB = new LinkedHashSet<>();
    findPath(root, b, pathB);
    //System.out.println(pathA);
    //System.out.println(pathB);
    /*
    Now we have to find the last common elemnt i  the union of the two paths
     */
    int ancestor = -1;
   Iterator iterator = pathA.iterator();
    while(iterator.hasNext()){
      int pathAElem = (Integer) iterator.next();
      if(pathB.contains(pathAElem)){
        ancestor = pathAElem;
        break;
      }
    }
    return ancestor;
  }

  /**
   *
    * @param root
   * @param data
   * @return
   */
  public static void findPath(BinaryTreeNode root,int data,Set path){
    if(root == null) {
      return;
    }
    if(root.data == data){
      path.add(data);
      return;
    }
    findPath(root.left,data,path);
    if(!path.isEmpty()){
      path.add(root.data);
      return;
    }
    else {
      findPath(root.right, data, path);
      if(!path.isEmpty()){
        path.add(root.data);
      }
    }

  }

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
    System.out.println("######");
    System.out.println(findLCAAlt(root, 4, 7));
    //System.out.println(findLCA(root,2,3).data);
    //System.out.println(findLCA(root,2,4).data);
    System.out.println(findLCAAlt(root, 3, 6));
    //System.out.println(findLCA(root,1,7).data);
    System.out.println(findLCAAlt(root, 3, 11));
    System.out.println(findLCAAlt(root, 6, 8));
    System.out.println(findLCAAlt(root, 8, 10));
    System.out.println(findLCAAlt(root, 8, 11));
    System.out.println(findLCAAlt(root, 5, 9));
    System.out.println(findLCAAlt(root, 8, 9));
    System.out.println(findLCAAlt(root, 4, 11));
    System.out.println(findLCAAlt(root, 7, 11));
    System.out.println(findLCAAlt(root, 5, 6));
  }

}
