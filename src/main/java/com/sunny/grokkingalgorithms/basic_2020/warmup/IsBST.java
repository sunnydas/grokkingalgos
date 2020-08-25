package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import com.sunny.grokkingalgorithms.ctci.c4.util.BinaryTreeNode;

class BNode{
	public BNode left;
	public BNode right;
	public int data;
	public int level;
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
	
	static int maxLevel=0;
	
	public static void leftView(BNode root,int level) {
		if(root == null) {
			return;			
		}
		if(level > maxLevel) {
			System.out.println(root.data);
			maxLevel = level;
		}
		leftView(root.left, level+1);
		leftView(root.right, level+1);
	}
	
	public static void rightView(BNode root) {
		if(root == null) {
			return;
		}
		Queue<BNode> queue = new LinkedList<BNode>();
		if(root !=  null) {
			queue.add(root);
			BNode marker = new BNode();
			queue.add(marker);
			while(!queue.isEmpty()) {
				BNode current = queue.poll();
				if(current == marker) {
					System.out.println();
					if(!queue.isEmpty()) {
						queue.add(marker);
					}
				}else {
					//System.out.print(current.data + " ");
					if(!queue.isEmpty() && queue.peek() == marker) {
						System.out.print(current.data);
					}
					//System.out.println();
					if(current.left != null) {
						queue.add(current.left);
					}
					if(current.right != null) {
						queue.add(current.right);
					}
				}
			}
		}
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
	
	
	public static void verticalTraversal(BNode root) {
		if(root == null) {
			return;			
		}
		Map<Integer, LinkedList<Integer>> traversalMap = 
				new TreeMap<Integer, LinkedList<Integer>>();
		root.level = 0;
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BNode current = queue.poll();
			if(traversalMap.containsKey(current.level)) {
				traversalMap.get(current.level).add(current.data);				
			}else {
				LinkedList<Integer> elements = new LinkedList<Integer>();
				elements.add(current.data);
				traversalMap.put(current.level,elements);
			}
			if(current.left != null) {
				current.left.level = current.level + 1;
				queue.add(current.left);				
			}
			if(current.right != null) {
				current.right.level = current.level - 1;
				queue.add(current.right);
			}
		}
		System.out.println(traversalMap);		
	}
	
