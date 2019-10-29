package com.sunny.grokkingalgorithms.boot2019.phleps;

public class VariableSwapWithoutTemp {

    public static void swap(int a,int b){
        System.out.println("before  a = " + a  + " b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after a = " + a  + " b = " + b);
    }

    public static void main(String[] args) {
        swap(5,6);
        swap(1,2);
    }

}
