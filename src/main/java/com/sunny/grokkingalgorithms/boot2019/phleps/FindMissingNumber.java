package com.sunny.grokkingalgorithms.boot2019.phleps;

public class FindMissingNumber {

    /*
    Given an array of consecutive numbers find the one missing in the sequence.
Example: input [1,2,3,4,6,7,8,9,10] --> output 5
     */

    public static int findMissingNumber(int[] input){
        int missing = -1;
        int n = input.length;
        int sum = ((n+1)*(n+2))/2;
        int curSum = 0;
        for(int i = 0; i < input.length ;i++){
            curSum += input[i];
        }
        missing = (sum - curSum);
        return missing;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,6,7,8,9,10};
        System.out.println(findMissingNumber(input));
        int a[] = { 1, 2, 4, 5, 6 };
        int miss = findMissingNumber(a);
        System.out.println(miss);
    }
}
