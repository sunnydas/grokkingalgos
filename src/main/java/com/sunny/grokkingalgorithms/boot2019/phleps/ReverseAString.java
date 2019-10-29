package com.sunny.grokkingalgorithms.boot2019.phleps;

public class ReverseAString {

    public static char[] reverseString(char[] input){
        int i = 0;
        int j = input.length - 1;
        while(i < j){
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            i++;
            j--;
        }
        return input;
    }

    public static void main(String[] args) {
        char[] input = new char[]{'s','u','n','n','y'};
        System.out.println(String.valueOf(reverseString(input)));
        input = new char[]{'s','u','n','n'};
        System.out.println(String.valueOf(reverseString(input)));
    }
}
