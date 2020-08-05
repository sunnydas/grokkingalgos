package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountTriplets {
	
	/*
	 * You are given an array and you need to find number of tripets of indices  such that the elements at those indices are in geometric progression for a given common ratio  and .

For example, . If , we have  and  at indices  and .

Function Description

Complete the countTriplets function in the editor below. It should return the number of triplets forming a geometric progression for a given  as an integer.

countTriplets has the following parameter(s):

arr: an array of integers
r: an integer, the common ratio
Input Format

The first line contains two space-separated integers  and , the size of  and the common ratio.
The next line contains  space-seperated integers .

Constraints

Output Format

Return the count of triplets that form a geometric progression.

Sample Input 0

4 2
1 2 2 4
Sample Output 0

2
Explanation 0

There are  triplets in satisfying our criteria, whose indices are  and 

Sample Input 1

6 3
1 3 9 9 27 81
Sample Output 1

6
Explanation 1

The triplets satisfying are index , , , ,  and .

Sample Input 2

5 5
1 5 5 25 125
Sample Output 2

4
Explanation 2

The triplets satisfying are index , , , .


	 */

	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	int count = 0;
    	/*
    	 * 
    	 */
    	Map<Long,List<Integer>> tracker = new HashMap();
    	for(int i = 0 ; i < arr.size() ; i++) {
    		long current = arr.get(i);
    		if(tracker.containsKey(current)) {
    			List<Integer> list = tracker.get(current);
    			list.add(i);
    		}else {
    			List<Integer> list = new ArrayList<Integer>();
    			list.add(i);
    			tracker.put(current, list);
    		}    		
    	}
    	//System.out.println(tracker);
    	for(int i = 0; i < arr.size() ; i++) {
    		for(int j = i+1; j < arr.size() ; j++) {
    			long a = arr.get(i);
    			long b = arr.get(j);
    			if(b/a == r) {
    				long key = b*r;
    				//System.out.println(key);
					if(tracker.containsKey(key)) {
						//System.out.println(i + " " + j + " " + tracker.get(key));
						List<Integer> list = tracker.get(key);
						for(int k : list) {
							if(k > j) {
								count++;								
							}
						}    					
    				}
    			}
    		}
    	}
    	return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = 
        		new BufferedReader(new InputStreamReader(System.in));
       

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(Collectors.toList());

        long ans = countTriplets(arr, r);
        
        System.out.println(ans);
    }

}
