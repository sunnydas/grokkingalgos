package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {

    public static List<String> permutations(String input){
        if(input.equals("")){
            List<String> permutations = new ArrayList<>();
            permutations.add(" ");
            return permutations;
        }
        char cur = input.charAt(0);
        input = input.substring(1);
        List<String> childPermutations = permutations(input);
        List<String> allPermutations = new ArrayList<>();
        for(String str : childPermutations){
            for(int i = 0 ; i < str.length() ; i++){
                StringBuilder stringBuilder = new StringBuilder(str);
                stringBuilder.insert(i,cur);
                allPermutations.add(stringBuilder.toString());
            }
        }

        allPermutations.addAll(childPermutations);
        return allPermutations;
    }

    public static void main(String[] args) {
        String input = "abcd";
        List<String> permutations = permutations(input);
        System.out.println(permutations);
        input = "abc";
        permutations = permutations(input);
        System.out.println(permutations);
        input = "ab";
        permutations = permutations(input);
        System.out.println(permutations);
    }
}
