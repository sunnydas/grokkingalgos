package com.sunny.grokkingalgorithms.boot2019.toast;

public class BuySellStock2Times {

    /*
    123. Best Time to Buy and Sell Stock III
Hard

1448

59

Favorite

Share
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

Example 1:

Input: [3,3,5,0,0,3,1,4]
Output: 6
Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
             Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
     */

    public static int maxProfit(int[] prices) {
        return maxProfit(prices,2,0);
    }

    public static int maxProfit(int[] prices,int k,int pos){
        if (k == 0 || pos == prices.length)
            return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = pos; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            int diff = prices[i] - min;
            if (diff > 0) {
                diff += maxProfit(prices, k - 1, pos + 1);
            }
            profit = Math.max(profit, diff);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,3,5,0,0,3,1,4};
        System.out.println(maxProfit(input));
    }
}
