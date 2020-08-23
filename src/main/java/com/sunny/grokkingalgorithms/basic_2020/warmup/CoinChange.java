package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class CoinChange {
	
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
	
	public static int coinChange(int[] coins,int v) {
		int[] cache = new int[v+1];
		for(int i = 1; i < cache.length ; i++) {
			cache[i] = Integer.MAX_VALUE;			
		}
		for(int i = 1; i <= v ; i++) {
			for(int j = 0 ; j < coins.length ; j++) {
				if(coins[j] <= i) {
					int result = cache[i - coins[j]];
					if(result != Integer.MAX_VALUE) {
						cache[i] = Math.min(cache[i], result  + 1);						
					}
				}
			}
		}
		return cache[v];
	}
	
	public static int coinChangeAlt(int[] coins,int v) {
		if(v <= 0) {
			return 0;			
		}
		int minChange = Integer.MAX_VALUE;
		for(int i = 0 ; i < coins.length ; i++) {
			if(coins[i] <= v) {
				int res = coinChange(v - coins[i]);
				if(res != Integer.MAX_VALUE) {
					System.out.println(res);
					minChange = Math.min(res + 1, minChange);
				}
			}
		}
		return minChange;
	}
	
	public static int coinChange(int v) {
		int minChanges = 0;
		int[] denominations = new int[] {1,2,5,10,20,50,100,500,1000};
		int start = denominations.length - 1;
		while(v > 0) {
			int index = findHighestValueThatFulFillsCriteria(v, denominations,start);
			if(index >= 0) {
				//System.out.println(denominations[index]);
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
        System.out.println(coinChange(93));
        int coins[] =  {9, 6, 5, 1};
        int v = 11;
        System.out.println(coinChange(coins, v));
        coins = new int[]{25,10,5};
        v = 30;
        System.out.println(coinChange(coins,v));
	}

}
