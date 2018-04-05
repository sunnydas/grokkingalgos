package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import com.sunny.grokkingalgorithms.ctci.c1.MatrixRotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sundas on 4/4/2018.
 */
class ChessPoint{
  int i;
  int j;

  @Override
  public String toString() {
    return "ChessPoint{" +
        "i=" + i +
        ", j=" + j +
        '}';
  }
}
public class EightQueensProblem {

  /*
  Given an 8X8 chessboard we need to place the queens in positions such the no two queens are on the
  same row, same column or same diagonal
   */

  /**
   *
   * @param n
   */
  public static void solveNQueens(int n){
    /*
    The position array gets overwritten so we do not need to clear explicitly
     */
    ChessPoint[] chessPoints = new ChessPoint[n];
    boolean solutionExists = solveNQueensUtil(n,0,chessPoints);
    if(solutionExists){
      Arrays.stream(chessPoints).forEach(position -> System.out.println(position.i + " " + position.j));
    }
  }

  /**
   *
   * @param n
   * @param row
   * @param points
   * @return
   */
  public static boolean solveNQueensUtil(int n,int row,ChessPoint[] points){
    if(n == row) {
      return true;
    }
    for(int i = 0 ; i < n ; i++){
      ChessPoint point = new ChessPoint();
      point.i = row;
      point.j = i;
      if(isSafe(points,point)){
        points[row] = point;
        boolean solutionExists = solveNQueensUtil(n,row+1,points);
        if(solutionExists){
          return true;
        }
      }
    }
    return false;
  }

  /**
   *
   * @param points
   * @param current
   * @return
   */
  public static boolean isSafe(ChessPoint[] points,ChessPoint current){
    boolean safe = true;
    /*
    Only check before the current row
     */
    /*
    Important formula
     */
    for(int q = 0; q < current.i ; q++){
      if(points[q].j == current.j || points[q].i - points[q].j == current.i - current.j || points[q].i + points[q].j
          == current.i + current.j){
        safe = false;
        break;
      }
    }
    return safe;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    solveNQueens(8);
  }
}
