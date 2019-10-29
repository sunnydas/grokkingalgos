package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.regex.Pattern;

public class ReverseASentenceKeepingPunctiationsIntact {

    public static String reverseKeepingPuncIntact(String sentence){
       char[] sentenceArr = sentence.toCharArray();
       int i = 0;
       int j = sentence.length() - 1;
       while(i < j){
           if(!Character.isAlphabetic(sentenceArr[i])){
               i++;
           }
           else if(!Character.isAlphabetic(sentenceArr[j])){
               j--;
           }else{
               char temp = sentenceArr[i];
               sentenceArr[i] = sentenceArr[j];
               sentenceArr[j] = temp;
               i++;
               j--;
           }
       }
       return String.valueOf(sentenceArr);
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
        str = "!Hello,                 world!                          ";
        System.out.println(reverseKeepingPuncIntact(str));
    }

}
