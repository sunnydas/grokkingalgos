package com.sunny.grokkingalgorithms.boot2019.yelper;

public class IsScorePossible {

    /*
    From a given integer array values, find if a Total value is possible or not?
    The numbers in the array can be used more than once.
example
int[] points = {3, 7};
isScorePossible(points, 10) => true
isScorePossible(points, 9) => true
     */

    public static boolean isScorePossible(int[] points, int k,int sum){
        if(sum == k){
            return true;
        }
        if(sum > k){
            return false;
        }
        for(int i = 0; i < points.length ; i++){
            boolean possible = isScorePossible(points,k,sum + points[i]);
            if(possible){
                return possible;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] points = new int[]{3,7};
        System.out.println(isScorePossible(points,10,0));
        System.out.println(isScorePossible(points,9,0));
        System.out.println(isScorePossible(points,8,0));
    }
}
