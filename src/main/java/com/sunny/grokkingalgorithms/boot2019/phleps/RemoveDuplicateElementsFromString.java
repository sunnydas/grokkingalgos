package com.sunny.grokkingalgorithms.boot2019.phleps;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateElementsFromString {


    public static char[] removeDuplicates(char[] input){
        Set<Character> trackerSet = new HashSet<>();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < input.length ; i++){
            if(!trackerSet.contains(input[i])){
                stringBuilder.append(input[i]);
                trackerSet.add(input[i]);
            }
        }
        return stringBuilder.toString().toCharArray();
    }

    public static void main(String[] args) {
        char str[] = "geeksforgeeks".toCharArray();
        System.out.println(String.valueOf(removeDuplicates(str)));
    }
}
