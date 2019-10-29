package com.sunny.grokkingalgorithms.boot2019.ggle;

public class SecondMinimum {

    public static int secondMinimum(int[] input){
        int min = Integer.MAX_VALUE;
        int secondMinimum = Integer.MAX_VALUE;
        for(int i = 0 ; i < input.length ; i++){
            int current = input[i];
            if(current < secondMinimum && current > min){
                secondMinimum = current;
            }
            if(current < min){
                secondMinimum = min;
                min = current;
            }
        }
        return secondMinimum;
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1};
        System.out.println(secondMinimum(input));
    }

}
