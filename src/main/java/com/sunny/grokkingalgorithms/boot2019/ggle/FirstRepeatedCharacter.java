package com.sunny.grokkingalgorithms.boot2019.ggle;

import java.util.HashSet;
import java.util.Set;

public class FirstRepeatedCharacter {

    /*
    Input: ch = "geeksforgeeks"
Output: e
e is the first element that repeats

Input: str = "hello geeks"
Output: l
l is the first element that repeats
     */

    public static char firstRepeatedCharacter(String str){
        char repeated = ' ';
        Set<Character> trackerSet = new HashSet<>();
        for(int i = 0 ; i < str.length() ; i++){
            if(trackerSet.contains(str.charAt(i))){
                repeated = str.charAt(i);
                break;
            } else{
                trackerSet.add(str.charAt(i));
            }
        }
        return repeated;
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(firstRepeatedCharacter(str));
        str = "hello geeks";
        System.out.println(firstRepeatedCharacter(str));
    }

}
