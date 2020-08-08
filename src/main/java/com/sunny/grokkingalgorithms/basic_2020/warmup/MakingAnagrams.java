package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
public class MakingAnagrams {
	
	/*
	 * Alice is taking a cryptography class and finding anagrams to be very useful. We consider two strings to be anagrams of each other if the first string's letters can be rearranged to form the second string. In other words, both strings must contain the same exact letters in the same exact frequency For example, bacdc and dcbac are anagrams, but bacdc and dcbad are not.

Alice decides on an encryption scheme involving two large strings where encryption is dependent on the minimum number of character deletions required to make the two strings anagrams. Can you help her find this number?

Given two strings,  and , that may or may not be of the same length, determine the minimum number of character deletions required to make  and  anagrams. Any characters can be deleted from either of the strings.

For example, if  and , we can delete  from string  and  from string  so that both remaining strings are  and  which are anagrams.

Function Description

Complete the makeAnagram function in the editor below. It must return an integer representing the minimum total characters that must be deleted to make the strings anagrams.

makeAnagram has the following parameter(s):

a: a string
b: a string
Input Format

The first line contains a single string, .
The second line contains a single string, .

Constraints

The strings  and  consist of lowercase English alphabetic letters ascii[a-z].
Output Format

Print a single integer denoting the number of characters you must delete to make the two strings anagrams of each other.

Sample Input

cde
abc
Sample Output

4
Explanation

We delete the following characters from our two strings to turn them into anagrams of each other:

Remove d and e from cde to get c.
Remove a and b from abc to get c.
We must delete  characters to make both strings anagrams, so we print  on a new line.
	 */

	// Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	int count = 0;
    	Map<Character,Integer> aTracker = new HashMap();
    	for(int i = 0 ; i < a.length() ;i++) {
    		char val = a.charAt(i);
			if(aTracker.containsKey(val)) {
				aTracker.put(val, aTracker.get(val) + 1);    			
    		}else {
    			aTracker.put(val, 1);
    		}
    	}
    	int commonCount = 0;
    	for(int i = 0; i < b.length() ; i++) {
    		char val = b.charAt(i);
    		Integer localCount = aTracker.get(val);
			if(aTracker.containsKey(val) 
    				&& localCount > 0) {
    			commonCount++;
    			aTracker.put(val, localCount - 1);
    		}
    	}
    	count = (a.length()  - commonCount) +  (b.length() - commonCount);
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        //bufferedWriter.write(String.valueOf(res));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        System.out.println(res);
        scanner.close();
    }

}
