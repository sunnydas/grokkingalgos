package com.sunny.grokkingalgorithms.gfg.amz;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by sundas on 4/18/2017.
 */
public class FindAllNodesATKDistanceFromRoot {

  //http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/


  /**
   *
   * @param root
   * @param k
   */
  public static void printNodesAtKDistanceFromRootDFS(Node root,int k){
    printNodesAtKDistanceFromRootDFSRecursion(root,k,0);
  }


  /**
   *
   * @param root
   * @param k
   * @param depth
   */
  public static void printNodesAtKDistanceFromRootDFSRecursion(Node root,int k,int depth){
    if(root == null){
      return;
    }
    if(depth == k){
      System.out.println(root.data);
    }
    else{
      if(root.left != null){
        printNodesAtKDistanceFromRootDFSRecursion(root.left,k,depth + 1);
      }
      if(root.right != null){
        printNodesAtKDistanceFromRootDFSRecursion(root.right,k,depth + 1);
      }
    }
  }


  /**
   *
   * @param root
   * @param k
   */
  public static void printNodesAtKDIstanceFromRoot(Node root,int k){
    Queue<Node> nodes = new LinkedList<>();
    nodes.add(root);
    Node level = new Node();
    nodes.add(level);
    int count = 0;
    while(!nodes.isEmpty()){
      Node node = nodes.poll();
      if(node == level){
        count++;
        if(!nodes.isEmpty()) {
          nodes.add(level);
        }
      }
      else if(count == k){
        Node cur = null;
        System.out.println(node.data);
        while(nodes.peek() != level && !nodes.isEmpty()){
          cur = nodes.poll();
          System.out.println(cur.data);
        }
        break;
      }
      if(node.left != null){
        nodes.add(node.left);
      }
      if(node.right != null){
        nodes.add(node.right);
      }
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Node root = new Node();
    root.data = 1;
    Node firstLeftOfRoot =  new Node();
    firstLeftOfRoot.data = 2;
    root.left = firstLeftOfRoot;
    Node firstRightOfRoot = new Node();
    firstRightOfRoot.data = 3;
    root.right = firstRightOfRoot;
    Node firstLeftOfTwo = new Node();
    firstLeftOfTwo.data = 4;
    firstLeftOfRoot.left = firstLeftOfTwo;
    Node firstRighTOfTwo = new Node();
    firstRighTOfTwo.data = 5;
    firstLeftOfRoot.right = firstRighTOfTwo;
    Node firstLeftOfThree = new Node();
    firstLeftOfThree.data = 8;
    firstRightOfRoot.left = firstLeftOfThree;
    Node newNode = new Node();
    newNode.data = 11;
    firstLeftOfThree.right = newNode;
    printNodesAtKDIstanceFromRoot(root,2);
    printNodesAtKDistanceFromRootDFS(root,2);
  }

}
