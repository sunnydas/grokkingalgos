package com.sunny.grokkingalgorithms.basic_2020.warmup;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;



public class AlternatingCharacters {
	
	/*
	 * Alternating Characters
You are given a string containing characters and only. Your task is to change it into a string such that there are no
matching adjacent characters. To do this, you are allowed to delete zero or more characters in the string.
Your task is to find the minimum number of required deletions.
For example, given the string , remove an at positions and to make in deletions.
Function Description
Complete the alternatingCharacters function in the editor below. It must return an integer representing the minimum
number of deletions to make the alternating string.
alternatingCharacters has the following parameter(s):
s: a string
Input Format
The first line contains an integer , the number of queries.
The next lines each contain a string .
Constraints
Each string will consist only of characters
	 */

	 // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {
    	char prevChar = s.charAt(0);
    	int count = 0;
    	int localCount = 0;
    	for(int i = 1; i < s.length() ; i++) {
    		char current = s.charAt(i);
    		if((current != prevChar)) {
    			count += localCount;
    			localCount = 0;    			
    		}else{
    			++localCount;
    			if(i == (s.length() - 1)) {
    				count += localCount;
    			}
    		}
    		prevChar = current;
    	}
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);
            System.out.println();
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }

}
