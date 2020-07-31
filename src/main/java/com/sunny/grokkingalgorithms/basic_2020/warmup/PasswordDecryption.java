package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class PasswordDecryption {
	
	/*
	 * 
	 */
	 public static String decryptPassword(String s) {
		    // Write your code here
		 int i = 0;
		 StringBuilder decrypted = new StringBuilder();
		 char[] original = s.toCharArray();
		 while(i < original.length) {
			 char current = original[i];
			 if(Character.isDigit(current)) {
				 int index = findZero(original,i);
				 if(index > 0) {
					 original[index] = current;
					 original[i] = '-';
				 }
			 }else if(Character.isUpperCase(current)
					 && (i+1 < original.length &&
							 Character.
							 isLowerCase(original[i+1]))) {
				 char temp = original[i+1];
				 original[i+1] = original[i];
				 original[i] = temp;
			 }
			 i++;			 
		 }
		 for(int j = 0 ; j < original.length;j++) {
			 char cur = original[j];
			 if(cur != '-' && cur != '*') {
				 decrypted.append(cur);				 
			 }
		 }
		 return decrypted.toString();
	 }
	 
	 public static int findZero(char[] dec, int start) {
		 int index = -1;
		 for(int i = start ; i < dec.length ; i++) {
			 if(dec[i] == '0') {
				 index = i;
				 break;
			 }
		 }
		 return index;
	 }
	 
	 
	 public static int calculatedLength(String s) {
		 int len = 0;
		 for(int i = 0 ; i < s.length() ; i++) {
			 int cur = s.charAt(i);
			 if(cur != '*') {
				 len++;				 
			 }
		 }
		 return len;
	 }
	 
	 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "51Pa*0Lp*0e";
		System.out.println(decryptPassword(input));
	}

}
