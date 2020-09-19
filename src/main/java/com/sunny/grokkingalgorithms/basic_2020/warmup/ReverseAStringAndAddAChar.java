package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class ReverseAStringAndAddAChar {

	/*
	 * Write a function that will reverse string and add character to it.  
	 */
	
	public static String reverseAndAdd(String s,
			char toAdd) {
		char[] arr = s.toCharArray();
		int i  = 0;
		int j = arr.length - 1;
		while(i < j) {
			char temp = arr[j];
			arr[j] = arr[i];
			arr[i] = temp;
			i++;
			j--;
		}
		s = String.valueOf(arr) + toAdd;
		return s;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "abcdef";
        char toAdd = 'z';
        System.out.println(reverseAndAdd(s, toAdd));
	}

}
