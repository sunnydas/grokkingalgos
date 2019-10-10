package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.Arrays;

public class AnagramGrouping {

    /*
    Given a sequence of words, print all anagrams together | Set 1
Given an array of words, print all anagrams together. For example, if the given array is {“cat”, “dog”, “tac”,
“god”,
 “act”}, then output may be “cat tac act dog god”.
     */

    public static String[] groupAnagramsUsingSort(String[] input){
        for(int i = 0 ; i < input.length; i++){
            int k = i + 1;
            for(int j = k ; j < input.length;j++){
                if(areSortedEqual(input[i],input[j])){
                    String temp = input[k];
                    input[k] = input[j];
                    input[j] = temp;
                    k++;
                }
            }
        }
        return input;
    }

    public static boolean areSortedEqual(String s1,String s2){
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        Arrays.sort(s1c);
        Arrays.sort(s2c);
        return  Arrays.equals(s1c,s2c);
    }

    public static void main(String[] args) {
        String[] animals = new String[]{"cat", "dog", "tac", "god", "act","doggo","ooggd","santorio","ogd"};
        System.out.println(Arrays.asList(groupAnagramsUsingSort(animals)));
    }

}
