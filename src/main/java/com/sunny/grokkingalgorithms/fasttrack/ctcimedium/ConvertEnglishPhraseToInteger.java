package com.sunny.grokkingalgorithms.fasttrack.ctcimedium;

import com.sunny.grokkingalgorithms.design_patterns.strategy.StrategyPattern;

/**
 * Created by sundas on 6/16/2018.
 */
public class ConvertEnglishPhraseToInteger {

  /*
  For example 70 should return seventy
  1000 should return one thousand etc
   */

  static String[] digits = new String[]{
       "zero",
       "one",
       "two",
       "three",
       "four",
       "five",
       "six",
       "seven",
       "eight",
       "nine",
       "ten",
       "eleven",
       "twelve",
       "thirteen",
       "fourteen",
       "fifteen",
       "sixteen",
       "seventeen",
       "eigteen",
       "nineteen"
  };

  static String[] tens = new String[]{
       "zero",
       "ten",
       "twenty",
       "thirty",
       "forty",
       "fifty",
       "sixty",
       "seventy",
       "eighty",
       "ninety"
  };

  /**
   *
   * @param num
   * @return
   */
  public static String getNum(int num){
    if(num < 20){
      return digits[num];
    }
    boolean alreadyAddedThousand = false;
    String value = String.valueOf(num);
    int powerCounter = value.length();
    StringBuilder result = new StringBuilder();
    int i = 0;
    while(i < value.length()){
      int digit = Integer.valueOf(""+value.charAt(i));
      if(powerCounter == 1){
        if(digit != 0) {
          result.append(digits[digit]);
        }
      }
      if(powerCounter == 2){
        if(digit != 0) {
          result.append(tens[digit]);
        }
      }
      else if(powerCounter == 3){
        if(digit != 0) {
          result.append(digits[digit] + "hundred");
        }
      }
      else if(powerCounter == 4){
        if(digit != 0) {
          result.append(digits[digit]);
          if(!alreadyAddedThousand){
            result.append("thousand");
          }
        }
      }
      else if(powerCounter == 5){
        if(digit != 0 && !alreadyAddedThousand) {
          result.append(tens[digit] + "thousand");
          alreadyAddedThousand = true;
        }
      }
      else if(powerCounter == 6){
        result.append(digits[digit] + "lakhs");
      }
      i++;
      powerCounter--;
    }
    return result.toString();
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println(getNum(19));
    System.out.println(getNum(20));
    System.out.println(getNum(99));
    System.out.println(getNum(21));
    System.out.println(getNum(45));
    System.out.println(getNum(79));
    System.out.println(getNum(100));
    System.out.println(getNum(120));
    System.out.println(getNum(122));
    System.out.println(getNum(199));
    System.out.println(getNum(985));
    System.out.println(getNum(1985));
    System.out.println(getNum(1000));
    System.out.println(getNum(10000));
    System.out.println(getNum(11001));
  }

}
