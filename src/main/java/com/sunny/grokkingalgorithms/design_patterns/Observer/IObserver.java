package com.sunny.grokkingalgorithms.design_patterns.Observer;

/**
 * Created by sundas on 4/10/2018.
 */
public interface IObserver<T> {

  public void notify(INotif<T> tiNotif);

}
