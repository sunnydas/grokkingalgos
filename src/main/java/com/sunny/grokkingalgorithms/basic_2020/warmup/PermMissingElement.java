package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

import com.sunny.grokkingalgorithms.gpn.findpath.Solution;

public class PermMissingElement {
	
	/*
	 * An array A consisting of N different integers is given. The array contains integers in the range [1..(N + 1)], which means that exactly one element is missing.

Your goal is to find that missing element.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns the value of the missing element.

For example, given array A such that:

  A[0] = 2
  A[1] = 3
  A[2] = 1
  A[3] = 5
the function should return 4, as it is the missing element.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
the elements of A are all distinct;
each element of array A is an integer within the range [1..(N + 1)].
	 */
	
	public static long solutionAlt(int[] A) {
		long n  = A.length + 1;
		long sum  = 0;
		for(int i = 0; i < A.length ; i++) {
			sum  += A[i];			
		}
		//System.out.println(sum);
		long val = n*(n+1)/2;
		//System.out.println(val);
		return (val - sum);
	}

	public static long solution(int[] A) {
		Arrays.parallelSort(A);
		if(A.length == 0) {
			return 1;			
		}
		if(A.length == 1) {
			if(A[0] == 1) {
				return 2;				
			}else {
				return 1;
			}			
		}
		if(A[0] != 1) {
			return 1;			
		}
		int missing = 0;
		for(int i = 1; i < A.length ; i++) {
			if(A[i] - A[i - 1] > 1) {
				missing = A[i - 1] + 1;
				break;
			}else if(i == A.length - 1) {
				missing = A[i] + 1;
				break;
			}
		}
		return missing;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {2,3,1,5};
		System.out.println(solution(input));
		input = new int[] {};
		System.out.println(solution(input));
		input = new int[] {1};
		System.out.println(solution(input));
		input = new int[] {2};
		System.out.println(solution(input));
		input = new int[] {1,2};
		System.out.println(solution(input));
		input = new int[] {3,2};
		System.out.println(solution(input));
	}

}
