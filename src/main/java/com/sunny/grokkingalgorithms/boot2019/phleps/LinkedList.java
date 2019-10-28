package com.sunny.grokkingalgorithms.boot2019.phleps;

class Node{

    public Node next;
    public int data;

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
public class LinkedList {


    public static Node createLinkedList(int[] input){
        Node root = null;
        Node previous = null;
        for(int i = 0 ; i < input.length ; i++){
            Node node = new Node();
            node.data = input[i];
            if(root == null){
                root = node;
            }
            if(previous != null){
                previous.next = node;
            }
            previous = node;
        }
        return root;
    }

    public static void printLinkedList(Node root){
        Node current = root;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println();
    }

    public static void addToLinkedListAtEnd(Node root,int data){
        Node current = root;
        Node previous = null;
        Node insert = new Node();
        insert.data = data;
        while(current != null){
            previous = current;
            current = current.next;
        }
        if(previous != null){
            previous.next = insert;
        } else{
            root = insert;
        }
    }

    public static void addToLinkedList(Node root,int key,int data){
        Node current = root;
        while(current != null){
            if(current.data == key){
                break;
            }
            current = current.next;
        }
        if(current.data == key){
            Node node = new Node();
            node.data = data;
            Node next = current.next;
            current.next = node;
            node.next = next;
        }
    }

    public static void printLinkedListReverse(Node root){
        if(root == null){
            return;
        }
        printLinkedListReverse(root.next);
        System.out.print(" " + root.data + " ");
    }

    public static Node reverseLinkedList(Node root){
        Node current = root;
        Node previous = null;
        while(current != null){
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        root = previous;
        return root;
    }


    public static boolean detectLoop(Node root){
        boolean hasLoop = false;
        Node slowPtr = root;
        Node fastPtr = root.next.next;
        while(fastPtr != null){
            if(slowPtr == fastPtr){
                hasLoop = true;
                break;
            }
            fastPtr = fastPtr.next;
            if(fastPtr != null){
                fastPtr = fastPtr.next;
            }
            slowPtr = slowPtr.next;
        }
        return hasLoop;
    }

    public static Node createLoopedLinkedList(){
        Node root = new Node();
        root.data = 1;
        Node two = new Node();
        two.data = 2;
        root.next = two;
        Node three = new Node();
        three.data = 3;
        two.next = three;
        Node four =  new Node();
        four.data = 4;
        three.next = four;
        four.next = two;
        return root;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        Node root = createLinkedList(input);
        printLinkedList(root);
        addToLinkedListAtEnd(root,6);
        printLinkedList(root);
        addToLinkedList(root,3,7);
        printLinkedList(root);
        System.out.println();
        printLinkedListReverse(root);
        System.out.println();
        printLinkedList(root);
        root =  reverseLinkedList(root);
        printLinkedList(root);
        System.out.println(detectLoop(root));
        root = createLoopedLinkedList();
        System.out.println(detectLoop(root));
    }

}
