package com.sunny.grokkingalgorithms.fasttrack.week3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Predicate;

enum PrevDir{
  vert,
  hor,
  none
}
/**
 * Created by sundas on 7/7/2018.
 */
class PH{
  int i;
  int j;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    PH ph = (PH) o;

    if (getI() != ph.getI()) return false;
    return getJ() == ph.getJ();

  }

  @Override
  public int hashCode() {
    int result = getI();
    result = 31 * result + getJ();
    return result;
  }

  @Override

  public String toString() {
    return "PH{" +
        "i=" + i +
        ", j=" + j +
        '}';
  }

  public int getI() {
    return i;
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
public class FindPathInAGrid {

  /*
  . means allow
  x means not allow
  we can reach any point (x,y) if there
  is a straight line without any X.
  Calculate minimum steps.
  In the example minsteps = 3

  char[][] grid = new char[][]{
        {'.','X','.'},
        {'.','X','.'},
        {'.','.','.'},
    };

   */

  private static Set<PH> consideredIndex = new HashSet<>();

  private static Set<PH> path = new LinkedHashSet<>();
  /**
   *
   * @param grid
   * @param a
   * @param b
   * @param c
   * @param d
   * @param i
   * @param j
   * @return
   */
  public static int minSteps(char[][] grid,int a,int b,
                             int c,int d,
  int i,int j){
    PH ph = new PH();
    ph.i = i;
    ph.j = j;
    if(consideredIndex.contains(ph)){
      return Integer.MAX_VALUE;
    }
    if(i == c && j == d){
      path.add(ph);
      return 1;
    }
    if(i >= grid.length || j >= grid.length
        || i < 0 || j < 0){
      return Integer.MAX_VALUE;
    }
    if(grid[i][j] == 'X'){
      return Integer.MAX_VALUE;
    }
    consideredIndex.add(ph);
    int minSteps = Integer.MAX_VALUE;
    int minStepsR = minSteps(grid, a, b, c, d, i, j + 1);
    int minStepsD = minSteps(grid, a, b, c, d, i + 1, j);
    int minStepsU = minSteps(grid,a,b,c,d,i - 1,j);
    int minStepsL = minSteps(grid,a,b,c,d,i,j - 1);
    minSteps = Math.min(Math.min(Math.min(minStepsR,minStepsD),
        minStepsU),minStepsL) + 1;
    path.add(ph);
    return minSteps;
  }

  /**
   *
   * @param grid
   * @param path
   * @return
   */
  public static int
  normalizeMinSteps(char[][] grid,Set<PH> path){
    int normalizedSteps = path.size();
    Iterator<PH> iterator = path.iterator();
    int prevI = -1;
    int prevJ = -1;
    PrevDir dir = PrevDir.none;
    while(iterator.hasNext()){
      PH ph = iterator.next();
      if(prevI >= 0 && prevJ >= 0){
        PrevDir temp =  dir;
        if(ph.i == prevI){
          dir = PrevDir.hor;
        }
        if(ph.j == prevJ){
          dir = PrevDir.vert;
        }
        if(temp != PrevDir.none && !dir.equals(temp)){
          prevI = ph.i;
          prevJ = ph.j;
          continue;
        }
        if(ph.i != prevI
            && ph.j == prevJ){
          normalizedSteps--;
        }
        else if(ph.i == prevI
            && ph.j != prevJ){
          normalizedSteps--;
        }
      }
      prevI = ph.i;
      prevJ = ph.j;
    }
    return normalizedSteps;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    char[][] grid = new char[][]{
        {'.','X','.'},
        {'.','X','.'},
        {'.','.','.'},
    };
    System.out.println(minSteps(grid,0,0,0,2,0,0));
    System.out.println(path);
    System.out.println(normalizeMinSteps(grid,path));
  }

}
