package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class DoubleSlice {
	
	/*
	 * A non-empty array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + 
A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
contains the following example double slices:

double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
double slice (3, 4, 5), sum is 0.
The goal is to find the maximal sum of any double slice.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers,
 returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
the function should return 17, because no double slice of array A 
has a sum of greater than 17.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−10,000..10,000].
	 */
	
	public static int solution(int[] A) {
		int maxSum = 0;
		int[] k1 = new int[A.length];
		int[] k2 = new int[A.length];
		for(int i = 1; i < A.length - 1 ; i++) {
			k1[i] = Math.max(k1[i - 1] + A[i], 0);			
		}
		//print(k1);
		for(int i = A.length - 2; i > 0; i--) {
			k2[i] = Math.max(k2[i + 1] + A[i], 0);			
		}
		//print(k2);
		for(int i = 1; i < A.length - 1 ; i++) {
			maxSum = Math.max(k1[i - 1] + k2[i + 1], maxSum);		
		}
		return maxSum;
	}
	

	public static int solutionAlt(int[] A) {
		int maxSum = 0;
		int[] prefixSum = new int[A.length];
		prefixSum[0] = A[0];
		for(int i = 1 ; i < A.length ; i++) {
			prefixSum[i] = prefixSum[i - 1] + A[i];
		}
		for(int i = 0 ; i < A.length; i++) {
			for(int j = i+1; j < A.length ; j++) {
				for(int k = j+1; k < A.length ; k++) {
					int sum = 0;
					sum += prefixSum[j - 1] - prefixSum[i];
					//System.out.println(sum);
                    sum += prefixSum[k - 1] - prefixSum[j]; 
					//System.exit(0);
                    maxSum = Math.max(sum, maxSum);
				}
			}
		}
		return maxSum;		
	}
	
	public static void print(int[] input) {
		for(int i : input) {
			System.out.print(i + " ");			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2
		 */
        int[] input = new int[] {3,2,6,-1,4,5,-1,2};
        System.out.println(solution(input));
        input = new int[] {5, 17, 0, 3};
        System.out.println(solution(input));
	}

}
