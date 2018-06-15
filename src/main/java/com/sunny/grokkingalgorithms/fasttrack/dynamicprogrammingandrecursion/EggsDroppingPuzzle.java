package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/15/2018.
 */
public class EggsDroppingPuzzle {

  /*
  We are given n floors and x eggs , find minimum number of egg droppings
  to determine the floor from which a egg will break
   */

  /**
   *
   * @param n
   * @param x
   * @return
   */
  public static int getMinNumberOfDroppings(int n,int x){
    //System.out.println(n + x);
    if(n == 0){
      return 0;
    }
    if(n == 1){
      return 1;
    }
    if(x == 1){
      return n;
    }
    int min = 1000;
    for(int p = 1; p <= n; p++){
      int temp = 1 + Math.max(getMinNumberOfDroppings(p - 1,x - 1),
          getMinNumberOfDroppings(n - p,x));
      if(temp < min){
        min = temp;
      }
    }
    return min;
  }

  public int calculateRecursive(int eggs, int floors){
    if(eggs == 1){
      return floors;
    }
    if(floors == 0){
      return 0;
    }
    int min = 1000;
    for(int i=1; i <= floors; i++){
      int val = 1 + Math.max(calculateRecursive(eggs-1, i-1),calculateRecursive(eggs, floors-i));
      if(val < min){
        min = val;
      }
    }
    return min;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int n = 10;
    int x = 3;
    System.out.println(getMinNumberOfDroppings(n,x));
  }
}
