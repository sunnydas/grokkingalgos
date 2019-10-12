package com.sunny.grokkingalgorithms.boot2019.twize;

import java.util.Stack;

public class CheckIfInputCanBePreorderTraversalForBST {

    /*
    Input:  pre[] = {2, 4, 3}
Output: true
Given array can represent preorder traversal
of below tree
    2

      4
     /
    3

Input:  pre[] = {2, 4, 1}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.

Input:  pre[] = {40, 30, 35, 80, 100}
Output: true
Given array can represent preorder traversal
of below tree
     40
   /
 30    80

  35     100


Input:  pre[] = {40, 30, 35, 20, 80, 100}
Output: false
Given array cannot represent preorder traversal
of a Binary Search Tree.
     */

    public static boolean isPreOrderBSTUsingStacks(int[] input){
        Stack<Integer> stack1 = new Stack<>();
        int lastInOrderTop = Integer.MIN_VALUE;
        boolean isPreOrderBST = true;
        for(int i = 0 ; i < input.length ; i++){
         //This is crucial
        if (lastInOrderTop > input[i]) {
            isPreOrderBST = false;
            return isPreOrderBST;
        }
            if(stack1.isEmpty() || stack1.peek() > input[i]){
                stack1.push(input[i]);
            } else{
                while (!stack1.isEmpty() && stack1.peek() < input[i]) {
                    int elem = stack1.pop();
                    if (elem > lastInOrderTop) {
                        lastInOrderTop = elem;
                    }
                }
                stack1.push(input[i]);
            }
        }
        //System.out.println(lastInOrderTop);
        //System.out.println(stack1);
        return isPreOrderBST;
    }

    public static boolean isPreorderForBST(int[] input,int index){
        if(index >= input.length){
            return true;
        }
        int curRoot = input[index];
        // find beginning of right subtree
        int rightSubtreeRootIndex = -1;
        for(int i = index + 1 ; i < input.length ; i++){
            if(input[i] > curRoot){
                rightSubtreeRootIndex = i;
                break;
            }
        }
        if(rightSubtreeRootIndex >= 0){
            //check if all values for right subtree is greater than current root
            for(int i = rightSubtreeRootIndex+1; i < input.length ; i++){
                if(input[i] < curRoot){
                    return false;
                }
            }
        }
        // Check that values of left subtree are less than current root
        int towards = input.length;
        if(rightSubtreeRootIndex != -1){
            towards = rightSubtreeRootIndex;
        }
        for(int i = index + 1 ; i <towards; i++ ){
            if(input[i] > curRoot){
                return false;
            }
        }
        return isPreorderForBST(input,index+1);
    }


    public static void main(String[] args) {
        int[] input = new int[]{2,4,3};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{2, 4, 1};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{40, 30, 35, 80, 100};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{40, 30, 35, 20, 80, 100};
        System.out.println(isPreorderForBST(input,0));
        input = new int[] {40, 30, 35, 20, 80, 100};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{45, 25, 15, 35, 75};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{50, 39, 44, 28, 85};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{10, 25, 5};
        System.out.println(isPreorderForBST(input,0));
        input = new int[]{30, 20, 10, 40, 50};
        System.out.println(isPreorderForBST(input,0));
        System.out.println();
        System.out.println();
        input = new int[]{2,4,3};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{2, 4, 1};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{40, 30, 35, 80, 100};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{40, 30, 35, 20, 80, 100};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[] {40, 30, 35, 20, 80, 100};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{45, 25, 15, 35, 75};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{50, 39, 44, 28, 85};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{10, 25, 5};
        System.out.println(isPreOrderBSTUsingStacks(input));
        input = new int[]{30, 20, 10, 40, 50};
        System.out.println(isPreOrderBSTUsingStacks(input));

        input = new int[]{2, 4, 1};
        System.out.println(isPreOrderBSTUsingStacks(input));
    }

}
