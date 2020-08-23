package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;

class BNode{
	public BNode left;
	public BNode right;
	public int data;
}
public class IsBST {
	
	/*
	 * Check if a binary tree is BST
	 */
	
	public static boolean isBST(BNode root) {
		if(root == null) {
			return true;
		}
		int maxLeft = findMax(root.left);
		int minRight = findMin(root.right);
		if(!isBST(root.left) || !isBST(root.right)) {
			return false;			
		}
		return (maxLeft < root.data) && (root.data < minRight);
	}
	
	public static int findMax(BNode root) {
		if(root == null) {
			return Integer.MIN_VALUE;			
		}
		int maxLeft = findMax(root.left);
		int maxRight = findMax(root.right);
		int maxSubTree = Math.max(maxLeft,maxRight);
		return Math.max(maxSubTree, root.data);
	}
	
	public static int findMin(BNode root) {
		if(root == null) {
			return Integer.MAX_VALUE;
		}
		int minLeft = findMin(root.left);
		int minRight = findMin(root.right);
		int minSubTree = Math.min(minLeft,minRight);
		return Math.min(minSubTree, root.data);
	}
	
	public static void inOrder(BNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
	
	public static BNode createBST() {
		BNode root = new BNode();
		root.data = 10;
		BNode left = new BNode();
		left.data = 8;
		BNode right = new BNode();
		right.data = 14;
		//root.data = 14;
		root.left = left;
		root.right = right;
		BNode six = new BNode();
		six.data = 6;
		BNode nine = new BNode();
		nine.data = 9;
		left.left = six;
		left.right = nine;
		return root;
	}
	
	public static BNode createBSTFalse() {
		BNode root = new BNode();
		root.data = 10;
		BNode left = new BNode();
		left.data = 8;
		BNode right = new BNode();
		right.data = 14;
		//root.data = 14;
		root.left = left;
		root.right = right;
		BNode six = new BNode();
		six.data = 6;
		BNode nine = new BNode();
		nine.data = 2;
		left.left = six;
		left.right = nine;
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BNode root = createBST();
		System.out.println();
		inOrder(root);
		System.out.println();
		System.out.println(findMin(root));
		System.out.println(findMin(root.left));
		System.out.println(findMin(root.right));
		System.out.println(findMin(root.left.right));
		System.out.println(findMax(root));
		System.out.println(findMax(root.right));
		System.out.println(findMax(root.left.right));
		System.out.println(findMax(root.left));
		System.out.println(isBST(root));
		root = createBSTFalse();
		System.out.println(isBST(root));
	}

}
