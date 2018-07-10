package com.sunny.grokkingalgorithms.fasttrack.week4;

import java.util.HashSet;
import java.util.Set;

class Cell{
  int i;

  @Override
  public String toString() {
    return "Cell{" +
        "i=" + i +
        ", j=" + j +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Cell cell = (Cell) o;

    if (i != cell.i) return false;
    return j == cell.j;

  }

  @Override
  public int hashCode() {
    int result = i;
    result = 31 * result + j;
    return result;
  }

  int j;
}
/**
 * Created by sundas on 7/10/2018.
 */
public class FloodFill {

  /*
  Given a 2d marix with colors , find block with
  most grids of same color
 .
 In the example the count should be six
   */

  /**
   *
   * @param grid
   * @return
   */
  public static int findMaxCountWithColor(String[][] grid){
    int maxSize = -1;
    for(int i = 0 ; i < grid.length ; i++){
      for(int j = 0 ; j < grid[i].length ; j++){
        int size = findSize(grid,i,j,new HashSet<>(),grid[i][j]);
        if(size > maxSize){
          maxSize = size;
        }
      }
    }
    return maxSize;
  }

  /**
   *
   * @param grid
   * @param i
   * @param j
   * @param set
   * @param prevColor
   * @return
   */
  public static int findSize(String[][] grid,int i,int j,
                             Set<Cell> set,String prevColor){
    Cell cell = new Cell();
    cell.i = i;
    cell.j = j;
    if(i >= grid.length || j >= grid.length || i < 0 || j < 0){
      return 0;
    }
    if(set.contains(cell)){
      return 0;
    }
    if(!grid[i][j].equals(prevColor)){
      return 0;
    }
    set.add(cell);
    int sizeU = findSize(grid,i-1,j,set,prevColor);
    int sizeD = findSize(grid,i+1,j,set,prevColor);
    int sizeL = findSize(grid,i,j - 1,set,prevColor);
    int sizeR = findSize(grid,i,j + 1,set,prevColor);
    int sizeNE = findSize(grid,i - 1,j + 1,set,prevColor);
    int sizeSE = findSize(grid,i + 1,j + 1,set,prevColor);
    int sizeNW = findSize(grid,i - 1,j - 1,set,prevColor);
    int sizeSW = findSize(grid,i + 1,j - 1,set,prevColor);
    return (sizeU + sizeD + sizeL + sizeR + sizeNE + sizeSE + sizeNW + sizeSW + 1);
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String[][] grid = new String[][]{
        {"RED","BLACK","BLUE","RED"},
        {"RED","WHITE","BLACK","WHITE"},
        {"WHITE","BLACK","RED","BLACK"},
        {"RED","BLACK","BLACK","BLACK"}
    };
    System.out.println(findMaxCountWithColor(grid));
  }
}
