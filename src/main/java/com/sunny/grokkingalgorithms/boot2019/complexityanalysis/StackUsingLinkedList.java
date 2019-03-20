package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class StackUsingLinkedList {


    private LinkedListNode head;

    public void push(int data){
        LinkedListNode linkedListNode = new LinkedListNode();
        linkedListNode.data = data;
        if(head == null){
            head = linkedListNode;
        }
        else{
            LinkedListNode currentHead = head;
            head = linkedListNode;
            head.next = currentHead;
        }
    }

    public int pop(){
        if(head ==  null){
            throw new IllegalArgumentException("Stack is empty");
        }
        LinkedListNode currentHead = head;
        head = currentHead.next;
        return currentHead.data;
    }


    public boolean isEmpty(){
        return (head == null);
    }

    public static void main(String[] args) {
        StackUsingLinkedList stackUsingLinkedList = new StackUsingLinkedList();
        int[] input = new int[]{1,2,3,4,5,0};
        for(int i : input){
            stackUsingLinkedList.push(i);
        }
        while(!stackUsingLinkedList.isEmpty()){
            System.out.println(stackUsingLinkedList.pop());
        }
    }

}
