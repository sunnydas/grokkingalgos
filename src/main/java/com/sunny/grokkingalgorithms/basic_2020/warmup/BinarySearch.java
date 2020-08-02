package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class BinarySearch {

	
	public static int binarySearchRecursive(int[] input,
			int start,
			int end,
			int key) {
		if(start > end) {
			return -1;			
		}
		int mid = start + (end - start)/2;
		if(input[mid] == key) {
			return mid;			
		}
		else if(input[mid] < key) {
			return binarySearchRecursive(input, mid+1, end, key);			
		}
		else{
			return binarySearchRecursive(input, start,mid - 1, key);			
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,2,3,4,5};
		System.out.println(binarySearchRecursive(input,
				0, 
				input.length - 1, 
				3));
		System.out.println(binarySearchRecursive(input,
				0, 
				input.length - 1, 
				5));
		System.out.println(binarySearchRecursive(input,
				0, 
				input.length - 1, 
				1));
		System.out.println(binarySearchRecursive(input,
				0, 
				input.length - 1, 
				10));
	}

}
