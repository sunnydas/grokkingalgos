package com.sunny.grokkingalgorithms.design_patterns.decorator.impl;

import com.sunny.grokkingalgorithms.design_patterns.decorator.Component;

/**
 * Created by sundas on 4/10/2018.
 */
public class ConcreteComponent implements Component {
  @Override
  public void processWork() {
    System.out.println("base work");
  }
}
