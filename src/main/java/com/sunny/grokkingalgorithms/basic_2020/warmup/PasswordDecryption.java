package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class PasswordDecryption {
	
	/*
	 * 
	 */
	 public static String decryptPassword(String s) {
		    // Write your code here
		 int i = 0;
		 char[] decrypted = new char[calculatedLength(s)];
		 int j  = 0;
		 while(i < s.length()) {
			char current = s.charAt(i);
			if(Character.isDigit(current)) {
				int index = findZero(decrypted);
				decrypted[index] = current;
			}
			else if(Character.isUpperCase(current) && 
					(i+1 < s.length() && 
							Character.isLowerCase(s.charAt(i+1)))) {
				decrypted[j] = s.charAt(i+1);
				decrypted[j+1] = current;
			}else {
			    decrypted[j] = current;	
			}			
			j++;
			i++;
		 }
		 return String.valueOf(decrypted);
	 }
	 
	 public static int findZero(char[] dec) {
		 int index = -1;
		 for(int i = 0 ; i < dec.length ; i++) {
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
