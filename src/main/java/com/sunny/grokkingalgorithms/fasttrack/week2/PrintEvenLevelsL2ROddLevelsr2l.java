package com.sunny.grokkingalgorithms.fasttrack.week2;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.Stack;

/**
 * Created by sundas on 6/24/2018.
 */
public class PrintEvenLevelsL2ROddLevelsr2l {

  /*
  Print the even levels - Left -> Right
                   Print the odd levels -Right -> Left
   */

  /**
   *
   * @param root
   */
  public static void printLevels(BinaryTreeNode root){
    if(root != null) {
      System.out.println("Printing levels:");
      Stack<BinaryTreeNode> s1 = new Stack<>();
      Stack<BinaryTreeNode> s2 = new Stack<>();
      s1.push(root);
      while(!s1.isEmpty()
          || !s2.isEmpty()) {
        while (!s1.isEmpty()) {
          BinaryTreeNode current = s1.pop();
          System.out.println(current.data);
          if (current.left != null) {
            s2.push(current.left);
          }
          if (current.right != null) {
            s2.push(current.right);
          }
        }
        while(!s2.isEmpty()){
          BinaryTreeNode current = s2.pop();
          System.out.println(current.data);
          if (current.right != null) {
            s1.push(current.right);
          }
          if (current.left != null) {
            s1.push(current.left);
          }
        }
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    printLevels(root);
  }

}
