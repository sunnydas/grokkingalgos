package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class PancakeSort {
	
	/*
	 * Implement a flip function and using that implement a sort function
	 */
	
	public static void flip(int[] input, int k) {
		if(input == null || input.length <= 1) {
			return;			
		}
		if(k < 0 || k > input.length) {
			throw new IllegalArgumentException();			
		}
		int i = 0;
		int j = k - 1;
		while(i < j) {
			int temp  = input[i];
			input[i] = input[j];
			input[j] = temp;
			i++;
			j--;
		}
	}
	
	public static void print(int[] input) {
		for(int i = 0; i < input.length ; i++) {
			System.out.print(input[i] + " ");			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {5,4,3,2,1};
        flip(input,5);	
        print(input);
        flip(input,3);
        print(input);
	}

}
