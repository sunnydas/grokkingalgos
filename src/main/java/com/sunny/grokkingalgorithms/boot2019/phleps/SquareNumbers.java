package com.sunny.grokkingalgorithms.boot2019.phleps;

import java.util.Scanner;

public class SquareNumbers {

    /*
    Write a program to square the numbers as long as the user provides the input.
    When 0 is pressed the program must terminate after displaying all the squared numbers.
     */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            int a = scanner.nextInt();
            if(a != 0) {
                System.out.println(Math.pow(a, 2));
            } else{
                break;
            }
        }
    }

}
