package com.sunny.grokkingalgorithms.ctci.c4.util;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sundas on 3/18/2018.
 */
public class TreeUtils {


  /**
   *
   * @return
   */
  public static BinaryTreeNode createBalancedBinaryTree(){
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
    two.left = four;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    two.right = five;
    BinaryTreeNode six = new BinaryTreeNode();
    six.data = 6;
    three.left = six;
    BinaryTreeNode seven = new BinaryTreeNode();
    seven.data = 7;
    three.right = seven;
    return one;
  }

  /**
   *
   * @return
   */
  public static BinaryTreeNode createUnBalancedBinaryTree(){
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
    two.left = four;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    two.right = five;
    BinaryTreeNode six = new BinaryTreeNode();
    six.data = 6;
    five.left = six;
    //three.left = six;
    BinaryTreeNode seven = new BinaryTreeNode();
    seven.data = 7;
    //three.right = seven;
    six.right = seven;
    return one;
  }


  /**
   *
   * @param root
   */
  public static void performBfs(BinaryTreeNode root){
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      System.out.println(current.data);
      if(current.left != null){
        queue.add(current.left);
      }
      if(current.right != null){
        queue.add(current.right);
      }
    }
  }


}
