package com.sunny.grokkingalgorithms.ctci.c4;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sundas on 3/19/2018.
 */
public class ConvertToLinkedListAtEachDepth {

  /*
  Convert nodes at each depth to linked list
   */

  /**
   *
   * @param root
   * @return
   */
  public static List<Node> convertNodesAtEachLevelToLinkedList(BinaryTreeNode root){
    List<Node> nodes = new ArrayList<>();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(root);
    queue.add(levelMarker);
    Node levelRoot = null;
    Node levelPrevious = null;
    while(!queue.isEmpty()){
      BinaryTreeNode currentNode = queue.poll();
      /*
      Level complete
       */
      if(currentNode == levelMarker){
        nodes.add(levelRoot);
        levelRoot = null;
        levelPrevious = null;
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        if(levelRoot == null){
          levelRoot = new Node();
          levelRoot.data = currentNode.data;
          levelPrevious = levelRoot;
        }
        else{
          Node current = new Node();
          current.data = currentNode.data;
          if(levelPrevious != null){
            levelPrevious.next = current;
          }
          levelPrevious = current;
        }
        if(currentNode.left != null){
          queue.add(currentNode.left);
        }
        if(currentNode.right != null){
          queue.add(currentNode.right);
        }
      }
    }
    return nodes;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    List<Node> nodes = convertNodesAtEachLevelToLinkedList(root);
    if(nodes != null){
      for(Node node : nodes){
        LinkedListUtil.printLinkedList(node);
      }
    }
  }

}
