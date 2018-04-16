package com.sunny.grokkingalgorithms.design_patterns.command.impl;

import com.sunny.grokkingalgorithms.design_patterns.command.Receiver;

/**
 * Created by sundas on 4/16/2018.
 */
public class Light implements Receiver {

  public Light() {
  }

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  private int state;

  @Override
  public void turnOn() {
    if(state == 0){
      state = 1;
      System.out.println(state);
    }
  }

  @Override
  public void turnOff() {
    if(state == 1){
      state = 0;
      System.out.println(state);
    }
  }
}
