package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

public class DuplicateParenthesis {

	
	public static boolean duplicateParenthesis(String s) {
		Stack<Character> stack = new Stack<Character>();
		int i = 0; 
		while(i < s.length()) {
			char current = s.charAt(i);
			if(current != ')') {
				stack.push(current);
			}else {
				if(stack.peek() == '(') {
					return true;
				}
				while(stack.peek() != '(') {
					stack.pop();					
				}
				stack.pop();
			}
			i++;			
		}
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "((x+y))";
        System.out.println(duplicateParenthesis(s));
        s = "((x+y)+(y+z))";
        System.out.println(duplicateParenthesis(s));
	}

}
