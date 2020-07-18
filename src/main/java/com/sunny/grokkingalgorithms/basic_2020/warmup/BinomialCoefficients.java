package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Arrays;

public class BinomialCoefficients {

    /*
    The value of C(n, k) can be recursively calculated using following standard formula for Binomial Coefficients.

   C(n, k) = C(n-1, k-1) + C(n-1, k)
   C(n, 0) = C(n, n) = 1
     */

    public static int[][] cache = null;

    public static int calculateBinomialCoefficientsCached(int n,int k){
        if(cache[n][k] > 0){
            //System.out.println("cached");
            return cache[n][k];
        }
        if(k <= 0 || n == k){
            cache[n][k] = 1;
            return  cache[n][k];
        }
        System.out.print(" C(" + n + "," + k + ")" + " ");
        cache[n][k] = calculateBinomialCoefficientsCached(n-1,k-1)
                + calculateBinomialCoefficientsCached(n-1,k);
        return cache[n][k];
    }

    public static int calculateBinomialCoefficients(int n,int k){
        if(k <= 0 || n == k){
            return 1;
        }
        System.out.print(" C(" + n + "," + k + ")" + " ");
        return calculateBinomialCoefficients(n-1,k-1)
                + calculateBinomialCoefficients(n-1,k);
    }

    public static void fill(int[][] cache,int value){
        for(int[] row : cache){
            Arrays.fill(row,value);
        }
    }

    public static void main(String[] args) {
        System.out.println(calculateBinomialCoefficients(4,2));
        System.out.println(calculateBinomialCoefficients(5,2));
        System.out.println(calculateBinomialCoefficients(10,2));
        System.out.println();
        cache = new int[5][3];
        fill(cache,0);
        System.out.println(calculateBinomialCoefficientsCached(4,2));
        cache = new int[6][3];
        fill(cache,0);
        System.out.println(calculateBinomialCoefficientsCached(5,2));
        cache = new int[11][3];
        fill(cache,0);
        System.out.println(calculateBinomialCoefficientsCached(10,2));
    }


}
