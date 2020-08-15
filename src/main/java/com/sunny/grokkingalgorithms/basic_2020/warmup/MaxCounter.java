package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.List;

public class MaxCounter {
	
	/*
	 * You are given N counters, initially set to 0, and you have two possible operations on them:

increase(X) − counter X is increased by 1,
max counter − all counters are set to the maximum value of any counter.
A non-empty array A of M integers is given. This array represents consecutive operations:

if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
if A[K] = N + 1 then operation K is max counter.
For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
The goal is to calculate the value of every counter after all operations.

Write a function:

class Solution { public int[] solution(int N, int[] A); }

that, given an integer N and a non-empty array A consisting of M integers, returns a sequence of integers representing the values of the counters.

Result array should be returned as an array of integers.

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the function should return [3, 2, 2, 4, 2], as explained above.

3 - 1
4 - 1 + 1 + 1 + 1
2
1 - 1

3, 2 , 3,4,2

1 - 2 + 1
2 - 2 
3 - 2
4 - 1 + 1 + 1 + 1
5 - 2 

max = 2
Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
each element of array A is an integer within the range [1..N + 1].
	 */

	
	public static int[] solution(int N, int[] A) {
		int[] output = new int[N];
		int max = 0;
		/*
		 * Logic
		 * keep track of positions:
		 * 1 - 2 + 1
2 - 2 
3 - 2
4 - 1 + 1 + 1 + 1
5 - 2 
		 */
		int runningMax = 0;
		for(int i = 0 ; i < A.length ; i++) {
			int current = A[i];
			if(current <= N) {
				if(output[current - 1] < max) {
					output[current - 1] = max + 1; 
				}else {
					output[current - 1]++;
				}
				if(output[current - 1] > runningMax) {
				    runningMax = output[current - 1];						
				}
			}else {
				max = runningMax;
			}
		}
		//print(output);
		if(max > 0) {
			for(int i = 0; i < output.length ; i++) {
				if(output[i] < max) {
					output[i] = max;					
				}
			}
		}
		return output;
	}
	
	public static int[] solutionAlt(int N, int[] A) {
		int max = 0;
		int[] arr = new int[N];
		for(int i = 0 ; i < A.length ; i++) {
			if(A[i] <= N) {
				arr[A[i] - 1]++;
				if(arr[A[i] - 1] > max) {
					max = arr[A[i] - 1];
				}
			}else {
				for(int j = 0; j < arr.length ; j++) {
					arr[j] = max;
					if(arr[j] > max) {
						max = arr[j];						
					}
				}
			}
		}
		return arr;
	}
	
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4
the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
		 */
		int[] A = new int[] {3,4,4,6,1,4,4};
		int[] output = solution(5, A);
		print(output);
	}

}
