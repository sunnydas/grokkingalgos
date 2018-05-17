package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sundas on 5/17/2018.
 */
public class MaximumWidthOfATree {


  /**
   *
   * @param root
   * @return
   */
  public static int maximumWidth(BinaryTreeNode root){
    int width = 0;
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(root);
    queue.add(levelMarker);
    int levelCount = 0;
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      if(current == levelMarker){
        if(levelCount > width){
          width = levelCount;
        }
        levelCount = 0;
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        levelCount++;
        if(current.left != null){
          queue.add(current.left);
        }
        if(current.right != null){
          queue.add(current.right);
        }
      }
    }
    return width;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println("############");
    System.out.println(maximumWidth(root));
    System.out.println("##########");
    root = TreeUtils.createUnBalancedBinaryTree();
    TreeUtils.performBfs(root);
    System.out.println("############");
    System.out.println(maximumWidth(root));
    System.out.println("##########");
  }

}
