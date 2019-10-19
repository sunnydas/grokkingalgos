package com.sunny.grokkingalgorithms.boot2019.yelper;

public class BinarySearch {


    public static int binarySearchUsingRecursion(int[] input,int start,
                                                 int end,int key){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start)/2;
        if(input[mid] == key){
            return mid;
        }
        else if(input[mid] < key){
            return binarySearchUsingRecursion(input,mid+1,end,key);
        }else{
            return binarySearchUsingRecursion(input,start,mid - 1,key);
        }
    }

    public static int binarySearchIterative(int[] input,int key){
        int foundIndex = -1;
        int start = 0;
        int end = input.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(input[mid] == key){
                foundIndex = mid;
                break;
            }
            else if(input[mid] < key){
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        return foundIndex;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5,6,7,8};
        System.out.println(binarySearchUsingRecursion(input,0,input.length - 1,5));
        System.out.println(binarySearchUsingRecursion(input,0,input.length - 1,1));
        System.out.println(binarySearchUsingRecursion(input,0,input.length - 1,8));
        System.out.println(binarySearchUsingRecursion(input,0,input.length - 1,2));
        System.out.println(binarySearchUsingRecursion(input,0,input.length - 1,123));
        System.out.println();
        System.out.println(binarySearchIterative(input,5));
        System.out.println(binarySearchIterative(input,1));
        System.out.println(binarySearchIterative(input,8));
        System.out.println(binarySearchIterative(input,2));
        System.out.println(binarySearchIterative(input,123));
    }

}
