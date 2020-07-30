package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Scanner;

public class Fibonacci {
	
	public static int fibonacci(int n) {
		if(n == 1) {
			return 1;			
		}
		if(n <= 0) {
			return 0;
		}
		return fibonacci(n-1) + fibonacci(n-2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();
        System.out.println(fibonacci(n));
    }
}
