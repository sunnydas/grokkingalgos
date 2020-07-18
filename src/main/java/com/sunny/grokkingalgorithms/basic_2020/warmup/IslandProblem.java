package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Grid2dPoint{
    private int x;

    public Grid2dPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    private int y;


    @Override
    public String toString() {
        return "Grid2dPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid2dPoint that = (Grid2dPoint) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
public class IslandProblem {

    /*
    https://leetcode.com/problems/number-of-islands/

    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1
Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
     */

    /*
    backup

    /*Set<Grid2dPoint> partOfAlreadyConsideredIsland = new HashSet<>();
        //System.out.println(getNumberOfIslands(matrix,0,0,partOfAlreadyConsideredIsland,0));
        getNumberOfIslands(matrix,0,0,partOfAlreadyConsideredIsland);
        System.out.println("count = " + count);
        matrix = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        count = 0;
        partOfAlreadyConsideredIsland = new HashSet<>();
        getNumberOfIslands(matrix,0,0,partOfAlreadyConsideredIsland);
        System.out.println("count = " + count);
        matrix = new char[][]{
                {'1', '1', '0', '0', '1'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'0', '0', '0', '1', '0'}
        };
        count = 0;
        partOfAlreadyConsideredIsland = new HashSet<>();
        getNumberOfIslands(matrix,0,0,partOfAlreadyConsideredIsland);
        //System.out.println(partOfAlreadyConsideredIsland);
        System.out.println("count = " + count);
        for(int i = 0 ; i < matrix.length ;i++){
            for(int j = 0; j < matrix[i].length ; j++){
                if(matrix[i][j] == '1' && !partOfAlreadyConsideredIsland.
                        contains(new Grid2dPoint(i,j))) {
                    System.out.print("x ");
                }else{
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
        printMatrix(matrix);*/



    public static void printMatrix(char[][] matrix){
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int getNumberOfIslands(char[][] grid){
        int count = 0;
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[i].length ; j++){
                if(grid[i][j] == '1'){
                    count++;
                    merge(grid,i,j);
                }
            }
        }
        return count;
    }

    private static void merge(char[][] grid,int i,int j){
        if(i >= grid.length || i < 0 || j >= grid[i].length || j < 0 || grid[i][j] != '1'){
            return;
        }
        grid[i][j] = 'X';
        merge(grid,i+1,j);
        merge(grid,i-1,j);
        merge(grid,i,j+1);
        merge(grid,i,j-1);
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
                };
        System.out.println(getNumberOfIslands(matrix));
    }


}
