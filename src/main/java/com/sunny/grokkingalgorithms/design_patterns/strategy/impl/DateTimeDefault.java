package com.sunny.grokkingalgorithms.design_patterns.strategy.impl;

import com.sunny.grokkingalgorithms.design_patterns.strategy.IChoice;

import java.util.Calendar;

/**
 * Created by sundas on 4/11/2018.
 */
public class DateTimeDefault implements IChoice{


  @Override
  public void execute() {
    System.out.println("Default choice:");
    Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.getTimeZone().getDisplayName());
    System.out.println(calendar.getTime());
  }
}
