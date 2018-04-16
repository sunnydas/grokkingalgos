package com.sunny.grokkingalgorithms.design_patterns.command;

/**
 * Created by sundas on 4/16/2018.
 */
public interface ICommand {

  public void execute();

  public void undo();

  public void redo();

}
