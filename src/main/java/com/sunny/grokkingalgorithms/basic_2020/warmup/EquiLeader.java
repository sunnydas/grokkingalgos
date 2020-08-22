package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

public class EquiLeader {

	/*
	 * A non-empty array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
we can find two equi leaders:

0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.
The goal is to count the number of equi leaders.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
the function should return 2, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].
	 */
	
	 public static int solution(int[] A) {
		 int eCount = 0;
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
				if(dominator >= 0) {
					int[] tracker = new int[A.length];
					int tCount = 0;
					for(int i = 0; i < A.length ; i++) {
						if(A[i] == candidate) {
							tCount++;
						}
						tracker[i] = tCount;
					}
					//print(tracker);
					for(int i = 0; i < tracker.length ; i++) {
						//System.out.println(i);
						int curCount = tracker[i];
						int leftLength = (i+1);
						/*
						 * 1 2 3
						 * 0 1 2
						 */
						int rightLength = A.length - i - 1;
						//System.out.println(curCount);
						//System.out.println(leftLength);
						//System.out.println(rightLength);
						//System.out.println();
						int rightCount = tracker[A.length - 1] - curCount;
						/*
						 * if(i == A.length - 1) { rightCount = A[A.length - 1]; }
						 */
						//System.out.println(rightCount);
						//System.out.println();
						//System.out.println();
						if(curCount > leftLength/2 && 
								rightCount > rightLength/2) {
							
							  //System.out.println(); System.out.println(" i " + i);
							  //System.out.println(leftLength); System.out.println(rightLength);
							  //System.out.println(curCount); System.out.println(eCount);
							  //System.out.println();
							 
							eCount++;
						}
					}
				}
			}
			return eCount;
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
		 * A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2
    1,1,2,3,4,4
    0,1,2,3,4,5
		 */
		int[] input = new int[] {4,3,4,4,4,2};
		System.out.println(solution(input));
		input = new int[] {4, 4, 2, 5, 3, 4, 4, 4};
		System.out.println(solution(input));
	}

}
