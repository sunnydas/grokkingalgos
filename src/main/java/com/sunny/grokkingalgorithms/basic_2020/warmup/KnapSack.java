package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class KnapSack {

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
	}

}
