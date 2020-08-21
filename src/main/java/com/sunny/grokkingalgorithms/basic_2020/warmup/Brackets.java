package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

public class Brackets {
	
	/*
	 * A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

S is empty;
S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
S has the form "VW" where V and W are properly nested strings.
For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

class Solution { public int solution(String S); }

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [0..200,000];
string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".
	 */
	
	public static int solution(String S) {
		Stack<Character> stack = new Stack<Character>();
		int i = 0;
		if(S.isEmpty()) {
			return 1;			
		}
		while(i < S.length()) {
			char current = S.charAt(i);
			if(current == '(' || current == '{' || current == '[') {
				stack.add(current);				
			}else if(!(stack.isEmpty()) && ((current == ')' && stack.peek() == '(')
					|| (current == '}' && stack.peek() == '{'
					|| (current == ']' && stack.peek() == '[')))) {
				stack.pop();				
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
        String s = "{[()()]}";
        System.out.println(solution(s));    
        s = "([)()]";
        System.out.println(solution(s));
	}

}
