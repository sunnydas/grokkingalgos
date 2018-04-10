package com.sunny.grokkingalgorithms.design_patterns.decorator.impl;

/**
 * Created by sundas on 4/10/2018.
 */
public class CustomDecorator extends AbstractDecorator {

  public void processWork(){
    super.processWork();
    System.out.println(" This is my custom functionality ");
  }

}
