package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class KnapSack {

		
	public static int maxProfitDP(int[] weights,
			int[] profits,
			int k) {
		int[][] dp = new int[profits.length][k+1];
		/*
		 * Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5

             0 1 2 3 4 5  
           0 0 0 0 0 0 0  
           1 0 
           2 0
           //           3
           
           
		 */
		for(int j = 0; j < dp.length; j++) {
			dp[j][0] = 0;			
		}
		
		for(int j = 0; j < dp.length; j++) {
			if(weights[0] <= j) {
				dp[0][j] = profits[0];
			}
		}
		
		for(int i = 1; i < dp.length ; i++) {
			for(int j = 1 ; j < dp[i].length ; j++) {
				int profit1 = 0;
				int profit2 = 0;
				if(weights[i] <= j) {
					profit1 = dp[i - 1][j - weights[i]] + profits[i];
				}
				profit2 = dp[i - 1][j];
				dp[i][j] = Math.max(profit1, profit2);
			}
		}
		//System.out.println(Arrays.toString(dp));
		//print(dp);
		printPathOfProfit(dp,k,profits,weights);
		return dp[dp.length - 1][k];		
	}
	
	public static void print(int[][] dp) {
		for(int i = 0 ; i < dp.length ; i++) {
			for(int j = 0; j < dp[i].length ; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	
	public static void printPathOfProfit(int[][] dp, int k,
			int[] profits,
			int[] weights) {
		int profit = dp[dp.length - 1][k];
		System.out.println("path start ---- ");
		for(int i = dp.length - 1 ; i > 0 ; i--) {
			if(dp[i-1][k] != profit) {
				System.out.println(weights[i]);
				profit -= profits[i];
				k -= weights[i];
			}
		}
		if(profit != 0) {
			System.out.println(weights[0]);			
		}
		System.out.println("path end -----");
	}
	
	
	public static int maxProfitWithMemoization(int[] weights,
			 int[] profits,
			 int k,
			 int profit,
			 int i,
			 String path,
			 Integer[][] dp) {
		if(k == 0) {
			System.out.println(path);
			return profit;			
		}
		if(k < 0 || i >= weights.length) {
			return -1;			
		}
		if(dp[i][k] != null) {
			return dp[i][k];						
		}
		int currentWeight = weights[i];
		int currentProfit = profits[i];
		int maxWithCur = -1;
		if(k - currentWeight >= 0) {
			maxWithCur = maxProfitWithMemoization(weights, profits,
					k - currentWeight,
					profit + currentProfit, 
					(i + 1),
					path + " " + i,
					dp);
		}
		int maxWithoutCur =  maxProfitWithMemoization(weights, profits, k,
				profit, 
				(i + 1),
				path,
				dp); 
		dp[i][k] = Math.max(maxWithCur, maxWithoutCur);
		return dp[i][k];
	}
	
	
	public static int maxProfit(int[] weights,
			 int[] profits,
			 int k,
			 int profit,
			 int i,
			 String path) {
		if(k == 0) {
			System.out.println(path);
			return profit;			
		}
		if(k < 0 || i >= weights.length) {
			return -1;			
		}
		int currentWeight = weights[i];
		int currentProfit = profits[i];
		int maxWithCur = -1;
		if(k - currentWeight >= 0) {
			maxWithCur = maxProfit(weights, profits,
					k - currentWeight,
					profit + currentProfit, 
					(i + 1),
					path + " " + i);
		}
		int maxWithoutCur =  maxProfit(weights, profits, k,
				profit, 
				(i + 1),path); 
		return Math.max(maxWithCur, maxWithoutCur);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Items: { Apple, Orange, Banana, Melon }
Weights: { 2, 3, 1, 4 }
Profits: { 4, 5, 3, 7 }
Knapsack capacity: 5
		 */
		int[] weights = new int[] {2,3,1,4};
		int[] profits = new int[] {4,5,3,7};
        int k = 5;
        System.out.println(maxProfit(weights, profits, k,0,0,""));
        Integer[][] dp = new Integer[profits.length][k+1];
        System.out.println(maxProfitWithMemoization(weights, profits, k, 0,0,"",dp));
        System.out.println(maxProfitDP(weights, profits, k));
        profits = new int[]{1, 6, 10, 16};
        weights = new int[]{1, 2, 3, 5}; 
        System.out.println(maxProfitDP(weights, profits, 7));
        System.out.println(maxProfitDP(weights, profits, 6));
 	}

}
