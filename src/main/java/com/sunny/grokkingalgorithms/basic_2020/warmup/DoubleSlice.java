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
		/*
		 * The problem is essentially to find a 
		 * subarray which does not include current element 
		 * and then find max sum among .
I think you are overthinking the problem, that's why you find it more difficult than it is:

The understanding that if all elements in the array are positive, or negative it is a different case than when there are some positive and negative elements in the array.

It doesn't have to be a different case. You might be able to come up with an algorithm that doesn't care about this distinction and works anyway.

You don't need to start by understanding this distinction, so don't think about it until or even if you have to.

Kadane's Algorithm

Don't think of an algorithm, think of what the problem requires. Usually that 10+ paragraph problem statement can be expressed in much less.

So let's see how we can simplify the problem statement.

It first defines a slice as a triplet (x, y, z). It's defined at the sum of elements starting at x+1, ending at z-1 and not containing y.

Then it asks for the maximum sum slice. If we need the maximum slice, do we need x and z in the definition? We might as well let it start and end anywhere as long as it gets us the maximum sum, no?

So redefine a slice as a subset of the array that starts anywhere, goes up to some y-1, continues from y+1 and ends anywhere. Much simpler, isn't it?

Now you need the maximum such slice.

Now you might be thinking that you need, for each y, the maximum sum subarray that starts at y+1 and the maximum sum subarray that ends at y-1. If you can find these, you can update a global max for each y.

So how do you do this? This should now point you towards Kadane's algorithm, which does half of what you want: it computes the maximum sum subarray ending at some x. So if you compute it from both sides, for each y, you just have to find:

kadane(y - 1) + kadane_reverse(y + 1)
		 */
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
