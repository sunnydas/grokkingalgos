package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ArrayManipulation {
	
	/*
	 * Starting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros . Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
The largest value is  after all operations are performed.

Function Description

Complete the function arrayManipulation in the editor below. It must return an integer, the maximum value in the resulting array.

arrayManipulation has the following parameters:

n - the number of elements in your array
queries - a two dimensional array of queries where each queries[i] contains three integers, a, b, and k.
Input Format

The first line contains two space-separated integers  and , the size of the array and the number of operations.
Each of the next  lines contains three space-separated integers ,  and , the left index, right index and summand.

Constraints

Output Format

Return the integer maximum value in the finished array.

Sample Input

5 3
1 2 100
2 5 100
3 4 100
Sample Output

200
Explanation

After the first update list will be 100 100 0 0 0.
After the second update list will be 100 200 100 100 100.
After the third update list will be 100 200 200 200 100.
The required answer will be .
	 */
	

	/*
	 * 0 0 0       2 3 1 => 1 2 2
	 * 0 1 1
	 * 2 3 1
	 * 
	 * 
	 * 0 1 0 -1
	 * 2 1 -2 -1
	 * 2 3 1 .... 
	 */
	
	static long arrayManipulationAlt(int n, int[][] queries) {
		long[] input = new long[n + 2];
		for(int i = 0; i < queries.length ;i++) {
			int begin = queries[i][0] - 1;
			int end = queries[i][1] - 1;
			int k = queries[i][2];
			input[begin] += k;
			input[end + 1] -= k;
		}
		long max = 0;
		long cur = 0;
		for(int i = 0; i < n ; i++) {
			cur += input[i];
			max = Math.max(cur, max);
		}
		return max;
    }
	
	static long arrayManipulation(int n, int[][] queries) {
		long[] input = new long[n];
		for(int i = 0; i < queries.length ;i++) {
			int begin = queries[i][0] - 1;
			int end = queries[i][1] - 1;
			int k = queries[i][2];
			for(int j = begin; j <= end ; j++) {
				input[j] = input[j] + k;				
			}
		}
		long max = input[0];
		for(int i = 1; i < input.length ; i++) {
			if(input[i] > max) {
				max = input[i];				
			}
		}
		return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
      
        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        
        System.out.println(" result = " + result);

        scanner.close();
    }

}
