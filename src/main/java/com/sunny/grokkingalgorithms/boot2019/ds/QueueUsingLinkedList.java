package com.sunny.grokkingalgorithms.boot2019.ds;

public class QueueUsingLinkedList {

    private Node head;

    private Node tail;

    public void enqueue(int data){
        Node node = new Node();
        node.data = data;
        if(head == null){
            head = node;
            tail = head;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public int dequeue(){
        int data = -1;
        if(head == null){
            throw new IllegalArgumentException("Empty stack exception");
        }
        data = head.data;
        if(head == tail){
            tail = null;
        }
        head = head.next;
        return data;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
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
