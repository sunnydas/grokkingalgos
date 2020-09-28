package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class SearchInSortedArray {

	public static int 
		findInCircularSortedArr(int[] input,int k) {
		int pivot = findPivotPoint(input);
		if(pivot >= 0) {
			if(k == input[pivot]) {
				return pivot;
			}
			if(k < input[pivot]) {
				return binarySearch(input, 0, pivot - 1, k);								
			}else {
				return binarySearch(input, 0, pivot + 1, k);
			}
		}
		return -1;				
	}
	
	
	public static int binarySearch(int[] input,
			int start,
			int end,
			int k) {
		if(start > end) {
			return -1;			
		}
		int mid = start + (end - start)/2;
		if(input[mid] == k) {
			return mid;			
		}
		else if(input[mid] > k) {
			return binarySearch(input, start, mid - 1, k);
		}
		else {
			return binarySearch(input, mid + 1, end, k);
		}
	}
	
	public static int findPivotPoint(int[] input) {
		int start = 0;
		int end = input.length - 1;
		while(start <= end) {
			if(input[start] <= input[end]) {
				return start;
			}
			int mid = start + (end - start)/2;
            int next = Math.floorMod(mid + 1, input.length);
            int prev = Math.floorMod(mid - 1, input.length);
            if(input[mid] < input[prev] && input[mid] < input[next]) {
            	return mid;
            }
            else if(input[mid] <= input[end]) {
            	end = mid - 1;
            }
            else if(input[mid] >= input[start]) {
            	start = mid + 1;
            }
		}
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = new int[] {9,10,2,5,6,8};
		//Search 10, index 2
		System.out.println(findInCircularSortedArr(input,5));
	}

}
