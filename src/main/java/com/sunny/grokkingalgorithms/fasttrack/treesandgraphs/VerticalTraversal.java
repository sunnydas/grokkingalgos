package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.*;

/**
 * Created by sundas on 6/18/2018.
 */
public class VerticalTraversal {

  /**
   *
   * @param root
   * @return
   */
  public static Map<Integer,List<BinaryTreeNode>>
     verticalTraversal(BinaryTreeNode root){
    Map<Integer,List<BinaryTreeNode>>
        verticalTraversal = new HashMap<>();
    Queue<BinaryTreeNode> queue = new LinkedList<>();
    queue.add(root);
    while(!queue.isEmpty()){
      BinaryTreeNode current = queue.poll();
      if(current != null){
        if(verticalTraversal.containsKey(current.horizontalDIstance)){
          verticalTraversal.get(current.horizontalDIstance).add(current);
        }
        else{
          List<BinaryTreeNode> nodesAtSameVerticalLevel = new LinkedList<>();
          nodesAtSameVerticalLevel.add(current);
          verticalTraversal.put(current.horizontalDIstance,nodesAtSameVerticalLevel);
        }
        if(current.left != null){
          current.left.horizontalDIstance = current.horizontalDIstance - 1;
          queue.add(current.left);
        }
        if(current.right != null){
          current.right.horizontalDIstance = current.horizontalDIstance + 1;
          queue.add(current.right);
        }
      }
    }
    return verticalTraversal;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    Map<Integer,List<BinaryTreeNode>> verticalTraversal =
        verticalTraversal(root);
    Iterator<Map.Entry<Integer,List<BinaryTreeNode>>> iterator =
        verticalTraversal.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<Integer,List<BinaryTreeNode>> entry =
          iterator.next();
      System.out.println(" For vertical level = " + entry.getKey());
      for(BinaryTreeNode node : entry.getValue()){
        System.out.println(node.data);
      }
    }
  }

}
