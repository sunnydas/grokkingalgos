package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class MedianOfSortedArrays {
	
	/*
	 * Case 1: m+n is odd, the median is at (m+n)/2 th index in the array obtained after merging both the arrays.
Case 2: m+n is even, the median will be average of elements at index ((m+n)/2 – 1) and 
(m+n)/2 in the array obtained after merging both the arrays
	 */
	
	public static void median(int[] arr1,
			int[]  arr2) {
		int length = arr1.length + arr2.length;
		int count = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int[] output = new int[length];
		while(i < arr1.length && j < arr2.length 
				&& count <= length/2) {
			if(arr1[i] < arr2[j]) {
				output[k] = arr1[i];
				i++;
				k++;
			}else {
				output[k] = arr2[j];
				j++;
				k++;
			}
			count++;
		}
		if(count < length/2) {
			while(i < arr1.length && count < length/2) {
				output[k] = arr1[i];		
				count++;
				k++;
			}
			
			while(j < arr2.length && count < length/2) {
				output[k] = arr2[j];
				count++;
				k++;
			}
		}
		System.out.println(Arrays.toString(output));
		if(length %2 != 0) {
			// odd
			System.out.println(output[length/2]);
		}else {
			// even
			System.out.println((output[length/2] + output[length/2 - 1])/2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] arr1 = {900};
        int[] arr2 = {5,8,10,20};
        median(arr1, arr2);
	} 

}
