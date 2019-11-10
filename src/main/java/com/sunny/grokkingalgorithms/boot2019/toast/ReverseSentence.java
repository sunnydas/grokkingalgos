package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.Scanner;

public class ReverseSentence {

    /*
    Sample Input

I am an Indian

Sample Output

Indian an am I
     */

    public static String reverseSentence(String line){
        StringBuilder reversed = new StringBuilder();
        String[] splitted = line.split("\\s+");
        String[] spaces = line.split("\\w+|\\p{Punct}");
        int j = 0;
        for(int i = splitted.length - 1 ; i >= 0 ; i--){
            reversed.append(splitted[i]);
            reversed.append(" ");
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(reverseSentence(line));
    }

}
