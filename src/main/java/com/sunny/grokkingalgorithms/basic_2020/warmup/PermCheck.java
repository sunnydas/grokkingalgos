package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class PermCheck {
	
	/*
	 * A non-empty array A consisting of N integers is given.

A permutation is a sequence containing each element from 1 to N once, and only once.

For example, array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
is a permutation, but array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
is not a permutation, because value 2 is missing.

The goal is to check whether array A is a permutation.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A, returns 1 if array A is a permutation and 0 if it is not.

For example, given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
    A[3] = 2
the function should return 1.

Given array A such that:

    A[0] = 4
    A[1] = 1
    A[2] = 3
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [1..1,000,000,000].
	 */

	public static int solution(int[] A) {
		int isPermutation = 1;
		if(A.length > 1) {
			int max = findMax(A);
			int[] tracker = new int[max + 1];
			for(int i = 0 ; i < A.length ; i++) {
				int current = A[i];
				if(current <= max) {
					tracker[current]++;
				}
			}
			for(int i = 1 ; i < tracker.length ; i++) {
				if(tracker[i] != 1) {
					isPermutation = 0;
					break;
				}
			}
		}else if(A.length == 1 
				&& A[0] == 1){
			isPermutation = 1;			
		}else {
			isPermutation = 0;
		}
		return isPermutation;
	}
	
	private static int findMax(int[] A) {
		int max = A[0];
		for(int i = 0 ; i < A.length ; i++) {
			int current = A[i];
			if(current > max) {
				max = current;				
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {4,1,3,2};
        System.out.println(solution(input));
        input = new int[] {4,1,3};
        System.out.println(solution(input));
	}

}
