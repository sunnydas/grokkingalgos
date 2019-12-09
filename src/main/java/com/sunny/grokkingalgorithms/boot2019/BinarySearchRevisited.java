package com.sunny.grokkingalgorithms.boot2019;

public class BinarySearchRevisited {

    public static int binarySearch(int[] input,
                                   int key,
                                   int start,
                                   int end){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(input[mid] == key){
            return mid;
        }else if(input[mid] > key){
            return binarySearch(input,key,start,mid - 1);
        }else{
            return binarySearch(input,key ,mid + 1,end);
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        System.out.println(binarySearch(input,3,0,input.length - 1));
        System.out.println(binarySearch(input,5,0,input.length - 1));
        System.out.println(binarySearch(input,1,0,input.length - 1));
    }

}
