package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class BinarySearchRecursive {


    public static int binarySearch(int[] input,int start,int end,int key){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(input[mid] == key){
            return mid;
        }
        else if(input[mid] < key){
            return binarySearch(input,mid + 1,end,key);
        }
        else{
            return binarySearch(input,start,mid - 1,key);
        }
    }


    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        System.out.println(binarySearch(input,0,input.length - 1,2));
        System.out.println(binarySearch(input,0,input.length - 1,5));
        System.out.println(binarySearch(input,0,input.length - 1,100));
    }

}
