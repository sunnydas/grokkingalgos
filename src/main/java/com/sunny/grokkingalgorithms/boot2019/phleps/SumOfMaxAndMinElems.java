package com.sunny.grokkingalgorithms.boot2019.phleps;

public class SumOfMaxAndMinElems {

    /*
    Sum of minimum and maximum elements of all subarrays of size k.
Given an array of both positive and negative integers, the task is to compute sum of minimum and maximum elements of all sub-array of size k.

Examples:

Input : arr[] = {2, 5, -1, 7, -3, -1, -2}
        K = 4
Output : 18
Explanation : Subarrays of size 4 are :
     {2, 5, -1, 7},   min + max = -1 + 7 = 6
     {5, -1, 7, -3},  min + max = -3 + 7 = 4
     {-1, 7, -3, -1}, min + max = -3 + 7 = 4
     {7, -3, -1, -2}, min + max = -3 + 7 = 4
     Sum of all min & max = 6 + 4 + 4 + 4
                          = 18
     */

    public static int sumOfAllMaxAndMin(int[] input,int k){
        int sum = 0;
        for(int i = 0 ; i <= (input.length - k) ; i++){
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for(int j = i; j <= i+ k - 1; j++){
                if(input[j] < min){
                    min = input[j];
                }
                if(input[j] > max){
                    max = input[j];
                }
            }
            sum += min + max;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 5, -1, 7, -3, -1, -2};
        int k = 4;
        System.out.println(sumOfAllMaxAndMin(input,k));
    }

}
