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


    public static boolean areCharactersUniqueWithoutUsingExtraSpace(String input){
        boolean unique = true;
        for(int i = 0 ; i < input.length() ; i++){
            char cur = input.charAt(i);
            for(int j = i+1 ; j < input.length() ; j++){
                if(cur == input.charAt(j)){
                    unique = false;
                    break;
                }
            }
            if(!unique){
                break;
            }
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
        System.out.println(areCharactersUniqueWithoutUsingExtraSpace(input1));
        System.out.println(areCharactersUniqueWithoutUsingExtraSpace(input2));
    }
}
