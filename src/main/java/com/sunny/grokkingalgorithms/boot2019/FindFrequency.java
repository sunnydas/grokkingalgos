package com.sunny.grokkingalgorithms.boot2019;

import java.util.Scanner;

public class FindFrequency {

    /*
    Given a vector of N positive integers and an integer X. The task is to find the frequency of X in vector.



Input Format:
First line of input contains number of testcases T.
 For each testcase there will be three lines. First line of which contains N, size of vector. Second line contains N positive integers seperated by space, and third line contains X, whose frequency is required.

Output Format:
For each testcase, print the frequency of X.

User Task:
Your task is to complete the function findFrequency() which should count the frequency of X and return it.

Constraints:
1 <= T <= 100
1 <= N <= 106
1 <= V[i] <= 1016
     */

    public static int findFrequency(int[] input,int x){
        int frequency = 0;
        for(int i = 0 ; i < input.length ; i++){
            if(input[i] == x){
                frequency++;
            }
        }
        return frequency;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numTestCases = scanner.nextInt();
        for(int i = 0 ; i < numTestCases ; i++){
            int size = scanner.nextInt();
            int[] input = new int[size];
            for(int j = 0 ; j < input.length ; j++){
                input[j] = scanner.nextInt();
            }
            int x = scanner.nextInt();
            System.out.println(findFrequency(input,x));
        }
    }

}
