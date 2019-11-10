package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.Scanner;

public class ReverseSentencesMyWay {

    public static String reverseSentence(String line){
        StringBuilder reversed = new StringBuilder();
        String[] splitted = line.split("\\s+");
        int i = splitted.length - 1;
        int j = 0;
        int k  = 0;
        while(j < line.length()){
            if(!Character.isAlphabetic(line.charAt(j))){
                reversed.append(line.charAt(j));
                j++;
            } else{
                reversed.append(splitted[i]);
                i--;
                j = j + splitted[k].length();
                k++;
            }
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(reverseSentence(line));
    }

}
