package com.sunny.grokkingalgorithms.design_patterns.observer.impl;

import com.sunny.grokkingalgorithms.design_patterns.observer.INotif;
import com.sunny.grokkingalgorithms.design_patterns.observer.IObserver;

/**
 * Created by sundas on 4/10/2018.
 */
public class SimpleObserver implements IObserver {
  @Override
  public void notify(INotif iNotif) {
    System.out.println(" Notfied " + iNotif);
  }
}
