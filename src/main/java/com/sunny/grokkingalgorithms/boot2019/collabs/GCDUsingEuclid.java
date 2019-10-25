package com.sunny.grokkingalgorithms.boot2019.collabs;

public class GCDUsingEuclid {

    public static int gcdIterative(int x,int y){
        while(x != y){
            if(x > y){
                x = x - y;
            } else{
                y = y - x;
            }
        }
        return x;
    }

    public static int gcd(int x,int y){
        if(y == 0){
            return x;
        }
        return gcd(y,x%y);
    }

    public static void main(String[] args) {
        System.out.println(gcd(36,60));
        System.out.println(gcdIterative(36,60));
    }

}
