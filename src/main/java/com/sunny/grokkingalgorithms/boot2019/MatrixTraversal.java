package com.sunny.grokkingalgorithms.boot2019;

public class MatrixTraversal {

   public static void traverseMatrixRecursive(int[][]  matrix,int i,int j){
       if(i >= matrix.length || j >= matrix.length){
           return;
       }
       matrix[i][j] = i*j;
       System.out.print(matrix[i][j]);
       System.out.print(" ");
       traverseMatrixRecursive(matrix,i,j+1);
       if(j == 0){
           System.out.println();
           traverseMatrixRecursive(matrix,i+1,j);
       }
   }

    public static void main(String[] args) {
       int[][] matrix = new int[5][5];
       for(int i = 0 ; i < matrix.length ; i++){
           for(int j = 0; j < matrix[i].length ; j++){
               System.out.print(matrix[i][j]);
               System.out.print(" ");
           }
           System.out.println();
       }
        System.out.println("-------");
       traverseMatrixRecursive(matrix,0,0);
    }

}
