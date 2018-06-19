package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;
import com.sunny.grokkingalgorithms.design_patterns.command.impl.Light;

import java.util.*;

/**
 * Created by sundas on 6/19/2018.
 */
public class BottomViewOfATree {

  /**
   *
   * @param root
   */
  public static void bottomView(BinaryTreeNode root){
    Map<Integer,List<BinaryTreeNode>> verticalTraversal
        = VerticalTraversal.verticalTraversal(root);
    if(verticalTraversal != null &&
        !verticalTraversal.isEmpty()){
      Set<Integer> keySet = new TreeSet(verticalTraversal.keySet());
      Iterator<Integer> iterator = keySet.iterator();
      while(iterator.hasNext()){
        List<BinaryTreeNode> nodes = verticalTraversal.get(iterator.next());
        System.out.println(nodes.get(nodes.size() - 1).data);
      }
    }

  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("##########");
    bottomView(root);
  }
}
