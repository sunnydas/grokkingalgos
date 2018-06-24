package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by sundas on 6/24/2018.
 */
public class MergeSortedStreamsAscending {

  /*
  Two streams of data in array, coming in ascending order.
  Copy them into master array in asc order.
  Merge k sorted arrays | Set 1
Given k sorted arrays of size n each,
merge them and print the sorted output.
Example:
Input:
k = 3, n =  4
arr[][] = { {1, 3, 5, 7},
            {2, 4, 6, 8},
            {0, 9, 10, 11}} ;
Output: 0 1 2 3 4 5 6 7 8 9 10 11
   */

  /**
   *
   * @param stream
   * @return
   */
  public static int[] sort(int[][] stream){
    /*
    1. Create an output array of size n*k.
2. Create a min heap of size k and insert 1st element in all the arrays into the heap
3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. If the array doesn’t have any more elements, then replace root with infinite.
     After replacing the root, heapify the tree.
     */
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int[] output = new int[stream.length*stream[0].length];
    for(int i = 0; i < stream.length ; i++){
      for(int j = 0 ; j < stream[i].length ; j++){
        heap.add(stream[i][j]);
      }
    }
    int index = 0;
    while(!heap.isEmpty()){
      output[index] = heap.poll();
      index++;
    }
    return output;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[][] input  = new int[][]{ {1, 3, 5, 7},
      {2, 4, 6, 8},
      {0, 9, 10, 11}} ;
    System.out.println(Arrays.toString(sort(input)));
  }
}
