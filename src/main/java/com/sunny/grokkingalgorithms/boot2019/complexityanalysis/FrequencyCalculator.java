package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class FrequencyCalculator {


    public static void calculateFrequency(String s){
        int[] frequencyCalculator = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) != ' ') {
                int index = s.charAt(i) - 'a';
                frequencyCalculator[index]++;
            }
        }
        for(int i = 0 ; i < s.length(); i++){
            if(s.charAt(i) != ' ') {
                int index = s.charAt(i) - 'a';
                System.out.println("char = " + s.charAt(i) + " frequency = " + frequencyCalculator[index]);
            }
        }
    }


    public static void main(String[] args) {
        String sentence = "lone fox dancing under the cedars of landour";
        calculateFrequency(sentence);
    }
}
