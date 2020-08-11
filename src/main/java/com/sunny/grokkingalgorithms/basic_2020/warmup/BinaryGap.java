package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

import com.sunny.grokkingalgorithms.gpn.findpath.Solution;

public class BinaryGap {
	
	/*
	 * A binary gap within a positive integer N is any maximal sequence of consecutive zeros 
	 * that is surrounded by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 
and contains a binary gap of length 2. The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. The number 20 has binary representation 10100 and contains one binary gap of length 1. The number 15 has binary representation 1111 and has no binary gaps. The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].
	 */
	
	public static int solution(int N) {
        // write your code in Java SE 8
		/*
		 * 1001
		 * 
		 * 1000
		 */
		int count = 0;
		String binString = Integer.toBinaryString(N);
		//System.out.println(binString);
		boolean scopeStarted = false;
		int localCount = 0;
		for(int i = 0; i < binString.length() ; i++) {
			char current = binString.charAt(i);
			if(!scopeStarted && current == '1') {
				scopeStarted = true;
			}else if(scopeStarted && current == '1') {
				count = Math.max(count, localCount);
				localCount = 0;
				scopeStarted = false;
			}else if(scopeStarted && current == '0') {
				localCount++;				
			}
		}
		return count;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 5;
		int p = 1;
		/*
		 * 101
		 * 001
		 * 
		 * 1001
		 * 1111
		 * 
		 * 0110
		 * 
		 */
		//System.out.println((n&p));
		//System.out.println((9^0xFF));
		//System.out.println(0xFF);
		//System.out.println(9>>1&1);
		System.out.println(solution(9));
		System.out.println(solution(20));
		
	}

}
