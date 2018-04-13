package com.sunny.grokkingalgorithms.ctci.c4.misc;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sundas on 4/13/2018.
 */
public class BottomViewOfATree {

  /*
  Bottom View of a Binary Tree
Given a Binary Tree, we need to print the bottom view from left to right. A node x is there in output if x is the bottommost node at its horizontal distance. Horizontal distance of left child of a node x is equal to horizontal distance of x minus 1, and that of right child is horizontal distance of x plus 1.

Examples:

                      20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14

For the above tree the output should be 5, 10, 3, 14, 25.

If there are multiple bottom-most nodes for a horizontal distance from root, then print the later one in level traversal. For example, in the below diagram, 3 and 4 are both the bottom-most nodes at horizontal distance 0, we need to print 4.


                      20
                    /    \
                  8       22
                /   \    /   \
              5      3 4     25
                    / \
                  10    14
For the above tree the output should be 5, 10, 4, 14, 25.
   */

  /**
   *
   * @param root
   */
  public static void printBottomViewOfTree(BinaryTreeNode root){
    Map<Integer,List<BinaryTreeNode>> verticalTraversal = TopViewOfATree.populateVerticalTraversalRouteBFS(root);
    /*
    We have populated the vertical traveesal
     */
    Iterator<Map.Entry<Integer,List<BinaryTreeNode>>> iterator = verticalTraversal.entrySet().iterator();
    System.out.println("bottom view");
    while(iterator.hasNext()){
      Map.Entry<Integer,List<BinaryTreeNode>> entry = iterator.next();
      System.out.println(entry.getValue().get(entry.getValue().size() - 1).data);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode twenty = new BinaryTreeNode();
    twenty.data = 20;
    BinaryTreeNode eight = new BinaryTreeNode();
    eight.data = 8;
    twenty.left = eight;
    BinaryTreeNode twentytwo = new BinaryTreeNode();
    twentytwo.data = 22;
    twenty.right = twentytwo;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    eight.left = five;
    BinaryTreeNode three = new BinaryTreeNode();
    three.data = 3;
    eight.right = three;
    BinaryTreeNode ten = new BinaryTreeNode();
    ten.data = 10;
    three.left = ten;
    BinaryTreeNode fourteen = new BinaryTreeNode();
    fourteen.data = 14;
    three.right = fourteen;
    BinaryTreeNode four = new BinaryTreeNode();
    four.data = 4;
    //twentytwo.left = four;
    BinaryTreeNode twentyfive = new BinaryTreeNode();
    twentyfive.data = 25;
    twentytwo.right = twentyfive;
    TreeUtils.performBfsLevelMarker(twenty);
    printBottomViewOfTree(twenty);
    System.out.println("===========next======================");
    twentytwo.left = four;
    TreeUtils.performBfsLevelMarker(twenty);
    printBottomViewOfTree(twenty);
  }
}
