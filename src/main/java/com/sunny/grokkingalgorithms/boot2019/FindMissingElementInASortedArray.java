package com.sunny.grokkingalgorithms.boot2019;

public class FindMissingElementInASortedArray {


    public static int findMissingElementInSortedArray(int[] ar,int size){
        int start = 0;
        int end = ar.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(ar[mid] != mid){
                if(mid == 0 || ar[mid - 1] == mid - 1){
                    return mid;
                }
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        throw new IllegalArgumentException("No missing number");
    }

    public static int findMissingElementInSortedArray(int[] input){
        int total = ((input.length + 1)*(input.length + 2))/2;
        for(int i = 0 ; i < input.length ; i++){
            total = total - input[i];
        }
        return total;
    }

    public static void main(String[] args) {
        //1,2,4
        int[] input = new int[]{1,2,3,4,5,6,8,9};
        System.out.println(findMissingElementInSortedArray(input));
        input = new int[]{0,1,2,3,4,5,6,8,9};
        System.out.println(findMissingElementInSortedArray(input,input.length));
        input = new int[]{0,1,2,3,4,5,6,7,8,10};
        System.out.println(findMissingElementInSortedArray(input,input.length));
    }

}
