package com.sunny.grokkingalgorithms.design_patterns.adapter;

/**
 * Created by sundas on 4/11/2018.
 */
public class CalculatorAdapter {

  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }

  private Calculator calculator;

  public double calculateArea(Triangle triangle){
    Rectangle rectangle = new Rectangle();
    rectangle.l = triangle.l;
    rectangle.b = 0.5*triangle.h;
    return this.calculator.calculateArea(rectangle);
  }


}
