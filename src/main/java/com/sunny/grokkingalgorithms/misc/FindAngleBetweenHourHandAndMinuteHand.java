package com.sunny.grokkingalgorithms.misc;

import java.util.Scanner;

/**
 * Created by sundas on 4/21/2017.
 */
public class FindAngleBetweenHourHandAndMinuteHand {

  /*
  Given a time of the day , find the angle between hour hand and minute hand.
  This solution assumes that the hour hand does not move between hour transitions and that may not be desired.
   */

  public static void printAngleBetweenHourAndMinuteHands(String tod){
    String[] splitted = tod.split(":");
    int hour = Integer.parseInt(splitted[0].trim());
    int minute = Integer.parseInt(splitted[1].trim());
    if(hour == 12){
      hour = 0;
    }
    int angleMadeByHourHand = hour*30; // Every hour is 30 degrees
    int angleMadeByMinuteHand = minute*6; // 360/6 1 minute.
    int angleBetweenThem = Math.abs(angleMadeByHourHand - angleMadeByMinuteHand);
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
