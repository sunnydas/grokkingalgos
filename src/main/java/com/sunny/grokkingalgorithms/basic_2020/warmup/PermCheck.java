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
	
	public static int solutionAlt(int[] A) {
		int isPermutation = 1;
		if(A.length > 1) {
			int[] minMax = findMinAndMax(A);
			int max = minMax[1];
			int min = minMax[0];
			if(A.length != (max - min + 1)) {
				return 0;
			}else {
				/*
				 * 4 1 3 2 
				 * 0 1 2 3
				 * 
				 *  2 1 3 4
				 *  1 2 3 4
				 *  
				 *  
				 *  4 1 1 2
				 *  
				 *  2 1 1 4
				 *  1 2 1 4
				 *  
				 *  2,3,4,5
				 *  
				 *  3,2,4,5
				 *  
				 *  
				 *  2 
				 *  0+2,1+2,2+2
				 */
				int i = 0;
				while(i < A.length) {
					int current = A[i] - min;
					//System.out.println(current);
					//print(A);
					if(current != i) {
						if(current <= A.length - 1) {
							int temp = A[current];
							A[current] = current+min;
							A[i] = temp;
						}else {
							isPermutation = 0;
							break;
						}
					}
					i++;					
				}
				print(A);
				if(isPermutation == 1) {
					i = 0;
					while(i < A.length) {
						if(A[i] != (i + min)) {
							isPermutation = 0;
							break;
						}
						i++;
					}
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
	
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}

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
			A = null;
			//System.gc();
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
	
	private static int[] findMinAndMax(int[] A) {
		int[] minMax = new int[2];
		int max = A[0];
		int min = A[0];
		for(int i = 0 ; i < A.length ; i++) {
			int current = A[i];
			if(current > max) {
				max = current;				
			}
			if(current < min) {
				min = current;
			}
		}
		minMax[0] = min;
		minMax[1] = max;
		return minMax;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {4,1,3,2};
        System.out.println(solution(input));
        input = new int[] {4,1,3};
        System.out.println(solution(input));
        input = new int[] {1,2,3,4};
        System.out.println(solution(input));
        input = new int[] {2,3,4};
        System.out.println(solution(input));
	}

}
