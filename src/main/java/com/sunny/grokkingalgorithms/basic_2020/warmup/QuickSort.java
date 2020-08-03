package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class QuickSort {
	
	
	public static int[] quickSort(int[] input,
			int start,
			int end) {
		if(start >= end) {
			return input;			
		}
		int pivotIndex = findPivot(start, end);
		int pivotElement = input[pivotIndex];
		/*
		 * 5 4 3 2 1
		 * 0 1 2 3 4
		 * 2 =  pivot element 
		 * 
		 * 1 4 3 2 5
		 * 1 2 3 4 5
		 * 
		 * 1 3 4 5 2
		 * 1 3 4 5 2 
		 * 
		 */
		int i = start;
		int j = end;
		while(i <= j) {
			while(input[i] < pivotElement) {
				i++;				
			}
			while(input[j] > pivotElement) {
				j--;				
			}
			while(i <= j) {
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
				i++;
				j--;
			}
		}
		if(start < j) {
			quickSort(input, start, j);			
		}
		if(end > i) {
			quickSort(input, i, end);			
		}
		return input;
	}
		
	public static int findPivot(int start,
			int end) {
		int pivot = start + (end - start)/2;
		return pivot;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {5,4,3,2,1};
		input = quickSort(input, 0, input.length - 1);
		for(int i = 0; i < input.length ; i++) {
			System.out.print(input[i] + " ");			
		}
		System.out.println();
	}

}