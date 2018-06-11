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
   * @param root
   */
  public static void preOrder(BinaryTreeNode root){
    if(root == null){
      return;
    }
    System.out.println(root.data);
    preOrder(root.left);
    preOrder(root.right);
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
    BinaryTreeNode eight = new BinaryTreeNode();
    eight.data = 8;
    six.left = eight;
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

  /**
   *
   * @param root
   */
  public static void performBfsLevelMarker(BinaryTreeNode root){
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    BinaryTreeNode level = new BinaryTreeNode();
    queue.add(level);
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      if(current == level){
        System.out.println();
        if(!queue.isEmpty()){
          queue.add(level);
        }
      }
      else {
        System.out.print(current.data + " ");
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
    }
  }


  /**
   *
   * @param root
   */
  public static void levelOrderTraversalUsingRecursion(BinaryTreeNode root){
    /*
    Get height of tree
     */
    int height = height(root);
    for(int i = 1; i <= height; i++){
      printLevelOrder(root,i);
    }
  }

  /**
   *
   * @param root
   * @param i
   */
  public static void printLevelOrder(BinaryTreeNode root,int i){
    if(root == null){
      return;
    }
    if(i == 1){
      System.out.println(root.data);
    }
    else{
      printLevelOrder(root.left,i-1);
      printLevelOrder(root.right,i-1);
    }
  }

  /**
   *
   * @param root
   * @return
   */
  public static int height(BinaryTreeNode root){
    if(root == null){
      return 0;
    }
    int lHeight = height(root.left);
    int rHeight = height(root.right);
    return Math.max(lHeight,rHeight) + 1;
  }



  /**
   *
   * @return
   */
  public static BinaryTreeNode createT2AsSubsetOfBalancedTree(){
    BinaryTreeNode two = new BinaryTreeNode();
    two.data = 2;
    BinaryTreeNode four = new BinaryTreeNode();
    four.data = 4;
    two.left = four;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    two.right = five;
    return two;
  }

  /**
   *
   * @return
   */
  public static BinaryTreeNode createT2AsSubsetOfBalancedTreeAlt(){
    BinaryTreeNode three = new BinaryTreeNode();
    three.data = 3;
    BinaryTreeNode seven = new BinaryTreeNode();
    seven.data = 7;
    three.right = seven;
    return three;
  }

  /**
   *
   * @return
   */
  public static BinaryTreeNode createBST(){
    BinaryTreeNode seven = new BinaryTreeNode();
    seven.data = 7;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    seven.left = five;
    BinaryTreeNode nine = new BinaryTreeNode();
    nine.data = 9;
    seven.right = nine;
    BinaryTreeNode four = new BinaryTreeNode();
    four.data = 4;
    five.left = four;
    BinaryTreeNode six = new BinaryTreeNode();
    six.data = 6;
    five.right = six;
    BinaryTreeNode eight = new BinaryTreeNode();
    eight.data = 8;
    nine.left = eight;
    BinaryTreeNode ten = new BinaryTreeNode();
    ten.data = 10;
    nine.right = ten;
    BinaryTreeNode three = new BinaryTreeNode();
    three.data = 3;
    four.left = three;
    BinaryTreeNode eleven = new BinaryTreeNode();
    eleven.data = 11;
    ten.right = eleven;
    return seven;
  }

  /**
   *
   * @return
   */
  public static BinaryTreeNode createBSTWithParents(){
    BinaryTreeNode seven = new BinaryTreeNode();
    seven.data = 7;
    BinaryTreeNode five = new BinaryTreeNode();
    five.data = 5;
    seven.left = five;
    five.parent = seven;
    BinaryTreeNode nine = new BinaryTreeNode();
    nine.data = 9;
    seven.right = nine;
    nine.parent = seven;
    BinaryTreeNode four = new BinaryTreeNode();
    four.data = 4;
    five.left = four;
    four.parent = five;
    BinaryTreeNode six = new BinaryTreeNode();
    six.data = 6;
    five.right = six;
    six.parent = five;
    BinaryTreeNode eight = new BinaryTreeNode();
    eight.data = 8;
    nine.left = eight;
    eight.parent = nine;
    BinaryTreeNode ten = new BinaryTreeNode();
    ten.data = 10;
    nine.right = ten;
    ten.parent = nine;
    BinaryTreeNode three = new BinaryTreeNode();
    three.data = 3;
    four.left = three;
    three.parent = four;
    BinaryTreeNode eleven = new BinaryTreeNode();
    eleven.data = 11;
    ten.right = eleven;
    eleven.parent = ten;
    return seven;
  }

  /**
   *
   * @param root
   */
  public static void inorder(BinaryTreeNode root){
    if(root == null){
      return;
    }
    inorder(root.left);
    System.out.println(root.data);
    inorder(root.right);
  }

  public static void performPostOrder(BinaryTreeNode root){
    if(root == null){
      return;
    }
    performPostOrder(root.left);
    performPostOrder(root.right);
    System.out.println(root.data);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println("############################");
    TreeUtils.levelOrderTraversalUsingRecursion(root);
  }


}
