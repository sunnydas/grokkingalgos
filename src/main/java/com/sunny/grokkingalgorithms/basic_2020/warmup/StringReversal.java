package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class StringReversal {

	public static String reverse(String s) {
		char[] reversed = s.toCharArray();
		int i = 0;
		int j = reversed.length - 1;
		while(i < j) {
			char temp = reversed[i];
			reversed[i] = reversed[j];
			reversed[j] = temp;
			i++;
			j--;
		}
		return String.valueOf(reversed);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "abcd";
        System.out.println(reverse(s));
	}

}
