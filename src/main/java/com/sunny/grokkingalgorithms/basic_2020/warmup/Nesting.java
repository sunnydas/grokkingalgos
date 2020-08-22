package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

public class Nesting {
	
	/*
	 * A string S consisting of N characters is called properly nested if:

S is empty;
S has the form "(U)" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..1,000,000];
string S consists only of the characters "(" and/or ")".
	 */

	public int solution(String s) {
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		while(i < s.length()) {
			Character current = s.charAt(i);
	        if(current == '(') {
	        	stack.add(current);	        	
	        }else{
	        	if(!stack.isEmpty() 
	        			&& stack.peek() == '(') {
	        		stack.pop();	        		
	        	}else {
	        		return 0;
	        	}
	        }
			i++;			
		}
		if(stack.isEmpty()) {
			return 1;			
		}
		return 0;		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
