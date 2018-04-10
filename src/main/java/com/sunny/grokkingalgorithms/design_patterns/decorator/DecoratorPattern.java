package com.sunny.grokkingalgorithms.design_patterns.decorator;

import com.sunny.grokkingalgorithms.design_patterns.decorator.impl.ConcreteComponent;
import com.sunny.grokkingalgorithms.design_patterns.decorator.impl.CustomDecorator;

/**
 * Created by sundas on 4/10/2018.
 */
public class DecoratorPattern {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Component concreteComponent = new ConcreteComponent();
    CustomDecorator customDecorator = new CustomDecorator();
    customDecorator.setComponent(concreteComponent);
    customDecorator.processWork();
  }

}
