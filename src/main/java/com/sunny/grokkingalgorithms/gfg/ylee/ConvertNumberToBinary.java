package com.sunny.grokkingalgorithms.gfg.ylee;

/**
 * Created by sundas on 5/15/2018.
 */
public class ConvertNumberToBinary {


  /**
   *
   * @param decimal
   * @return
   */
  public static String toBinary(int decimal){
    String binaryRep = null;
    StringBuilder binaryTemp = new StringBuilder();
    int dividend = decimal;
    int divisor = 2;
    while(dividend >= 2){
      int quotient = dividend/divisor;
      int remainder = dividend%divisor;
      binaryTemp.append(remainder);
      dividend = quotient;
    }
    if(dividend > 0){
      binaryTemp.append(dividend);
    }
    binaryRep = binaryTemp.reverse().toString();
    return binaryRep;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    int input = 5;
    System.out.println(toBinary(input));
    input = 10;
    System.out.println(toBinary(input));
    input = 100;
    System.out.println(toBinary(input));
    input = 16;
    System.out.println(toBinary(input));
  }

}
