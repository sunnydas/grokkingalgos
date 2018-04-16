package com.sunny.grokkingalgorithms.design_patterns.command.impl;

import com.sunny.grokkingalgorithms.design_patterns.command.ICommand;
import com.sunny.grokkingalgorithms.design_patterns.command.Invoker;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by sundas on 4/16/2018.
 */
public class CommandInvoker implements Invoker {

  private Stack<ICommand> undoStack = new Stack<>();

  @Override
  public void invoke(ICommand iCommand) {
    iCommand.execute();
    undoStack.push(iCommand);
  }

  public void undo(){
    if(!undoStack.isEmpty()){
      undoStack.pop().undo();
    }
  }
}
