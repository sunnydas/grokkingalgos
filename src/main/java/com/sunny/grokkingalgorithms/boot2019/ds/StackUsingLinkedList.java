package com.sunny.grokkingalgorithms.boot2019.ds;

class Node{
     public Node next;
     int data;

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
public class StackUsingLinkedList {

    private Node head;

    public void push(int data){
        Node node = new Node();
        node.data = data;
        node.next = head;
        head = node;
    }

    public int pop(){
        int data = -1;
        if(head == null){
            throw new IllegalArgumentException("Stack is empty");
        }
        data = head.data;
        head = head.next;
        return data;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
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
