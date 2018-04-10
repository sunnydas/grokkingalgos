package com.sunny.grokkingalgorithms.design_patterns.Observer;

/**
 * Created by sundas on 4/10/2018.
 */
public interface ISubject {
  public void registerObserver(IObserver iObserver);
  public void unregisterObserver(IObserver iObserver);
}
