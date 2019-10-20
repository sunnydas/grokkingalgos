package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.ArrayList;
import java.util.List;

public class PossibleCombinations {

    /*
    a coding question about given a lowercase string 'ab',write a program to generate
    all possible lowercase and uppercase combination {'AB',‘Ab’,'aB' and 'ab'}
     */

    public static List<String> getCombinations(String input, int origLength){
        if(input.equals("")){
            return new ArrayList<>();
        }
        char current = input.charAt(0);
        char upper = Character.toUpperCase(current);
        char lower = Character.toLowerCase(current);
        List<String> totalCombs = new ArrayList<>();
        List<String> comb = getCombinations(input.substring(1),origLength);
        if(comb.isEmpty()){
            String upperComb = ""+upper;
            comb.add(upperComb);
            if(upperComb.length() == origLength){
                System.out.println(upperComb);
            }
            String lowerComb = ""+lower;
            comb.add(lowerComb);
            if(lowerComb.length() == origLength){
                System.out.println(lowerComb);
            }
        } else{
            for(String combination : comb){
                String upperComb = ""+upper + combination;
                totalCombs.add(upperComb);
                if(upperComb.length() == origLength){
                    System.out.println(upperComb);
                }
                String lowerComb = ""+lower + combination;
                totalCombs.add(lowerComb);
                if(lowerComb.length() == origLength){
                    System.out.println(lowerComb);
                }
            }
        }
        totalCombs.addAll(comb);
        return totalCombs;
    }


    public static List<String> getCombinations(String input){
        if(input.equals("")){
            return new ArrayList<>();
        }
        char current = input.charAt(0);
        char upper = Character.toUpperCase(current);
        char lower = Character.toLowerCase(current);
        List<String> totalCombinations = new ArrayList<>();
        List<String> combinations = getCombinations(input.substring(1));
        if(combinations.isEmpty()){
            combinations.add(""+upper);
            combinations.add(""+lower);
        }else{
            for(String combination : combinations){
                totalCombinations.add(upper + combination);
                totalCombinations.add(lower + combination);
            }
        }
        totalCombinations.addAll(combinations);
        return totalCombinations;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(getCombinations(input));
        input = "ab";
        System.out.println(getCombinations(input));
        System.out.println();
        input = "abc";
        System.out.println(getCombinations(input,input.length()));
        input = "ab";
        System.out.println(getCombinations(input,input.length()));
    }

}
