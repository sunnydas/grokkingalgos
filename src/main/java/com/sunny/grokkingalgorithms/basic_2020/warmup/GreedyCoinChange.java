package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class GreedyCoinChange {
	
	/*
	 * Given a value V, if we want to make a change for V Rs, and we have an infinite supply of each of the denominations in Indian currency, i.e., we have an infinite supply of { 1, 2, 5, 10, 20, 50, 100, 500, 1000} valued coins/notes, what is the minimum number of coins and/or notes needed to make the change?
Examples:

Input: V = 70
Output: 2
We need a 50 Rs note and a 20 Rs note.

Input: V = 121
Output: 3
We need a 100 Rs note, a 20 Rs note and a 1 Rs coin. 
	 */
	
	public static int coinChange(int v) {
		int minChanges = 0;
		int[] denominations = new int[] {1,2,5,10,20,50,100,500,1000};
		int start = denominations.length - 1;
		while(v > 0) {
			int index = findHighestValueThatFulFillsCriteria(v, denominations,start);
			if(index >= 0) {
				v -= denominations[index];
				minChanges++;
				start = index;
			}
		}
		return minChanges;		
	}
	
	public static int findHighestValueThatFulFillsCriteria(int v,int[] denoms,int start) {
		int index = -1;
		for(int i = start; i >= 0 ; i--) {
			if(denoms[i] <= v) {
				index = i;
				break;
			}
		}
        return index;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(coinChange(70));
        System.out.println(coinChange(121));
	}

}
