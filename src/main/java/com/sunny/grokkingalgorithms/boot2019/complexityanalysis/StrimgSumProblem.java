package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class StrimgSumProblem {

    /*
    You are provided a positive integer n and asked to construct all strings of 1s, 2s, and 3s that would sum up to n. For example,
if n = 3, then the following strings will sum up to n:

111
12
21
3
     */


    public static int findSumMemoization(int n, int[] computed){
        if(n == 0){
            //System.out.println(s);
            return 1;
        }
        if(n < 1){
            return 0;
        }
        if(computed[n] != -1){
            return computed[n];
        }
        int sum = 0;
        sum += findSumMemoization(n - 1,computed) + findSumMemoization(n - 2,computed)
          + findSumMemoization(n - 3,computed);
        computed[n] = sum;
        return computed[n];
    }

    public static void printStringSum(int n,String s){
        if(n == 0){
            System.out.println(s);
            return;
        }
        if(n < 0){
            return;
        }
        for(int i = 1; i <= 3; i++){
            printStringSum(n-i,s + i);
        }
    }


    public static void main(String[] args) {
        System.out.println();
        printStringSum(3,"");
        System.out.println("with memoization:");
        int[] computed = new int[51];
        for(int i = 0 ; i < computed.length ; i++){
            computed[i] = -1;
        }
        System.out.println(findSumMemoization(50,computed));
        System.out.println();
        System.out.println();
        printStringSum(2,"");
        System.out.println();
        printStringSum(7,"");
    }

}
