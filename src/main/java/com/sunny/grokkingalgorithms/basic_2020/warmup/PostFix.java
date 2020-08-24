package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Stack;

public class PostFix {

	public static void evaluatePostFix(String s) {
		Stack<Integer> stack = new Stack<Integer>();
		for(int i = 0 ; i < s.length() ; i++) {
			char current = s.charAt(i);
			if(Character.isDigit(current)) {
				stack.push(Integer.parseInt(String.valueOf(current)));				
			}else {
				int x = stack.pop();
				int y = stack.pop();
				stack.push(x+y);
			}
		}
		System.out.println(stack.pop());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "34+5+";
        evaluatePostFix(s);
	}

}
