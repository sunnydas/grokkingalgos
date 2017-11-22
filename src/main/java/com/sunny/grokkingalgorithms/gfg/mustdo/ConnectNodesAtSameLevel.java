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
   *
   * @param args
   */
  public static void main(String[] args) {

  }

}
