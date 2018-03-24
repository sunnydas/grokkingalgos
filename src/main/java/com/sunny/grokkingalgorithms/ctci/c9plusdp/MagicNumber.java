package com.sunny.grokkingalgorithms.ctci.c9plusdp;

/**
 * Created by sundas on 3/24/2018.
 */
public class MagicNumber {

  /*
  Given a sorted array find a number such that a[i] = i.
   */

  /**
   *
   * @param input
   * @param start
   * @param end
   * @return
   */
  public static int findMagicNumberRecursive(int[] input,int start,int end){
    if(start < 0 || end >= input.length || start > end ){
      return Integer.MIN_VALUE;
    }
    int mid = start + (end - start)/2;
    if(input[mid] == mid){
      return mid;
    }
    else if(input[mid] < mid){
      return findMagicNumberRecursive(input, mid + 1, end);
    }
    else{
      return findMagicNumberRecursive(input, start, mid - 1);
    }
  }


  /**
   *
   * @param input
   * @return
   */
  public static int findAMagicNumber(int[] input){
    int magicNumber = Integer.MIN_VALUE;
    int low = 0;
    int high = input.length - 1;
    while(low <= high){
      int mid = low + (high - low)/2;
      /*
      Found
       */
      if(input[mid] == mid){
        magicNumber = input[mid];
        break;
      }
      /*
      The value is greater than index go left
       */
      else if(input[mid] > mid){
        high = mid - 1;
      }
      /*
      Go right
       */
      else if(input[mid] < mid){
        low = mid + 1;
      }
    }
    return magicNumber;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int[] input = new int[]{-1,0,1,3,7};
    System.out.println(findAMagicNumber(input));
    input = new int[]{0,1,2,3,7};
    System.out.println(findAMagicNumber(input));
    input = new int[]{0,2,4,8,7};
    System.out.println(findAMagicNumber(input));
    input = new int[]{-1,2,4,8,7};
    System.out.println(findAMagicNumber(input));
    input = new int[]{-3,-2,-1,0,4};
    System.out.println(findAMagicNumber(input));
    System.out.println("recursive");
    input = new int[]{-1,0,1,3,7};
    System.out.println(findMagicNumberRecursive(input, 0, input.length - 1));
    input = new int[]{0,1,2,3,7};
    System.out.println(findMagicNumberRecursive(input, 0, input.length - 1));
    input = new int[]{0,2,4,8,7};
    System.out.println(findMagicNumberRecursive(input, 0, input.length - 1));
    input = new int[]{-1,2,4,8,7};
    System.out.println(findMagicNumberRecursive(input, 0, input.length - 1));
    input = new int[]{-3,-2,-1,0,4};
    System.out.println(findMagicNumberRecursive(input,0,input.length-1));
  }

}