	public static void topView(BNode root) {
		if(root == null) {
			return;			
		}
		Map<Integer, LinkedList<Integer>> traversalMap = 
				new TreeMap<Integer, LinkedList<Integer>>();
		root.level = 0;
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BNode current = queue.poll();
			if(traversalMap.containsKey(current.level)) {
				traversalMap.get(current.level).add(current.data);				
			}else {
				LinkedList<Integer> elements = new LinkedList<Integer>();
				elements.add(current.data);
				traversalMap.put(current.level,elements);
			}
			if(current.left != null) {
				current.left.level = current.level - 1;
				queue.add(current.left);				
			}
			if(current.right != null) {
				current.right.level = current.level + 1;
				queue.add(current.right);
			}
		}
		System.out.println(traversalMap);
		Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator = 
				traversalMap.entrySet().iterator();
		System.out.println();
		while(iterator.hasNext()) {
			Map.Entry<Integer, LinkedList<Integer>> entry = iterator.next();
			System.out.println(entry.getValue().get(0));
		}
	}
	
	public static void bottomView(BNode root) {
		if(root == null) {
			return;			
		}
		Map<Integer, LinkedList<Integer>> traversalMap = 
				new TreeMap<Integer, LinkedList<Integer>>();
		root.level = 0;
		Queue<BNode> queue = new LinkedList<BNode>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BNode current = queue.poll();
			if(traversalMap.containsKey(current.level)) {
				traversalMap.get(current.level).add(current.data);				
			}else {
				LinkedList<Integer> elements = new LinkedList<Integer>();
				elements.add(current.data);
				traversalMap.put(current.level,elements);
			}
			if(current.left != null) {
				current.left.level = current.level - 1;
				queue.add(current.left);				
			}
			if(current.right != null) {
				current.right.level = current.level + 1;
				queue.add(current.right);
			}
		}
		System.out.println(traversalMap);
		Iterator<Map.Entry<Integer, LinkedList<Integer>>> iterator = 
				traversalMap.entrySet().iterator();
		System.out.println();
		while(iterator.hasNext()) {
			Map.Entry<Integer, LinkedList<Integer>> entry = iterator.next();
			System.out.println(entry.getValue().get(entry.getValue().size() - 1));
		}
	}
	
	public static void levelOrder(BNode root) {
		Queue<BNode> queue = new LinkedList<BNode>();
		if(root !=  null) {
			queue.add(root);
			BNode marker = new BNode();
			queue.add(marker);
			while(!queue.isEmpty()) {
				BNode current = queue.poll();
				if(current == marker) {
					System.out.println();
					if(!queue.isEmpty()) {
						queue.add(marker);
					}
				}else {
					System.out.print(current.data + " ");	
					if(current.left != null) {
						queue.add(current.left);
					}
					if(current.right != null) {
						queue.add(current.right);
					}
				}
			}
		}
	}
	
	public static BNode findLCA(BNode root,
			int node1,
			int node2) {
		if(root == null) {
			return null;			
		}
		//System.out.println(root.data);
		//System.out.println(node1);
		//System.out.println(node2);
		if(node1 <= root.data && root.data < node2) {
			return root;
		}else if(root.data < node1 && root.data < node2) {
			return findLCA(root.right, node1, node2);
		}else if(root.data > node1 && root.data > node2){
			return findLCA(root.left, node1, node2);
		}else {
			return root;
		}
	}
	
	public static boolean isNodePresent(BNode root,int node) {
		if(root == null) {
			return false;			
		}
		if(root.data == node) {
			return true;
		}
		boolean found = isNodePresent(root.left, node);
		if(!found) {
			found = isNodePresent(root.right, node);
		}
		return found;
	}
	
	public static BNode findLCASafe(BNode root,
			int node1,
			int node2) {
		if(!isNodePresent(root, node1) && !isNodePresent(root.right, node2)) {
			return null;			
		}
		return findLCA(root, node1, node2);
	}
	
	public static void swap(BNode root) {
		BNode temp = root.right;
		root.right = root.left;
		root.left = temp;
	}
	
	public static void invert(BNode root) {
		if(root == null) {
			return;
		}
		swap(root);
		invert(root.left);
		invert(root.right);
	}
	
	public static void preOrder(BNode root) {
		if(root == null) {
			return;
		}
		System.out.println(root.data);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public static int height(BNode root) {
		if(root == null) {
			return 0;
		}
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
		return Math.max(leftHeight,rightHeight) + 1;
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
		BNode eighty = new BNode();
		eighty.data = 80;
		nine.left = eighty;
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
		System.out.println("---Begin of lca check -----");
		System.out.println(findLCA(root, 8, 14).data);
		System.out.println(findLCA(root, 6, 9).data);
		System.out.println(findLCA(root, 8, 9).data);
		System.out.println(findLCA(root, 6, 14).data);
		System.out.println(findLCA(root, 8, 14).data);
		System.out.println(findLCA(root, 6, 9).data);
		System.out.println(findLCA(root, 8, 9).data);
		System.out.println(findLCA(root, 6, 14).data);
		System.out.println(findLCASafe(root, 100, 9));
		System.out.println("---lca check done ---");
		levelOrder(root);
		root = createBSTFalse();
		System.out.println(isBST(root));
		levelOrder(root);
		System.out.println();
		leftView(root,1);
		System.out.println();
		rightView(root);
		System.out.println();
		verticalTraversal(root);
		System.out.println();
		topView(root);
		System.out.println();
		bottomView(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		levelOrder(root);
		invert(root);
		System.out.println();
		preOrder(root);
		System.out.println();
		levelOrder(root);
		System.out.println();
		System.out.println(height(root));
	}

}
