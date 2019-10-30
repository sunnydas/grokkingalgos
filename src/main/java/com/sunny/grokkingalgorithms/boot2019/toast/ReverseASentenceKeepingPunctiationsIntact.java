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

    public static String reverseArray(String input){
        char[] inputArr = input.toCharArray();
        for(int i = 0 ; i < inputArr.length ;){
            if(inputArr[i] != ' ') {
                int end = findEndOfWord(inputArr, i);
                reverseWord(inputArr,i,end);
                i = i + (end - i) + 1;
            } else{
                i++;
            }
        }
        //System.out.println("###" + String.valueOf(inputArr));
        System.out.println();
        reverseWord(inputArr,0,inputArr.length - 1);
        return String.valueOf(inputArr);
    }

    public static void reverseWord(char[] input,int start,int end){
        int i = start;
        int j = end;
        while(i < j){
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
    }

    public static int findEndOfWord(char[] input,int startIndex){
        int index = startIndex;
        for(int i = startIndex+1; i < input.length ; i++){
            if(input[i] == ' '){
                index = i - 1;
                break;
            } else if(i == (input.length - 1)){
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String str = "this new world ";
        System.out.println(reverse(str));
        str = "!Hello,                 world!                          ";
        System.out.println(reverseKeepingPuncIntact(str));
        str = "Hello world this     is sunny";
        System.out.println(reverseArray(str));
    }

}
