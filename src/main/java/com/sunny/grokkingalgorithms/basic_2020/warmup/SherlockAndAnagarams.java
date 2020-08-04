package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SherlockAndAnagarams {

	/*
	 * Two strings are anagrams of each other if the letters of one string can be rearranged to form the other string. Given a string, find the number of pairs of substrings of the string that are anagrams of each other.

For example , the list of all anagrammatic pairs is  at positions  respectively.

Function Description

Complete the function sherlockAndAnagrams in the editor below. It must return an integer that represents the number of anagrammatic pairs of substrings in .

sherlockAndAnagrams has the following parameter(s):

s: a string .
Input Format

The first line contains an integer , the number of queries.
Each of the next  lines contains a string  to analyze.

Constraints



String  contains only lowercase letters  ascii[a-z].

Output Format

For each query, return the number of unordered anagrammatic pairs.

Sample Input 0

2
abba
abcd
Sample Output 0

4
0
Explanation 0

The list of all anagrammatic pairs is  and  at positions  and  respectively.

No anagrammatic pairs exist in the second query as no character repeats.

Sample Input 1

2
ifailuhkqq
kkkk
Sample Output 1

3
10
Explanation 1

For the first query, we have anagram pairs  and  at positions  and  respectively.

For the second query:
There are 6 anagrams of the form  at positions  and .
There are 3 anagrams of the form  at positions  and .
There is 1 anagram of the form  at position .

Sample Input 2

1
cdcd
Sample Output 2

5
Explanation 2

There are two anagrammatic pairs of length :  and .
There are three anagrammatic pairs of length :  at positions  respectively.
	 */
	
	/*
	 * abc 
	 * 
	 * a  
	 *    b
	 *      c
	 *    abc  cba
	 *    
	 *         a b b a 
	 *         
	 *         a 
	 *            b
	 *               b
	 *                  a
	 *                  
	 *                 a
	 *               ba, ab
	 *            aba, baa ,aab, aba 
	 *            
	 *            abba 
	 *            a 
	 *              b
	 *                 b 
	 *                    a
	 *                 a   
	 *               ba,a
	 *             bba,ba,ba,a 
	 *             
	 *             a 
	 *                b
	 *                
	 *                  
	 */
	
	static void findAnagramicSubstrings(String s,
			List<String> anagrams){
		if(s.length() <= 0) {
			return;
		}
		char current = s.charAt(0);
		s = s.substring(1);
		findAnagramicSubstrings(s, anagrams);
		if(anagrams.isEmpty()) {
			anagrams.add(""+current);
			anagrams.add("");
		} else {
			Set<String> curList = new LinkedHashSet<String>();
			for(String anagram : anagrams) {
				curList.add(current + anagram);	
				//curList.add(anagram + current);
			}
			anagrams.addAll(curList);
		}
	}
	
	 // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	int count = 0;
    	List<String> anagrams = new ArrayList<String>();
    	findAnagramicSubstrings(s,anagrams);
    	Map<String,Integer> tracker = new HashMap<String,Integer>();
    	Iterator<String> iterator = anagrams.iterator();
    	while(iterator.hasNext()) {
    		String current = iterator.next();
    		if(current != "" 
    				&& current.length() 
    				< s.length()) {    			
	    			char[] cs = current.toCharArray();
	    			Arrays.sort(cs);
	    			String valueOf = String.valueOf(cs);
					if(tracker.containsKey(valueOf)) {
	    				int val = tracker.get(valueOf);
	    				tracker.put(valueOf, val+1);
	    			}else {
	    				tracker.put(valueOf,1);
	    			}
    			}
    		}
    	Iterator<Map.Entry<String,Integer>> iterator2 = tracker.
    			entrySet().
    			iterator();
    	System.out.println(tracker);
    	while(iterator2.hasNext()) {
    		Map.Entry<String, Integer> entry = iterator2.next();
    		if(entry.getValue() >= 2) {
    			count++;    			
    		}
    	}
    	return count;
    }
	
    private static final Scanner scanner = new Scanner(System.in);
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            System.out.println(result);
            //Set<String> anagrams = new LinkedHashSet<String>();
            //findAnagramicSubstrings(s, anagrams);
            //System.out.println(anagrams);
        }

        scanner.close();
	}

}
