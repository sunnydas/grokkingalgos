package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

class Node<T>{
	
	
	public T data;
	
	public Node<T> next;
	
	
	
}
public class ReverseLinkedList {

	
	public static <T> Node<T> reverse(Node<T> root){
		Node<T> current = root;
		Node<T> previous = null;
		while(current != null) {
			Node<T> next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}
		root = previous;
		return root;
	}
	
	private static <T> Node<T> createLinkedList(T[] types){
		Node<T> root = null;
		Node<T> current = null;
		Node<T> previous = null;
		for(T type : types) {
			current = new Node();
			if(root == null) {
				root = current;				
			}
			current.data = type;
			if(previous != null) {
				previous.next = current;				
			}
			previous = current;
		}
		return root;		
	}
	
	private  static <T> void printLinkedList(Node<T> root) {
		Node<T> current = root;
		while(current != null) {
			System.out.print(current.data + " ");
			current = current.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] input = new Integer[] {1,2,3,4,5};
		Node<Integer> root = createLinkedList(input);
		printLinkedList(root);
		root = reverse(root);
		printLinkedList(root);
	}

}
