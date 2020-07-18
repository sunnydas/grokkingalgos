package com.sunny.grokkingalgorithms.basic_2020.warmup;

public class BinomialCoefficients {

    /*
    The value of C(n, k) can be recursively calculated using following standard formula for Binomial Coefficients.

   C(n, k) = C(n-1, k-1) + C(n-1, k)
   C(n, 0) = C(n, n) = 1
     */

    public static int calculateBinomialCoefficients(int n,int k){
        if(k <= 0 || n ==k){
            return 1;
        }
        return calculateBinomialCoefficients(n-1,k-1)
                + calculateBinomialCoefficients(n-1,k);
    }

    public static void main(String[] args) {
        System.out.println(calculateBinomialCoefficients(4,2));
        System.out.println(calculateBinomialCoefficients(5,2));
    }


}
