package com.sunny.grokkingalgorithms.boot2019;

import java.util.PriorityQueue;

public class KthMinimum {

    public static int kthMinimum(int[] input,int k){
        int kthMin = -1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int i : input){
            minHeap.add(i);
        }
        for(int i = 0; i < k ; i++){
            kthMin = minHeap.poll();
        }
        return kthMin;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        System.out.println(kthMinimum(input,3));
        System.out.println(kthMinimum(input,4));
        System.out.println(kthMinimum(input,1));
    }

}
