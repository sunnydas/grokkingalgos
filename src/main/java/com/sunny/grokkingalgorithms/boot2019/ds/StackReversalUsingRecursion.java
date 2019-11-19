package com.sunny.grokkingalgorithms.boot2019.ds;

import java.util.Stack;

public class StackReversalUsingRecursion{

    public static void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int i = stack.pop();
        reverse(stack);
        System.out.println(i);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        for(int i = 0 ; i < 5 ; i++){
            stack.push(i);
        }
        reverse(stack);
    }


}
