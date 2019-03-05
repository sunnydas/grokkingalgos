package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class MergeSort {


    public static void mergeSort(int[] input){
        mergeSortRecursive(input,0,input.length - 1);
    }

    public static void mergeSortRecursive(int[] input,int left,int right){
        if(left >= right){
            return;
        }
        int mid = left + (right - left)/2;
        mergeSortRecursive(input,left,mid);
        mergeSortRecursive(input,mid+1,right);
        merge(input,left,mid,mid+1,right);
    }

    public static void merge(int[] input,int l1,int r1,int l2,int r2){
        int[] auxillary = new int[(r1 - l1) + (r2 - l2) + 2];
        int l1Index = l1;
        int l2Index = l2;
        int index = 0;
        while(l1Index <= r1 && l2Index <= r2){
            if(input[l1Index] > input[l2Index]){
                auxillary[index] = input[l2Index];
                l2Index++;
            }
            else if(input[l1Index] <= input[l2Index]){
                auxillary[index] = input[l1Index];
                l1Index++;
            }
            index++;
        }
        while(l1Index <= r1){
            auxillary[index] = input[l1Index];
            l1Index++;
            index++;
        }
        while(l2Index <= r2){
            auxillary[index] = input[l2Index];
            l2Index++;
            index++;
        }
        index = 0;
        for(int i = l1 ; i <= r1 ; i++,index++){
            input[i] = auxillary[index];
        }
        for(int i = l2 ; i <= r2 ; i++,index++){
            input[i] = auxillary[index];
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1};
        mergeSort(input);
        for(int i : input){
            System.out.println(i);
        }
        System.out.println();
        input = new int[]{0,100,2,3,5,4};
        mergeSort(input);
        for(int i : input){
            System.out.println(i);
        }
    }

}
