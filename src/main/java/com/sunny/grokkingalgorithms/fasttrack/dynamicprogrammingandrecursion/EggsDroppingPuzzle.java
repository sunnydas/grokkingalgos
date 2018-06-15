package com.sunny.grokkingalgorithms.fasttrack.dynamicprogrammingandrecursion;

/**
 * Created by sundas on 6/15/2018.
 */
public class EggsDroppingPuzzle {

  static int[][] eggsDropCache;

  /**
   *
   * @param n
   * @param x
   * @return
   */
  public static int getMinNumberOfDroppingsMemoized(int n,int x){
    //System.out.println(n + x);
    if(eggsDropCache[n][x] >= 0){
      return eggsDropCache[n][x];
    }
    if(n == 0 || n == 1 || x == 1){
      eggsDropCache[n][x] = n;
      return eggsDropCache[n][x];
    }

    int min = 1000;
    for(int p = 1; p <= n; p++){
      int temp = 1 + Math.max(getMinNumberOfDroppingsMemoized(p - 1,x - 1),
          getMinNumberOfDroppingsMemoized(n - p,x));
      if(temp < min){
        min = temp;
      }
    }
    eggsDropCache[n][x] = min;
    return min;
  }

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
    int n = 100;
    int x = 2;
    //System.out.println(getMinNumberOfDroppings(n,x));
    eggsDropCache = new int[n+1][x+1];
    for(int i = 0 ; i < eggsDropCache.length ; i++){
      for(int j = 0 ; j < eggsDropCache[i].length ; j++){
        eggsDropCache[i][j] = -1;
      }
    }
    System.out.println(getMinNumberOfDroppingsMemoized(n,x));
  }
}
