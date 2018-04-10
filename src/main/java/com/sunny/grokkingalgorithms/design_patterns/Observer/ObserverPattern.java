package com.sunny.grokkingalgorithms.design_patterns.Observer;

import com.sunny.grokkingalgorithms.design_patterns.Observer.impl.SimpleObserver;
import com.sunny.grokkingalgorithms.design_patterns.Observer.impl.Subject;

/**
 * Created by sundas on 4/10/2018.
 */
public class ObserverPattern {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    ISubject iSubject = new Subject();
    IObserver iObserver = new SimpleObserver();
    iSubject.registerObserver(iObserver);
    for(int i = 0 ; i < 10 ; i++) {
      ((Subject) iSubject).update(" data = " + i);
    }
    iSubject.unregisterObserver(iObserver);
    for(int i = 10 ; i < 20 ; i++) {
      ((Subject) iSubject).update(" data = " + i);
    }
  }

}
