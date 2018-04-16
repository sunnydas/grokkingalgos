package com.sunny.grokkingalgorithms.design_patterns.command.impl;

import com.sunny.grokkingalgorithms.design_patterns.command.ICommand;
import com.sunny.grokkingalgorithms.design_patterns.command.Receiver;

/**
 * Created by sundas on 4/16/2018.
 */
public class TurnOnCommand implements ICommand {

  private Receiver receiver;

  public TurnOnCommand(Receiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public void execute() {
    receiver.turnOn();
  }

  @Override
  public void undo() {
    receiver.turnOff();
  }

  @Override
  public void redo() {
    receiver.turnOn();
  }
}
