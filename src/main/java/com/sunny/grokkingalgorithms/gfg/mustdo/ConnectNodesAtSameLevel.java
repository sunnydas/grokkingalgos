package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sundas on 11/22/2017.
 */
class Node
{
  int data;
  Node left, right, nextRight;
  Node(int item)
  {
    data = item;
    left = right = nextRight = null;

  }
}
public class ConnectNodesAtSameLevel {

  //https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1


  /**
   *
   * @param root
   */
  public static void connect(Node root){
    /*
    We could essentially use bfs and stitch nodes at each level using a previous pointer
     */
    if(root != null) {
      Queue<Node> bfsQueue = new LinkedList<>();
      bfsQueue.add(root);
      Node levelMarker = new Node(-1);
      bfsQueue.add(levelMarker);
      Node previousNodeInThisLevel = null;
      while(!bfsQueue.isEmpty()){
        Node current = bfsQueue.poll();
        if(current == levelMarker){
          previousNodeInThisLevel = null;
          if(!bfsQueue.isEmpty()) {
            bfsQueue.add(levelMarker);
          }
        }
        else{
          if(current != null){
            if(current.left != null){
              bfsQueue.add(current.left);
            }
            if(current.right != null){
              bfsQueue.add(current.right);
            }
          }
          if(previousNodeInThisLevel != null){
            previousNodeInThisLevel.nextRight = current;
          }
          previousNodeInThisLevel = current;
        }
      }
    }
  }

  /**
   * The Editorial solution using O(1) space
   *
   */
  public static void connectEditorial(Node root){
    /**
     * Base case
     */
    if(root == null){
      return;
    }
    if(root.left == null && root.right == null){
      return;
    }
    /**
     * normal use case
     * At level one we will get connected nodes and then we build on it each next
     */
    if(root.left != null && root.right != null){
      root.left.nextRight = root.right;
      Node temp = root.nextRight;
      while(temp != null
          && temp.left == null
          && temp.right == null){
        temp = temp.nextRight;
      }
      if(temp == null){
        root.right.nextRight = null;
      }
      else if(temp.left != null){
        root.right.nextRight = temp.left;
      }
      else if(temp.right != null){
        root.right.nextRight = temp.right;
      }
    }
    if(root.right == null){
      Node temp = root.nextRight;
      while(temp != null
          && temp.left == null
          && temp.right == null){
        temp = temp.nextRight;
      }
      if(temp == null){
        root.left.nextRight = null;
      }
      else if(temp.left != null){
        root.left.nextRight = temp.left;
      }
      else if(temp.right != null){
        root.left.nextRight = temp.right;
      }
    }
    else if(root.left == null){
      Node temp = root.nextRight;
      while(temp != null
          && temp.left == null
          && temp.right == null){
        temp = temp.nextRight;
      }
      if(temp == null){
        root.right.nextRight = null;
      }
      else if(temp.left != null){
        root.right.nextRight = temp.left;
      }
      else if(temp.right != null){
        root.right.nextRight = temp.right;
      }
    }
    connectEditorial(root.left);
    connectEditorial(root.right);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {

  }

}
