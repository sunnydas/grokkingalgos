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
   * @return
   */
  public static boolean findIfAPathExistsFromRootToLeafAlternate(BinaryTreeNode root,
                                                                 int sum){
    /*
    Might not need this
     */
    if(root == null){
      return false;
    }
    /**
     * subtract current root's value from sum
     */
    sum -= root.data;
    /*
    Found child next
     */
    if(root.left == null
        && root.right == null){
      /*
      Time to check if path exists
       */
      if(sum == 0){
        /*
        Remember to print this next as well.
         */
        System.out.print(root.data + " ");
        return true;
      }
      return false;
    }
    boolean lFound = findIfAPathExistsFromRootToLeafAlternate(root.left,sum);
    if(lFound){
      System.out.print(root.data + " ");
    }
    boolean rFound = findIfAPathExistsFromRootToLeafAlternate(root.right,sum);
    if(rFound){
      System.out.print(root.data + " ");
    }
    /*
    Crucial check
     */
    return (lFound || rFound);
  }

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
    Check if path found since we have found a leaf next
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
    findIfPathExistsFromRootToLeaf(root, 10, "", 0);
    System.out.println("##########################");
    findIfAPathExistsFromRootToLeafAlternate(root, 37);
    System.out.println();
    findIfAPathExistsFromRootToLeafAlternate(root, 18);
    System.out.println();
    findIfAPathExistsFromRootToLeafAlternate(root, 19);
    System.out.println();
    findIfAPathExistsFromRootToLeafAlternate(root, 24);
    System.out.println();
    findIfAPathExistsFromRootToLeafAlternate(root, 10);
    System.out.println();
  }

}
