package com.sunny.grokkingalgorithms.design_patterns.command;

/**
 * Created by sundas on 4/16/2018.
 */
public interface Receiver {

  public void turnOn();

  public void turnOff();

  public int getState();

  public void setState(int state);

}
