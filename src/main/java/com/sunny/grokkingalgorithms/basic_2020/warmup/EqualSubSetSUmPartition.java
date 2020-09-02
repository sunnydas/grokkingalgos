package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.ml.distance.CanberraDistance;

public class EqualSubSetSUmPartition {
	
	/*
	 * iven a set of positive numbers, find if we can partition it into two subsets such that the sum of elements in both the subsets is equal.

Example 1: #
Input: {1, 2, 3, 4}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 4} & {2, 3}
Example 2: #
Input: {1, 1, 3, 4, 7}
Output: True
Explanation: The given set can be partitioned into two subsets with equal sum: {1, 3, 4} & {1, 7}
	 */
	
	public static boolean canPartitionImproved(int[] input) {
		int sum = 0;
		/*
		 * 1 2 3 4=10
		 * 1+4 2+3
		 * 
		 */
		for(int i = 0; i < input.length ; i++) {
			sum += input[i];			
		}
		if(sum %2 != 0) {
			return false;			
		}
		Boolean[][] dp = new Boolean[input.length][sum/2+1];
		//return canPartitionRecursive(input, sum/2, 0);
		return canPartitionRecursiveMemoized(input, sum/2, 0, dp);
	}
	
	public static boolean canPartitionRecursiveMemoized(int[] input,
			int sum,
			int currentIndex,
			Boolean[][] dp) {
		
		if(sum == 0) {
			return true;		
		}
		
		if(input.length == 0 
				|| currentIndex >= input.length) {
			return false;
		}
		
		if(dp[currentIndex][sum] == null) {
			if((sum - input[currentIndex]) >= 0) {
				if(canPartitionRecursiveMemoized(input, 
						sum - input[currentIndex], 
						currentIndex +1,
						dp)) {
					dp[currentIndex][sum] = true;
					return true;
				}
			}
			dp[currentIndex][sum] = canPartitionRecursiveMemoized(input, 
					sum, 
					currentIndex + 1, 
					dp);
		
		}
		return dp[currentIndex][sum];
	}
	
	
	public static boolean canPartitionRecursive(int[] input,
			int sum,
			int currentIndex) {
		
		if(sum == 0) {
			return true;			
		}
		
		if(input.length == 0 
				|| currentIndex >= input.length) {
			return false;
		}
		
		if((sum - input[currentIndex]) >= 0) {
			if(canPartitionRecursive(input, sum - input[currentIndex], 
					currentIndex +1)) {
				return true;
			}
		}
		return canPartitionRecursive(input, sum, currentIndex+1);
	}
	
	public static boolean canPartition(int[] input) {
		boolean canPartition = false;
		List<List<Integer>> all = getCombinations(input);
		//System.out.println(all);
		for(int i = 0; i < all.size() ; i++) {
			for(int j = i+1; j < all.size() ; j++) {
				if(areSumEqual(all.get(i), all.get(j))) {
					//System.out.println("##");
					//System.out.println(all.get(i));
					//System.out.println(all.get(j));
					canPartition = true;
					break;
				}
			}
		}
		return canPartition;
	}
	
	public static boolean areSumEqual(List<Integer> a,List<Integer> b) {
		int sum = 0;
		for(Integer i : a) {
			sum += i;
		}
		int sum1 = 0;
		for(Integer i : b) {
			sum1 += i;
		}
		return sum == sum1;
	}
	
	public static List<List<Integer>> getCombinations(int[] input){
			if(input.length <= 0) {
				List<List<Integer>> list = new ArrayList<List<Integer>>();
				List<Integer> empty = new ArrayList<Integer>();
				list.add(empty);
				return list;
			}
			if(input.length == 1) {
				List<List<Integer>> list = new ArrayList<List<Integer>>();
				List<Integer> one = new ArrayList<Integer>();
				one.add(input[0]);
				list.add(one);
				List<Integer> empty = new ArrayList<Integer>();
				list.add(empty);
				return list;				
			}
			//System.out.println(Arrays.toString(input));
			int current = input[0];
			int[] rest = Arrays.copyOfRange(input, 1, input.length);
			List<List<Integer>> sub = getCombinations(rest);
			List<List<Integer>> all = new ArrayList<List<Integer>>();
			if(sub.size() == 1 
					&& sub.get(0).isEmpty()) {
				List<Integer> one = new ArrayList<Integer>();
				one.add(current);
				all.add(one);
				//System.out.println(all);
			}else {
				//System.out.println(sub);
				for(List<Integer> now : sub) {
					List<Integer> mod = new ArrayList<Integer>();
					mod.add(current);
					mod.addAll(now);
					all.add(mod);
				}
			}
			all.addAll(sub);
			return all;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1, 2, 3, 4};
		System.out.println(canPartition(input));
		System.out.println(canPartitionImproved(input));
		int[] input1 = {1, 1, 3, 4, 7};
		System.out.println(canPartition(input1));
		System.out.println(canPartitionImproved(input1));
		int[] input3 = {2, 3, 4, 6};
		System.out.println(canPartition(input3));
		System.out.println(canPartitionImproved(input3));
	}

}
