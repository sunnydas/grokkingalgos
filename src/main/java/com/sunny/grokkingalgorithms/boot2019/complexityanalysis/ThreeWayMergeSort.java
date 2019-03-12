package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

import java.util.PriorityQueue;

public class ThreeWayMergeSort {


    public static void threeWayMergeSort(int[] input){
        threeWayMergeSortRecursive(input,0,input.length - 1);
    }

    public static void threeWayMergeSortRecursive(int[] input,int start,int end){
        if(start >= end){
            return;
        }else if (start + 1 == end) {
            if (input[start] > input[end]) {
                int temp = input[start];
                input[start] = input[end];
                input[end] = temp;
            }
            return;
        }
        int oneThird = (end - start)/3;
        threeWayMergeSortRecursive(input,start,start + oneThird);
        threeWayMergeSortRecursive(input,oneThird + 1,start + 2*(oneThird) + 1);
        threeWayMergeSortRecursive(input,start + 2*(oneThird) + 2,end);
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i = start; i <= end ; i++){
            queue.add(input[i]);
        }
        int i = start;
        while(!queue.isEmpty()){
            input[i] = queue.poll();
            i++;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{5,4,3,2,1,0};
        threeWayMergeSort(input);
        for(int i : input){
            System.out.println(i);
        }
        System.out.println();
        input = new int[]{0,100,2,3,5,4};
        threeWayMergeSort(input);
        for(int i : input){
            System.out.println(i);
        }
    }

}
