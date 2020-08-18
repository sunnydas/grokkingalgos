package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinAvgTwoSlice {
	
	/*
	 * A non-empty array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.
The goal is to find the starting position of a slice whose average is minimal.

Write a function:

class Solution { public int solution(int[] A); }

that, given a non-empty array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
the function should return 1, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [2..100,000];
each element of array A is an integer within the range [−10,000..10,000].
	 */
	
	public static int solution(int[] A) {
		/*
		 * For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
contains the following example slices:

slice (1, 2), whose average is (2 + 2) / 2 = 2;
slice (3, 4), whose average is (5 + 1) / 2 = 3;
slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

1 2 3 

1 3 6

1 3/2 6/3

1 1.5 3 
		 */
		//List<Integer> minIndexes = new ArrayList<Integer>();
		double[] prefixSum = new double[A.length];
		prefixSum[0] = A[0];
		//minIndexes.add(0);
		for(int i = 1; i < A.length ; i++) {
			prefixSum[i] = A[i] + prefixSum[i - 1];			
		}
		//print(prefixSum);
		/*
		 * 4 2 2 1
		 * 4 6 8 9
		 */
		double min = Double.MAX_VALUE;
		Map<Double,List<Integer>> tracker = new HashMap<Double,List<Integer>>();
		for(int i = 0 ; i < prefixSum.length ;i++) {
			for(int j = i+1; j < prefixSum.length ; j++) {
				double avg;
				if(i == 0) {
					//System.out.println(prefixSum[j]);
					//System.out.println(j);
					avg = (prefixSum[j])/(j+1);
					//System.out.println(avg);
				}else {
					avg = (prefixSum[j] - prefixSum[i - 1])/(j - i + 1);
				}
				//System.out.println(i);
				//System.out.println(j);
				//System.out.println(avg);
				if(avg < min) {
					min = avg;
					if(tracker.containsKey(min)) {
						tracker.get(min).add(i);							
					}else {
						List<Integer> indexes = new ArrayList<Integer>();
						indexes.add(i);
						tracker.put(min, indexes);
					}
				}
			}
		}
		//System.out.println(min);
		//System.out.println(tracker);
		return tracker.get(min).get(0);
	}
	
	public static int findMin(double[] input) {
		int minIndex = -1;
		double min = input[0];
		for(int i = 1 ; i < input.length ; i++) {
			if(input[i] < min) {
				min = input[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}
	
	public static void print(double[] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 *  A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8
		 */
		int[] input = new int[] {4,2,2,5,1,5,8};
		System.out.println(solution(input));
		input = new int[]{1,2,1,1};
		System.out.println(solution(input));
		double a = 3.0;
		int b = 2;
		double c = a/b;
		//System.out.println(c);
	}

}
