package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class CountDiv {

	
	/*
	 * Write a function:

class Solution { public int solution(int A, int B, int K); }

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Write an efficient algorithm for the following assumptions:

A and B are integers within the range [0..2,000,000,000];
K is an integer within the range [1..2,000,000,000];
A ≤ B.
	 */
	
	
	public static int solution(int A, int B, int K) {
		/*
		 * 6, 11 2
		 * 11/2 - 6/2 + 1
		 * 5 - 3 + 1
		 * The number of multiples of z in a number n is simply n / z

/ being the integer division, meaning decimals that could result from the division are simply ignored (for instance 17/5 => 3 and not 3.4).

Now, in a range from x to y, how many multiples of z are there?

Let see how many multiples m we have up to y

0----------------------------------x------------------------y
-m---m---m---m---m---m---m---m---m---m---m---m---m---m---m---
You see where I'm going... to get the number of multiples in the range [ x, y ], get the number of multiples of y then subtract the number of multiples before x, (x-1) / z

Solution: ( y / z ) - (( x - 1 ) / z )

Programmatically, you could make a function numberOfMultiples

function numberOfMultiples(n, z) {
   return n / z;
}
to get the number of multiples in a range [x, y]

numberOfMultiples(y) - numberOfMultiples(x-1)
The function is O(1), there is no need of a loop to get the number of multiples.

Examples of results you should find

[30, 90] ÷ 13 => 4
[1, 1000] ÷ 6 => 166
[100, 1000000] ÷ 7 => 142843
[777, 777777777] ÷ 7 => 111111001
For the first example, 90 / 13 = 6, (30-1) / 13 = 2, and 6-2 = 4

---26---39---52---65---78---91--
     ^                      ^
     30<---(4 multiples)-->90
		 */
		if(A % K == 0) {
			return (B/K) - (A/K) + 1;			
		}
		return (B/K) - (A/K);
	}
	
	public static int solutionAlt(int A, int B, int K) {
		int count = 0;
		/*
		 * 5 6 7 8
		 * 
		 */
		for(int i = A; i <= B ; i++) {
			if(i % K  == 0) {
				count++;				
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(6, 11, 2));
		System.out.println(solution(5, 8, 7));
	}

}
