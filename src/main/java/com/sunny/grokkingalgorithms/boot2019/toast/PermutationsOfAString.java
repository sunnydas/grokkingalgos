package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfAString {

    public static void permutations(String s,String perm){
        if(s.length() == 0){
            System.out.println(perm);
            return;
        }
        for(int i = 0; i < s.length() ; i++){
            char current = s.charAt(i);
            String rest = s.substring(0,i) + s.substring(i+1);
            permutations(rest,perm + current);
        }
    }

    public static void main(String[] args) {
        String s = "123";
        permutations(s,"");
    }

}
