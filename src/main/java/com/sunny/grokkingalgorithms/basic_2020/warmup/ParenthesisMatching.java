package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

import com.sunny.grokkingalgorithms.boot2019.phleps.LinkedList;

public class ParenthesisMatching {

	public static boolean 
		isValid(String input) {
		boolean valid = true;
		if(input != null) {
			Stack<Character> stack = new Stack<Character>();	
			int i = 0;
			while(i < input.length()) {
				char current = input.charAt(i);
				if((current == '{') || (current == '(')
						|| (current == '[')) {
					stack.push(current);					
				}
				else if((current == '}' 
						&& stack.peek() == '{')
						||
						(current == ')' &&
						stack.peek() == '(')
						||
						(current == ']' &&
						stack.peek() == '[')) {
					stack.pop();					
				}
				i++;
			}
			if(!stack.isEmpty()) {
				valid = false;				
			}
		}
		return valid;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "{{{}}}";
		System.out.println(isValid(input));
		input = "{]{}";
		System.out.println(isValid(input));
		input = "{}()[](((())))";
		System.out.println(isValid(input));
	}

}
