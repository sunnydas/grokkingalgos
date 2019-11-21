package com.sunny.grokkingalgorithms.boot2019;

public class PascalTriangle {

    public static void printPascalTriangle(int n){
        int[][] matrix = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            matrix[i][0] = 1;
        }
        for(int i = 1 ; i < n ; i++){
            for(int j = 1; j < n ; j++){
                matrix[i][j] = matrix[i-1][j] + matrix[i-1][j -1];
            }
        }
        for(int i = 0; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                System.out.print(matrix[i][j] +  " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printPascalTriangle(6);
    }

}
