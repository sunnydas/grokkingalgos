package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static void permute(String s,String ans) {
		if(s.length() == 0) {
			System.out.print(ans + " ");			
		}
		for(int i = 0; i < s.length() ; i++) {
			char cur = s.charAt(i);
			String rest = s.substring(0, i) + s.substring(i+1);
			permute(rest,ans+cur);
		}
	}
	
	public static List<String> permute(String s) {
		if(s.length() <= 0) {
			List<String> empty = new ArrayList<String>();
			empty.add(" ");
			return empty;
		}
	    char current = s.charAt(0);
	    String remaining = s.substring(1);
	    List<String> sub = permute(remaining);
	    List<String> overall = new ArrayList<String>();
	    for(String str : sub) {
	    	//System.out.println(str);
	    	for(int i =  0; i < str.length() ; i++) {
	    		StringBuilder builder = new StringBuilder(str);
	    		builder.insert(i, current);
	    		overall.add(builder.toString());
	    	}
	    }
	    
	    overall.addAll(sub);
	    return overall;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String s = "abc";
        /*
         * abc
         * a  bc 
         *      b  
         *          c
         *    
         *                abcd
         *                dbacd
         *                bca
         *             
         */
        System.out.println(permute(s));
        System.out.println();
        permute(s,"");
        System.out.println();
	}

}
