package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class LargestSumInWindow {
	
	
	public static int largestSum(int[] input) {
		int largestSum  = 0;
		int maxSoFar=0;
		for(int i = 0 ; i  < input.length ; i++) {
			maxSoFar = Math.max(0, input[i] + maxSoFar);
			largestSum = Math.max(maxSoFar, largestSum);
		}
		return largestSum;
	}
	
	public static int largestSumAlt(int[] input) {
		int largestSum  = 0;
	    int[] prefixSums = new int[input.length];
	    prefixSums[0] = input[0];
	    for(int i = 1; i < input.length ; i++) {
	    	prefixSums[i] = input[i] + prefixSums[i - 1];	    	
	    }
	    //print(prefixSums);
	    /*
	     * 5, -7, 3, 5,-2, 4,-1
	     * 0,  1, 2, 3, 4, 5, 6, 
	     * 
	     * 5 -2 1 6 4 8 7
	     * 
	     * 
	     */
	    for(int i = 0 ; i < input.length ; i++) {
	    	for(int j = i+1; j < input.length ; j++) {
	    		int curSum = prefixSums[j] - prefixSums[Math.max(i - 1, 0)];
	    		largestSum = Math.max(curSum, largestSum);
	    	}
	    }
		return largestSum;
	}
	
	public static void print(int[] input) {
		for(int i : input) {
			System.out.print(i + " ");			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {5,-7,3,5,-2,4,-1};
        System.out.println(largestSum(input));
	}

}
