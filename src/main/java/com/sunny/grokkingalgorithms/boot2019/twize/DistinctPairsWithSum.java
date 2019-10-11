package com.sunny.grokkingalgorithms.boot2019.twize;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
class Pair{

    private int i;

    private int j;

    public int getI() {
        return i;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return (i == pair.i &&
                j == pair.j) || (i == pair.j && j == pair.i);
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }

    public void setI(int i) {
        this.i = i;
    }

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }
}
public class DistinctPairsWithSum {


    /*
    Input  :  arr[] = {1, 5, 7, -1},
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)

Input  :  arr[] = {1, 5, 7, -1, 5},
          sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &
                     (1, 5)

Input  :  arr[] = {1, 1, 1, 1},
          sum = 2
Output :  6
There are 3! pairs with sum 2.

Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6,
                   5, 4, 2, 1, 1, 1},
          sum = 11
Output :  9
     */

    public static void countDistinctPairsWithSum(int[] input,int k){
        Set<Pair> pairs = new HashSet<>();
        for(int i = 0 ; i < input.length ; i++){
            for(int j = i + 1; j < input.length ; j++ ){
                if(k - input[i] == input[j]) {
                    pairs.add(new Pair(i,j));
                }
            }
        }
        System.out.println(pairs.size());
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 5, 7, -1};
        countDistinctPairsWithSum(input,6);
        input = new int[]{1, 5, 7, -1, 5};
        countDistinctPairsWithSum(input,6);
        input = new int[]{1, 1, 1, 1};
        countDistinctPairsWithSum(input,2);
        input = new int[]{10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1};
        countDistinctPairsWithSum(input,11);
    }

}
