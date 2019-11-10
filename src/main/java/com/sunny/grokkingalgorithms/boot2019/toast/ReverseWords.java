package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.Scanner;

public class ReverseWords {

    /*
    https://www.hackerrank.com/contests/codejam/challenges/reverse-words/problem

    Input
The first line of input would be the number of test cases followed by each string in a line.

Sample input
1
Hello World
Output
Output should be the string with each word reversed and first letter of each reversed word capitalized. Each output string should be printed to a new line.

Sample output
OlleH DlroW
     */

    public static String reverseAndCapitalizeFirstWord(String line){
        String[] splitted = line.split("\\s+");
        String [] spaces = line.split("\\w+");
        StringBuilder reversed = new StringBuilder();
        int j = 0;
        for(int i = splitted.length - 1; i >= 0;i--){
            String reverseAndCapatilizedWord =
                    String.valueOf(reverse(splitted[i].toCharArray()));
            if(j < spaces.length) {
                reversed.append(spaces[j]);
            }
            reversed.append(reverseAndCapatilizedWord);
            j++;
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
