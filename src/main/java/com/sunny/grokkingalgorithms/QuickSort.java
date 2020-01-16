package com.sunny.grokkingalgorithms;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] input,
                                 int low,
                                 int high){
        int i = low;
        int j = high;
        int pivot = low + ((high - low)/2);
        int pivotElement = input[pivot];
        while(i < j){
            while(input[i] < pivotElement){
                i++;
            }
            while(input[j] > pivotElement){
                j--;
            }
            if(i <= j){
                int temp = input[j];
                input[j] = input[i];
                input[i] = temp;
                i++;
                j--;
            }
        }
        if(j > low){
            quickSort(input,low,j);
        }
        if(i < high){
            quickSort(input,i,high);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{7,4,1,2,6,5};
        quickSort(input,0,input.length - 1);
        for(int i : input){
            System.out.print(i + " ");
        }
        System.out.println();
    }

}