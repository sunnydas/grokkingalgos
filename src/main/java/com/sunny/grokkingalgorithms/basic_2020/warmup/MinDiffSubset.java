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
			Integer[][] dp) {
		if(index >= input.length) {
			return Math.abs(sum1 - sum2);			
		}
		if(dp[index][sum1] != null) {
			return dp[index][sum1];
		}
		int diff1 = minDiff(input,index+1,sum1+input[index],sum2);
		int diff2 = minDiff(input,index+1,sum1,sum2 + input[index]);
		dp[index][sum1] = Math.min(diff1,diff2);
		return dp[index][sum1];
	}
	
	
	public static int mindDiffDP(int[] input) {
		int sum = 0;
		for(int i = 0; i < input.length ; i++) {
			sum += input[i];
		}
		boolean[][] dp = new boolean[input.length][sum/2 + 1];
		for(int i = 0; i < dp.length ; i++) {
			dp[i][0] = true;
		}
		for(int j = 1; j <= sum/2; j++) {
			if(input[0] == j) {
				dp[0][j] = true;
			}
		}
		for(int i = 1; i < input.length ; i++) {
			for(int j = 1; j <= sum/2 ; j++) {
				if(dp[i - 1][j]) {
					dp[i][j] = dp[i-1][j];
				}else if(input[i] <= j) {
					dp[i][j] = dp[i-1][j - input[i]];
				}
			}
		}
		int sum1 = 0;
		for(int j  = sum/2 ; j >= 0 ; j--) {
			if(dp[input.length - 1][j]) {
				sum1 = j;
				break;
			}
		}
		//print(dp);
		int sum2  = sum - sum1;
		return Math.abs(sum2 - sum1);
	}
	
	
	public static void print(boolean[][] input) {
		for(int i = 0 ; i < input.length ; i++) {
			for(int j = 0; j < input[i].length ; j++) {
				System.out.print(input[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = {1, 2, 3, 9};
        System.out.println(minDiff(input, 0, 0, 0));
        int sum = 0;
        for(int i = 0; i < input.length ; i++) {
        	sum += input[i];
        }
        Integer[][] dp = new Integer[input.length+1][sum+1];
        System.out.println(minDiffMemoized(input, 0, 0, 0, dp));
        System.out.println(mindDiffDP(input));
	}

}
