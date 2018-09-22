package com.sunny.grokkingalgorithms.refresh.ctci.arraysandstrings;

import java.util.Arrays;

public class PermutationCheckForTwoStrings {


    /*
    Check if two strings are permutations of each other.
     */

    public static boolean areTwoStringsPermutationsOfEachOther(String str1,
                                                               String str2){
        boolean arePermutations = true;
        if(str1.length() != str2.length()){
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        str1 = String.valueOf(arr1);
        str2 = String.valueOf(arr2);
        arePermutations = str1.equals(str2);
        return arePermutations;
    }


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "cba";
        System.out.println(areTwoStringsPermutationsOfEachOther(str1,str2));
        str1 = "zxcf";
        str2 = "zxcd";
        System.out.println(areTwoStringsPermutationsOfEachOther(str1,str2));
        str1 = "zxcf";
        str2 = "zxcff";
        System.out.println(areTwoStringsPermutationsOfEachOther(str1,str2));
    }

}
