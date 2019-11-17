package com.sunny.grokkingalgorithms.boot2019;

public class KevinSolutionForMysteryAlgo {


    public static int mysteryAlgo(int[][] input){
        int count = 0;
        boolean forward = true;
        int i = 0;
        int j = 0;
        int k  = input.length - 1;
        while(i < input.length){
            if(j != k) {
                count += input[i][j] + input[i][k];
            } else{
                count += input[i][j];
            }
            if(forward) {
                i++;
                j++;
                k--;
                if(j == k){
                    forward = false;
                }
            } else{
                i++;
                j--;
                k++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] input1 = new int[][]{
                {1,2,3,4,5},
                {6,7,8,9,0},
                {1,2,3,4,5},
                {6,7,8,9,0},
                {1,2,3,4,5}
        };
        System.out.println(mysteryAlgo(input1));
        int[][] input2 = new int[][]{
                {10,2,3,4,5,10},
                {1,20,3,4,20,6},
                {1,2,30,30,5,6},
                {1,2,40,40,5,6},
                {1,50,3,4,50,6},
                {60,2,3,4,5,60}
        };
        System.out.println(mysteryAlgo(input2));
    }

}
