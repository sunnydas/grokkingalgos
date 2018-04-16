package com.sunny.grokkingalgorithms.design_patterns.command.impl;

import com.sunny.grokkingalgorithms.design_patterns.command.ICommand;
import com.sunny.grokkingalgorithms.design_patterns.command.Receiver;

/**
 * Created by sundas on 4/16/2018.
 */
public class TurnOffCommand implements ICommand {

  public TurnOffCommand(Receiver receiver) {
    this.receiver = receiver;
  }

  private Receiver receiver;



  @Override
  public void execute() {
    receiver.turnOff();
  }

  @Override
  public void undo() {
    receiver.turnOn();
  }

  @Override
  public void redo() {
    receiver.turnOff();
  }
}
