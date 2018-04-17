package com.sunny.grokkingalgorithms.design_patterns.iterator;

/**
 * Created by sundas on 4/17/2018.
 */
public interface CustomIterator<T> {

  public boolean hasNext();

  public T next();

  public T first();


}
