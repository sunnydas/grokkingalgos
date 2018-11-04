package com.sunny.grokkingalgorithms.refresh.ctci.arraysandstrings;

public class PermutationPalindromeChecker {

    /**
     * Check when given a string , any of its permutation is a palindrome.
     *
     * Tact Coa
     *
     * true
     *
     * (taco cat,atco cta)
     */

    public static int effectiveCount(String s){
        int count = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) ==  ' '){
                continue;
            }
            count++;
        }
        return count;
    }

    /**
     *
     * @param s
     * @return
     */
    public static boolean isAnyPermutationAPalindrome(String s){
        boolean isAnyPermutationPalindrome = false;
        char[] arr = s.toCharArray();
        for(int i = 0 ; i < s.length() ; i++){
            char cur = Character.toLowerCase(s.charAt(i));
            if(cur == ' '){
                continue;
            }
            for(int j = i+1 ; j < s.length() ; j++){
                if(cur == Character.toLowerCase(s.charAt(j))) {
                    arr[i] = ' ';
                    arr[j] = ' ';
                    break;
                }
            }
        }
        int count = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] != ' '){
                count++;
            }
        }
        if(effectiveCount(s)%2 == 0 && count == 0){
            isAnyPermutationPalindrome = true;
        }
        else if((effectiveCount(s)%2 != 0) && count == 1){
            isAnyPermutationPalindrome = true;
        }
        return isAnyPermutationPalindrome;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String s = "Tact Coa";
        System.out.println(isAnyPermutationAPalindrome(s));
    }
}
