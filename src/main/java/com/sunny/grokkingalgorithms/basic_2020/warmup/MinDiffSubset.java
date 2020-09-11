package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class MinDiffSubset {

	/*
	 * Given a set of positive numbers, partition the set into two subsets with a minimum difference between their subset sums.

Example 1: #
Input: {1, 2, 3, 9}
Output: 3
Explanation: We can partition the given set into two subsets where minimum absolute difference 
between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
Example 2: #
	 */
	
	public static int minDiff(int[] input,
			int index,
			int sum1,
			int sum2) {
		if(index >= input.length) {
			return Math.abs(sum1 - sum2);			
		}
		int diff1 = minDiff(input,index+1,sum1+input[index],sum2);
		int diff2 = minDiff(input,index+1,sum1,sum2 + input[index]);
		return Math.min(diff1,diff2);
	}
	
	public static int minDiffMemoized(int[] input,
			int index,
			int sum1,
			int sum2,
			Integer[] dp) {
		if(index >= input.length) {
			return Math.abs(sum1 - sum2);			
		}
		if(dp[index] != null) {
			return dp[index];
		}
		int diff1 = minDiff(input,index+1,sum1+input[index],sum2);
		int diff2 = minDiff(input,index+1,sum1,sum2 + input[index]);
		dp[index] = Math.min(diff1,diff2);
		return dp[index];
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {1, 2, 3, 9};
        System.out.println(minDiff(input, 0, 0, 0));
        Integer[] dp = new Integer[input.length];
        System.out.println(minDiffMemoized(input, 0, 0, 0, dp));
	}

}
