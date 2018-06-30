package com.sunny.grokkingalgorithms.fasttrack.week2;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sundas on 6/30/2018.
 */
public class MaximumWidthOfATree {

  /**
   *
   * @param root
   * @return
   */
  public static int maxWidth(BinaryTreeNode root){
    int maxWidth = Integer.MIN_VALUE;
    if(root != null) {
      Queue<BinaryTreeNode> queue = new LinkedList<>();
      queue.add(root);
      BinaryTreeNode levelMarker = new BinaryTreeNode();
      queue.add(levelMarker);
      int levelCount = 0;
      while (!queue.isEmpty()) {
        BinaryTreeNode current = queue.poll();
        if(current == levelMarker){
          if(levelCount > maxWidth){
            maxWidth = levelCount;
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
    }
    return maxWidth;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("max width");
    System.out.println(maxWidth(root));
  }
}
