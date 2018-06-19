package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.*;

/**
 * Created by sundas on 6/19/2018.
 */
public class TopViewOfATree {

  /**
   *
   * @param root
   */
  public static void topView(BinaryTreeNode root){
    Map<Integer,List<BinaryTreeNode>> verticalTraversal
        = VerticalTraversal.verticalTraversal(root);
    if(verticalTraversal != null &&
        !verticalTraversal.isEmpty()){
      Set<Integer> keySet = new TreeSet(verticalTraversal.keySet());
      Iterator<Integer> iterator = keySet.iterator();
      while(iterator.hasNext()){
        System.out.println(verticalTraversal.get(iterator.next()).get(0).data);
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
    System.out.println("####################");
    topView(root);
  }

}
