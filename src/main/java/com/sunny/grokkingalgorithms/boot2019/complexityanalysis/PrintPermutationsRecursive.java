package com.sunny.grokkingalgorithms.boot2019.complexityanalysis;

public class PrintPermutationsRecursive {


    public static void printPermutationsRecursive(char[] input,boolean[] consideredCharacters,
                                                  char[] perm,int index){
        if(index == input.length){
            System.out.println(perm);
            return;
        }
        for(int i = 0 ; i < input.length; i++){
            if(!consideredCharacters[input[i] - 'a']) {
                consideredCharacters[input[i] - 'a'] = true;
                perm[index] = input[i];
                printPermutationsRecursive(input, consideredCharacters, perm, index + 1);
                consideredCharacters[input[i] - 'a'] = false;
            }
        }
    }


    public static void main(String[] args) {
        char[] input = new char[]{'a','b','c','d'};
        boolean[] consideredCharacters = new boolean[256];
        char[] perm = new char[input.length];
        printPermutationsRecursive(input,consideredCharacters,perm,0);
    }

}
