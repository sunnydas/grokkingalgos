package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

class UnorderedPair{
	
	public int i;
	@Override
	public String toString() {
		return "UnorderedPair [i=" + i + ", j=" + j + "]";
	}
	public int j;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + i + j;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnorderedPair other = (UnorderedPair) obj;
		if ((i == other.i || i == other.j))
			return true;
		return false;
	}
	
	
	
}
public class NumberOfDiscIntersections {
	
	/*
	 * We draw N discs on a plane. The discs are numbered from 0 to N − 1. An array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

  A[0] = 1
  A[1] = 5
  A[2] = 2
  A[3] = 1
  A[4] = 4
  A[5] = 0


There are eleven (unordered) pairs of discs that intersect, namely:

discs 1 and 4 intersect, and both intersect with all the other discs;
disc 2 also intersects with discs 0 and 3.
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [0..2,147,483,647].
	 */
	
	 public static int solution(int[] A) {
		 long count = 0;
		 /*
		  *  j - i <= A[i] + A[j]
		  *  -A[j] + j <= A[i] + i
		  *  -(A[j] - j) <= A[i] + i
		  */
		 long[] arr1 = new long[A.length];
		 long[] arr2 = new long[A.length];
		 for(int i = 0; i < A.length ;i++) {
			 arr1[i] = ((long)A[i] + i);
			 arr2[i] = -((long)A[i] - i);
		 }
		 Arrays.parallelSort(arr1);
		 Arrays.parallelSort(arr2);
		 //print(arr1);
		 //print(arr2);
		 for(int i = arr1.length - 1 ; i >= 0 ; i--) {
			 long current = arr1[i];
			 //Important
			 int pos = Arrays.binarySearch(arr2, current);
			 //System.out.println(pos);
			 // exact match
			 if(pos >= 0) {
				 //System.out.println(current);
				 //System.out.println(pos);
				 /*
				  * Required because there can be repeats
				  */
				 while(pos < arr2.length && arr2[pos] == current) {
					 pos++;					 
				 }
				 count += pos;
			 }else {
				 //No match find all values which have values less than A[i] + i
				 count += -(pos + 1);
			 }
		 }
		 int n = A.length;
		 //Why is this required?
		 /*
		  * but we only care about those where j > i, as otherwise my predicate trivially holds. That means we have to eliminate all pairs where (j <= i). Say you have the list [x_1,x_2,x_3,...,x_k], you want to eliminate the tuples {(x_1,x_1),(x_1,x_2),(x_1,x_3),...(x_1,x_n)} for x_1. There is N of those. For x_2, you have (N-1). For x_k, you only have to ignore x_k, so 1 pair. You get N + (N-1) + (N-2) + ... + 1 tuples you have to eliminate – this is known to be N(N+1)/2.

2 
•
Reply
		  */
		 long sub = (long)n*((long)n+1)/2;
		 count -= sub;
		 if(count > 10000000) return -1;
		 return (int)count;
	 }
	
	 public static int solutionAlt(int[] A) {
		 int count = 0;
		 /*
		  * 1 1 1 
		  * 1 1 1
		  * 
		  * j−i≤A[i]+A[j]
		  */
		 for(int i = 0; i < A.length ; i++) {
			 for(int j = i+1 ; j < A.length ; j++) {
				 long val = A[i] + A[j];
				 System.out.println(val);
				 if((j - i) <= val) {
					 count++;					 
				 }
			 }
		 }
		 return count;		 
	 }
	 
	 private static void print(int[] input) {
		 for(int i : input) {
			 System.out.print(i + " ");
		 }
		 System.out.println();
	 }

	 private static void print(long[] input) {
		 for(long i : input) {
			 System.out.print(i + " ");
		 }
		 System.out.println();
	 }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,5,2,1,4,0};
		//Arrays.sort(input);
		//print(input);
		//System.out.println(Arrays.binarySearch(input, 3));
		System.out.println(solution(input));
		input = new int[] {1,1,1};
		System.out.println(solution(input));
		input = new int[] {1, 2147483647, 0};
		System.out.println(solution(input));	
	}

}
