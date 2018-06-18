package com.sunny.grokkingalgorithms.fasttrack;

/**
 * Created by sundas on 6/17/2018.
 */
public class Poweroftwo {

  public static void main(String[] args) {

    int a = 3;
    while(a != 1){
      if(a %2 == 0){
        System.out.println("true");
        break;
      }
      a = a/2;
    }

    a = 4;
    int x = a&(a - 1);
    System.out.println(x == 0);
  }
}
