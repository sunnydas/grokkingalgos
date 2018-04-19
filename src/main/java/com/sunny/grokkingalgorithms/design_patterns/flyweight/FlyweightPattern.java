package com.sunny.grokkingalgorithms.design_patterns.flyweight;

import com.sunny.grokkingalgorithms.design_patterns.flyweight.factory.FWFactory;

/**
 * Created by sundas on 4/19/2018.
 */
public class FlyweightPattern {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    for(int i = 0 ;  i < 5 ; i++){
      System.out.println(FWFactory.getObject("list"));
      System.out.println(FWFactory.getObject("bigdecimal"));
    }
  }
}
