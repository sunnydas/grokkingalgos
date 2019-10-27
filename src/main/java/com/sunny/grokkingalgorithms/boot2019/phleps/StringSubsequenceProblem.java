package com.sunny.grokkingalgorithms.boot2019.phleps;

public class StringSubsequenceProblem {

    /*
    Given two strings, find if first string is a subsequence of second
Given two strings str1 and str2, find if str1 is a subsequence of str2. A subsequence is a sequence that can be derived from another sequence by deleting some elements without changing the order of the remaining elements (source: wiki). Expected time complexity is linear.

Examples :

Input: str1 = "AXY", str2 = "ADXCPY"
Output: True (str1 is a subsequence of str2)

Input: str1 = "AXY", str2 = "YADXCP"
Output: False (str1 is not a subsequence of str2)

Input: str1 = "gksrek", str2 = "geeksforgeeks"
Output: True (str1 is a subsequence of str2)
     */

    public static boolean isSubsequenceRecursive(String str,String subsequence,int i,int j,int count){
        if(count == subsequence.length()){
            return true;
        }
        if(i >= str.length()){
            return false;
        }
        if(j >= subsequence.length()){
            return false;
        }
        if(str.charAt(i) == subsequence.charAt(j)){
            j++;
            count++;
        }
        return isSubsequenceRecursive(str,subsequence,i+1,j,count);
    }

    public static boolean isSubsequenceAlt(String str,String subsequence){
        boolean isSubsequence = false;
        int i = 0;
        int j = 0;
        for(;i < str.length() && j < subsequence.length(); i++){
            if(str.charAt(i) == subsequence.charAt(j)){
                j++;
            }
        }
        isSubsequence = (j==subsequence.length());
        return isSubsequence;
    }


    public static boolean isSubsequence(String subsequence,String str){
        boolean isSubsequence = false;
        for(int i = 0 ; i < str.length() ; i++){
            char current = str.charAt(i);
            if(current == subsequence.charAt(0)){
                isSubsequence = doesStringContainSubsequence(str,i,subsequence);
                if(isSubsequence){
                    break;
                }
            }
        }
        return isSubsequence;
    }

    public static boolean doesStringContainSubsequence(String str,int index,String subsequence){
        int matchCount = 0;
        boolean isSubsequence = false;
        int subIndex = 0;
        int strIndex = index;
        while(strIndex < str.length()
                && subIndex < subsequence.length()){
            if(str.charAt(strIndex) == subsequence.charAt(subIndex)){
                matchCount++;
                subIndex++;
            }
            strIndex++;
        }
        if(matchCount == subsequence.length()){
            isSubsequence = true;
        }
        return isSubsequence;
    }

    public static void main(String[] args) {
        String subsequence = "AXY";
        String str = "ADXCPY";
        System.out.println(isSubsequence(subsequence,str));
        System.out.println(isSubsequenceAlt(str,subsequence));
        System.out.println(isSubsequenceRecursive(str,subsequence,0,0,0));
        System.out.println();
        subsequence = "AXY";
        str = "YADXCP";
        System.out.println(isSubsequence(subsequence,str));
        System.out.println(isSubsequenceAlt(str,subsequence));
        System.out.println(isSubsequenceRecursive(str,subsequence,0,0,0));
        System.out.println();
        subsequence = "gksrek";
        str = "geeksforgeeks";
        System.out.println(isSubsequence(subsequence,str));
        System.out.println(isSubsequenceAlt(str,subsequence));
        System.out.println(isSubsequenceRecursive(str,subsequence,0,0,0));
        System.out.println();
    }

}
