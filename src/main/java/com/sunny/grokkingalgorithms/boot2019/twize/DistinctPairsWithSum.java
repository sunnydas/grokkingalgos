package com.sunny.grokkingalgorithms.boot2019.twize;

import java.util.*;

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
    public String toString() {
        return "Pair{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public int hashCode() {
        return (i + j);
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
            for(int j = 0; j < input.length ; j++ ){
                if(i != j) {
                    if (k - input[i] == input[j]) {
                        pairs.add(new Pair(input[i], input[j]));
                    }
                }
            }
        }
        System.out.println(pairs);
        System.out.println(pairs.size());
        int count = 0;
    }


    public static int countPairs(List<Integer> arr, long k) {
        // Write your code here
        Map<Integer,Integer> numFreqMap = new HashMap<>();
        for(Integer num : arr){
            if(numFreqMap.containsKey(num)){
                numFreqMap.put(num,numFreqMap.get(num) + 1);
            } else{
                numFreqMap.put(num,1);
            }
        }
        int count = 0;
        for(Integer num : arr){
            if(numFreqMap.containsKey(k - num)){
                count += numFreqMap.get(k - num);
                if(num == (k - num)){
                    count--;
                }
            }
        }
        return (count/2);
    }

    public static void countPairs(int[] input,int k){
        Map<Integer,Integer> numFreqMap = new HashMap<>();
        for(int i = 0 ; i < input.length ; i++){
            if(numFreqMap.containsKey(input[i])){
                numFreqMap.put(input[i],numFreqMap.get(input[i]) + 1);
            } else{
                numFreqMap.put(input[i],1);
            }
        }
        int count = 0;
        System.out.println(numFreqMap);
        for(int i = 0 ; i < input.length ; i++){
            if(numFreqMap.containsKey(k - input[i])){
                count += numFreqMap.get(k - input[i]);
                if(input[i] == (k - input[i])){
                    count--;
                }
            }
        }
        System.out.println(count/2);
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
        System.out.println();
        System.out.println();
        input = new int[]{1, 5, 7, -1};
        countPairs(input,6);
        input = new int[]{1, 5, 7, -1, 5};
        countPairs(input,6);
        input = new int[]{1, 1, 1, 1};
        countPairs(input,2);
        input = new int[]{10, 12, 10, 15, -1, 7, 6,
                5, 4, 2, 1, 1, 1};
        countPairs(input,11);
        System.out.println();
        input = new int[]{7,6,6,3,9,3,5,1,12};
        List<Integer> numbers = new ArrayList<>();
        numbers.add(7);
        numbers.add(6);
        numbers.add(6);
        numbers.add(3);
        numbers.add(9);
        numbers.add(3);
        numbers.add(5);
        numbers.add(1);
        numbers.add(12);
        System.out.println(countPairs(numbers,47));
        int[] ints = new int[]{5,7,9,13,11,6,6,3,3};
        countDistinctPairsWithSum(ints,12);
        ints = new int[]{1,3,46,1,3,9};
        countDistinctPairsWithSum(ints,47);
    }

}
