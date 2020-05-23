package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class PeakFinder {

    /*
    Given a single domensional array , find a peak

    [1,2,1,4,5]

    2 is a peak

    a<= b >= c
     */


    public static int findPeak(int[] input){
        int index = -1;
        for(int i = 1 ; i < input.length; i++){
            if((input[i] >= input[i - 1])
                && ((i == input.length - 1)
                    || (input[i] >=  input[i + 1]))){
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,1,4,5};
        System.out.println(input[findPeak(input)]);
        input = new int[]{1,2,3,4,2};
        System.out.println(input[findPeak(input)]);
        input = new int[]{1,2,3,4,6};
        System.out.println(input[findPeak(input)]);
    }



}
