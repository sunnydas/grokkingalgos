package com.sunny.grokkingalgorithms.boot2019;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;
import com.sunny.grokkingalgorithms.ctci.c4.util.TreeUtils;

import java.util.*;

public class VerticalTraversal {


    public static Map<Integer, List<BinaryTreeNode>> verticalTraversal(BinaryTreeNode root){
        Map<Integer, List<BinaryTreeNode>> verticalTraversal = new LinkedHashMap<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        ((LinkedList<BinaryTreeNode>) queue).add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode binaryTreeNode = queue.poll();
            if(verticalTraversal.containsKey(binaryTreeNode.horizontalDIstance)){
                verticalTraversal.get(binaryTreeNode.horizontalDIstance).add(binaryTreeNode);
            } else{
                List<BinaryTreeNode> binaryTreeNodes = new ArrayList<>();
                binaryTreeNodes.add(binaryTreeNode);
                verticalTraversal.put(binaryTreeNode.horizontalDIstance,binaryTreeNodes);
            }
            if(binaryTreeNode.left != null){
                binaryTreeNode.left.horizontalDIstance  = binaryTreeNode.horizontalDIstance - 1;
                queue.add(binaryTreeNode.left);
            }
            if(binaryTreeNode.right != null){
                binaryTreeNode.right.horizontalDIstance = binaryTreeNode.horizontalDIstance + 1;
                queue.add(binaryTreeNode.right);
            }
        }
        return verticalTraversal;
    }

    public static void main(String[] args) {
        BinaryTreeNode binaryTreeNode = TreeUtils.createBalancedBinaryTree();
        TreeUtils.performBfsLevelMarker(binaryTreeNode);
        System.out.println();
        Map<Integer,List<BinaryTreeNode>> traversal =
                verticalTraversal(binaryTreeNode);
        Iterator<Map.Entry<Integer,List<BinaryTreeNode>>> entryIterator = traversal.
                entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<Integer,List<BinaryTreeNode>> entry = entryIterator.next();
            System.out.print(entry.getKey() + " : ");
            for(BinaryTreeNode binaryTreeNode1 : entry.getValue()){
                System.out.print(binaryTreeNode1.data);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
