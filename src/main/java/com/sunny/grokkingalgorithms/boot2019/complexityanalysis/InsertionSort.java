package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class InsertionSort {

    public static void insertionSort(int[] input){
        for(int i = 1 ; i < input.length ; i++){
            int x = input[i];
            int j = i - 1;
            while(j >= 0){
                if(x < input[j]){
                    int temp = input[j];
                    input[j] = x;
                    input[j + 1] = temp;
                }
                j--;
            }
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1};
        insertionSort(input);
        for(int i : input){
            System.out.println(i);
        }
    }
}
