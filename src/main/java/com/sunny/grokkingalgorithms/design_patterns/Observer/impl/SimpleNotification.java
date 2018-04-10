package com.sunny.grokkingalgorithms.design_patterns.Observer.impl;

import com.sunny.grokkingalgorithms.design_patterns.Observer.INotif;

/**
 * Created by sundas on 4/10/2018.
 */
public class SimpleNotification implements INotif {

  private Object payload;

  @Override
  public String toString() {
    return "SimpleNotification{" +
        "payload=" + payload +
        '}';
  }

  @Override
  public Object getNotif() {
    return this.payload;
  }

  @Override
  public void setNotif(Object notif) {
    this.payload = notif;
  }
}
