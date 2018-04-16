package com.sunny.grokkingalgorithms.ctci.c4.misc;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by sundas on 4/16/2018.
 */
public class ZigZagTraversal {

  /*
  Print zig zag traversal of a tree

                       20
                    /    \
                  8       22
                /   \      \
              5      3      25
                    / \
                  10    14
   */

  /**
   *
   * @param root
   */
  public static void printZigZagTraversal(BinaryTreeNode root){
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(levelMarker);
    Stack<BinaryTreeNode> stack = new Stack<>();
    boolean reverse = true;
    while(!queue.isEmpty()){
      BinaryTreeNode node = queue.poll();
      if(node == levelMarker){
        if(reverse){
          while(!stack.isEmpty()){
            System.out.println(stack.pop().data);
          }
          reverse = false;
        }
        else{
          reverse = true;
        }
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        if(!reverse){
          System.out.println(node.data);
        }
        else{
          stack.push(node);
        }
        if(node.left != null){
          queue.add(node.left);
        }
        if(node.right != null){
          queue.add(node.right);
        }
      }
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
    System.out.println("#############################");
    printZigZagTraversal(twenty);
  }
}
