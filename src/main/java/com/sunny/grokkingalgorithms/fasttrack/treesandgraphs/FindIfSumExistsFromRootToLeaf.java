package com.sunny.grokkingalgorithms.fasttrack.treesandgraphs;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

/**
 * Created by sundas on 6/10/2018.
 */
public class FindIfSumExistsFromRootToLeaf {

  /*
  Find if a path exists from root to leaf with
  a given sum.
   */

  /**
   *
   * @param root
   * @param sum
   * @param path
   * @param curSum
   */
  public static void findIfPathExistsFromRootToLeaf(BinaryTreeNode root,
                                                    int sum,
                                                    String path,

                                                    int curSum){
    /*
    Base case
     */
    if(root == null){
      return;
    }
    curSum += root.data;
    path += root.data +",";
    /*
    Check if path found since we have found a leaf node
     */
    if(root.left ==  null
        && root.right == null){
      if(curSum == sum){
        System.out.println(path);
      }
      return;
    }
    /*
    Keep looking, since we have not foun a leaf noce
     */
    else{
      findIfPathExistsFromRootToLeaf(root.left,sum,path,curSum);
      findIfPathExistsFromRootToLeaf(root.right,sum,path,curSum);
    }
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    BinaryTreeNode root = TreeUtils.createBST();
    TreeUtils.performBfsLevelMarker(root);
    System.out.println("#######################");
    findIfPathExistsFromRootToLeaf(root, 37, "", 0);
    findIfPathExistsFromRootToLeaf(root,18,"",0);
    findIfPathExistsFromRootToLeaf(root,19,"",0);
    findIfPathExistsFromRootToLeaf(root,24,"",0);
    findIfPathExistsFromRootToLeaf(root,10,"",0);
  }

}
