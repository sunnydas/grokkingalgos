package com.sunny.grokkingalgorithms.refresh.ctci.arraysandstrings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PermutationCheckForTwoStrings {


    /*
    Check if two strings are permutations of each other.
     */

    /**
     *
     * @param str1
     * @param str2
     * @return
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

    public static boolean areTwoStringsPermutationsOfEachOtherUsingMap(String str1,
                                                               String str2){
        boolean arePermutations = true;
        if(str1.length() != str2.length()){
            return false;
        }
        Map<Character,Integer> str1CountMap = new HashMap<>();
        Map<Character,Integer> str2CountMap = new HashMap<>();
        /*
        Populate count map 1
         */
        for(int i = 0 ; i < str1.length() ; i++){
            char cur = str1.charAt(i);
            if(str1CountMap.containsKey(cur)){
                str1CountMap.put(cur,(str1CountMap.get(cur))+1);
            }
            else{
                str1CountMap.put(cur,1);
            }
        }
        /*
        Populate count map 2
         */
        for(int i = 0 ; i < str2.length() ; i++){
            char cur = str2.charAt(i);
            if(str2CountMap.containsKey(cur)){
                str2CountMap.put(cur,(str2CountMap.get(cur))+1);
            }
            else{
                str2CountMap.put(cur,1);
            }
        }
        //compare
        Iterator<Map.Entry<Character,Integer>> str1MapIterator = str1CountMap.entrySet().iterator();
        while(str1MapIterator.hasNext()){
            Map.Entry<Character,Integer> entry = str1MapIterator.next();
            if((!str2CountMap.containsKey(entry.getKey()))
                    || (str2CountMap.get(entry.getKey()) != entry.getValue())){
                arePermutations = false;
                break;
            }
        }
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
        System.out.println(areTwoStringsPermutationsOfEachOtherUsingMap(str1,str2));
        str1 = "zxcf";
        str2 = "zxcd";
        System.out.println(areTwoStringsPermutationsOfEachOther(str1,str2));
        System.out.println(areTwoStringsPermutationsOfEachOtherUsingMap(str1,str2));
        str1 = "zxcf";
        str2 = "zxcff";
        System.out.println(areTwoStringsPermutationsOfEachOther(str1,str2));
        System.out.println(areTwoStringsPermutationsOfEachOtherUsingMap(str1,str2));

    }

}
