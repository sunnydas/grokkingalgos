package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctc.c2.util.LinkedListUtil;
import com.sunny.grokkingalgorithms.ctc.c2.util.Node;
import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by sundas on 6/9/2018.
 */
public class CreateLinkedListAtEachLevelOfBinarySearchTree {

  /*
  Create a linked list at each level of binary search tree
   */

  /**
   *
   * @param root
   * @return
   */
  public static List<Node> createLinkedListAtEachLevel(BinaryTreeNode root){
    if(root == null){
      return null;
    }
    /*
    Using level order traversal
     */
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    List<Node> linkedLists = new ArrayList<>();
    queue.add(root);
    BinaryTreeNode levelMarker = new BinaryTreeNode();
    queue.add(levelMarker);
    Node currentLevelHead = null;
    Node previous = null;
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      /*
      Level end logic
       */
      if(current == levelMarker){
        /*
        End of level, means we have the linked list
         */
        if(currentLevelHead != null){
          linkedLists.add(currentLevelHead);
        }
        /*
        Reset
         */
        currentLevelHead = null;
        previous = null;
        /*
        Prepare for next level
         */
        if(!queue.isEmpty()){
          queue.add(levelMarker);
        }
      }
      else{
        /*
        Normal processing
         */
        Node node = new Node();
        node.data = current.data;
        if(currentLevelHead == null){
          currentLevelHead = node;
        }
        if(previous != null){
          previous.next = node;
        }
        previous = node;
        /*
        Normal level order traversal
         */
        if(current.left != null){
          queue.add(current.left);
        }
        if(current.right != null){
          queue.add(current.right);
        }
      }
    }
    return linkedLists;
  }

  /**
   *
   * @param root
   * @param linkedLists
   * @param level
   */
  public static void createLinkedListAtEachLevelUsingDFS(BinaryTreeNode root,
                                                         List<LinkedList> linkedLists,
                                                         int level){
    if(root == null){
      return;
    }
    /*
    The idea is that each level represents an index on the linkedLists. The linked list cannot
    be null. We we visit left or right child , we essentially increase the level count by 1
     */
    if(level == linkedLists.size()){
      /*
      New level
       */
      LinkedList linkedList = new LinkedList();
      linkedList.add(root.data);
      linkedLists.add(linkedList);
    }
    else{
      /*
      The level is already contained in the list, just fetch it at the index
       */
      LinkedList linkedList = linkedLists.get(level);
      if(linkedList != null){
        linkedList.add(root.data);
      }
    }
    createLinkedListAtEachLevelUsingDFS(root.left,linkedLists,level+1);
    createLinkedListAtEachLevelUsingDFS(root.right,linkedLists,level+1);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("##################");
    List<Node> linkedLists = createLinkedListAtEachLevel(root);
    for(Node head : linkedLists){
      LinkedListUtil.printLinkedList(head);
    }
    System.out.println("#########");
    List<LinkedList> lists = new ArrayList<>();
    createLinkedListAtEachLevelUsingDFS(root, lists,0);
    for(LinkedList linkedList : lists){
      System.out.println(linkedList);
      System.out.println("---------");
    }
  }

}
