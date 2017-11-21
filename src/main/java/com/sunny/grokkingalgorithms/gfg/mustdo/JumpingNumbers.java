package com.sunny.grokkingalgorithms.gfg.mustdo;

import java.util.*;

/**
 * Created by sundas on 11/20/2017.
 */
public class JumpingNumbers {

  //http://practice.geeksforgeeks.org/problems/jumping-numbers/0

  /**
   *
   * @param x
   */
  public static void printJumpingNumbers(int x){
    //Find number of digits in x
    int numberOfDigits = String.valueOf(x).length();
    //System.out.println(numberOfDigits);
    /*
    We recursively find digits and add them and try to find jumping numbers
     */
    String curStr = "";
    /*
    Print zero as default value
     */
    List<Integer> jumpingNumbersList = new ArrayList<>();
    jumpingNumbersList.add(0);
    jumpingNumbersList = populateJumpingNumbersRecursive(curStr, numberOfDigits, x);
    Comparator<Integer> mostSignificantDigitComparator  = new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {

        if(getFirstDigit(o1) < getFirstDigit(o2)){
          return -1;
        }
        else if(getFirstDigit(o1) > getFirstDigit(o2)){
          return 1;
        }
        else if(getFirstDigit(o1) == getFirstDigit(o2)){
          /*
          Important case
           */
          return (o1 - o2);
        } else{
          return 0;
        }
      }
    };
    Collections.sort(jumpingNumbersList,mostSignificantDigitComparator);
    for(int jumpingNumber : jumpingNumbersList){
      System.out.print(jumpingNumber);
      System.out.print(" ");
    }
  }

  /**
   *
   * @param n
   * @return
   */
  public static int getFirstDigit(int n) {
    while (n < -9 || 9 < n) n /= 10;
    return Math.abs(n);
  }

  public static List<Integer> populateJumpingNumbersRecursive(String curStr,int depth,int x){
    if(depth <= 0){
      return null;
    }
    List<Integer> jumpingNumbersList = new ArrayList<>();
    //List<Integer> childJumpingNumbers = new ArrayList<>();
    for(int i = 0 ; i <= 9 ; i++){
      String curNum = curStr + i;
      // We donot care about values with Zeor as most significant number.
      if(curNum.length() > 1 && curNum.charAt(0) == '0'){
        continue;
      }
      //System.out.println(curNum);
      int num = Integer.valueOf(curNum);
      if(num > x){
        return jumpingNumbersList;
      }
      if(isJumpingNumber(curNum)){
       jumpingNumbersList.add(num);
      }
      List<Integer> curChildJumpingNumberList = populateJumpingNumbersRecursive(curNum,(depth-1),x);
      if(curChildJumpingNumberList != null){
        jumpingNumbersList.addAll(curChildJumpingNumberList);
      }
    }
    //jumpingNumbersList.addAll(childJumpingNumbers);
    return jumpingNumbersList;
  }

  /**
   *
   * @param num
   * @return
   */
  public static boolean isJumpingNumber(String num){
    boolean jumpingNumber = false;
    int index = 0;
    boolean cond = true;
    while(index < num.length()){
      if(index > 0){
        int prev = Character.getNumericValue(num.charAt(index-1));
        int current = Character.getNumericValue(num.charAt(index));
        if((Math.abs(current - prev) != 1)
            && (((index + 1) > (num.length() - 1))
            || Math.abs(current - num.charAt(index+1)) != 1)){
          cond = false;
          break;
        }
      }
      index++;
    }
    if(cond){
      jumpingNumber = true;
    }
    return jumpingNumber;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    /*
    1
     89384
     */
    Scanner scanner = new Scanner(System.in);
    int numberOfTestCases = scanner.nextInt();
    for(int i = 0 ; i < numberOfTestCases ;i++){
      printJumpingNumbers(scanner.nextInt());
      System.out.println();
    }
  }
}
