package com.sunny.grokkingalgorithms.design_patterns.Observer.impl;

import com.sunny.grokkingalgorithms.design_patterns.Observer.INotif;
import com.sunny.grokkingalgorithms.design_patterns.Observer.IObserver;

/**
 * Created by sundas on 4/10/2018.
 */
public class SimpleObserver implements IObserver {
  @Override
  public void notify(INotif iNotif) {
    System.out.println(" Notfied " + iNotif);
  }
}
