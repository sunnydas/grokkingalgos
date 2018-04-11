package com.sunny.grokkingalgorithms.design_patterns.adapter;

/**
 * Created by sundas on 4/11/2018.
 */
public class AdapterPattern {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Calculator calculator = new Calculator();
    Triangle triangle = new Triangle();
    triangle.l = 10;
    triangle.h = 15;
    triangle.setCalculator(calculator);
    System.out.println(triangle.calculateArea());;
  }

}
