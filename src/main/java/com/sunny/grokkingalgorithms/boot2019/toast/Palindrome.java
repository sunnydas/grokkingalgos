package com.sunny.grokkingalgorithms.boot2019.toast;

public class Palindrome {

    public static boolean isPalindrome(char[] input){
        boolean palindrome = true;
        int i = 0;
        int j = input.length -1;
        while(i < j){
            if(input[i] != input[j]){
                palindrome = false;
                break;
            }
            i++;
            j--;
        }
        return palindrome;
    }

    public static void main(String[] args) {
        String s = "abba";
        System.out.println(isPalindrome(s.toCharArray()));
        s = "abccdef";
        System.out.println(isPalindrome(s.toCharArray()));
    }
}
