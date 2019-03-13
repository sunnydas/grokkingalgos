package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class PermutaionsOfAStringLoop {


    public static void printPermutations(char[] input){
        int count = 0;
        for(int i = 0 ; i < input.length ; i++){
            for(int j = 0 ; j < input.length ; j++){
                if(j == i){
                    continue;
                }
                for(int k = 0 ; k < input.length ; k++){
                    if(k == j || k == i){
                        continue;
                    }
                    for(int l = 0; l < input.length ; l++){
                        if(l == k || l == j || l == i){
                            continue;
                        }
                        System.out.print(input[i]);
                        System.out.print(input[j]);
                        System.out.print(input[k]);
                        System.out.print(input[l]);
                        System.out.println();
                        System.out.println(++count);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        char[] input = new char[]{'a','b','c','d'};
        printPermutations(input);
    }

}
