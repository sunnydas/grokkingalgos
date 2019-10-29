package com.sunny.grokkingalgorithms.boot2019.toast;

public class ReverseASentenceKeepingPunctiationsIntact {

    public static String reverse(String sentence){
        String[] splitted = sentence.split(" ");
        StringBuilder sentenceBuilder = new StringBuilder();
        for(int i = splitted.length - 1; i >= 0 ; i--){
            sentenceBuilder.append(splitted[i]);
            sentenceBuilder.append(" ");
        }
        return sentenceBuilder.toString();
    }

    public static void main(String[] args) {
        String str = "this new world ";
        System.out.println(reverse(str));
    }

}
