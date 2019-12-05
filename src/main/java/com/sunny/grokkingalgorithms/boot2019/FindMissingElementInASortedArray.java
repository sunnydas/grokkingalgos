package com.sunny.grokkingalgorithms.boot2019;

public class FindMissingElementInASortedArray {
    


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
    }

}
