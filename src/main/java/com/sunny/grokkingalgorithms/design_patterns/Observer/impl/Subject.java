package com.sunny.grokkingalgorithms.design_patterns.Observer.impl;

import com.sunny.grokkingalgorithms.design_patterns.Observer.INotif;
import com.sunny.grokkingalgorithms.design_patterns.Observer.IObserver;
import com.sunny.grokkingalgorithms.design_patterns.Observer.ISubject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 4/10/2018.
 */
public class Subject implements ISubject {

  private StringBuilder data;

  private List<IObserver> observers;

  public Subject(){
    data = new StringBuilder();
    observers = new ArrayList<>();
  }

  public void update(String value){
    data.append(" : " + value);
    INotif iNotif = new SimpleNotification();
    iNotif.setNotif(data);
    for(IObserver iObserver: observers){
      iObserver.notify(iNotif);
    }
  }

  @Override
  public void registerObserver(IObserver iObserver) {
    if(iObserver != null) {
      observers.add(iObserver);
    }
  }

  @Override
  public void unregisterObserver(IObserver iObserver) {
    if(iObserver != null){
      for(IObserver observer : observers){
        if(observer == iObserver){
          observers.remove(iObserver);
          break;
        }
      }
    }
  }
}
