package com.sunny.grokkingalgorithms.misc;

import java.util.Scanner;

/**
 * Created by sundas on 4/21/2017.
 */
public class FindAngleBetweenHourHandAndMinuteHandAccurate {

  /*
  Given a time of the day , find the angle between hour hand and minute hand.
  This solution assumes that the hour hand does not move between hour transitions and that may not be desired.
   */

  public static void printAngleBetweenHourAndMinuteHands(String tod){
    String[] splitted = tod.split(":");
    int hour = Integer.parseInt(splitted[0].trim());
    int minute = Integer.parseInt(splitted[1].trim());
    double angleMadeByHourHand =  0.5*(60*hour + minute);
    double angleMadeByMinuteHand = minute*6;
    double angleBetweenThem = Math.abs(angleMadeByHourHand - angleMadeByMinuteHand);
    if(angleBetweenThem > 180){
      angleBetweenThem = Math.abs(360 - angleBetweenThem);
    }
    System.out.println(angleBetweenThem);
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("Please enter time in hh:mm 12 hour format:");
    Scanner scanner = null;
    try {
      scanner = new Scanner(System.in);
      String tod = scanner.next();
      printAngleBetweenHourAndMinuteHands(tod);
    }finally {
      scanner.close();
    }

  }

}
