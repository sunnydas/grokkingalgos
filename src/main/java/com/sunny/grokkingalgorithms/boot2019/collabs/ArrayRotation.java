package com.sunny.grokkingalgorithms.boot2019.collabs;

public class ArrayRotation {

    public static int[] rotate(int[] input, int k){
        int[] rotated = new int[input.length];
        /*
        Complexity O(n)
        space complexity O(n)
         */
        for(int i = 0 ; i < input.length ; i++){
            // Java's % will not work here
            int nextIndex = Math.floorMod((i-k),input.length);
            rotated[nextIndex] = input[i];
        }
        System.out.println();
        return rotated;
    }

    public static void printArray(int[] input){
        for(int i = 0 ; i < input.length ; i++){
            System.out.print(input[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{1, 2, 3, 4, 5, 6, 7};
        int[] rotated = rotate(input1, 2);
        printArray(rotated);
    }


}
