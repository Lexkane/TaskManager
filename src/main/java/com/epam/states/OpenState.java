package com.epam.states;

import com.epam.ui.Task;

public class OpenState extends State {


  public OpenState(Task task) {
    super(task);
  }

  @Override
  public String inProgress() {
    return "in progress";
  }

  @Override
  public String close() {
    return "close";
  }

  @Override
  public String toString() {
    return "opened";
  }
}
