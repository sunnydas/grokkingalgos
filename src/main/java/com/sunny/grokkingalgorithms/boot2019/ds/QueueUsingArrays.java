package com.sunny.grokkingalgorithms.boot2019.ds;

public class QueueUsingArrays {

    private int[] queueInternal;

    private int headPointer;

    private int tailPointer;

    public QueueUsingArrays(int length){
        this.queueInternal = new int[length];
    }

    public void enqueue(int data){
        if(tailPointer == queueInternal.length){
            throw new IllegalArgumentException("Queue is full");
        }
        this.queueInternal[tailPointer++] = data;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new IllegalArgumentException("Queue is empty");
        }
        int data = this.queueInternal[headPointer++];
        if(headPointer == this.queueInternal.length){
            headPointer=0;
            tailPointer=0;
        }
        return data;
    }

    public boolean isEmpty(){
        return headPointer == tailPointer;
    }

    public static void main(String[] args) {
        QueueUsingArrays queue = new QueueUsingArrays(5);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        while(!queue.isEmpty()){
            System.out.println(queue.dequeue());
        }
        queue.enqueue(6);
        System.out.println(queue.dequeue());
    }
}
