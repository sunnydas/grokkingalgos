package com.sunny.grokkingalgorithms.gfg.dp_learning;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by sundas on 5/12/2017.
 */
class IJPair{

  private int i;

  public IJPair(int i, int j) {
    this.i = i;
    this.j = j;
  }

  private int j;

  public int getI() {
    return i;
  }

  @Override
  public String toString() {
    return "IJPair{" +
        "i=" + i +
        ", j=" + j +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    IJPair ijPair = (IJPair) o;

    if (getI() != ijPair.getI()) return false;
    return getJ() == ijPair.getJ();

  }

  @Override
  public int hashCode() {
    int result = getI();
    result = 31 * result + getJ();
    return result;
  }

  public void setI(int i) {
    this.i = i;
  }

  public int getJ() {
    return j;
  }

  public void setJ(int j) {
    this.j = j;
  }
}
public class FindMinCostNavigating2DGrid {

  //http://www.geeksforgeeks.org/minimum-cost-path-left-right-bottom-moves-allowed/

  /**
   *
   * @param grid
   * @param srcRow
   * @param srcCol
   * @param targetRow
   * @param targetCol
   * @return
   */
  public static int findMinCostTo(int[][] grid, int srcRow, int srcCol,
                                  int targetRow, int targetCol, Set<IJPair> alreadyTraversetSet){
    int minCost = Integer.MAX_VALUE;
    if(srcRow == targetRow && srcCol == targetCol){
      //System.out.println(alreadyTraversetSet);
      return grid[srcRow][srcCol];
    }
    if(alreadyTraversetSet.contains(new IJPair(srcRow,srcCol))){
      return Integer.MAX_VALUE;
    }
    alreadyTraversetSet.add(new IJPair(srcRow,srcCol));
    //Traverse in all directions
    //up
    int cost = 0;
    if(srcRow - 1 >= 0 && srcCol <= grid[0].length - 1){
      cost = findMinCostTo(grid, srcRow - 1, srcCol, targetRow, targetCol, new LinkedHashSet<>(alreadyTraversetSet));
      if(cost != Integer.MAX_VALUE) {
        cost += grid[srcRow][srcCol];
        if (cost < minCost) {
          minCost = cost;
        }
      }
    }
    //down
    if(srcRow + 1 <= grid.length - 1 && srcCol <= grid[0].length - 1){
      cost = findMinCostTo(grid, srcRow + 1, srcCol, targetRow, targetCol, new LinkedHashSet<>(alreadyTraversetSet));
      if(cost != Integer.MAX_VALUE) {
        cost += grid[srcRow][srcCol];
        if (cost < minCost) {
          minCost = cost;
        }
      }
    }
    //right
    if(srcRow <= grid.length - 1 && srcCol + 1 <= grid[0].length - 1){
      cost = findMinCostTo(grid, srcRow, srcCol + 1, targetRow, targetCol, new LinkedHashSet<>(alreadyTraversetSet));
      if(cost != Integer.MAX_VALUE) {
        cost += grid[srcRow][srcCol];
        if (cost < minCost) {
          minCost = cost;
        }
      }
    }
    //left
    if(srcRow <= grid.length - 1 && srcCol - 1  >= 0){
      cost = findMinCostTo(grid, srcRow, srcCol - 1, targetRow, targetCol, new LinkedHashSet<>(alreadyTraversetSet));
      if(cost != Integer.MAX_VALUE) {
        cost += grid[srcRow][srcCol];
        if (cost < minCost) {
          minCost = cost;
        }
      }
    }
    //System.out.println(minCost);
    return minCost;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] grid = new int[][]{
        {31, 100, 65, 12, 18},
        {10, 13, 47, 157, 6},
        {100, 113, 174, 11, 33},
        {88, 124, 41, 20, 140},
        {99, 32, 111, 41, 20}
    };
    Set<IJPair> alreadyTraversedSet = new LinkedHashSet<>();
    System.out.println(findMinCostTo(grid, 0, 0, grid.length - 1, grid[0].length - 1, alreadyTraversedSet));
    alreadyTraversedSet = new LinkedHashSet<>();
    System.out.println(findMinCostTo(grid, 0, 0, 0, 1, alreadyTraversedSet));
  }
}
