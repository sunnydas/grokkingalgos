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
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyQueries {
	
	/*
	 * You are given  queries. Each query is of the form two integers described below:
-  : Insert x in your data structure.
-  : Delete one occurence of y from your data structure, if present.
-  : Check if any integer is present whose frequency is exactly . If yes, print 1 else 0.

The queries are given in the form of a 2-D array  of size  where  contains the operation, and  contains the data element. For example, you are given array . The results of each operation are:

Operation   Array   Output
(1,1)       [1]
(2,2)       [1]
(3,2)                   0
(1,1)       [1,1]
(1,1)       [1,1,1]
(2,1)       [1,1]
(3,2)                   1
Return an array with the output: .

Function Description

Complete the freqQuery function in the editor below. It must return an array of integers where each element is a  if there is at least one element value with the queried number of occurrences in the current array, or 0 if there is not.

freqQuery has the following parameter(s):

queries: a 2-d array of integers
Input Format

The first line contains of an integer , the number of queries.
Each of the next  lines contains two integers denoting the 2-d array .

Constraints

All 
Output Format

Return an integer array consisting of all the outputs of queries of type .

Sample Input 0

8
1 5
1 6
3 2
1 10
1 10
1 6
2 5
3 2
Sample Output 0

0
1
Explanation 0

For the first query of type , there is no integer whose frequency is  (). So answer is .
For the second query of type , there are two integers in  whose frequency is  (integers =  and ). So, the answer is .

Sample Input 1

4
3 4
2 1003
1 16
3 1
Sample Output 1

0
1
Explanation 1

For the first query of type , there is no integer of frequency . The answer is . For the second query of type , there is one integer,  of frequency  so the answer is .

Sample Input 2

10
1 3
2 3
3 2
1 4
1 5
1 5
1 4
3 2
2 4
3 2
Sample Output 2

0
1
1
Explanation 2

When the first output query is run, the array is empty.
 We insert two 's and two 's before the second output query,  
 so there are two instances of elements occurring twice.
  We delete a  and run the same query.
   Now only the instances of  satisfy the query.


	 */

	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
    	Map<Integer,Integer> freqMap = new HashMap<Integer, Integer>();
    	Set<Integer> countTracker = new LinkedHashSet<Integer>();
    	List<Integer> result = new ArrayList<Integer>();
    	for(int i = 0 ; i < queries.size() ; i++) {
    		int queryId = queries.get(i).get(0);
            int value = queries.get(i).get(1);
            if(queryId == 1) {
            	if(freqMap.containsKey(value)) {
            		Integer count = freqMap.get(value);
					freqMap.put(value, count + 1);
            		if(countTracker.contains(count - 1)) {
            			countTracker.remove(count - 1);            			
            		}
            		countTracker.add(count+1);
            	}else {
            		freqMap.put(value, 1);
            		countTracker.add(1);
            	}
            }
            else if(queryId == 2) {
            	if(freqMap.containsKey(value)) {
            		Integer count = freqMap.get(value);
					freqMap.put(value, count - 1);
            		if(countTracker.contains(count)) {
            			countTracker.remove(count);            			
            		}
            		countTracker.add(count - 1);
            	}else {
            		freqMap.put(value, 1);
            		countTracker.add(1);
            	}
            }else if(queryId == 3 
            		&& countTracker.contains(value)){
            	result.add(1);            	
            }else if(queryId == 3 
            		&& !countTracker.contains(value)) {
            	result.add(0);            	
            }
    	}
    	System.out.println(freqMap);
    	System.out.println(countTracker);
    	return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

       System.out.println(ans);
        
    }



}
