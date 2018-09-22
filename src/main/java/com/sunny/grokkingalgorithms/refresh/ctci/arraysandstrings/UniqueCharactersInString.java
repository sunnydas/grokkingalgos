package com.sunny.grokkingalgorithms.refresh.ctci.arraysandstrings;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharactersInString {

    /*
    Determine if all characters in a string are unique.
     */

    /**
     *
     * @param input
     * @return
     */
    public static boolean areCharactersUnique(String input){
        //Uses Set
        boolean unique = true;
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < input.length() ; i++){
            final char o = input.charAt(i);
            if(set.contains(o)){
                unique = false;
                break;
            }
            set.add(o);
        }
        return unique;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String input1 = "abcdef";
        String input2 = "zxcvbjhglzlo";
        System.out.println(areCharactersUnique(input1));
        System.out.println(areCharactersUnique(input2));
    }
}
