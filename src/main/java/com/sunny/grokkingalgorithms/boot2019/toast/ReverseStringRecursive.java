package com.sunny.grokkingalgorithms.boot2019.toast;

public class ReverseStringRecursive {

    public static String reverse(String s){
        if(s.isEmpty()){
            return "";
        }
        String sub = s.substring(1);
        String reversed = reverse(sub);
        return  reversed + s.charAt(0);
    }

    public static void main(String[] args) {
        System.out.println(reverse("hello world"));
    }
}
