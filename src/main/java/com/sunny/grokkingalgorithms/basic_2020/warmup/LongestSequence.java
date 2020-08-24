package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class LongestSequence {
	
	public static void longestSequence(int[] input) {
		Arrays.parallelSort(input);
		int longestCount = 0;
		int runningCount = 0;
		System.out.println(Arrays.toString(input));
		for(int i = 1; i < input.length ; i++) {
			if(input[i] - input[i - 1] == 1) {
				runningCount++;				
			}
			else if(input[i] == input[i - 1]) {
				continue;
			}else {
				if(runningCount > longestCount) {
					longestCount = runningCount;					
				}
				runningCount = 0;
			}
		}
		if(runningCount > longestCount) {
			longestCount = runningCount;			
		}
		System.out.println(longestCount);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,2,9,8,7,4,5,6,7,8,9};
		longestSequence(input);
	}

}
