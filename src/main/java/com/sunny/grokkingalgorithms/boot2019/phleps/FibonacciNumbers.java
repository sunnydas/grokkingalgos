package com.sunny.grokkingalgorithms.boot2019.phleps;

public class FibonacciNumbers {

    public static int fib(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        return (fib(n - 1) + fib(n - 2));
    }

    public static int fibIterative(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        int fibN = 0;
        int fibN_1 = 1;
        int fibN_2 = 0;
        int i = 2;
        while(i <= n){
            fibN = fibN_1 + fibN_2;
            fibN_2 = fibN_1;
            fibN_1 = fibN;
            i++;
        }
        return fibN;
    }

    public static void main(String[] args) {
        System.out.println(fib(5));
        System.out.println(fib(2));
        System.out.println(fib(7));
        System.out.println(fib(10));
        System.out.println();
        System.out.println(fibIterative(5));
        System.out.println(fibIterative(2));
        System.out.println(fibIterative(7));
        System.out.println(fibIterative(10));
    }

}
