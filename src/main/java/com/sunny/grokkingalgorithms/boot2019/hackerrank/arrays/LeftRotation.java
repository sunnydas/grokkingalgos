package com.sunny.grokkingalgorithms.boot2019.hackerrank.arrays;

import java.util.Arrays;

public class LeftRotation {

    /*
    https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays


    A left rotation operation on an array shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

Given an array  of  integers and a number, , perform  left rotations on the array. Return the updated array to be printed as a single line of space-separated integers.

Function Description

Complete the function rotLeft in the editor below. It should return the resulting array of integers.

rotLeft has the following parameter(s):

An array of integers .
An integer , the number of rotations.
Input Format

The first line contains two space-separated integers  and , the size of  and the number of left rotations you must perform.
The second line contains  space-separated integers .

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:


     */


    // Complete the rotLeft function below.
    public static int[] rotLeft(int[] a, int d) {
        int[] rotated = new int[a.length];
        for(int i = 0 ; i < a.length ; i++){
            int nextPosition = Math.floorMod(i - d,
                    a.length);
            rotated[nextPosition] = a[i];
        }
        return rotated;
    }

    public static int[] rotLeftAlt(int[] a, int d) {
        a = reverse(a,0,d - 1);
        a = reverse(a,d,a.length - 1);
        a= reverse(a,0,a.length - 1);
        return a;
    }

    public static  int[] reverse(int[] a,int startIndex,int lastIndex){
        int i = startIndex;
        int j = lastIndex;
        while(i < j){
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
        return a;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1,2,3,4,5};
        int[] rotated = rotLeft(input,4);
        for(int i = 0 ; i < rotated.length ; i++){
            System.out.println(rotated[i]);
        }
        System.out.println();
        input = rotLeftAlt(input,4);
        for(int i = 0 ; i < input.length ; i++){
            System.out.println(input[i]);
        }
    }

}
