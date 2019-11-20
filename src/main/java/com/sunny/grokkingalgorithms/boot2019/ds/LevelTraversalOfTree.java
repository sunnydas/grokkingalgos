package com.sunny.grokkingalgorithms.boot2019.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class BTreeNode{
    public BTreeNode left;
    public BTreeNode right;
    public int data;
}
public class LevelTraversalOfTree {


    public static List<List<Integer>> levelOrder(BTreeNode root){
        List<List<Integer>> levelOrder = new ArrayList<>();
        Queue<BTreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        BTreeNode levelMarker = new BTreeNode();
        bfsQueue.add(levelMarker);
        List<Integer> levelList = new ArrayList<>();
        while(!bfsQueue.isEmpty()){
            BTreeNode current = bfsQueue.poll();
            if(current == levelMarker){
                levelOrder.add(levelList);
                levelList = new ArrayList<>();
                if(!bfsQueue.isEmpty()){
                    bfsQueue.add(levelMarker);
                }
            } else{
                levelList.add(current.data);
                if(current.left != null){
                    bfsQueue.add(current.left);
                }
                if(current.right != null){
                    bfsQueue.add(current.right);
                }
            }
        }
        return levelOrder;
    }


    public static void preOrder(BTreeNode root){
        if(root == null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }


    public static void main(String[] args) {
        BTreeNode root = new BTreeNode();
        root.data = 5;
        BTreeNode leftofRoot = new BTreeNode();
        leftofRoot.data = 6;
        BTreeNode rightOfRoot = new BTreeNode();
        rightOfRoot.data = 7;
        root.left = leftofRoot;
        root.right = rightOfRoot;
        BTreeNode leftOfl1Left = new BTreeNode();
        leftOfl1Left.data = 8;
        BTreeNode rightOfLeft1Left = new BTreeNode();
        rightOfLeft1Left.data = 9;
        leftofRoot.left = leftOfl1Left;
        leftofRoot.right = rightOfLeft1Left;
        preOrder(root);
        System.out.println();
        System.out.println(levelOrder(root));
    }

}
