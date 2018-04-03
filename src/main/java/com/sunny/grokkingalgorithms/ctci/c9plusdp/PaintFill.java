package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import com.sunny.grokkingalgorithms.ctci.c9plusdp.utils.Colors;

/**
 * Created by sundas on 4/3/2018.
 */

public class PaintFill {

 /*
 Given a grid represented by 2d matrix which has its own color sche. You are given a point on the matrix, you have to
 paint the surrounding areas with a new color until we hit a non original color. Better way to explain is by an xample:

      RED    RED   RED   YELLOW
      GREEN GREEN GREEN  YELLOW
      GREEN GREEN GREEN  YELLOW
      RED   RED   RED    RED
      point = 2,2 ,original color = GREEN new color = RED
      RED    RED   RED   YELLOW
      RED    RED   RED  YELLOW
      RED    RED   RED  YELLOW
      RED    RED    RED    RED
  */

  /**
   *
   * @param matrix
   * @param pI
   * @param pJ
   * @param oColor
   * @param nColor
   */
  public static void paintFill(Colors[][] matrix,int pI,int pJ,
                               Colors oColor,Colors nColor){
    /*
    Boundary conditions
     */
    if(pI < 0 || pJ < 0 || pI > matrix.length || pJ > matrix.length || !matrix[pI][pJ].equals(oColor)){
      return;
    }
    matrix[pI][pJ] = nColor;
    paintFill(matrix,pI-1,pJ,oColor,nColor);
    paintFill(matrix,pI+1,pJ,oColor,nColor);
    paintFill(matrix,pI,pJ-1,oColor,nColor);
    paintFill(matrix,pI,pJ+1,oColor,nColor);
    paintFill(matrix,pI-1,pJ-1,oColor,nColor);
    paintFill(matrix,pI+1,pJ+1,oColor,nColor);
    paintFill(matrix,pI-1,pJ+1,oColor,nColor);
    paintFill(matrix,pI+1,pJ-1,oColor,nColor);
  }



  public static void printGrid(Colors[][] grid){
    for(int i = 0 ; i < grid.length ; i++){
      for(int j = 0 ; j < grid[i].length ; j++){
        System.out.print(grid[i][j] + " ");
      }
      System.out.println();
    }
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Colors[][] colors = new Colors[][]{
        {Colors.RED,    Colors.RED,   Colors.RED,   Colors.YELLOW},
        {Colors.GREEN, Colors.GREEN, Colors.GREEN,  Colors.YELLOW},
        {Colors.GREEN, Colors.GREEN, Colors.GREEN,  Colors.YELLOW},
        {Colors.RED,   Colors.RED,   Colors.RED,    Colors.RED}
    };
    printGrid(colors);
    System.out.println();
    paintFill(colors, 2, 2, Colors.GREEN, Colors.RED);
    printGrid(colors);
  }
}
