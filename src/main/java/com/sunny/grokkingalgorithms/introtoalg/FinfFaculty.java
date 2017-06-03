package com.sunny.grokkingalgorithms.introtoalg;

/**
 * Created by sundas on 6/3/2017.
 */
public class FinfFaculty {


  public static int findFaculty(int n){
    if(n == 1){
      return 1;
    }
    if(n == 0){
      return 0;
    }
    if(n < 0){
      throw new IllegalArgumentException("Negative number s not supported");
    }
    return n*findFaculty(n-1);
  }

  public static void main(String[] args) {
    System.out.println(findFaculty(8));
  }
}
