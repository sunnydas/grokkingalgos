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
	
	public static boolean subsetSumDP(int[] input,int k) {
		boolean[][] dp = new boolean[input.length][k+1];
		for(int i = 0; i < input.length ; i++) {
			dp[i][0] = true;
		}
		for(int j = 1; j <= k ; j++) {
			if(input[0] == j) {
				dp[0][j] = true;
			}else {
				dp[0][j] = false;
			}
		}
		for(int i = 1; i < dp.length ; i++) {
			for(int j = 1; j <= k ; j++) {
				if(dp[i-1][j]) {
					dp[i][j] = dp[i-1][j];
				}else if(input[i] <= j) {
					dp[i][j] = dp[i - 1][j - input[i]];
				}
			}
		}
		return dp[input.length - 1][k];
	}

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
	
	public static boolean subSetSumCached(int[] input,
			int k) {
			Boolean[][] dp = new Boolean[input.length][k+1];
			return subsetSumMemoization(input,
					k, 
					0, 
					dp);
	}
	
	public static boolean subsetSumMemoization(int[] input,
			int k,
			int index,
			Boolean[][] dp) {
		if(k == 0) {
			return true;
		}
		if(input.length == 0 
				|| index >= input.length) {
			return false;
		}
		if(dp[index][k] == null) {
		    if(input[index] <= k) {
		    	boolean isSum = subsetSumMemoization(input, k - input[index], index+1, dp);
		    	dp[index][k] = isSum;
		    	if(isSum) {
		    		return true;
		    	}
		    }
		}
		dp[index][k] = subsetSumMemoization(input, k, index+1,dp);
		return dp[index][k];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 7};
		System.out.println(subsetSum(input,6,0));
		System.out.println(subSetSumCached(input, 6));
		System.out.println(subsetSumDP(input, 6));
		int[] input1 = {1, 2, 7, 1, 5};
		System.out.println(subsetSum(input1,10,0));
		System.out.println(subSetSumCached(input1, 10));
		System.out.println(subsetSumDP(input1, 10));
		int[] input2 = {1, 3, 4, 8};
		System.out.println(subsetSum(input2,6,0));
		System.out.println(subSetSumCached(input2, 6));
		System.out.println(subsetSumDP(input2, 6));
	}

}
