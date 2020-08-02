package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class MergeSort {
	
	public static int[] mergeSort(int[] input,
			int start, 
			int end) {
		if(start >= end) {
			return input;			
		}
		int mid = start + (end - start)/2;
		mergeSort(input, start, mid);
		mergeSort(input, mid+1, end);
		return merge(input, start, mid, mid+1, end);
	}

	
	public static int[] merge(int[] input,int s1,int e1,
			int s2,int e2) {
		// 1 2 3 4 5 - 0 1 2 3 4 - 2 + 4 
		int[] helper = new int[(e1 - s1 + 1) + (e2 - s1 + 1)];
		int i = s1;
		int j = s2;
		int k = 0;
		while((i <= e1) 
				&& (j <= e2)) {
			if(input[i] <= input[j]) {
				helper[k] = input[i];
				i++;
				k++;
			}else {
				helper[k] = input[j];
				j++;
				k++;
			}
		}
		while(i <= e1) {
			helper[k] = input[i];
			k++;
			i++;
		}
		while(j <= e2) {
			helper[k] = input[j];
			k++;
			j++;
		}
		k = 0;
		i = s1;
		while(i <= e1) {
			input[i] = helper[k];
			k++;
			i++;
		}
		j = s2;
		while(j <= e2) {
			input[j] = helper[k];
			k++;
			j++;
		}
		return input;		
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {5,4,3,2,1};
		input = mergeSort(input,0, input.length - 1);
		for(int i : input) {
			System.out.print(i + " ");		
		}
		System.out.println();
		input = new int[] {1,9,2,0,4,100,10,3};
		input = mergeSort(input,0, input.length - 1);
		for(int i : input) {
			System.out.print(i + " ");		
		}
		System.out.println();
	}

}
