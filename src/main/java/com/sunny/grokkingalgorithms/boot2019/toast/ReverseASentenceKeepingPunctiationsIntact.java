package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.regex.Pattern;

public class ReverseASentenceKeepingPunctiationsIntact {

    public static String reverseKeepingPuncIntact(String sentence){
        String[] splitted = sentence.split("[\\p{Punct}\\s]+");
        StringBuilder sentenceBuilder = new StringBuilder();
        int j  = 0;
        for(int i = splitted.length - 1; i >= 0 ; i--){
            sentenceBuilder.append(splitted[i]);
            sentenceBuilder.append(" ");
        }
        return sentenceBuilder.toString();
    }

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
        str = "!Hello,world!";
        System.out.println(reverseKeepingPuncIntact(str));
    }

}
