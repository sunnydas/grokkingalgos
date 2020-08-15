package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class MissingInteger {

	/*
	 * Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0)
 that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

-1 , 1 , 3 2
Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
	 */
	
	public static int solution(int[] A) {
		/*
		 * A = [1, 3, 6, 4, 1, 2], the function should return 5.
		 * 1 6 
		 * 
		 * [1,2,3,4,X,6]
		 * 
		 * 
		 */
		int[] minAndMax = findMinAndMax(A);
		int min = minAndMax[0];
		int max = minAndMax[1];
		if(max <= 0) {
			return 1;
		}else if(min <= 0) {
			min = 0;
		}		
		int[] tracker = new int[max + 1];
		for(int i = 0 ; i < A.length ; i++) {
			if(A[i] > 0) {
				tracker[A[i]]++;
			}
		}
		//print(tracker);
		for(int i = 1 ; i < tracker.length ; i++) {
			if(tracker[i] <= 0) {
				return i;				
			}
		}
		return max + 1;
	}
	
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}
	
	public static int[] findMinAndMax(int[] A) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int[]  output = new int[2];
		for(int i = 0; i < A.length ; i++) {
			int current = A[i];
			if(current < min) {
				min = current;				
			}
			if(current > max) {
				max = current;				
			}
		}
		output[0] =  min;
		output[1] = max;
		return output;				
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1, 3, 6, 4, 1, 2};
		System.out.println(solution(input));
		input = new int[] {1,2,3};
		System.out.println(solution(input));
		input = new int[] {-1,1,3};
		System.out.println(solution(input));
		input = new int[] {-1,-3};
		System.out.println(solution(input));
	}

}
