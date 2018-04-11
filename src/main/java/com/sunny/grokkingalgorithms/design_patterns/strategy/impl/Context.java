package com.sunny.grokkingalgorithms.design_patterns.strategy.impl;

import com.sunny.grokkingalgorithms.design_patterns.strategy.IChoice;

/**
 * Created by sundas on 4/11/2018.
 */
public class Context {

  public IChoice getiChoice() {
    return iChoice;
  }

  public void setiChoice(IChoice iChoice) {
    this.iChoice = iChoice;
  }

  private IChoice iChoice;

  public void execute(){
    if(iChoice != null) {
      iChoice.execute();
    }
  }

}
