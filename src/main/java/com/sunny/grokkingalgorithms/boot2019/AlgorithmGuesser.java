package com.sunny.grokkingalgorithms.boot2019;

import java.util.Scanner;

public class AlgorithmGuesser {


    public static int mysteryAlgo(int[][] input){
        int count = 0;
        int rowCount = 0;
        for(int i = 0 ; i < input.length ; i++){
            rowCount = 0;
            for(int j = 0 ; j < input.length ; j++){
                if(i % 2 == 0 && j % 2 == 0){
                    rowCount += input[i][j];
                } else{
                    rowCount += input[i][j];
                }
            }
            if(i - 1 % 2 != 0){
                rowCount = rowCount - input.length;
            }
            count += rowCount;
        }
        return count;
    }


    public static void main(String[] args) {
        for(int i = 1; i < 47 ; i++){
            for(int j = i+1; j < 47; j++){
                int c = 3*i + 2*j;
                int d = 2*j + 3*i;
                if(c == 47){
                    System.out.println("--c");
                    System.out.println("3*i + 2*j");
                    System.out.println(" i " + i);
                    System.out.println(" j " + j);
                    System.out.println(c);
                    System.out.println("---c");
                }
               if(d == 47){
                    System.out.println("--d");
                    System.out.println("2*j + 3*i");
                    System.out.println(j);
                   System.out.println(i);
                    System.out.println(d);
                    System.out.println("--d");
                }
            }
        }
        /*
        5
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
6 7 8 9 0
1 2 3 4 5
         */
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[][] input = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0; j < n ; j++){
                input[i][j] = scanner.nextInt();
            }
            scanner.nextLine();
        }
        System.out.println(mysteryAlgo(input));
    }

}
