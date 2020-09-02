package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class SubsetSum {
	
	/*
	 * Input: {1, 2, 3, 7}, S=6
Output: True
The given set has a subset whose sum is '6': {1, 2, 3}
Example 2: #
Input: {1, 2, 7, 1, 5}, S=10
Output: True
The given set has a subset whose sum is '10': {1, 2, 7}
Example 3: #
Input: {1, 3, 4, 8}, S=6
Output: False
The given set does not have any subset whose sum is equal to '6'.
	 */

	public static boolean subsetSum(int[] input,int k,int index) {
		if(k == 0) {
			return true;
		}
		if(input.length == 0 
				|| index >= input.length) {
			return false;
		}
	    if(input[index] <= k) {
	    	boolean isSum = subsetSum(input, k - input[index], index + 1);
	    	if(isSum) {
	    		return true;
	    	}
	    }
		return subsetSum(input, k, index+1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 7};
		System.out.println(subsetSum(input,6,0));
		int[] input1 = {1, 2, 7, 1, 5};
		System.out.println(subsetSum(input1,10,0));
		int[] input2 = {1, 3, 4, 8};
		System.out.println(subsetSum(input2,6,0));
	}

}
