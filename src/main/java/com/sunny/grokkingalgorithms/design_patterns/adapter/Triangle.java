package com.sunny.grokkingalgorithms.design_patterns.adapter;

/**
 * Created by sundas on 4/11/2018.
 */
public class Triangle extends CalculatorAdapter{


  double l;
  double h;

  public double calculateArea(){
    return super.calculateArea(this);
  }

}
