package com.sunny.grokkingalgorithms.design_patterns.iterator.impl;

import com.sunny.grokkingalgorithms.design_patterns.iterator.CustomIterator;

/**
 * Created by sundas on 4/17/2018.
 */
public class ArrayIterator<T> implements CustomIterator<T>{

  private int index;

  public ArrayIterator(T[] ts) {
    this.ts = ts;
  }

  private T[] ts;



  @Override
  public boolean hasNext() {
    if(ts != null && this.index < ts.length){
      return true;
    }
    return false;
  }

  @Override
  public T next() {
    if(ts != null){
      return ts[index++];
    }
    return null;
  }

  @Override
  public T first() {
    if(ts != null && ts.length >= 1){
      return ts[0];
    }
    return null;
  }
}
