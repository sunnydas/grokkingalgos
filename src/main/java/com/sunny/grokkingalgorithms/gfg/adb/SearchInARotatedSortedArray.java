package com.sunny.grokkingalgorithms.gfg.adb;

/**
 * Created by sundas on 5/4/2018.
 */
public class SearchInARotatedSortedArray {

  /*
  Given a sorted and rotated array (rotated at some point) A[ ], and given an element K, the task is to find the index of the given element K in the array A[ ]. The array has no duplicate elements. If the element does not exist in the array, print -1.


Input:
The first line of the input contains an integer T, depicting the total number of test cases. Then T test cases follow. Each test case consists of three lines. First line of each test case contains an integer N denoting the size of the given array. Second line of each test case contains N space separated integers denoting the elements of the array A[ ]. Third line of each test case contains an integer K denoting the element to be searched in the array.


Output:

Corresponding to each test case, print in a new line, the index of the element found in the array.  If element is not present, then print -1.


Constraints:

1 ? T ? 100
1 ? N ? 100005
0 ? A[i] ? 10000005
1 ? k ? 100005


Example:

Input
3
9
5 6 7 8 9 10 1 2 3
10
3
3 1 2
1
4
3 5 1 2
6


Output
5
1
-1
   */


  /**
   *
   * @param input
   * @param k
   * @return
   */
  public static int searchInARotatedArray(int[] input,int k){
    int found = -1;
    /*
    Find rotation point
    doesnt consider the fact that rotation point could be the required index
     */
    int rotationPoint = findRotationPoint(input,0,input.length - 1);
    //System.out.println(rotationPoint);
    /*
    Found rotation point
     */
    if(rotationPoint < 0){
      rotationPoint = 0;
    }
    /*
    Use binary search to search in both sides of rotation point
     */
    //System.out.println(rotationPoint);
    found = binarySearch(input,0,rotationPoint - 1,k);
    if(found < 0){
      found = binarySearch(input,rotationPoint,input.length - 1,k);
    }
    return found;
  }

  public static int binarySearch(int[] input,int start,int end,int k){
    if(start >=  end){
      if(start == end && input[start] == k){
        return start;
      }
      return -1;
    }
    int mid = start + (end - start)/2;
    if(input[mid] == k){
      return mid;
    }
    else if(input[mid] < k){
      return binarySearch(input,mid+1,end,k);
    }
    else{
      return binarySearch(input,start,mid,k);
    }
  }

  /**
   *
   * @param input
   * @param  end
   * @param  start
   * @return
   */
  public static int findRotationPoint(int[] input,int start,int end){
    if(start >= end){
      return -1;
    }
    int mid = start + (end - start)/2;
    if(mid - 1 >= 0 && input[mid] < input[mid - 1]){
      return mid;
    }
    int rotationPoint = findRotationPoint(input,start,mid);
    if(rotationPoint < 0){
      rotationPoint = findRotationPoint(input,mid+1,end);
    }
    return rotationPoint;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[]  input = new int[]{5 ,6 ,7 ,8 ,9 ,10 ,1 ,2 ,3};
    int k = 10;
    System.out.println(searchInARotatedArray(input,k));
    input = new int[]{5,1,2,3,4};
    k = 4;
    System.out.println(searchInARotatedArray(input,k));
    input = new int[]{3,1,2};
    k = 1;
    System.out.println(searchInARotatedArray(input,k));
    input = new int[]{3,5,1,2};
    k = 5;
    System.out.println(searchInARotatedArray(input,k));
  }

}
