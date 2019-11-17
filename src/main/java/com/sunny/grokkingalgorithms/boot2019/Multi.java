package com.sunny.grokkingalgorithms.boot2019;
public class Multi {

    public static void multiplicationTableIterative(int n){
        if(n > 0 && n <= 12){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    System.out.print((i*j));
                    System.out.print(" ");
                }
                System.out.println();
            }
        } else{
            throw new IllegalArgumentException("Invalid value for n = " + n);
        }
    }

    public static void multiplicationTableRecursive(int i,int j,int n){
        if(n <= 0 || n > 12){
            throw new IllegalArgumentException("Invalid value for n " + n);
        }
        if(i > n || j > n){
            return;
        }
        System.out.print((i*j));
        System.out.print(" ");
        multiplicationTableRecursive(i,j+1,n);
        if(j == 1){
            System.out.println();
            multiplicationTableRecursive(i+1,j,n);
        }
    }


    public static void main(String[] args) {
        multiplicationTableIterative(12);
        System.out.println();
        multiplicationTableIterative(3);
        System.out.println();
        try {
            multiplicationTableIterative(14);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            multiplicationTableIterative(0);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        multiplicationTableRecursive(1,1,3);
        System.out.println();
        multiplicationTableRecursive(1,1,12);
        System.out.println();
        try {
            multiplicationTableRecursive(1, 1, 0);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        try {
            multiplicationTableRecursive(1, 1, 14);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
        multiplicationTableRecursive(1,1,4);
    }


}
