package com.sunny.grokkingalgorithms.basic_2020.warmup;

import org.junit.Test;

public class RemoveDuplicatesInPlace {
	
	/*
	 * Unsorted array
	 */
	public static void removeDuplicatesInPlace(int[] input) {
		for(int i = 0; i < input.length ; i++) {
			for(int j = i+1; j < input.length ; j++) {
				if((input[i] != Integer.MIN_VALUE) 
						&& (input[j] != Integer.MIN_VALUE) && 
						(input[i] == input[j])) {
					input[j] = Integer.MIN_VALUE;
				}
			}
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] myArr = new int[]{1, 1, 2, 2, 3, 4, 5};
        removeDuplicatesInPlace(myArr);
        for(int item : myArr) {
        	System.out.println(item);        	
        }
	}

}
