package com.sunny.grokkingalgorithms.boot2019.ds;

public class StackUsingArray {

    private int[] stackInternal;

    private int tailPointer;

    public StackUsingArray(int length){
        stackInternal = new int[length];
    }

    public void push(int data){
        if(tailPointer == stackInternal.length){
            throw new IllegalArgumentException("Stack overflow exception");
        }
        stackInternal[tailPointer++] = data;

    }

    public int pop(){
        if(tailPointer == 0){
            throw new IllegalArgumentException("Empty stack");
        }
        int data = stackInternal[--tailPointer];
        return data;
    }

    public boolean isEmpty(){
        return tailPointer == 0;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        while(!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
