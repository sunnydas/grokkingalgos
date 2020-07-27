package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class PowerSum {
	
	/*
	 *Find the number of ways that a given integer, , can be expressed as the sum of the  powers of unique, natural numbers.

For example, if  and , we have to find all combinations of unique squares adding up to . The only solution is .

Function Description

Complete the powerSum function in the editor below. It should return an integer that represents the number of possible combinations.

powerSum has the following parameter(s):

X: the integer to sum to
N: the integer power to raise numbers to
Input Format

The first line contains an integer .
The second line contains an integer .

Constraints

Output Format

Output a single integer, the number of possible combinations caclulated.

Sample Input 0

10
2
Sample Output 0

1
Explanation 0

If  and , we need to find the number of ways that  can be represented as the sum of squares of unique numbers.


This is the only way in which  can be expressed as the sum of unique squares.

Sample Input 1

100
2
Sample Output 1

3
Explanation 1


Sample Input 2

100
3
Sample Output 2

1
Explanation 2

 can be expressed as the sum of the cubes of .
. There is no other way to express  as the sum of cubes. 
	 */

	// Complete the powerSum function below.
    static int powerSum(int X, int N) {
    	Set<Integer> considered = new LinkedHashSet<Integer>();
    	return powerSumRecursive(X, N, 0,considered,X);
    }
	
    static int powerSumRecursive(int x,int n,int curSum,
    		Set<Integer> considered,
    		int rest) {
    	if(curSum == x) {
    		//System.out.println(considered);
    		//System.out.println(curSum);
    		return 1;    		
    	}else if(curSum > x) {
    		return 0;    		
    	}
    	int totalCount = 0;
    	for(int i = 1; i <= rest; i++) {
    		if(!considered.contains(i)) {
    			int curValue = (int) Math.pow(i,n);
    			considered.add(i);
	    		totalCount += powerSumRecursive(x, n, 
	    				curSum + curValue,clone(considered),x - curValue);
    		}
    	}
    	return totalCount;
    }
    
    
    static Set clone(Set input) {
    	Set cloned = new LinkedHashSet<>();
    	Iterator iterator = input.iterator();
    	while(iterator.hasNext()) {
    		cloned.add(iterator.next());    		
    	}
    	return cloned;
    }
	
    private static final Scanner scanner = new Scanner(System.in);

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int X = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int N = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int result = powerSum(X, N);
        
        System.out.println(result);
	}

}
