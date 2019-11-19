package com.sunny.grokkingalgorithms.ctci.c4.misc;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.*;

/**
 * Created by sundas on 4/11/2018.
 */
public class TopViewOfATree {

  /*
  Top view of a tree

  Top view of a binary tree is the set of nodes visible when the tree is viewed from the top. Given a binary tree, print the top view of it. The output nodes can be printed in any order. Expected time complexity is O(n)

A next x is there in output if x is the topmost next at its horizontal distance. Horizontal distance of left child of a next x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

       1
    /     \
   2       3
  /  \    / \
 4    5  6   7
Top view of the above binary tree is
4 2 1 3 7

        1
      /   \
    2       3
      \
        4
          \
            5
             \
               6
Top view of the above binary tree is
2 1 3 6
   */

  private static Map<Integer,List<BinaryTreeNode>> verticalTraversal = new HashMap<>();


  /**
   *
   * @param root
   */
  public static void printTopViewOfATree(BinaryTreeNode root){
    /*
    The idea is that we do a vertical traversal and keep track of horizontal distances
     */
     Map<Integer,List<BinaryTreeNode>> verticalTraversal = populateVerticalTraversalRouteBFS(root);
     if(verticalTraversal != null && !verticalTraversal.isEmpty()){
       /*
       We just need to worry about the first next in an increasing order of horizontal distances.
        */
       int leftHDTracker = 0;
       int rightHDTracker = 0;
       System.out.println("top view print begins");
       while(verticalTraversal.containsKey(leftHDTracker)
           || verticalTraversal.containsKey(rightHDTracker)){
         if(leftHDTracker < 0 && verticalTraversal.containsKey(leftHDTracker)){
           System.out.println(verticalTraversal.get(leftHDTracker).get(0).data);
         }
         if(rightHDTracker >= 0 && verticalTraversal.containsKey(rightHDTracker)){
           System.out.println(verticalTraversal.get(rightHDTracker).get(0).data);
         }
         leftHDTracker--;
         rightHDTracker++;
       }
     }
  }

  /**
   *
   * @param root
   */
  public static void printVerticalTraversal(BinaryTreeNode root,int horizontalDistance){
    if(root ==  null){
      return;
    }
    if(verticalTraversal.containsKey(horizontalDistance)){
      List<BinaryTreeNode> nodes = verticalTraversal.get(horizontalDistance);
      nodes.add(root);
    }
    else{
      List<BinaryTreeNode> nodes = new ArrayList<>();
      nodes.add(root);
      verticalTraversal.put(horizontalDistance,nodes);
    }
    printVerticalTraversal(root.left, horizontalDistance - 1);
    printVerticalTraversal(root.right, horizontalDistance + 1);
  }

  /**
   *
   * @param root
   */
  public static Map<Integer,List<BinaryTreeNode>> populateVerticalTraversalRouteBFS(BinaryTreeNode root){
    Map<Integer,List<BinaryTreeNode>> verticalTraversal = new TreeMap<>();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(root);
    queue.add(levelMarker);
    while(!queue.isEmpty()){
      BinaryTreeNode node = queue.poll();
      if(node == levelMarker){
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        int hd = node.horizontalDIstance;
        if(verticalTraversal.containsKey(hd)){
          List<BinaryTreeNode> nodes = verticalTraversal.get(hd);
          nodes.add(node);
        }
        else{
          //This preserves insertion order
          List<BinaryTreeNode> nodes = new LinkedList<>();
          nodes.add(node);
          verticalTraversal.put(hd,nodes);
        }
        if(node.left != null){
          node.left.horizontalDIstance = hd - 1;
          queue.add(node.left);
        }
        if(node.right != null){
          node.right.horizontalDIstance = hd + 1;
          queue.add(node.right);
        }
      }
    }
    printVerticalTraversal(verticalTraversal);
    return verticalTraversal;
  }

  /**
   *
   * @param root
   */
  public static void printVerticalTraversalBFS(BinaryTreeNode root){
    Map<Integer,List<BinaryTreeNode>> verticalTraversal = new HashMap<>();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(root);
    queue.add(levelMarker);
    while(!queue.isEmpty()){
      BinaryTreeNode node = queue.poll();
      if(node == levelMarker){
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        int hd = node.horizontalDIstance;
        if(verticalTraversal.containsKey(hd)){
          List<BinaryTreeNode> nodes = verticalTraversal.get(hd);
          nodes.add(node);
        }
        else{
          List<BinaryTreeNode> nodes = new ArrayList<>();
          nodes.add(node);
          verticalTraversal.put(hd,nodes);
        }
        if(node.left != null){
          node.left.horizontalDIstance = hd - 1;
          queue.add(node.left);
        }
        if(node.right != null){
          node.right.horizontalDIstance = hd + 1;
          queue.add(node.right);
        }
      }
    }
    printVerticalTraversal(verticalTraversal);
  }

  public static void printVerticalTraversal(Map<Integer,List<BinaryTreeNode>> verticalTraversal){
    Iterator<Map.Entry<Integer,List<BinaryTreeNode>>> iterator = verticalTraversal.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<Integer,List<BinaryTreeNode>> entry = iterator.next();
      System.out.println(entry.getKey() + ":");
      List<BinaryTreeNode> nodes = entry.getValue();
      for(BinaryTreeNode node : nodes){
        System.out.println(node.data);
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode t1 = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfsLevelMarker(t1);
    System.out.println();
    //System.out.println(t1.data);
    //printTopViewOfTree(0, 0, true, 0, t1);
    printVerticalTraversal(t1, 0);
    //System.out.println(verticalTraversal);
    printVerticalTraversal(verticalTraversal);
    verticalTraversal.clear();
    System.out.println("level order");
    printVerticalTraversalBFS(t1);
    System.out.println();
    System.out.println("Top View:");
    printTopViewOfATree(t1);
    System.out.println("done");
    BinaryTreeNode one = new BinaryTreeNode();
    one.data = 1;
    BinaryTreeNode two = new BinaryTreeNode();
    two.data = 2;
    one.left = two;
    BinaryTreeNode three = new BinaryTreeNode();
    three.data = 3;
    one.right = three;
    BinaryTreeNode four = new BinaryTreeNode();
    four.data = 4;
    two.right = four;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    four.right = five;
    BinaryTreeNode six = new BinaryTreeNode();
    six.data = 6;
    five.right = six;
    System.out.println();
    TreeUtils.performBfsLevelMarker(one);
    System.out.println();
    //System.out.println(one.data);
    //printTopViewOfTree(0, 0, true, 0, one);
    verticalTraversal.clear();
    printVerticalTraversal(one, 0);
    //System.out.println(verticalTraversal);
    printVerticalTraversal(verticalTraversal);
    System.out.println();
    verticalTraversal.clear();
    System.out.println("level order");
    printVerticalTraversalBFS(one);
    System.out.println();
    System.out.println("Top view of a tree");
    printTopViewOfATree(one);
    System.out.println("done");
  }


}
