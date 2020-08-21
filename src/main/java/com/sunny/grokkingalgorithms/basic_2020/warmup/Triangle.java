package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class Triangle {
	
	/*
	 * An array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

A[P] + A[Q] > A[R],
A[Q] + A[R] > A[P],
A[R] + A[P] > A[Q].
For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
the function should return 1, as explained above. Given array A such that:

  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
	 */
	
	 public static int solution(int[] A) {
		 /*
		  * For example, consider array A such that:

  A[0] = 10    A[1] = 2    A[2] = 5
  A[3] = 1     A[4] = 8    A[5] = 20
Triplet (0, 2, 4) is triangular.

10,2,5,1,8,20

1,2,5,8,10


		  */
		 
		 /*
		  *  A[0] = 10    A[1] = 50    A[2] = 5
  A[3] = 1
the function should return 0.

10,50,5,1

1,5,10,50
		  */
		 int count = 0;
		 for(int i = 0 ; i < A.length ; i++) {
			 for(int j = i+1; j < A.length ; j++) {
				 for(int k = j+1 ; k < A.length ; k++) {
					 if((A[i] + A[j] > A[k]) && (A[j] + A[k] > A[i])
							 && (A[i] + A[k] > A[j])) {
						 count++;						 
					 }
				 }
			 }
		 }
		 return count;
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * 10,2,5,1,8,20

			1,2,5,8,10
		 */
		int[] input = new int[] {10,2,5,1,8,20};
		System.out.println(solution(input));
		input = new int[] {10,50,5,1};
		System.out.println(solution(input));
		input = new int[] {1, 1, 1, 1, 5, 5, 5};
		System.out.println(solution(input));
	}

}
