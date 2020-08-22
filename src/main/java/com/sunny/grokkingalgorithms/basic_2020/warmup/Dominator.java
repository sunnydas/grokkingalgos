package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;
import java.util.Stack;

public class Dominator {
	
	/*
	 * An array A consisting of N integers is given. The dominator of array A is the value that occurs in more than half of the elements of A.

For example, consider array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
The dominator of A is 3 because it occurs in 5 out of 8 elements of A (namely in those with indices 0, 2, 4, 6 and 7) and 5 is more than a half of 8.

Write a function

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns index of any element of array A in which the dominator of A occurs. The function should return −1 if array A does not have a dominator.

For example, given array A such that

 A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
the function may return 0, 2, 4, 6 or 7, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	 */
	
	public static int solution(int[] A) {
		int dominator = -1;
		if(A.length > 1) {
			/*
						 * 7
			3
			2
			-1
			
			{3,4,3,2,3,-1,3,3}
			
			-1,2,3,3,3,3,3,4
			 */
			Arrays.parallelSort(A);
			int count = 1;
			int maxCount = -1;
			int maxCandidate = -1;
			for(int i = 1; i < A.length ; i++) {
				if(A[i] == A[i-1]) {
					count++;					
				}else {
					if(count > maxCount) {
						maxCount = count;
						maxCandidate = i;
					}
					count = 1;
				}
			}
			if(maxCount > A.length/2) {
				dominator = maxCandidate;				
			}
		}else if(A.length == 1) {
			dominator = 0;
		}
		return dominator;
	}
	
	public static int solutionAlt(int[] A) {
		int dominator = -1;
		if(A.length > 0) {
			if(A.length == 1) {
				return 0;				
			}
			Stack<Integer> stack = new Stack<Integer>();
			stack.push(A[0]);
			int candidate = Integer.MIN_VALUE;
			for(int i = 1; i < A.length ; i++) {
				int current = A[i];
				if(stack.isEmpty() || stack.peek() == current) {
					stack.push(A[i]);
					//candidate = current;
				}else if(stack.peek() != current) {
					stack.pop();
					stack.add(current);
				}
			}
			//System.out.println(stack);
			if(!stack.isEmpty()) {
				if(stack.size() == 1) {
					candidate = stack.pop();					
				}else {
					int prev = stack.pop();
					while(!stack.isEmpty() && stack.peek() != prev) {
						prev = stack.pop();						
					}
					candidate = prev;
				}
			}
			if(candidate != Integer.MIN_VALUE) {
				//System.out.println(candidate);
				int count = 0;
				for(int i = 0; i < A.length ; i++) {
					if(candidate == A[i]) {
						dominator = i;
						count++;
					}
				}
				//System.out.println(count);
				//System.out.println(A.length/2);
				if(count <= (A.length/2)) {
					dominator = -1;
				}
			}
		}
		return dominator;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  A[0] = 3    A[1] = 4    A[2] =  3
 A[3] = 2    A[4] = 3    A[5] = -1
 A[6] = 3    A[7] = 3
		 */
		int[] input = new int[] {3,4,3,2,3,-1,3,3};
		System.out.println(solution(input));
		input = new int[] {2, 1, 1, 1, 3};
		System.out.println(solution(input));
		input = new int[] {1,2,1};
		System.out.println(solution(input));	
		input = new int[] {2, 1, 1, 3};
		System.out.println(solution(input));
	}

}
