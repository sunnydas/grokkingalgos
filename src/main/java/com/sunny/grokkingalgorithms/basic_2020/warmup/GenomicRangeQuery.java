package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class GenomicRangeQuery {
	
	/*
	 * A DNA sequence can be represented as a string consisting of the letters A, C, G and T,
	 *  which correspond to the types of successive nucleotides in the sequence.
	 *   Each nucleotide has an impact factor, which is an integer. 
	 *   Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
The answers to these M = 3 queries are as follows:

The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), 
whose impact factors are 3 and 2 respectively, so the answer is 2.
The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.
Write a function:

class Solution { public int[] solution(String S, int[] P, int[] Q); }

that, given a non-empty string S consisting of N characters and two non-empty
 arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

Result array should be returned as an array of integers.

For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6
the function should return the values [2, 4, 1], as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
M is an integer within the range [1..50,000];
each element of arrays P, Q is an integer within the range [0..N − 1];
P[K] ≤ Q[K], where 0 ≤ K < M;
string S consists only of upper-case English letters A, C, G, T.
	 */
	
	/*
	 *  2 1 3 2 2 4 1
	 *  
	 *  2(2) 1(1,2)  3(1,3) 2(1,2)  2(1,2) 4(1,2) 1(1)
	 *  
	 *  
	 *  3 1 2 4
	 *  
	 *   3(1,3)   1(1,1)  2(2,2)  4(4,4) 
	 *       
	 *   2(1,2)   1(1,1)  3(1,2)   2(1,2)  2(1,2) 4(1,4) 1(1,1)
	 *  
	 * 2 -1 4 -2 0 4 -3
	 *  
	 *      2  1   1   1  1  1  1  
	 *  
	 *     15  13  12  9  7  5  1         
	 *  
	 *  2 1 2 2 2 1 1 
	 *  
	 *  2 3 6 8 10 14 15
	 *  
	 *  2 1 1 1 1 1 1
	 *  
	 *  2 0 2 1 1 3 0 
	 *  
	 *  C A G C C T A
	 *  
	 *  2 3  6  8  10  14  15
	 *  
	 * 15 13 12  9  7   5    1   
	 * 
	 *   
	 *     0   1   2   3   4   5
	 *  0  2   1   1   1   1   1 
	 *  
	 *  1  X   1   1   1   1   1  
	 *  
	 *  2  X   X   3   2   2   1 
	 *   
	 *  3  X   X   X   2   2   1
	 *  
	 *  4  X   X   X   X   2   1   
	 *  
	 *  5  X   X   X   X   X   4
	 *   
	 * 
	 * 
	 *  
	 */
	
	public static int[] solution(String S,int[] P,int[] Q) {
		int[] impact = new int[P.length];
		/*
		 * 0 is global mean , 1 is local mean
		 */
		int[][] tracker = new int[S.length()][2];
		int[] input = new int[S.length()];
		for(int i = 0; i < S.length() ; i++) {
			char current = S.charAt(i);
			if(current == 'A') {
				input[i] = 1;
			}else if(current == 'C'){
				input[i] = 2;				
			}else if(current == 'G'){
				input[i] = 3;				
			}else if(current == 'T'){
				input[i] = 4;				
			} 
		}
		int globalMin = input[input.length - 1];
		int localMin = input[input.length - 1];
		tracker[input.length - 1][0] = globalMin;
		tracker[input.length - 1][1] = localMin;
		for(int i = input.length - 2; i >= 0; i--) {
			int current = input[i];
			if(current < globalMin) {
				globalMin = current;				
			}
			tracker[i][0] = globalMin;
			tracker[i][1] = current;
		}
		print(tracker);
		for(int i = 0; i < P.length ; i++) {
			int start = P[i];
			int end = Q[i];
			if(end == input.length - 1) {
				impact[i] = tracker[start][0]; 				
			}else {
				impact[i] = Math.min(tracker[P[i]][1], tracker[Q[i]][1]);
			}
		}
		return impact;
	}
	
	public int[] solutionAlt(String S, int[] P, int[] Q) {
		int[] impact = new int[P.length];
		int[] input = new int[S.length()];
		for(int i = 0; i < S.length() ; i++) {
			char current = S.charAt(i);
			if(current == 'A') {
				input[i] = 1;
			}else if(current == 'C'){
				input[i] = 2;				
			}else if(current == 'G'){
				input[i] = 3;				
			}else if(current == 'T'){
				input[i] = 4;				
			} 
		}
		for(int i = 0; i < P.length ;i++) {
			impact[i] = findMin(input, P[i], Q[i]);			
		}
		return impact;
	}

	
	private static int findMin(int[] input,int start,int end) {
		int min = input[start];
		for(int i = start+1; i <= end ; i++) {
			if(input[i] < min) {
				min = input[i];				
			}
		}
		return min;
	}
	
	public static void print(int[] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i] + " ");			
		}
		System.out.println();
	}
	
	public static void print(int[][] arr) {
		for(int i = 0; i < arr.length ; i++) {
			System.out.print(arr[i][0] + "," + arr[1][1] + " ");			
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Example test:   ('CAGCCTA', [2, 5, 0], [4, 5, 6])
WRONG ANSWER (got [1, 1, 1] expected [2, 4, 1])
		 */
		
		String s = "CAGCCTA";
		int[] p = new int[] {2,5,0};
		int[] q = new int[] {4,5,6};
		int[] arr = solution(s, p, q);	
        print(arr);
        /*
         * ('AC', [0, 0, 1], [0, 1, 1]) 
         */
        s = "AC";
        p = new int[] {0,0,1};
        q = new int[] {0,1,1};
        arr = solution(s, p, q);
        //print(arr);
	}

}
