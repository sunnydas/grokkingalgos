package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.Scanner;

public class ReverseWordsHackerRank {

    public static String reverseAndCapitalizeFirstWord(String line){
        StringBuilder reversed = new StringBuilder();
        String[] splitted = line.split("\\s+");
        String[] spaces = line.split("\\w+");
        int j = 0;
        for(int i = 0 ; i < splitted.length ; i++){
            String revWord = String.valueOf(reverse(splitted[i].toCharArray()));
            if(j < spaces.length){
                reversed.append(spaces[j]);
                j++;
            }
            reversed.append(revWord);
        }
        return reversed.toString();
    }

    public static char[] reverse(char[] input){
        int i = 0;
        int j = input.length - 1;
        while(i < j){
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            input[0] = Character.toUpperCase(input[0]);
            i++;
            j--;
        }
        return input;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0 ; i < num ; i++){
            String line = scanner.nextLine();
            System.out.println(reverseAndCapitalizeFirstWord(line));
        }
    }

}
