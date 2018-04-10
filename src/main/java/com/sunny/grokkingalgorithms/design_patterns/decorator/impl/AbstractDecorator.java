package com.sunny.grokkingalgorithms.design_patterns.decorator.impl;

import com.sunny.grokkingalgorithms.design_patterns.decorator.Component;

/**
 * Created by sundas on 4/10/2018.
 */
public abstract class AbstractDecorator implements Component{

  private Component component;

  public void setComponent(Component component){
    this.component = component;
  }

  public void processWork(){
    if(component != null){
      component.processWork();
    }
  }
}
