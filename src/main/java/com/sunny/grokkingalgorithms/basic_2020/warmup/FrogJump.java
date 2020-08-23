package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
class Jump{
	public int pos;
	public Jump(int pos, int mov) {
		super();
		this.pos = pos;
		this.mov = mov;
	}
	public int mov;
}
public class FrogJump {

	/*
	 * The Fibonacci sequence is defined using the following recursive formula:

    F(0) = 0
    F(1) = 1
    F(M) = F(M - 1) + F(M - 2) if M >= 2
A small frog wants to get to the other side of a river. The frog is initially located at one bank of the river (position −1) and wants to get to the other bank (position N). The frog can jump over any distance F(K), where F(K) is the K-th Fibonacci number. Luckily, there are many leaves on the river, and the frog can jump between the leaves, but only in the direction of the bank at position N.

The leaves on the river are represented in an array A consisting of N integers. Consecutive elements of array A represent consecutive positions from 0 to N − 1 on the river. Array A contains only 0s and/or 1s:

0 represents a position without a leaf;
1 represents a position containing a leaf.
The goal is to count the minimum number of jumps in which the frog can get to the other side of the river (from position −1 to position N). The frog can jump between positions −1 and N (the banks of the river) and every position containing a leaf.

For example, consider array A such that:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
The frog can make three jumps of length F(5) = 5, F(3) = 2 and F(5) = 5.

Write a function:

class Solution { public int solution(int[] A); }

that, given an array A consisting of N integers, returns the minimum number of jumps by which the frog can get to the other side of the river. If the frog cannot reach the other side of the river, the function should return −1.

For example, given:

    A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 1
    A[4] = 1
    A[5] = 0
    A[6] = 1
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
the function should return 3, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..100,000];
each element of array A is an integer that can have one of the following values: 0, 1.
	 */
	
	public static int fib(int n,int[] cache) {
		if(cache[n] > 0) {
			return cache[n];			
		}
		int fib = 0;
		cache[0] = 1;
		cache[1] = 2;
		int fibN2 = cache[0];
		int fibN1 = cache[1];
		cache[1] = 1;
		for(int i = 2; i <= n; i++) {
			fib = fibN1 + fibN2;
			fibN2 = fibN1;
			fibN1 = fib;
			cache[i] = fib;
		}
		cache[n] = fib;
		return cache[n];
	}
	
	private static List < Integer > fibArray(int n) {
	    List < Integer > fibs = new ArrayList < > ();
	    fibs.add(1);
	    fibs.add(2);
	    while (fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2) <= n) {
	        fibs.add(fibs.get(fibs.size() - 1) + fibs.get(fibs.size() - 2));
	    }
	    return fibs;
	}
	
	public static int solution(int[] A) {
		int n = A.length;
	    List < Integer > fibs = fibArray(n + 1);
	    Queue < Jump > positions = new LinkedList < Jump > ();
	    boolean[] visited = new boolean[n + 1];

	    if (A.length <= 2)
	        return 1;

	    for (int i = 0; i < fibs.size(); i++) {
	        int initPos = fibs.get(i) - 1;
	        if (A[initPos] == 0 || visited[initPos])
	            continue;
	        positions.add(new Jump(initPos, 1));
	        visited[initPos] = true;
	    }

	    while (!positions.isEmpty()) {
	        Jump jump = positions.remove();
	        for (int j = fibs.size() - 1; j >= 0; j--) {
	            int nextPos = jump.pos + fibs.get(j);
	            if (nextPos == n)
	                return jump.mov + 1;
	            else if (nextPos < n && A[nextPos] == 1 && !visited[nextPos]) {
	                positions.add(new Jump(nextPos, jump.mov + 1));
	                visited[nextPos] = true;
	            }
	        }
	    }
	    return -1;
	}
	
	public static void print(int[] cache) {
		for(int i : cache) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*
         * A[0] = 0
    A[1] = 0
    A[2] = 0
    A[3] = 4
    A[4] = 5
    A[5] = 0
    A[6] = 7
    A[7] = 0
    A[8] = 0
    A[9] = 0
    A[10] = 0
    A[11] = 12
         */
		int[] input = new int[] {0,0,0,1,1,0,1,0,0,0};
		/*
		 * 0,0,0,4,5,0,7,0,0,0,0
		 * 
		 * 0,0,0,1,1
		 */
		System.out.println(solution(input));
		int[] cache = new int[10];
		//System.out.println(fib(5,cache));
		//System.out.println(fib(3, cache));
		//print(cache);
	}

}
