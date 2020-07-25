package com.sunny.grokkingalgorithms.basic_2020.warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Pair<T,U>{
	
	private T key;
	
	private U value;

	public Pair(T key, U value) {
		super();
		this.key = key;
		this.value = value;
	}

	public T getKey() {
		return key;
	}

	public void setKey(T key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pair [key=" + key + ", value=" + value + "]";
	}

	public U getValue() {
		return value;
	}

	public void setValue(U value) {
		this.value = value;
	}
		
}
public class MinimumSwaps {

	/*
	 * You are given an unordered array consisting of consecutive integers  [1, 2, 3, ..., n] without any duplicates. You are allowed to swap any two elements. You need to find the minimum number of swaps required to sort the array in ascending order.

For example, given the array  we perform the following steps:

i   arr                         swap (indices)
0   [7, 1, 3, 2, 4, 5, 6]   swap (0,3)
1   [2, 1, 3, 7, 4, 5, 6]   swap (0,1)
2   [1, 2, 3, 7, 4, 5, 6]   swap (3,4)
3   [1, 2, 3, 4, 7, 5, 6]   swap (4,5)
4   [1, 2, 3, 4, 5, 7, 6]   swap (5,6)
5   [1, 2, 3, 4, 5, 6, 7]
It took  swaps to sort the array.

Function Description

Complete the function minimumSwaps in the editor below. It must return an integer representing the minimum number of swaps to sort the array.

minimumSwaps has the following parameter(s):

arr: an unordered array of integers
Input Format

The first line contains an integer, , the size of .
The second line contains  space-separated integers .

Constraints

Output Format

Return the minimum number of swaps to sort the given array.

Sample Input 0

4
4 3 1 2
Sample Output 0

3
Explanation 0

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 1

5
2 3 4 1 5
Sample Output 1

3
Explanation 1

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.

Sample Input 2

7
1 3 5 2 4 6 7
Sample Output 2

3
Explanation 2

Given array 
After swapping  we get 
After swapping  we get 
After swapping  we get 
So, we need a minimum of  swaps to sort the array in ascending order.
	 */
	
	/*
	 * 4 3 1 2
	 * 
	 * 3 4 1 2
	 * 
	 * 3 1 2 4
	 */
	
	
	static int minimumSwaps(int[] arr) {
		int minSwaps = 0;
		List<Pair<Integer, Integer>> list = 
				new ArrayList<Pair<Integer, Integer>>();
		for(int i = 0 ; i < arr.length ; i++) {
			list.add(new Pair<Integer, Integer>(arr[i],i));			
		}
		Collections.sort(list,new Comparator<Pair<Integer, Integer>>() {

			@Override
			public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
				
				if(o1.getKey() > o2.getKey()) {
					return 1;					
				}
				if(o1.getKey() < o2.getKey()) {
					return -1;					
				}
				return 0;
			}
		});
		int cycleLength = 0;
		boolean[] visited = new boolean[arr.length];
		for(int i = 0; i < arr.length ; i++) {
			cycleLength = 0;
			int j = i;
			if(visited[j] || (j == list.get(j).getValue())) {
				continue;			
				
			}
			while(!visited[j]) {
				visited[j] = true;
				j = list.get(j).getValue();
				cycleLength++;				
			}
			if(cycleLength > 0) {
				minSwaps += (cycleLength - 1);	
			}
		}
		//System.out.println("MinimumSwaps.minimumSwaps()" + list);
		return minSwaps;
	}
	
	 // Complete the minimumSwaps function below.
    static int minimumSwapsAlt(int[] arr) {
    	int swapCount = 0;
    	boolean swapped = true;
    	while(swapped) {
    		swapped = false;
    		for(int j = 1 ; j < arr.length; j++) {
    			if(arr[j] < arr[j - 1]) {
    				int temp = arr[j];
    				arr[j] = arr[j-1];
    				arr[j-1] = temp;
    				++swapCount;
    				swapped = true;
    			}
    		}
    	}
    	System.out.println();
		
		  for(int i : arr) { System.out.print(i + " "); } System.out.println();
		 
    	return swapCount;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	int[] input = new int[] {3, 7, 6, 9, 1, 8, 10, 4, 2, 5};
    	System.out.println("MinimumSwaps.main() " + minimumSwaps(input));
    }
	
}
