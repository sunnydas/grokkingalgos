package com.sunny.grokkingalgorithms.boot2019.collabs;

public class EditDistance {


    /*
     Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

You have the following 3 operations permitted on a word:

Insert a character
Delete a character
Replace a character
Example 1:

Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
Example 2:

Input: word1 = "intention", word2 = "execution"
Output: 5
Explanation:
intention -> inention (remove 't')
inention -> enention (replace 'i' with 'e')
enention -> exention (replace 'n' with 'x')
exention -> exection (replace 'n' with 'c')
exection -> execution (insert 'u')
     */



    public static int findMinEditDistance(String word1,String word2){
        /*
        complexity O(3.pow(max{word1.length,word2.length}))
         */
        if(word1.isEmpty()){
            return word2.length();
        }
        if(word2.isEmpty()){
            return word1.length();
        }
        int replaceCost = findMinEditDistance(word1.substring(1),word2.substring(1)) + replaceCost(word1.charAt(0),
                word2.charAt(0));
        int insertCost = findMinEditDistance(word1,word2.substring(1)) + 1;
        int deleteCost = findMinEditDistance(word1.substring(1),word2) + 1;
        return findMin(insertCost,deleteCost,replaceCost);
    }

    public static int findMin(int ... values){
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < values.length ; i++){
            if(values[i] < minValue){
                minValue = values[i];
            }
        }
        return minValue;
    }

    public static int replaceCost(char first,char second){
        return (first == second)?0:1;
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(findMinEditDistance(word1,word2));
    }

}
