package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class MarkAndToys {
	
	/*
	 * Mark and Jane are very happy after having their first child. Their son loves toys, so Mark wants to buy some. There are a number of different toys lying in front of him, tagged with their prices. Mark has only a certain amount to spend, and he wants to maximize the number of toys he buys with this money.

Given a list of prices and an amount to spend, what is the maximum number of toys Mark can buy? For example, if  and Mark has  to spend, he can buy items  for , or  for  units of currency. He would choose the first group of  items.

Function Description

Complete the function maximumToys in the editor below. It should return an integer representing the maximum number of toys Mark can purchase.

maximumToys has the following parameter(s):

prices: an array of integers representing toy prices
k: an integer, Mark's budget
Input Format

The first line contains two integers,  and , the number of priced toys and the amount Mark has to spend.
The next line contains  space-separated integers 

Constraints




A toy can't be bought multiple times.

Output Format

An integer that denotes the maximum number of toys Mark can buy for his son.

Sample Input

7 50
1 12 5 111 200 1000 10
Sample Output

4
Explanation

He can buy only  toys at most. These toys have the following prices: .
	 */
	
	 static int maximumToys(int[] prices, int k) {
		 Arrays.parallelSort(prices);
		 int count = 0;
		 int sum = 0;
		 for(int i = 0; i < prices.length ; i++) {
			int price = prices[i];
			if(sum + price <= k) {				
				sum += price;
				++count;
			}else {
				break;
			}
		 }
		 //System.out.println(sum);
		 return count;
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1, 12, 5, 111, 200, 1000, 10};
		System.out.println(maximumToys(input, 50));

	}

}
