package com.sunny.grokkingalgorithms.ctci.c9plusdp;

import java.util.ArrayList;
import java.util.List;

class Point{
  int x;
  int y;

  @Override
  public String toString() {
    return "Point{" +
        "x=" + x +
        ", y=" + y +
        '}';
  }
}
/**
 * Created by sundas on 3/23/2018.
 */
public class RobotTraversal {

  /*
  A robot can move down or right , find number of ways it can reacha  point (x,y) fro (0,0)
   */

  public static boolean findPathFromBottomLeftToTopRight(int[][] matrix,List<Point> paths,int x,int y){
    if(x == 0 && y == 0){
      Point point = new Point();
      point.x = x;
      point.y = y;
      paths.add(point);
      return true;
    }
    boolean success = false;
    /*
    Go left
     */
    if(x >= 0 && y-1 >= 0 && isFree(matrix,x,y)){
      Point point = new Point();
      point.x = x;
      point.y = y;
      paths.add(point);
      success = findPathFromBottomLeftToTopRight(matrix,paths,x,y-1);
      if(!success){
        paths.remove(point);
      }
    }
    /*
    Go up
     */
    if(!success && x-1 >= 0 && y >= 0 && isFree(matrix,x,y)){
      Point point = new Point();
      point.x = x;
      point.y = y;
      paths.add(point);
      success = findPathFromBottomLeftToTopRight(matrix,paths,x-1,y);
      if(!success){
        paths.remove(point);
      }
    }
    return success;
  }

  /**
   *
   * @param matrix
   * @param x
   * @param y
   * @return
   */
  public static int countWaysToReachXY(int[][] matrix,int x,int y){
    int count = 0;
    count = countWaysRecursive(matrix,x,y,0,0);
    return count;
  }

  public static int countWaysRecursive(int[][] matrix,int x,int y,int i,int j){
    if(i >= matrix.length){
      return 0;
    }
    else if(j >= matrix[i].length){
      return 0;
    }
    if(i == x && j == y){
      return 1;
    }
    int count = 0;
    /*
    Go right
     */
    if(i < matrix.length && j+1 < matrix[i].length){
       count = countWaysRecursive(matrix,x,y,i,j+1);
    }
    /*
    Go down
     */
    if(i+1 < matrix.length && j < matrix[i].length){
      count += countWaysRecursive(matrix,x,y,i+1,j);
    }
    return count;
  }


  /**
   *
   * @param matrix
   */
  public static List<String> findPathFromTopLevelToBottomLevelWithCertainCellsOffLimits(int[][] matrix){
    /*
    Certain paths are offlimits denoted by 1s
     */
    List<String> paths = new ArrayList<>();
    findPathsFromTopToBottomRecursive(matrix,paths,"",0,0);
    return paths;
  }

  /**
   *
   * @param matrix
   * @param paths
   */
  public static void findPathsFromTopToBottomRecursive(int[][] matrix,List<String> paths,String path,int x, int y){
    if(x == (matrix.length - 1) && y == (matrix[x].length - 1)){
      /*
      Path found
       */
      path += "-> " + x+" "+ y + " ";
      paths.add(path);
    }
    path += "-> " + x+" "+ y + " ";
    /*
    Go right
     */
    if(x < matrix.length && y+1 < matrix[x].length && isFree(matrix,x,y+1)){
      findPathsFromTopToBottomRecursive(matrix,paths,path,x,y+1);
    }
    /*
    Go down
     */
    if(x+1 < matrix.length && y < matrix[x].length && isFree(matrix,x+1,y)){
      findPathsFromTopToBottomRecursive(matrix,paths,path,x+1,y);
    }
  }

  /**
   *
   * @param matrix
   * @param x
   * @param y
   * @return
   */
  public static boolean isFree(int[][] matrix,int x, int y){
    boolean free = matrix[x][y] == 0;
    return free;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] robotPath = new int[][]{
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0},
        {0,0,0,0}
    };
    System.out.println(countWaysToReachXY(robotPath,2,3));
    robotPath = new int[][]{
        {0,1,0,0},
        {0,1,0,0},
        {0,0,1,0},
        {0,0,0,0}
    };
    System.out.println(findPathFromTopLevelToBottomLevelWithCertainCellsOffLimits(robotPath));
    List<Point> paths = new ArrayList<>();
    boolean found = findPathFromBottomLeftToTopRight(robotPath, paths,robotPath.length - 1,
        robotPath[0].length - 1);
    System.out.println(found);
    System.out.println(paths);
  }
}
