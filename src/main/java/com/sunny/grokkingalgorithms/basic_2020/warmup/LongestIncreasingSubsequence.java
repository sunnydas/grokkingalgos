package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public static int longestIncreasingSubsequenceDP(int[] input) {
		int[] tracker = new int[input.length];
		Arrays.fill(tracker, 1);
		for(int i = 1; i < tracker.length ; i++) {
			for(int j = 0 ; j < i; j++) {
				if(input[i] > input[j]) {
					if(tracker[j] + 1 > tracker[i]) {
						tracker[i] = tracker[j] + 1;
					}
				}
			}
		}
		int max = tracker[0];
	    System.out.println(Arrays.toString(tracker));
		for(int i = 1; i < tracker.length ; i++) {
			if(tracker[i] > max) {
				max = tracker[i];				
			}
		}
		return max;
	}
	
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
		System.out.println(longestIncreasingSubsequenceDP(input));
	}

}
