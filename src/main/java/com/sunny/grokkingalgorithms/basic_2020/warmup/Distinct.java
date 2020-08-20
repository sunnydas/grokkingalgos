package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

import com.sunny.grokkingalgorithms.gpn.findpath.Solution;

public class Distinct {
	
	/*
	 * Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the number of distinct values in array A.

For example, given array A consisting of six elements such that:

 A[0] = 2    A[1] = 1    A[2] = 1
 A[3] = 2    A[4] = 3    A[5] = 1
the function should return 3, because there are 3 distinct values appearing in array A, namely 1, 2 and 3.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
	 */

	public static int solution(int[] A) {
		int distinctCount = 0;
		if(A.length > 1) {
			distinctCount = 1;
			Arrays.sort(A);
			for(int i = 1; i < A.length ; i++) {
				if(A[i] != A[i - 1]) {
					distinctCount++;				
				}
			}
		}else if(A.length == 1) {
			distinctCount = 1;			
		}
		return distinctCount;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {2,1,1,2,3,1};
		System.out.println(solution(input));
	}

}
