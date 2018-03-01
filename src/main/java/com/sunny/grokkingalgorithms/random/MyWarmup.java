package com.sunny.grokkingalgorithms.random;

public class MyWarmup{


	public int findMax(int[] array) {
		int max = Integer.MIN_VALUE;
		if(array != null){
			for(int i = 0 ; i < array.length ; i++){
				if(array[i] > max){
					max = array[i];
				}
			}
		}
		return max;
	}
}
