package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.LinkedHashSet;
import java.util.Set;

class PlaceHolder{
	public int minIndex;
	public int maxIndex;
}
public class DifferentNumber {
	
	/*
	 * Find smallest non negative number not in the arrays
	 */

	public static int getSmallestNonNegativeNumber(int[] input) {
		int smallest = -1;
		/*
		 * Smallest number could be in the beginning , middle or end
		 * [0,3,4,6] -> 1
		 */
		PlaceHolder holder = findMinAndMax(input);
		int smallestVal = input[holder.minIndex];
		Set<Integer> tracker = new LinkedHashSet<Integer>();
		for(int i = 0; i < input.length ; i++) {
			tracker.add(input[i]);
		}
		if(smallestVal > 0) {
			smallest = smallestVal - 1;			
		}else {
			for(int i = smallest + 1; i <= input[holder.maxIndex] ; i++) {
				if(!tracker.contains(i)) {
					smallest = i;
					break;
				}
			}
			if(smallest == -1) {
				smallest = input[holder.maxIndex] + 1;				
			}
		}
		return smallest;
	}
	
	public static PlaceHolder findMinAndMax(int[] input) {
		PlaceHolder holder = new PlaceHolder();
		int minIndex = 0;
		int min  = input[0];
		int maxIndex = 0;
		int max = input[0];
		for(int i = 1 ; i < input.length ; i++) {
			if(input[i] < min) {
				min = input[i];
				minIndex = i;
			}
			if(input[i] > max) {
				max = input[i];
				maxIndex = i;
			}
		}
		holder.minIndex = minIndex;
		holder.maxIndex = maxIndex;
		return holder;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int[] input = new int[] {3,4,5,6};
        System.out.println(getSmallestNonNegativeNumber(input));
        input = new int[] {0,1,2,3};
        System.out.println(getSmallestNonNegativeNumber(input));
        input = new int[] {0,1,3};
        System.out.println(getSmallestNonNegativeNumber(input));
	}

}
