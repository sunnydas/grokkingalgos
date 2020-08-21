package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;
import java.util.Comparator;

class Elem implements Comparable<Elem>{
	
	public int index;
	public int value;
	
	@Override
	public int compareTo(Elem o) {
		if(this.value > o.value && this.index > o.index) {
			return 1;
		}else if(this.value < o.value) {
			return -1;			
		} 
		return 0;
	}
	
	
}
public class MaxProductofThree {
	
	/*
	 * A non-empty array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
contains the following example triplets:

(0, 1, 2), product is −3 * 1 * 2 = −6
(1, 2, 4), product is 1 * 2 * 5 = 10
(2, 4, 5), product is 2 * 5 * 6 = 60
Your goal is to find the maximal product of any triplet.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

  A[0] = -3
  A[1] = 1
  A[2] = 2
  A[3] = -2
  A[4] = 5
  A[5] = 6
the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [3..100,000];
each element of array A is an integer within the range [−1,000..1,000].
	 */
	
	public static int solution(int[] A) {
		int max = Integer.MIN_VALUE;
		Arrays.parallelSort(A);
		int i = A.length - 1;
		max = Math.max(A[i]*A[i-1]*A[i-2],A[i]*A[0]*A[1]);
		return max;
	}
	
	public static int solutionAlt1(int[] A) {
		int max = Integer.MIN_VALUE;
		Elem[] elems = new Elem[A.length];
		for(int i = 0 ; i < A.length ; i++) {
			Elem elem = new Elem();
			elem.index = i;
			elem.value = A[i];
			elems[i] = elem;
		}
		Arrays.sort(elems);
		print(elems);
		int i = 0;
		int j = elems.length - 1;
		int k = i + (j - i)/2;
		return max;
	}
	
	private static void print(Elem[] elems) {
		System.out.println();
		for(Elem elem  : elems) {
			System.out.print(" " + elem.value + " " + elem.index + " , ");
			//System.out.println();
		}
		System.out.println();
	}
	
	 public static int solutionAlt(int[] A) {
		 int max = Integer.MIN_VALUE;
		 /*
		  *  
		  * -3 1 2 -2 5 6 
		  *
		  * -3 -2 1 2 5 6
		  * 
		  * -5 5 -5 4
		  * 
		  * -5 -5 5 4
		  * 
		  * 
		  */
		 for(int i = 0 ; i < A.length ; i++) {
			 for(int j = i+1 ; j < A.length ; j++) {
				 for(int k = j+1; k < A.length ; k++) {
					 int val = A[i]*A[j]*A[k];
					 if(val > max) {
						 max = val;
					 }
				 }				 
			 }
		 }
		 return max;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {-3,1,2,-2,5,6};
		System.out.println(solution(input));
		input = new int[] { -5, 5, -5, 4};
		System.out.println(solution(input));
	}

}
