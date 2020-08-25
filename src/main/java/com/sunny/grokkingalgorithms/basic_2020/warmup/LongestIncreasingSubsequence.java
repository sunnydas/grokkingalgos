package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class LongestIncreasingSubsequence {
	
	public static int longestIncreasingSubsequence(int[] input,
			int currentPos,
			int previous) {
		if(currentPos >= input.length) {
			return 0;
		}
		int included = 0;
		if(input[currentPos] > previous) {
			included = 1 + longestIncreasingSubsequence(input, 
					currentPos + 1, 
					input[currentPos]);
		}
		int notincluded = longestIncreasingSubsequence(input, currentPos+1, previous);
		return Math.max(included, notincluded);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Input: arr[] = {3, 10, 2, 1, 20}
Output: Length of LIS = 3
The longest increasing subsequence is 3, 10, 20
		 */
		int[] input = {3, 10, 2, 1, 20};
		System.out.println(longestIncreasingSubsequence(input, 0, Integer.MIN_VALUE));
	}

}
