package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.Arrays;

public class PascalTriangle {

    /*
    1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
     */

    public static void printPascalsTriangle(int n){
        int[][] pascalTriangle = new int[n][n];
        pascalTriangle[0][0] = 1;
        for(int i = 1 ; i < pascalTriangle.length ; i++){
            for(int j = 0 ; j < pascalTriangle[i].length ; j++){
                int curVal = pascalTriangle[i - 1][j];
                if(j - 1 >= 0){
                    curVal += pascalTriangle[i - 1][j -1];
                }
                pascalTriangle[i][j] = curVal;
            }
        }
        print2DArray(pascalTriangle);
    }

    public static void print2DArray(int[][] input){
        for(int i = 0 ; i < input.length ; i++){
            for(int j = 0 ; j < input[i].length ; j++){
                System.out.print(input[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPascalsTriangle(6);
    }

}
