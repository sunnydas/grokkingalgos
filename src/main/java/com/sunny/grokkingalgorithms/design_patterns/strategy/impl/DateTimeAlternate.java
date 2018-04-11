package com.sunny.grokkingalgorithms.design_patterns.strategy.impl;

import com.sunny.grokkingalgorithms.design_patterns.strategy.IChoice;

import java.util.Calendar;

/**
 * Created by sundas on 4/11/2018.
 */
public class DateTimeAlternate implements IChoice {
  @Override
  public void execute() {
    System.out.println("Alternate with mills");
    Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getTimeZone().getDisplayName());
    System.out.println(calendar.getTimeInMillis());
  }
}
