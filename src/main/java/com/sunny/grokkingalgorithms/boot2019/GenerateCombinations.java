package com.sunny.grokkingalgorithms.boot2019;

import java.util.ArrayList;
import java.util.List;

public class GenerateCombinations {


    public static List<List<Integer>> generateCombinations(List<Integer> input){
        if(input.isEmpty()){
            List<Integer> emptyList = new ArrayList<>();
            List<List<Integer>> combination = new ArrayList<>();
            combination.add(emptyList);
            return combination;
        }
        int cur = input.remove(0);
        List<List<Integer>> subList = generateCombinations(input);
        List<List<Integer>> combination = new ArrayList<>();
        if(subList.size() == 1){
            List<Integer> curList = new ArrayList<>();
            curList.add(cur);
            combination.add(curList);
        }else{
            for(List<Integer> sub : subList){
                List<Integer> mod = new ArrayList<>();
                mod.addAll(sub);
                mod.add(cur);
                combination.add(mod);
            }
        }
        combination.addAll(subList);
        return combination;
    }

    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        System.out.println(generateCombinations(input));
        input = new ArrayList<>();
        input.add(1);
        input.add(2);
        input.add(3);
        input.add(4);
        System.out.println(generateCombinations(input));
    }

}
