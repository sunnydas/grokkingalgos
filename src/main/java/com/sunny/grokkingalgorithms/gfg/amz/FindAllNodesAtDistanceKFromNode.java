package com.sunny.grokkingalgorithms.gfg.amz;

import java.util.Stack;

/**
 * Created by sundas on 4/30/2017.
 */
public class FindAllNodesAtDistanceKFromNode {


  // http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/

  /**
   *
   * @param root
   * @param target
   * @param k
   */
  public static void printAllNodesAtDistanceKfromNode(Node root,Node target,int k){
    Stack<Node> parents = new Stack<>();
    traverse(target,root,k,parents);
  }


  /**
   *
   * @param child
   * @param parents
   * @param k
   */
  public static void printPotentialNodesNorth(Node current,Node child,Stack<Node> parents,int k){
    if(k == 0){
      if(current != null){
        System.out.println(current.data);
      }
    }
    if(k > 0 && !parents.isEmpty()){
      printPotentialNodesNorth(parents.pop(),current,parents,k - 1);
    }
    if(k > 0){
      // south based logic
      if(current.left != null && current.left != child){
        printPotentialNodesDeep(current.left,k - 1);
      }
      if(current.right != null && current.right != child) {
        printPotentialNodesDeep(current.right,k - 1);
      }
    }
  }


  public static void traverse(Node target,Node current,int k,Stack<Node> parents){
    if(current == null){
      return;
    }
    //Found the target node
    if(current == target){
      // this is my zero mark now we have to go south and north
      if(k == 0){
        System.out.println(current.data);
        return;
      }
      // south based logic
      if(current.left != null){
        printPotentialNodesDeep(current.left,k - 1);
      }
      if(current.right != null) {
        printPotentialNodesDeep(current.right,k - 1);
      }
      if(!parents.isEmpty()) {
        printPotentialNodesNorth(parents.pop(), current, parents, k - 1);
      }
    }
    else{
      if(current.left != null || current.right != null){
        parents.push(current);
      }
      if(current.left != null){
        traverse(target, current.left, k, parents);
      }
      if(current.right != null){
        traverse(target,current.right,k,parents);
      }
    }
  }

  public static void printPotentialNodesDeep(Node root, int k){
    //Found potential node
    if(k == 0){
      System.out.println(root.data);
    }
    if(k > 0  && root.left != null){
      printPotentialNodesDeep(root.left, k-1);
    }
    if(k > 0 && root.right != null){
      printPotentialNodesDeep(root.right,k-1);
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
    System.out.println("----------------------------------");
    printAllNodesAtDistanceKfromNode(root, firstLeftOfRoot, 3);
    root = new Node(20);
    root.left = new Node(8);
    root.right = new Node(22);
    root.left.left = new Node(4);
    root.left.right = new Node(12);
    root.left.right.left = new Node(10);
    root.left.right.right = new Node(14);
    Node target = root.left.right;
    System.out.println("----------------------------------");
    printAllNodesAtDistanceKfromNode(root, target, 2);
    target = root.left.right.right;
    System.out.println("----------------------------------");
    printAllNodesAtDistanceKfromNode(root, target, 3);
    target = root.left;
    System.out.println("----------------------------------");
    printAllNodesAtDistanceKfromNode(root, target, 2);
    System.out.println("----------------------------------");
    target = root.left.right;
    printAllNodesAtDistanceKfromNode(root, target, 1);
    printAllNodesAtDistanceKfromNode(root, target, 2);
    System.out.println("----------------------------------");
    target = root.left.right;
    printAllNodesAtDistanceKfromNode(root, target, 3);
    System.out.println("----------------------------------");
    printAllNodesAtDistanceKfromNode(root, target, 2);
    System.out.println("----------------------------------");
    target = root.left.right;
    printAllNodesAtDistanceKfromNode(root, target, 4);
    System.out.println("----------------------------------");
    target = root.left.right.right;
    printAllNodesAtDistanceKfromNode(root, target, 1);
    System.out.println("----------------------------------");
    target = root.left.right.right;
    printAllNodesAtDistanceKfromNode(root, target, 2);
  }


}
