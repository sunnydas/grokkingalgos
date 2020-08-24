package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class LargestAndSmall {
	
	public static void largestAndSmallest(int[] input) {
		int smallest = Integer.MAX_VALUE;
		int largest = Integer.MIN_VALUE;
		for(int i = 0; i < input.length ; i++) {
			int current = input[i];
			if(current < smallest) {
				smallest = current;
			}
			if(current > largest) {
				largest = current;
			}
		}
		System.out.println(" smallest " + smallest);
		System.out.println(" largest " + largest);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {1,2,3,4,5,0,100,1,0,200,5,10};
		largestAndSmallest(input);
	}

}
