package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class TripleSum {
	
	/*
	 * Given  arrays  of different sizes, find the number of distinct triplets  where  is an element of , written as , , and , satisfying the criteria: .

For example, given  and , we find four distinct triplets: .

Function Description

Complete the triplets function in the editor below. It must return the number of distinct triplets that can be formed from the given arrays.

triplets has the following parameter(s):

a, b, c: three arrays of integers .
Input Format

The first line contains  integers , the sizes of the three arrays.
The next  lines contain space-separated integers numbering  respectively.

Constraints



Output Format

Print an integer representing the number of distinct triplets.

Sample Input 0

3 2 3
1 3 5
2 3
1 2 3
Sample Output 0

8 
Explanation 0

The special triplets are  .

Sample Input 1

3 3 3
1 4 5
2 3 3
1 2 3
Sample Output 1

5 
Explanation 1

The special triplets are 

Sample Input 2

4 3 4
1 3 5 7
5 7 9
7 9 11 13
Sample Output 2

12
Explanation 2

The special triplets are 
	 */

	 // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	long tripletCount = 0;
    	Set<String> tracker = new LinkedHashSet<String>();
    	for(int i = 0 ; i < a.length ; i++) {
    		for(int j = 0 ; j < b.length ; j++) {
    			for(int k = 0 ; k < c.length ; k++) {
    				String key = ""+a[i]
							+b[j]+c[k];
					if((a[i] <= b[j]) 
    						&& (b[j] >= c[k]) && (!tracker.contains(key))) {
    					//System.out.println(i + " " + j + " " + k);
    					//System.out.println(a[i] + " " + b[j] + " " + c[k]);
    					tripletCount++;    		
    					tracker.add(key);
    				}
    			}
    		}
    	}
    	return tripletCount;
    }
	
    private static final Scanner scanner = new Scanner(System.in);

    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        System.out.println(ans);
	}

}
