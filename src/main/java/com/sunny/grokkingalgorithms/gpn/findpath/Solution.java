package com.sunny.grokkingalgorithms.gpn.findpath;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

  static long maxSum = Long.MIN_VALUE;

  /*
   * Complete the function below.
   */
  static long journey(int[] path, int k) {
    calculateSumRecursive(path,k,0,0);
    return maxSum;
  }

  static long calculateSumRecursive(int[] path,int k,int curIndex,long curSum){
    if(curIndex == (path.length - 1)){
      curSum += path[curIndex];
      if(curSum > maxSum){
        maxSum = curSum;
      }
      return curSum;
    }
    else if(curIndex >= path.length){
      return Long.MIN_VALUE;
    }
    else{
      curSum += path[curIndex];
      int loopIndex = 1;
      while(loopIndex <= k){
        calculateSumRecursive(path,k,(curIndex+loopIndex),curSum);
        loopIndex++;
      }
    }
    return curSum;
  }

  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = null;
    if (fileName != null) {
      bw = new BufferedWriter(new FileWriter(fileName));
    }
    else {
      bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    long res;
    int path_size = 0;
    path_size = Integer.parseInt(in.nextLine().trim());

    int[] path = new int[path_size];
    for(int i = 0; i < path_size; i++) {
      int path_item;
      path_item = Integer.parseInt(in.nextLine().trim());
      path[i] = path_item;
    }

    int k;
    k = Integer.parseInt(in.nextLine().trim());

    res = journey(path, k);
    bw.write(String.valueOf(res));
    bw.newLine();

    bw.close();
  }
}
