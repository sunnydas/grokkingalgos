package com.sunny.grokkingalgorithms.design_patterns.command.impl;

import com.sunny.grokkingalgorithms.design_patterns.command.ICommand;
import com.sunny.grokkingalgorithms.design_patterns.command.Receiver;

/**
 * Created by sundas on 4/16/2018.
 */
public class CommandPattern {


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    CommandInvoker commandInvoker = new CommandInvoker();
    Receiver receiver = new Light();
    TurnOnCommand turnOnCommand = new TurnOnCommand(receiver);
    TurnOffCommand turnOffCommand = new TurnOffCommand(receiver);
    commandInvoker.invoke(turnOnCommand);
    commandInvoker.invoke(turnOffCommand);
    commandInvoker.undo();
  }

}
